
public class ComputadorMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Processador cpu = new Processador("i7","Intel",3.2,8);
		String result = cpu.getDescricao();
		System.out.println(result);
		
		Memoria men = new Memoria("Kingston","DDR4",8.0,3.2,4);
		String men_info = men.getDescricao();
		System.out.println(men_info);
		
		Disco disc = new Disco("Western Digital","HDD",4000.0,9600);
		String disc_info = disc.getDescricao();
		System.out.println(disc_info);
		
		Computador compu = new Computador("Dell",cpu,men,disc);
		String compu_info = compu.getDescricao();
		System.out.println(compu_info);
	}

}
