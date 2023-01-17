package Consultas;

//import java.util.ArrayList;
import java.util.Scanner;

public class InterfaceDeUsuario {
	private void print(String print) {
		System.out.println(print + "\n");
	}

	CadastroDePacientes CadastroDePacientes = new CadastroDePacientes();
	CadastroDeMedicos CadastroDeMedicos = new CadastroDeMedicos();
	CadastroDeConsultas CadastroDeConsultas = new CadastroDeConsultas(CadastroDeMedicos, CadastroDePacientes);
	Scanner entrada = new Scanner(System.in);

	public void apresentarInterface() {
		this.mostrarMenuOpcoes();
		int opcao = entrada.nextInt();
		while (opcao != 0) {
			switch (opcao) {
				case 1:
					CadastroDePacientes.pick();
					break;

				case 2:
					CadastroDeMedicos.pick();
					break;

				case 3:
					CadastroDeConsultas.pick();
					break;

				case 4:
					CadastroDePacientes.Setup();
					CadastroDeMedicos.Setup();
					CadastroDeConsultas.cadastroTeste();
					System.out.println("\nCadastro TESTE incluído\n");
					break;

				default:
				print("Opção inválida");
				break;

			}

			this.mostrarMenuOpcoes();
			opcao = entrada.nextInt();

		}

	}

	private void mostrarMenuOpcoes() {
		System.out.println("\n0.Sair");
		System.out.println("1.Cadastrar um paciente");
		System.out.println("2.Cadastro de médicos");
		System.out.println("3.Cadastro de consultas");
		System.out.println("4.Fazer Cadastro de Teste");
	}

}





