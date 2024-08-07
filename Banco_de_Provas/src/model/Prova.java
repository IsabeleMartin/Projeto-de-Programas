package model;

public class Prova {
	protected String ID;
	protected String Banca;
	protected String Orgao;
	protected String Estado;
	protected String Ano;
	protected String Nivel;
	protected String Cargo;
	
	public Prova() {
	
	}
	
	
	public Prova(String ID, String banca, String orgao, String estado, String ano, String nivel, String cargo) {
		super();
		this.ID = ID;
		this.Banca = banca;
		this.Orgao = orgao;
		this.Estado = estado;
		this.Ano = ano;
		this.Nivel = nivel;
		this.Cargo = cargo;
	}


	public String getID() {
		return Banca;
	}


	public void setID(String ID) {
		this.ID = ID;
	}
	
	public String getBanca() {
		return Banca;
	}


	public void setBanca(String banca) {
		this.Banca = banca;
	}


	public String getOrgao() {
		return Orgao;
	}


	public void setOrgao(String orgao) {
		this.Orgao = orgao;
	}


	public String getEstado() {
		return Estado;
	}


	public void setEstado(String estado) {
		this.Estado = estado;
	}


	public String getAno() {
		return Ano;
	}


	public void setAno(String ano) {
		this.Ano = ano;
	}


	public String getNivel() {
		return Nivel;
	}


	public void setNivel(String nivel) {
		this.Nivel = nivel;
	}


	public String getCargo() {
		return Cargo;
	}


	public void setCargo(String cargo) {
		this.Cargo = cargo;
	}
	
	

}
