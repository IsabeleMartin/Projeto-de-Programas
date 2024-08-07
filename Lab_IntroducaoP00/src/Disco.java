
public class Disco {
	String marca;
	String tipo;
	double capacidade;
	int rpm;
	
	Disco(){
		marca = "";
		tipo = "";
		capacidade = 0.0;
		rpm = 0;
	}
	
	Disco(String marca, String tipo, double capacidade, int rpm){
		this.marca = marca;
		this.tipo = tipo;
		this.capacidade = capacidade;
		this.rpm = rpm;
	}
	String getDescricao() {
		return "Disco: marca="+marca+", tipo="+tipo+", capacidade="+capacidade+"GB, rpm="+rpm+"rpm.";
	}
}

