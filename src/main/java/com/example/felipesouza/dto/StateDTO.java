package com.example.felipesouza.dto;

import java.io.Serializable;

import com.example.felipesouza.domain.State;

public class StateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private int cityQuantity;

	public StateDTO() {

	}

	public StateDTO(State obj) {
		this.name = obj.getName();
		this.cityQuantity = obj.getCityQuantity();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCityQuantity() {
		return cityQuantity;
	}

	public void setCityQuantity(int cityQuantity) {
		this.cityQuantity = cityQuantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
