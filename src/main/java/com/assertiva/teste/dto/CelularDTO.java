package com.assertiva.teste.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CelularDTO {
    private Long id;
    private String ddd;
    private String numero;
}
