package br.edu.ufam.icomp.lab_encapsulamento;

import java.util.Random;

public class Celular implements Localizavel {
	private int codPais;
	private int codArea;
	private int numero;
	
	public Celular(int codPais, int codArea, int numero){
		this.setCodArea(codArea);
		this.setCodPais(codPais);
		this.setNumero(numero);
	}

	public int getCodPais() {
		return codPais;
	}
	final public void setCodPais(int codPais) {
		if(codPais<1|| codPais > 1999) {
			this.codPais = -1;
		}else {
			this.codPais = codPais;
		}
	}

	
	public int getCodArea() {
		return codArea;
	}

	final public void setCodArea(int codArea) {
		if(codArea< 10 || codArea > 99) {
			this.codArea = -1;
		}else {
			this.codArea = codArea;
		}
	}

	
	public int getNumero() {
		return numero;
	}

	final public void setNumero(int numero) {
		if(numero < 10000000 || numero > 999999999 ) {
			this.numero = -1;
		}else {
			this.numero = numero;
		}
	}

	@Override
	public Posicao getPosicao() {
		Random r = new Random();
		double latitude = -3.160000 + (-2.960000 - (-3.160000 )) * r.nextDouble();
		double longitude = -60.120000 +(-59.820000 - (-60.120000))* r.nextDouble();
		double altitude = 15.0 + (100.0 - 15.0) * r.nextDouble();
		Posicao loc = new Posicao(latitude,longitude,altitude);
		return loc;
	}

	@Override
	public double getErroLocalizacao() {
		// TODO Auto-generated method stub
		return 50.0;
	}
}
