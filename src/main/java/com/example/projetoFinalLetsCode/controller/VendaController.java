package com.example.projetoFinalLetsCode.controller;

import com.example.projetoFinalLetsCode.model.Venda;
import com.example.projetoFinalLetsCode.service.VendaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/venda")
public class VendaController {
    final VendaService vendaService;

    public VendaController(VendaService vendaService) {
        this.vendaService = vendaService;
    }

    @PostMapping
    public ResponseEntity<Venda> salvar(@RequestBody @Valid Venda venda) {
        return ResponseEntity.ok(vendaService.salvar(venda));
    }

    @GetMapping
    public ResponseEntity<Page<Venda>> listar(String filtro, Pageable pageable) {
        return ResponseEntity.ok(vendaService.listar(filtro, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> getId(@PathVariable Long id) {
        return ResponseEntity.ok(vendaService.getId(id));
    }
}
