package com.skilllink.backend.repository;

import com.skilllink.backend.entity.Desafio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesafioRepository extends JpaRepository<Desafio, Long> {
}
