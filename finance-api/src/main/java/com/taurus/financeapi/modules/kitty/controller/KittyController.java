package com.taurus.financeapi.modules.kitty.controller;

import com.taurus.financeapi.modules.kitty.model.Kitty;
import com.taurus.financeapi.modules.kitty.repository.KittyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kitties")
public class KittyController {

    @Autowired
    KittyRepository kittyRepository;

    @PostMapping
    public Kitty create(@RequestBody Kitty kitty) {
        return kittyRepository.save(kitty);
    }

    @GetMapping
    public ResponseEntity<List<Kitty>> findAll() {
        List<Kitty> lista = kittyRepository.findAll();
        return lista.isEmpty()
                ? ResponseEntity.status(204).build()
                : ResponseEntity.status(200).body(lista);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Kitty> getById(
            @PathVariable long id) {
        return ResponseEntity.of(kittyRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remove(
            @PathVariable Long id) {

        if (kittyRepository.existsById(id)) {
            kittyRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Kitty> update(
            @PathVariable Long id, @RequestBody Kitty kitty) {
        if (kittyRepository.existsById(id)) {
            kitty.setId(id);
            kittyRepository.save(kitty);
            return ResponseEntity.status(200).body(kitty);
        }
        return ResponseEntity.status(404).build();
    }
}
