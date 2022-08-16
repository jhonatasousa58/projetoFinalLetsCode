package com.example.projetoFinalLetsCode.controller;

import com.example.projetoFinalLetsCode.model.Cliente;
import com.example.projetoFinalLetsCode.service.ClienteService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody @Valid Cliente cliente) {
        return ResponseEntity.ok(clienteService.salvar(cliente));
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable("id") Long idCliente) {
        clienteService.excluir(idCliente);
    }

    @GetMapping
    public ResponseEntity<Page<Cliente>> listar(String filtro, Pageable pageable) {
        return ResponseEntity.ok(clienteService.listar(filtro, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getId(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.getId(id));
    }

}
