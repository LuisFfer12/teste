package com.assertiva.teste.dto;

import com.assertiva.teste.entity.Celular;
import com.assertiva.teste.entity.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String cpf;
    private List<EmailDTO> emails;
    private List<CelularDTO> celulares;

}
