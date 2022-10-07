package com.taurus.financeapi.modules.spent.controller;

import com.taurus.financeapi.modules.spent.dto.SpentFinanceResponse;
import com.taurus.financeapi.modules.spent.dto.SpentRequest;
import com.taurus.financeapi.modules.spent.model.Spent;
import com.taurus.financeapi.modules.spent.service.SpentService;
import com.taurus.financeapi.modules.spent.dto.SpentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/spenties")
public class SpentController {

    @Autowired
    private SpentService spentService;

    @PostMapping
    public SpentResponse save(@Valid @RequestBody SpentRequest request) {
        return spentService.save(request);
    }

    @GetMapping
    public List<SpentResponse> findAll() {
        return spentService.findAll();
    }

    @GetMapping("{id}")
    public SpentResponse findById(@PathVariable Integer id) {
        return spentService.findByIdResponse(id);
    }

    @GetMapping("/name/{name}")
    public List<SpentResponse> findByName(@PathVariable String name) {
        return spentService.findByName(name);
    }

    @GetMapping("/category/{categoryId}")
    public List<SpentResponse> findByCategoryId(@PathVariable Integer categoryId) {
        return spentService.findByCategoryId(categoryId);
    }

    @PutMapping("{id}")
    public SpentResponse update(@RequestBody SpentRequest request,
                                  @PathVariable Integer id) {
        return spentService.update(request, id);
    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity<Spent> delete(@PathVariable Integer id) {
        spentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("{spentId}/finances")
    public SpentFinanceResponse findSpentByFinance(@PathVariable Integer id) {
        return spentService.findSpentFinances(id);
    }

}
