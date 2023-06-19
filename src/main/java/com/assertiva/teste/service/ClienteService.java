package com.assertiva.teste.service;

import com.assertiva.teste.dto.CelularDTO;
import com.assertiva.teste.dto.ClienteDTO;
import com.assertiva.teste.dto.EmailDTO;
import com.assertiva.teste.entity.Celular;
import com.assertiva.teste.entity.Cliente;
import com.assertiva.teste.entity.Email;
import com.assertiva.teste.exception.NoRecordFoundException;
import com.assertiva.teste.repository.CelularRepository;
import com.assertiva.teste.repository.ClienteRepository;
import com.assertiva.teste.repository.EmailRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ModelMapper mapper;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmailRepository emailRepository;

    @Autowired
    CelularRepository celularRepository;

    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = mapper.map(clienteDTO,Cliente.class);

        cliente.getCelulares().forEach(item -> {
            item.setCliente(cliente);
        });
        cliente.getEmails().forEach(item -> {
            item.setCliente(cliente);
        });

        Cliente clienteSaved = clienteRepository.save(cliente);
        return mapper.map(clienteSaved,ClienteDTO.class);
    }

    public ClienteDTO editCliente(Long clienteId, ClienteDTO requestDTO) {

        Cliente clienteFind = clienteRepository.findById(clienteId).orElseThrow(
                () -> new NoRecordFoundException());

        Cliente cliente = mapper.map(requestDTO,Cliente.class);
        cliente.setId(clienteFind.getId());

        cliente.getCelulares().forEach(item -> {
            item.setCliente(cliente);
        });
        cliente.getEmails().forEach(item -> {
            item.setCliente(cliente);
        });

        Cliente clienteSaved = clienteRepository.save(cliente);
        return mapper.map(clienteSaved,ClienteDTO.class);

    }

    public ClienteDTO findClienteById(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new NoRecordFoundException());
        return mapper.map(cliente,ClienteDTO.class);
    }

    public void deleteClienteById(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(
                () -> new NoRecordFoundException());
        clienteRepository.delete(cliente);
    }

    public List<ClienteDTO> getAllCliente(String nome,String ddd) {
        List<Cliente> clientes = clienteRepository.findAllByDddAndName(nome,ddd);
        List<ClienteDTO> clientesResponse = mapper.map(clientes,new TypeToken<List<ClienteDTO>>() {}.getType());
        return clientesResponse;
    }

}
