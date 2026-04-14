package com.samuek.apibanco.repository;

import com.samuek.apibanco.domain.Conta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContaRepository extends JpaRepository<Conta, Long> {
}
