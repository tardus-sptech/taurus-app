package com.taurus.financeapi.modules.spent.controller;

import com.taurus.financeapi.modules.spent.dto.SpentRequest;
import com.taurus.financeapi.modules.spent.model.Spent;
import com.taurus.financeapi.modules.spent.service.SpentService;
import com.taurus.financeapi.modules.spent.dto.SpentResponse;
import com.taurus.financeapi.modules.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/api/spenties")
public class SpentController {

    @Autowired
    private SpentService spentService;

    @GetMapping("/user/{idUser}")
    public List<SpentResponse> getSpentByUserId(@PathVariable Integer idUser){
        return spentService.findByUserId(idUser);
    }

    @PostMapping
    public SpentResponse save(@RequestBody SpentRequest spent) {
        return spentService.save(spent);
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

//    @PutMapping("{id}")
//    public SpentResponse update(@RequestBody SpentRequest request,
//                                  @PathVariable Integer id) {
//        return spentService.update(request, id);
//    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity<Spent> delete(@PathVariable Integer id) {
        spentService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/user/sum/{userId}")
    public Double sumSpentfindByUserId(@PathVariable Integer userId) {
        return spentService.sumSpentfindByUserId(userId);
    }

}
