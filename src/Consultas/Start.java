package Consultas;

public class Start {

	public static void main(String[] args) {

		InterfaceDeUsuario interacao = new InterfaceDeUsuario();
		try {
				interacao.apresentarInterface();
		} catch (Exception e) {
			System.out.println("Erro na execucao do programa");
		}

	}
}