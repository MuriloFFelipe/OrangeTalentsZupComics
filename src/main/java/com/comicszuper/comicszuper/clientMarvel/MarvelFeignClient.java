package com.comicszuper.comicszuper.clientMarvel;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.comicszuper.comicszuper.models.comics.ComicsResponse;

@FeignClient(name = "marvel", url = "http://gateway.marvel.com/v1/public/comics")
public interface MarvelFeignClient {

	@GetMapping("/{comicId}?ts={timest}&apikey={apiKey}&hash={hash}")
	public ComicsResponse comicsResponse(@PathVariable Long comicId, @PathVariable long timest, @PathVariable String apiKey,
			@PathVariable String hash);
}
