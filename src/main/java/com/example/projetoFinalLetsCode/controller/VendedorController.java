package com.example.projetoFinalLetsCode.controller;

import com.example.projetoFinalLetsCode.model.Vendedor;
import com.example.projetoFinalLetsCode.service.VendedorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
    final VendedorService vendedorService;

    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @PostMapping
    public ResponseEntity<Vendedor> salvar(@RequestBody @Valid Vendedor vendedor) {
        return ResponseEntity.ok(vendedorService.salvar(vendedor));
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long idVendedor) {
        vendedorService.excluir(idVendedor);
    }

    @GetMapping
    public ResponseEntity<Page<Vendedor>> listar(String filtro, Pageable pageable) {
        return ResponseEntity.ok(vendedorService.listar(filtro, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendedor> getId(@PathVariable Long id) {
        return ResponseEntity.ok(vendedorService.getId(id));
    }
}
