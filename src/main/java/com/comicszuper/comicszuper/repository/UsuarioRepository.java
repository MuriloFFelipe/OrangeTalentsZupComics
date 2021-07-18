package com.comicszuper.comicszuper.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comicszuper.comicszuper.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	public Usuario findByCpf(String cpf);
}
