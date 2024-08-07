
public class SessaoJediMain {

	public static void main(String[] args) {
		IniciadoJedi jedi = new IniciadoJedi("Kotooni","Tholothian",23);
		String jedi_info = jedi.getDescricao();
		System.out.println(jedi_info);
		
		TreinadorJedi treinador = new TreinadorJedi("Grão-Mestre", "Fae Coven");
		String treinador_info = treinador.getDescricao();
		System.out.println(treinador_info);
		
		SessaoJedi sessao = new SessaoJedi("Instruções de Uso da Força",treinador);
		sessao.addIniciado(jedi);
		String sessao_info = sessao.getDescricao();
		System.out.println(sessao_info);
	}

}
