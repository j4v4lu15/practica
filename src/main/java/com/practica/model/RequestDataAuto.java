package com.practica.model;

import lombok.Data;

@Data
public class RequestDataAuto {
	
	private int idauto;
	public int getIdauto() {
		return idauto;
	}
	public void setIdauto(int idauto) {
		this.idauto = idauto;
	}
	public String getDueño() {
		return dueño;
	}
	public void setDueño(String dueño) {
		this.dueño = dueño;
	}
	private String dueño;

}
