package com.info.mercadoriaapi.controller;


import com.info.mercadoriaapi.model.Mercadoria;
import com.info.mercadoriaapi.service.MercadoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaController {
    @Autowired
    private MercadoriaService mercadoriaService;

    @GetMapping("/{codBarras}")
    public ResponseEntity<Mercadoria> findBiId(@PathVariable String codBarras){
        return ResponseEntity.ok(mercadoriaService.findById(codBarras));
    }

    @GetMapping ResponseEntity<List<Mercadoria>> findAll(){
        return ResponseEntity.ok(mercadoriaService.findAll());
    }

    @PostMapping()
    public ResponseEntity<Mercadoria> save(@RequestBody Mercadoria mercadoria){
        return ResponseEntity.ok(mercadoriaService.save(mercadoria));
    }

    @DeleteMapping("/{codBarras}")
    public void delete(@PathVariable String codBarras){
        mercadoriaService.delete(codBarras);
    }
}
