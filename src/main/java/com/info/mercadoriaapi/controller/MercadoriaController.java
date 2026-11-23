package com.info.mercadoriaapi.controller;


import com.info.mercadoriaapi.dto.MovimentacaoRequest;
import com.info.mercadoriaapi.dto.MovimentacaoResponse;
import com.info.mercadoriaapi.model.Mercadoria;
import com.info.mercadoriaapi.service.MercadoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mercadoria")
public class MercadoriaController {
    @Autowired
    private MercadoriaService mercadoriaService;

    @GetMapping("/{codBarras}")
    public ResponseEntity<Mercadoria> findById(@PathVariable String codBarras){
        return ResponseEntity.ok(mercadoriaService.findById(codBarras));
    }

    @GetMapping()
    public ResponseEntity<List<Mercadoria>> findAll(){
        return ResponseEntity.ok(mercadoriaService.findAll());
    }

    @GetMapping("/abaixodoestoque")
    public ResponseEntity<List<Mercadoria>> findQuantidadeLowerThan(){
        return ResponseEntity.ok(mercadoriaService.findQuantidadeLowerThanEstoqueMinimo());
    }

    @PostMapping()
    public ResponseEntity<Mercadoria> save(@RequestBody Mercadoria mercadoria){
        return ResponseEntity.ok(mercadoriaService.save(mercadoria));
    }

    @DeleteMapping("/{codBarras}")
    public void delete(@PathVariable String codBarras){
        mercadoriaService.delete(codBarras);
    }

    @PostMapping("/{codBarras}/entry")
    public ResponseEntity<MovimentacaoResponse> entryMovimentacao(@PathVariable("codBarras") String codBarras, @RequestBody MovimentacaoRequest movimentacaoRequest){
        return ResponseEntity.ok(mercadoriaService.entry(codBarras,movimentacaoRequest.movimentacao()));
    }

    @PostMapping("/{codBarras}/exit")
    public ResponseEntity<MovimentacaoResponse> exitMovimentacao(@PathVariable("codBarras") String codBarras, @RequestBody MovimentacaoRequest movimentacaoRequest){
            return ResponseEntity.ok(mercadoriaService.exit(codBarras, movimentacaoRequest.movimentacao()));
    }
}
