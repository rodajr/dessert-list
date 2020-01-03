package br.com.dessert.api.entity.dto;

import java.io.Serializable;

public class DessertDTO implements Serializable {

	private static final long serialVersionUID = -7551249069504654502L;

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "{\nname : " + name + "\n}";
	}
	
}
