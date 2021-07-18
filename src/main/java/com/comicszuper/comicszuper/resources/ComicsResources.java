package com.comicszuper.comicszuper.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.comicszuper.comicszuper.clientMarvel.MarvelClient;
import com.comicszuper.comicszuper.models.Comics;
import com.comicszuper.comicszuper.models.Usuario;
import com.comicszuper.comicszuper.models.comics.ComicsResponse;
import com.comicszuper.comicszuper.models.comics.ComicsResult;
import com.comicszuper.comicszuper.repository.ComicsRepository;
import com.comicszuper.comicszuper.repository.UsuarioRepository;
import com.comicszuper.comicszuper.services.ComicsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/use")
@Api(value = "API REST Comics")
@CrossOrigin(origins = "*")

public class ComicsResources {

	@Autowired
	ComicsRepository comicsRepository;

	@Autowired
	ComicsService comicsService;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	MarvelClient marvelClient;

	@GetMapping("/listaComics")
	@ApiOperation(value = "Retorna lista de Comics para o cpf do usuário")
	public ResponseEntity<String> listaComics(String cpf) {
		if (usuarioRepository.findByCpf(cpf) != null) {
			List<Comics> comics = comicsRepository.findAllByUsuario_cpf(cpf);
			String comicsStr = comics.stream().map(comicsService::formatacao).collect(Collectors.toList()).toString();
			return new ResponseEntity<>(comicsStr, HttpStatus.OK);
		} else
			return new ResponseEntity<>("Por favor confira os dados da busca, não encontramos sua lista.", HttpStatus.BAD_REQUEST);
	}

	@PostMapping("/comics/{id}")
	@ApiOperation(value = "Salva Comics")
	public ResponseEntity<Comics> salvaComics(@PathVariable long id, @RequestHeader String cpf) {
		try {
			Usuario usuario = usuarioRepository.findByCpf(cpf);
			ComicsResponse comicsResponse = marvelClient.getComicById(id);
			Comics novoComics = new Comics();
			ComicsResult result = comicsResponse.getData().getResults().get(0);
			novoComics.setAutor(result.getCreators().getItems().get(0).getName());
			novoComics.setComicId(id);
			novoComics.setISBN(result.getIsbn());
			novoComics.setPreço(result.getPrices().get(0).getPrice());
			novoComics.setTitulo(result.getTitle());
			novoComics.setDescricao(result.getDescription());
			novoComics.setUsuario(usuario);
			novoComics = comicsRepository.save(novoComics);
			return new ResponseEntity<>(novoComics, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
