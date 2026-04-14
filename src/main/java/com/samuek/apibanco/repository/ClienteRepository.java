package com.samuek.apibanco.repository;

import com.samuek.apibanco.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
