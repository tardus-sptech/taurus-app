package com.taurus.financeapi.modules.gain.controller;

import com.taurus.financeapi.modules.gain.dto.GainRequest;
import com.taurus.financeapi.modules.gain.dto.GainResponse;
import com.taurus.financeapi.modules.gain.model.Gain;
import com.taurus.financeapi.modules.gain.service.GainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/api/gains")
public class GainController {

    @Autowired
    private GainService gainService;

    @PostMapping
    public GainResponse save(@RequestBody GainRequest spent) {
        return gainService.save(spent);
    }

    @GetMapping("/user/{idUser}")
    public List<GainResponse> getGainByUserId(@PathVariable Integer idUser) {
        return gainService.findByIdUser(idUser);
    }

    @GetMapping
    public List<GainResponse> findAll() {
        return gainService.findAll();
    }
//
//    @GetMapping("{id}")
//    public GainResponse findById(@PathVariable Integer id) {
//        return gainService.findByIdResponse(id);
//    }

    @GetMapping("/name/{name}")
    public List<GainResponse> findByName(@PathVariable String name) {
        return gainService.findByName(name);
    }


//    @PutMapping("{id}")
//    public SpentResponse update(@RequestBody SpentRequest request,
//                                  @PathVariable Integer id) {
//        return spentService.update(request, id);
//    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity<Gain> delete(@PathVariable Integer id) {
        gainService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/user/sum/{userId}")
    public Double sumGainfindByUserId(@PathVariable Integer userId) {
        return gainService.sumGainfindByUserId(userId);
    }

}
