package com.comicszuper.comicszuper.clientMarvel;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.comicszuper.comicszuper.models.comics.ComicsResponse;

import feign.FeignException;
@Component
public class MarvelClient {
	  private static final String PUBLIC_KEY = "c4dc3618195658daf9f1361d425ed203";
	    private static final String PRIVATE_KEY = "d17190e900426d155bac23c8838c488c89d5e302";

	    @Autowired
	    private MarvelFeignClient marvelFeignClient;

	    public ComicsResponse getComicById(Long id) throws Exception {
	        long currentTimestamp = System.currentTimeMillis();
	        String message = currentTimestamp + PRIVATE_KEY + PUBLIC_KEY;
	        String hash = generateMd5Hash(message);

	        ComicsResponse comicsResponse = null;
	        try {
	        	comicsResponse = marvelFeignClient.comicsResponse(id, currentTimestamp, PUBLIC_KEY, hash);
	        } catch (FeignException.NotFound ex) {
	            throw new Exception("Não foi possível encontrar esse Comic.");
	        }

	        return comicsResponse;
	    }

	    private String generateMd5Hash(String message) {
	        MessageDigest md = null;
	        try {
	            md = MessageDigest.getInstance("MD5");
	        } catch (NoSuchAlgorithmException e) {
	            e.printStackTrace();
	        }
	        md.update(message.getBytes());
	        byte[] digest = md.digest();
	        String myHash = DatatypeConverter.printHexBinary(digest).toLowerCase();

	        return myHash;
	    }
	}


