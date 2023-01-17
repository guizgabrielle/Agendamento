package Consultas;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class CadastroDeConsultas {
	private void print(String print) {

		System.out.println(print);
	}

	private Scanner scan = new Scanner(System.in);

	private String textInput(String label) {
		System.out.println(label + "\n");
		String line = scan.nextLine();
		return line;
	}

	private CadastroDeMedicos cadMedicos;
	private CadastroDePacientes cadPacientes;

	private ArrayList<Consulta> listaDeConsultas = new ArrayList<Consulta>();

	public CadastroDeConsultas(CadastroDeMedicos cadMedicos, CadastroDePacientes cadPacientes) {
		this.cadMedicos = cadMedicos;
		this.cadPacientes = cadPacientes;
	}



	private ArrayList<Medico> filtroMedicosPorEspecialidade(String c) {
		ArrayList<Medico> listaDeMedicos = cadMedicos.getListaDeMedicos();
		ArrayList<Medico> lista = new ArrayList<Medico>();

		for (int i = 0; i < listaDeMedicos.size(); i++) {

			Medico d = listaDeMedicos.get(i);

			if (d.getEspecialidade().contains(c)) {
				lista.add(d);
			}

		}

		return lista;
	}

	private ArrayList<Paciente> filtroPacientesPorNome(String c) {
		ArrayList<Paciente> listaDePacientes = cadPacientes.getListaDePacientes();
		ArrayList<Paciente> lista = new ArrayList<Paciente>();

		for (Paciente paciente : listaDePacientes) {

			if (paciente.getNome().contains(c)) {
				lista.add(paciente);
			}

		}

		return lista;
	}

	public void cadastrarConsulta() {
		ArrayList<Medico> listaDeMedicos = cadMedicos.getListaDeMedicos();
		ArrayList<Paciente> listaDePacientes = cadPacientes.getListaDePacientes();

		if (listaDePacientes.size() != 0 && listaDeMedicos.size() != 0) {

			Consulta consulta = new Consulta();
			Paciente paciente = pickPaciente();
			Medico medico = pickMedico();

			consulta.setPaciente(paciente);
			consulta.setMedico(medico);
			consulta.setDia(textInput("Digite o Dia"));
			consulta.setMes(textInput("Digite o Mes"));
			consulta.setAno(textInput("Digite o Ano"));
			consulta.setHora(textInput("Digite o horário HH/MM"));
			consulta.setId(listaDeConsultas.size());
			listaDeConsultas.add(consulta);

		}

		else
			print("Por favor, cadastre médicos e pacientes primeiro.");

	}

	public void cadastrarConsultanoinicio(Paciente paciente, Medico medico, String dia, String mes, String ano,
			String hora) {

		Consulta consulta = new Consulta();
		consulta.setPaciente(paciente);
		consulta.setMedico(medico);
		consulta.setDia(dia);
		consulta.setMes(mes);
		consulta.setAno(ano);
		consulta.setHora(hora);
		consulta.setId(listaDeConsultas.size());
		listaDeConsultas.add(0, consulta);

	}

	private void cadastrarConsultainicio() {
		ArrayList<Medico> listaDeMedicos = cadMedicos.getListaDeMedicos();
		ArrayList<Paciente> listaDePacientes = cadPacientes.getListaDePacientes();

		if (listaDePacientes.size() != 0 && listaDeMedicos.size() != 0) {

			Consulta consulta = new Consulta();
			Paciente paciente = pickPaciente();
			Medico medico = pickMedico();

			consulta.setPaciente(paciente);
			consulta.setMedico(medico);
			consulta.setDia(textInput("Digite o Dia"));
			consulta.setMes(textInput("Digite o Mes"));
			consulta.setAno(textInput("Digite o Ano"));
			consulta.setHora(textInput("Digite o horário HH/MM"));
			consulta.setId(listaDeConsultas.size());
			listaDeConsultas.add(0, consulta);
		}

		else
			print("Por favor, cadastre médicos e pacientes primeiro.");

	}

	private Paciente pickPaciente() {
		ArrayList<Paciente> listaDePacientes = cadPacientes.getListaDePacientes();
		print("Digite o nome:");
		String name = scan.nextLine();

		listarPacientesPorNome(name);

		int i = Integer.valueOf(textInput("Digite o ID"));
		Paciente escolhido = listaDePacientes.get(i);
		return escolhido;
	}

	private Medico pickMedico() {
		ArrayList<Medico> listaDeMedicos = cadMedicos.getListaDeMedicos();

		String especialidadeprocurada = textInput("Digite a especialidade que deseja:");
		listarMedicosEspecialistas(especialidadeprocurada);

		int i = Integer.valueOf(textInput("Digite o ID"));

		Medico escolhido = listaDeMedicos.get(i);
		return escolhido;
	}

	public void listarPacientesPorNome(String nome) {
		ArrayList<Paciente> lista = filtroPacientesPorNome(nome);
		if (lista.size() == 0) {
			print("Não existe registros de pacientes com este nome");
		} else {
			System.out.println("Lista de Pacientes com este nome:");
			for (Paciente paciente : lista) {
				if (paciente.getNome().contains(nome)) {
					System.out.println("ID# " + paciente.getID());
					System.out.println("Nome: " + paciente.getNome());

				}
			}
		}
	}

	public void listarMedicosEspecialistas(String especialidade) {

		ArrayList<Medico> lista = filtroMedicosPorEspecialidade(especialidade);

		if (lista.size() == 0) {
			print("Não existem médicos cadastrados com esta especialidade.");

		}

		else {
			System.out.println("Lista de Especialistas:" + especialidade);

			for (int i = 0; i < lista.size(); i++) {
				Medico d = lista.get(i);
				System.out.println("\tID: " + d.getID());
				System.out.println("\tNome: " + d.getNome());
				System.out.println("\tCPF: " + d.getCpf());
				System.out.println("\tCargo: " + d.getEspecialidade());

			}

			System.out.println("\nFim da lista\n");
		}
	}

	public void listarConsultas() {

		System.out.println("\nSelecione uma opção:\n");
		System.out.println("0 - Voltar ao menu principal");
		System.out.println("1 - Listar todas as consultas");
		System.out.println("2 - Quantidade de consultas agendadas");
		System.out.println("3 - Localizar consulta pelo ID\n");

		switch (scan.nextInt()) {

			case 1:
				if (listaDeConsultas.size() == 0) {
					print("Não existem consultas cadastradas");
				}

				else {
					for (Consulta consulta : listaDeConsultas) {

						print("Consulta ID: " + String.valueOf(consulta.getId()));
						print("Paciente: " + consulta.getPaciente().getNome());
						print("Medico: " + consulta.getMedico().getNome());
						print("Data: " + consulta.getDia() + "/" + consulta.getMes() + "/" + consulta.getAno() + " as: "
								+ consulta.getHora() + " horas.\n");

					}
				}
				break;


			case 2:
				System.out.println("Número de consultas agendadas: ");
				System.out.println(listaDeConsultas.size());
				break;

			case 3:
				try {
					System.out.println("Para localizar a consulta, digite  o ID:  ");
					int id = scan.nextInt();
					System.out.println(listaDeConsultas.get(id));
				}

				catch (Exception e) {
					System.out.println("Este ID não existe!");
				}

			default:
				System.out.println("\nRetornando ao menu principal");
				break;
		}

	}

	public void cadastroTeste() {

		ArrayList<Paciente> listap = cadPacientes.getListaDePacientes();
		ArrayList<Medico> listam = cadMedicos.getListaDeMedicos();

		for (int i = 0; i < 5; i++) {

			cadastrarConsultanoinicio(listap.get(i), listam.get(i), String.valueOf(i), String.valueOf(i),
					String.valueOf(i),
					String.valueOf(i));
		}

	}

	public void pick() {
		System.out.println("\nCadastro de Consultas\n");
		System.out.println("\nSelecione uma opção:\n");
		System.out.println("0 - Voltar ao menu principal");
		System.out.println("1 - Incluir consulta no fim da lista ");
		System.out.println("2 - Incluir consulta no inicio da lista ");
		System.out.println("3 - Exibir consultas");
		System.out.println("4 - Remover consulta");
		System.out.println("5 - Ordenar consultas");

		switch (scan.nextInt()) {
			case 1:
				cadastrarConsulta();
				break;

			case 2:
				cadastrarConsultainicio();
				break;

			case 3:
				listarConsultas();
				break;

			case 4:
				cancelarConsulta();
				break;
			case 5:
				ordenarConsulta();
				break;

			default:
				System.out.println("\nRetornando ao menu principal");
				break;
		}

	}

	private void ordenarConsulta() {
		if (listaDeConsultas.size() == 0) {
			print("\nNão existem consultas cadastradas");
		}

		else {
			Consulta cpm;
			cpm = new Consulta();

			OrdenarDia cpd;
			cpd = new OrdenarDia();

			OrdenarAno cpa;
			cpa = new OrdenarAno();

			Collections.sort(listaDeConsultas, cpm);
			Collections.sort(listaDeConsultas, cpd);
			Collections.sort(listaDeConsultas, cpa);

			System.out.println("\nLista de consultas ordenada!");
		}

	}

	public void cancelarConsulta() {
		System.out.println("\nDigite o ID da consulta que deseja remover:");
		int id = scan.nextInt();
		listaDeConsultas.remove(id);
		System.out.println("\nConsulta removida!\n");

	}

	public ArrayList<Consulta> getListaDeConsultas() {
		return new ArrayList<Consulta>(listaDeConsultas);
	}
}