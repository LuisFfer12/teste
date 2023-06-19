package com.assertiva.teste.controller;

import com.assertiva.teste.dto.ClienteDTO;
import com.assertiva.teste.entity.Cliente;
import com.assertiva.teste.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value="/cliente")
public class ClienteController {


    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteDTO>> getAllCliente(@RequestParam(required = false) String nome,
                                                            @RequestParam(required = false) String ddd){
        return ResponseEntity.ok(clienteService.getAllCliente(nome,ddd));
    }

    @PostMapping
    ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO requestDTO){
        return ResponseEntity.ok(clienteService.createCliente(requestDTO));
    }

    @PutMapping("/{clienteId}")
    ResponseEntity<ClienteDTO> editCliente(@PathVariable("clienteId") Long clienteId,@RequestBody ClienteDTO requestDTO){
        ClienteDTO response = clienteService.editCliente(clienteId, requestDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{clienteId}")
    ResponseEntity<ClienteDTO> findClienteById(@PathVariable("clienteId") Long clienteId){
        ClienteDTO response = clienteService.findClienteById(clienteId);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{clienteId}")
    public void deleteById(@PathVariable("clienteId") Long clienteId){
        clienteService.deleteClienteById(clienteId);
    }

}
