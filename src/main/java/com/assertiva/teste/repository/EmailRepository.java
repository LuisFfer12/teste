package com.assertiva.teste.repository;

import com.assertiva.teste.entity.Cliente;
import com.assertiva.teste.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email,Long> {
}
