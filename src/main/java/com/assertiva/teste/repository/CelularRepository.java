package com.assertiva.teste.repository;

import com.assertiva.teste.entity.Celular;
import com.assertiva.teste.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CelularRepository extends JpaRepository<Celular,Long> {
}
