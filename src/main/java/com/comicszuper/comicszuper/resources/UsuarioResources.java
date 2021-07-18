package com.comicszuper.comicszuper.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comicszuper.comicszuper.models.Usuario;
import com.comicszuper.comicszuper.repository.UsuarioRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/use")
@Api(value="Comics - usuarios")
@CrossOrigin(origins="*")
public class UsuarioResources {
	
@Autowired
UsuarioRepository usuarioRepository;

@PostMapping("/usuarios")
@ApiOperation(value="Salva usuário")
public ResponseEntity<Usuario> salvaUsuario(@RequestBody Usuario usuario) {
	try {
		Usuario novoUsuario  = usuarioRepository.save(usuario);
		usuario.setId(novoUsuario.getId());
		return new ResponseEntity<>(usuario, HttpStatus.CREATED);
	}
    catch (Exception e) {
        System.out.println(e.getMessage());
    	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
}
}
