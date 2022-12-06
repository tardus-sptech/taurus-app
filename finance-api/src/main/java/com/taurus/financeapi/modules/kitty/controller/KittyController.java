package com.taurus.financeapi.modules.kitty.controller;

import com.taurus.financeapi.modules.kitty.dto.KittyRequest;
import com.taurus.financeapi.modules.kitty.dto.KittyResponse;
import com.taurus.financeapi.modules.kitty.model.Kitty;
import com.taurus.financeapi.modules.kitty.repository.KittyRepository;
import com.taurus.financeapi.modules.kitty.service.KittyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(allowedHeaders = "*")
@RestController
@RequestMapping("/api/kitties")
public class KittyController {

    @Autowired
    private KittyService kittyService;

    @Autowired
    KittyRepository kittyRepository;

//    @PostMapping
//    public Kitty create(@RequestBody Kitty kitty) {
//        return kittyRepository.save(kitty);
//    }


//    @GetMapping("/{id}")
//    public ResponseEntity<Kitty> getById(
//            @PathVariable Integer id) {
//        return ResponseEntity.of(kittyRepository.findById(id));
//    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> remove(
//            @PathVariable Integer id) {
//
//        if (kittyRepository.existsById(id)) {
//            kittyRepository.deleteById(id);
//            return ResponseEntity.status(200).build();
//        }
//        return ResponseEntity.status(404).build();
//    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Kitty> update(
//            @PathVariable Integer id, @RequestBody Kitty kitty) {
//        if (kittyRepository.existsById(id)) {
//            kitty.setId(id);
//            kittyRepository.save(kitty);
//            return ResponseEntity.status(200).body(kitty);
//        }
//        return ResponseEntity.status(404).build();
//    }
    @GetMapping
    public List<KittyResponse> findAll() {
        return kittyService.findAll();
    }

    @PostMapping
    public KittyResponse save(@RequestBody KittyRequest request) {
        return kittyService.save(request);
    }

    @GetMapping("{id}")
    public KittyResponse findById(@PathVariable Integer id) {
        return kittyService.findByIdResponse(id);
    }

    @GetMapping("/name/{name}")
    public List<KittyResponse> findByName(@PathVariable String name) {
        return kittyService.findByName(name);
    }

    @GetMapping("/category/{categoryId}")
    public List<KittyResponse> findByCategoryId(@PathVariable Integer categoryId) {
        return kittyService.findByCategoryId(categoryId);
    }

//    @PutMapping("{id}")
//    public KittyResponse update(@RequestBody KittyRequest request,
//                                @PathVariable Integer id) {
//        return kittyService.update(request, id);
//    }

    @Transactional
    @DeleteMapping("{id}")
    public ResponseEntity<Kitty> delete(@PathVariable Integer id) {
        kittyService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
