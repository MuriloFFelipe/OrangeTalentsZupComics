package com.comicszuper.comicszuper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comicszuper.comicszuper.models.Comics;


public interface ComicsRepository extends JpaRepository<Comics, Long> {

List<Comics> findAllByUsuario_cpf(String cpf);

}
