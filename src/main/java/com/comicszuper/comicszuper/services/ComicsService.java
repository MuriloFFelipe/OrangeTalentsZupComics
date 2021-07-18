package com.comicszuper.comicszuper.services;

import java.util.Calendar;

import org.springframework.stereotype.Service;

import com.comicszuper.comicszuper.models.Comics;

@Service
public class ComicsService {

	private String desconto(Comics comics) {
		char ult = comics.getISBN().charAt(comics.getISBN().length() - 1);
		if (ult == '0' || ult == '1') {
			return "Segunda-feira";
		} else if (ult == '2' || ult == '3') {
			return "Terça-feira";
		} else if (ult == '4' || ult == '5') {
			return "Quarta-feira";
		} else if (ult == '6' || ult == '7') {
			return "Quinta-feira";
		} else if (ult == '8' || ult == '9') {
			return "Sexta-feira";
		} else
			return "";
}

	private String dataAtual() {
		Calendar cal = Calendar.getInstance();
		int day = cal.get(Calendar.DAY_OF_WEEK);
		if (day == 2) {
			return "Segunda-feira";
		} else if (day == 3) {
			return "Terça-feira";
		} else if (day == 4) {
			return "Quarta-feira";
		} else if (day == 5) {
			return "Quinta-feira";
		} else if (day == 6) {
			return "Sexta-feira";
		} else
			return "";
	}

	private boolean hoje(Comics comics) {
		return dataAtual() == desconto(comics);
	}

	private float valorComDesconto(Comics comics) {
		if (hoje(comics) == true) {
			return (float) (comics.getPreço() - (comics.getPreço() * 0.1));
		} else
			return comics.getPreço();
	}

	public String formatacao(Comics comics) {
		return "Hoje é " + dataAtual() + ", o Comics tem o ISBN " + comics.getISBN()
				+ ", ou seja, seu desconto será às " + desconto(comics) + " e o atributo de rodízio ativo será "
				+ hoje(comics) + ". O valor a pagar hoje é " + valorComDesconto(comics) + ".";
	}
}
