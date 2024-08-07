package br.edu.ufam.icomp.lab_encapsulamento;

public class GISMain {

	public static void main(String[] args) {
		Localizavel[] vetLoc = new Localizavel[100];
		
		
		Posicao loc = new Posicao(-3.089242, -59.964874, 88.374);
		String loc_info = loc.toString();
		System.out.println(loc_info);
		
		Celular cell = new Celular(145, 92, 996095099);
		loc = cell.getPosicao();
		loc_info = loc.toString();
		System.out.println(loc_info);
		
		CarroLuxuoso car = new CarroLuxuoso("JKL-8965");
		CarroLuxuoso carLux = new CarroLuxuoso("ABC-999");
		Celular cell2 = new Celular( 456, 45, 78965412);
		
		vetLoc[0] = cell;
		vetLoc[1] = car;
		vetLoc[2] = carLux;
		vetLoc[3] = cell2;
		
		for(int i = 0; i <4; i++) {
			System.out.println(vetLoc[i].getPosicao());
		}
	}

}
