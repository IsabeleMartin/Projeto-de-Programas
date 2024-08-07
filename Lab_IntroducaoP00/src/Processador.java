
class Processador {
	String marca;
	String modelo;
	double velocidade;
	int numNucleos;
	Processador() {
		marca = "";
		modelo = "";
		velocidade = 0;
		numNucleos = 0;
	}
	Processador(String marca, String modelo, double velocidade, int numNucleos){
		this.modelo = modelo;
		this.marca = marca ;
		this.velocidade = velocidade;
		this.numNucleos = numNucleos;
	}
	double getVelocidadeParalela() {
		double result = velocidade*numNucleos;
		return result;
	}
	
	String getDescricao() {
		return "Processador: marca=" + marca + ", modelo=" + modelo + ", velocidade=" + velocidade + "GHz, numNucleos=" + numNucleos + ", velocidadeParalela=" + getVelocidadeParalela() + "GHz.";
	}
	

}
