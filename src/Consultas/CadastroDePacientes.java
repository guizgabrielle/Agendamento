package Consultas;

import java.util.Scanner;
import java.util.ArrayList;


public class CadastroDePacientes {
	private Scanner scan = new Scanner(System.in);

	private String textInput(String label) {
		System.out.println(label + "\n");
		return scan.nextLine();
	}

	private ArrayList<Paciente> listaDePacientes = new ArrayList<Paciente>();

	// cadastro de teste
	public void Setup() {
		
		String[] nome = {"Marina","Naiara","Matheus","Paula","Otavio"};
		String[] cpf = {"1","2","3","4","5","6","7","8","9"};
		String[] end = {"Rua 1","Rua 2","Rua 3", "Rua 4", "Rua 5"};
		for (int i = 0; i < 5; i++) {
			Paciente d = new Paciente();
			d.setNome(nome[i]);
			d.setCpf(cpf[i]);
			d.setEndereco(end[i]);
			d.setId(listaDePacientes.size());
			listaDePacientes.add(d);
		}
	}

	public void cadastrarPaciente() {
		Paciente d = new Paciente();
		scan.nextLine();
		d.setNome(textInput("Nome: "));
		d.setCpf(textInput("CPF: "));
		d.setEndereco(textInput("Endereco: "));
		d.setId(listaDePacientes.size());
		listaDePacientes.add(d);
	}

	public void listarPacientes() {

		if (listaDePacientes.size() != 0 ) {
			
			System.out.println("\nLista de Pacientes\n");
		
			for (int i = 0; i < listaDePacientes.size(); i++) {
			Paciente d = listaDePacientes.get(i);
			System.out.println("\tID: " + i);
			System.out.println("\tNome: " + d.getNome());
			System.out.println("\tCPF: " + d.getCpf());
			System.out.println("\tEndereco: " + d.getEndereco() + "\n");
			System.out.println("\nFim da lista\n");
		}
	}
		else
		System.out.println("\nPor favor, cadastre pacientes primeiro!");

		
	}

	public ArrayList<Paciente> getListaDePacientes() {
		return new ArrayList<Paciente>(listaDePacientes);
	}

	public void pick() {
		System.out.println("\nCadastro De Pacientes\n");
		System.out.println("\nSelecione uma opção:\n");
		System.out.println("0 - Voltar ao menu principal");
		System.out.println("1 - Cadastrar novo paciente");
		System.out.println("2 - Listar pacientes");

		switch (scan.nextInt()) {
			case 1:
				cadastrarPaciente();
				break;

			case 2:
				listarPacientes();
				break;

			default:
				System.out.println("\nRetornando ao menu principal\n");
				break;
		}

	}

	public String toString() {
		return "Teste Override Pacientes";
	}
}
