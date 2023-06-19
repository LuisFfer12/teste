package com.assertiva.teste.repository;

import com.assertiva.teste.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

    @Query(value = "SELECT c.* from cliente c " +
            "inner join celular cel on cel.cliente_id = c.id " +
            "where (:nome is null or c.nome like %:nome%) and (:ddd is null or cel.ddd = :ddd) " ,nativeQuery = true)
    List<Cliente> findAllByDddAndName(@Param("nome") String nome, @Param("ddd") String ddd);
}
