package com.taurus.financeapi.modules.gain.service;

import com.taurus.financeapi.config.exception.ValidationException;
import com.taurus.financeapi.modules.gain.dto.GainRequest;
import com.taurus.financeapi.modules.gain.dto.GainResponse;
import com.taurus.financeapi.modules.gain.model.Gain;
import com.taurus.financeapi.modules.gain.repository.GainRepository;
import com.taurus.financeapi.modules.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.util.ObjectUtils.isEmpty;

@Slf4j
@Service
public class GainService {

    @Lazy
    @Autowired
    private GainRepository gainRepository;

    @Lazy
    @Autowired
    private UserService userService;

    public GainResponse save(GainRequest request) {
        var user = userService.findById(request.getUserId());
        user.setValueInAccount(user.getValueInAccount() + request.getValue());
        var gain = gainRepository.save(Gain.of(request, user));
        return GainResponse.of(gain);
    }

    public Gain findById(Integer id) {
        return gainRepository
                .findById(id)
                .orElseThrow(() -> new ValidationException("There's no spent for the given ID."));
    }


    public List<GainResponse> findAll() {
        return gainRepository
                .findAll()
                .stream()
                .map(GainResponse::of)
                .collect(Collectors.toList());
    }

    public List<GainResponse> findByIdUser(Integer idUser){
        return gainRepository
                .findByUserIdOrderByCreatedAtDesc(idUser)
                .stream()
                .map(GainResponse::of)
                .collect(Collectors.toList());
    }

    public List<GainResponse> findByName(String name) {
        if (isEmpty(name)) {
            throw new ValidationException("The kitty name must be informed.");
        }

        return gainRepository
                .findByNameIgnoreCaseContaining(name)
                .stream()
                .map(GainResponse::of)
                .collect(Collectors.toList());
    }

    public GainResponse findByIdResponse(Integer id) {
        return GainResponse.of(findById(id));
    }

    private void validateSpentDataInformed(GainRequest request) {
        if (isEmpty(request.getName())) {
            throw new ValidationException("The spent name was not informed.");
        }
        if (request.getValue() <= 0) {
            throw new ValidationException("The value must be greater than 0.");
        }
    }

    public GainResponse update(GainRequest request, Integer id) {
        validateSpentDataInformed(request);
        validateInformedId(id);
        var user = userService.findById(request.getUserId());
        var spent = gainRepository.save(Gain.of(request, user));
        return GainResponse.of(spent);
    }

    public void delete(Integer id) {
        gainRepository.deleteById(id);
    }

    private void validateInformedId(Integer id) {
        if (isEmpty(id)) {
            throw new ValidationException("The ID must be informed");
        }
    }

    public List<Gain> findByUserId(Integer userId) {
        return gainRepository.findByUserId(userId);
    }

    public Double sumGainfindByUserId(Integer userId) {
        return gainRepository.sumGainfindByUserId(userId);
    }

    public int countGains(Integer idUSer){
        return gainRepository.countGainByUserId(idUSer);
    }
}