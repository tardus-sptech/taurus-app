package com.taurus.financeapi.modules.spent.service;

import com.taurus.financeapi.modules.finances.client.SpentiesClient;
import com.taurus.financeapi.modules.finances.dto.SpentConfirmationDTO;
import com.taurus.financeapi.modules.finances.enums.FinanceStatus;
import com.taurus.financeapi.modules.spent.dto.SpentFinanceResponse;
import com.taurus.financeapi.modules.spent.dto.SpentRequest;
import com.taurus.financeapi.modules.spent.repository.SpentRepository;
import com.taurus.financeapi.config.exception.ValidationException;
import com.taurus.financeapi.modules.category.service.CategoryService;
import com.taurus.financeapi.modules.spent.dto.SpentValueDTO;
import com.taurus.financeapi.modules.spent.dto.SpentResponse;
import com.taurus.financeapi.modules.finances.rabbitmq.SpentConfirmationSender;
import com.taurus.financeapi.modules.spent.model.Spent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Service
public class SpentService {
    @Lazy
    @Autowired
    private SpentRepository spentRepository;

    @Lazy
    @Autowired
    private CategoryService categoryService;

   @Autowired
   private SpentConfirmationSender spentConfirmationSender;

   @Autowired
   private SpentiesClient spentiesClient;

    public SpentResponse save(SpentRequest request) {
//        validateSpentDataInformed(request);
//        validateCategoryIdInformed(request);
        var category = categoryService.findById(request.getCategoryId());
        var spent = spentRepository.save(Spent.of(request, category));
        return SpentResponse.of(spent);
    }

    public Spent findById(Integer id) {
        return spentRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no spent for the given ID."));
    }


    public List<SpentResponse> findAll() {
        return spentRepository
                .findAll()
                .stream()
                .map(SpentResponse::of)
                .collect(Collectors.toList());
    }

    public List<SpentResponse> findByName(String name) {
        if (isEmpty(name)) {
            throw new ValidationException("The kitty name must be informed.");
        }

        return spentRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(SpentResponse::of)
                .collect(Collectors.toList());
    }

    public SpentResponse findByIdResponse(Integer id) {
        return SpentResponse.of(findById(id));
    }

    public List<SpentResponse> findByCategoryId(Integer categoryId) {
        if (isEmpty(categoryId)) {
            throw new ValidationException("The kitt' category ID must be informed.");
        }
        if (!spentRepository.existsByCategoryId(categoryId)) {
            throw new ValidationException("The spent' category ID was not found.");
        }
        return spentRepository
                .findByCategoryId(categoryId)
                .stream()
                .map(SpentResponse::of)
                .collect(Collectors.toList());
    }

    private void validateSpentDataInformed(SpentRequest request) {
        if (isEmpty(request.getName())) {
            throw new ValidationException("The spent name was not informed.");
        }
        if (request.getValue() <= 0) {
            throw new ValidationException("The value must be greater than 0.");
        }
    }

    public SpentResponse update(SpentRequest request, Integer id) {
        validateSpentDataInformed(request);
        validateCategoryIdInformed(request);
        validateInformedId(id);
        var category = categoryService.findById(request.getCategoryId());
        var spent = spentRepository.save(Spent.of(request, category));
        return SpentResponse.of(spent);
    }

    public void delete(Integer id) {
        spentRepository.deleteById(id);
    }

    private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The ID must be informed");
        }
    }

    private void validateCategoryIdInformed(SpentRequest request) {
        if (isEmpty(request.getCategoryId())) {
            throw new ValidationException("The spent ID was not informed.");
        }
    }

    public void updateSpentValue(SpentValueDTO spent) {
        try {
            validateValueUpdateData(spent);
            updateValue(spent);
        } catch (Exception e) {
            log.error("Error while trying to update stock for message with error: {}", e.getMessage(), e);
            var rejectMessage = new SpentConfirmationDTO(spent.getFinancesId(), FinanceStatus.REJECTED);
            spentConfirmationSender.sendSpentConfirmationMessage(rejectMessage);
        }
    }

    private void updateValue(SpentValueDTO spent) {
        var spentiesForUpdate = new ArrayList<Spent>();

        spent
            .getSpenties()
            .forEach(financesSpent -> {
                var existingSpent = findById(financesSpent.getSpentId());
                existingSpent.updateValue(financesSpent.getValue());
                spentiesForUpdate.add(existingSpent);
        });
        if (!isEmpty(spentiesForUpdate)) {
            spentRepository.saveAll(spentiesForUpdate);
            var approvedMessage = new SpentConfirmationDTO(spent.getFinancesId(), FinanceStatus.CREATED);
            spentConfirmationSender.sendSpentConfirmationMessage(approvedMessage);
        }
    }

    private void validateValueUpdateData(SpentValueDTO spent) {
        if (isEmpty(spent) || isEmpty(spent.getFinancesId())) {
            throw new ValidationException("The spent data or finance ID must be informed.");
        }
        if (isEmpty(spent.getSpenties())) {
            throw new ValidationException("The finances' spenties must be informed.");
        }
        spent
            .getSpenties()
            .forEach(financeSpent -> {
                if (isEmpty(financeSpent.getValue()) || isEmpty(financeSpent.getSpentId())) {
                    throw new ValidationException("The spentID and the value must be informed.");
                }
            });
    }

    public SpentFinanceResponse findSpentFinances(Integer id) {
        var spent = findById(id);
        try {
            var finances =  spentiesClient.
                    findFinanceBySpentId (spent.getId())
                    .orElseThrow(() -> new ValidationException("The finances was not found by this product."));
            return SpentFinanceResponse.of(spent, finances.getFinanceIds());
        } catch (Exception e) {
            throw new ValidationException("There was an error trying to get the spent's finances.");
        }
    }

}