package com.taurus.financeapi.modules.spentlimit.controller;

import com.taurus.financeapi.modules.spentlimit.dto.SpentLimitRequest;
import com.taurus.financeapi.modules.spentlimit.dto.SpentLimitResponse;
import com.taurus.financeapi.modules.spentlimit.model.SpentLimit;
import com.taurus.financeapi.modules.spentlimit.service.SpentLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/api/limities")
public class SpentLimitController {

    @Autowired
    private SpentLimitService spentLimitService;

    @PostMapping
    public SpentLimitResponse save(@RequestBody SpentLimitRequest spentLimit) {
        return spentLimitService.save(spentLimit);
    }

    @GetMapping
    public List<SpentLimit> findAll() {
        return spentLimitService.findAll();
    }

//    @GetMapping("/{id}")
//    public SpentLimit findById(@PathVariable Integer id) {
//        return spentLimitService.fi(id);
//    }

//    @PatchMapping("/{id}")
//    public SpentLimitResponse update(@RequestBody SpentLimitRequest request,
//                                     @PathVariable Integer id) {
//        return spentLimitService.update(request, id);
//    }

    @GetMapping("/user/{userId}")
    public List<SpentLimit> findByUserId(@PathVariable Integer userId) {
        return spentLimitService.findByUserId(userId);
    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity<SpentLimit> delete(@PathVariable Integer id) {
        spentLimitService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
