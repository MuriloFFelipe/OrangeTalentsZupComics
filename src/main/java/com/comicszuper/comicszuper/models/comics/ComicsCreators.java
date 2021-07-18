package com.comicszuper.comicszuper.models.comics;

import java.util.ArrayList;
import java.util.List;

public class ComicsCreators {
public List<ComicsCreatorsItem> items = new ArrayList<>();

public List<ComicsCreatorsItem> getItems() {
	return items;
}

public void setItems(List<ComicsCreatorsItem> items) {
	this.items = items;
}
}
