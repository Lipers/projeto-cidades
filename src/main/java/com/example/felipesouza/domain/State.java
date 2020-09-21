package com.example.felipesouza.domain;

import java.util.List;

public class State {

	private String uf;
	private String name;
	private List<City> cities;
	private int cityQuantity;

	public State() {

	}

	public State(String uf, String name, List<City> cities) {
		super();
		this.uf = uf;
		this.name = name;
		this.cities = cities;
		this.cityQuantity = cities.size();
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	public int getCityQuantity() {
		return cityQuantity;
	}

	public void setCityQuantity(int quantity) {
		this.cityQuantity = quantity;
	}

}
