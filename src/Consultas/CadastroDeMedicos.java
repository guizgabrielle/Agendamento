package Consultas;

import java.util.Scanner;
import java.util.ArrayList;

public class CadastroDeMedicos {

	private Scanner scan = new Scanner(System.in);

	private String textInput(String label) {
		System.out.println(label + "");
		return scan.nextLine();
	}

	private ArrayList<Medico> listaDeMedicos = new ArrayList<Medico>();

	// cadastro de teste
	public void Setup() {
		// faz 5 cadastros aleatorios para teste
		// nao considerar nomes, fiz somente para me auxiliar durante o processo

		String[] specs = { "Oftalmologista", "Ortopedista", "Dentista", "Gastroenterologista", "Hepatologista",
				"Neurologista", "Endocrinologista", "Dermatologista", "Cardiologista" };
		String[] nome = {"Afonso","Bernardo","Carolina","Debora","Eduarda","Felipe","Guilherme","Lais","Vinicius"};
		String[] cpf = {"1","2","3","4","5","6","7","8","9"};
			for (int j = 0; j < 9; j++) {
				cadastrarMedico(nome[j], cpf[j], specs[j]);
		
			}
		}
	

	public void cadastrarMedico() {
		Medico d = new Medico();
		scan.nextLine();
		d.setNome(textInput("Nome: "));
		d.setCpf(textInput("CPF: "));
		d.setEspecialidade(textInput("Especialidade: "));
		d.setId(listaDeMedicos.size());
		listaDeMedicos.add(d);
	}

	public void cadastrarMedico(String nome, String cpf, String espec) {
		Medico d = new Medico();
		d.setNome(nome);
		d.setCpf(cpf);
		d.setEspecialidade(espec);
		d.setId(listaDeMedicos.size());
		listaDeMedicos.add(d);
	}

	public void listarMedicos() {

		if (listaDeMedicos.size() != 0 ) {

		System.out.println("Lista de Medicos");

		for (int i = 0; i < listaDeMedicos.size(); i++) {
			Medico d = listaDeMedicos.get(i);
			System.out.println("\tID: " + i);
			System.out.println("\tNome: " + d.getNome());
			System.out.println("\tCPF: " + d.getCpf());
			System.out.println("\tCargo: " + d.getEspecialidade() + "");
			System.out.println("Fim da lista");
		}
	}

	else
	System.out.println("\nPor favor, cadastre médicos primeiro!");
}


	public ArrayList<Medico> getListaDeMedicos() {
		return new ArrayList<Medico>(listaDeMedicos);
	}

	public void pick() {
		System.out.println("\nCadastro de Medicos");
		System.out.println("\nSelecione uma opção:\n");
		System.out.println("0 - Voltar ao menu principal");
		System.out.println("1 - Cadastrar novo médico");
		System.out.println("2 - Listar médicos");

		switch (scan.nextInt()) {
			case 1:
				cadastrarMedico();
				break;

			case 2:
				listarMedicos();
				break;

			default:
				System.out.println("\nRetornando ao menu principal\n");
				break;
		}

	}

	@Override
	public String toString() {
		return "Teste Override Medicos";
	}
}
