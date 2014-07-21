package com.greenapple.inventory.model;

import java.util.Date;

public class Product {
	
	private int num;
	private String code1;
	private String code2;
	private String designation;
	private Date dateAcq;
	private Date dateAj;
	private String etat;
	private float prix;
	private String facture;
	private int num_file;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCode1() {
		return code1;
	}
	public void setCode1(String code1) {
		this.code1 = code1;
	}
	public String getCode2() {
		return code2;
	}
	public void setCode2(String code2) {
		this.code2 = code2;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public Date getDateAcq() {
		return dateAcq;
	}
	public void setDateAcq(Date dateAcq) {
		this.dateAcq = dateAcq;
	}
	public Date getDateAj() {
		return dateAj;
	}
	public void setDateAj(Date dateAj) {
		this.dateAj = dateAj;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public float getPrix() {
		return prix;
	}
	public void setPrix(float prix) {
		this.prix = prix;
	}
	public String getFacture() {
		return facture;
	}
	public void setFacture(String facture) {
		this.facture = facture;
	}
	public int getNum_file() {
		return num_file;
	}
	public void setNum_file(int num_file) {
		this.num_file = num_file;
	}
	
	

}
