package com.comicszuper.comicszuper.models.comics;

import java.util.ArrayList;
import java.util.List;

public class ComicsResult {
	public int digitalId;
	public String title;
	public String description;
	public String isbn;

	List<ComicsPrice> prices = new ArrayList<>();
	ComicsCreators creators = new ComicsCreators();

	public int getDigitalId() {
		return digitalId;
	}

	public void setDigitalId(int digitalId) {
		this.digitalId = digitalId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public List<ComicsPrice> getPrices() {
		return prices;
	}

	public void setPrices(List<ComicsPrice> prices) {
		this.prices = prices;
	}

	public ComicsCreators getCreators() {
		return creators;
	}

	public void setCreators(ComicsCreators creators) {
		this.creators = creators;
	}

}
