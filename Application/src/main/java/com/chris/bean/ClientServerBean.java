package com.chris.bean;

import java.io.Serializable;

public class ClientServerBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int number;

	public ClientServerBean() {
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "ClientServerBean [number=" + number + "]";
	}
}
