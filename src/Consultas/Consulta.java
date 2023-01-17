package Consultas;

import java.util.Comparator;

public class Consulta implements Comparator <Consulta> {

	private Paciente paciente;
	private Medico medico;
	private String dia;
	private String mes;
	private String ano;
	private String hora;
	private int id;

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico Medico) {
		this.medico = Medico;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}


	public String getMes() {
		return mes;
	}


	public void setMes(String mes) {
		this.mes = mes;
	}


	public String getAno() {
		return ano;
	}


	public void setAno(String ano) {
		this.ano = ano;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;

	}

	public String getHora() {
		return hora;
	}

	public void setHora(String Hora) {
		this.hora = Hora;
	}


	@Override
	public String toString() {
		return "Consulta [ano=" + ano + ", dia=" + dia + ", hora=" + hora + ", id=" + id + ", medico=" + medico
				+ ", mes=" + mes + ", paciente=" + paciente + "]";
	}

	@Override
	public int compare(Consulta c1, Consulta c2) {
		
		String mes1 = c1.getMes();
		String mes2 = c2.getMes();

		return mes1.compareTo(mes2);
		
	}

	public static Comparator <Consulta> mesComparator = new Comparator<Consulta>() {

		@Override
		public int compare(Consulta c3, Consulta c4) {
			String dia1 = c3.getDia();
			String dia2 = c4.getDia();

			return dia1.compareTo(dia2);
		}
	};

	public static Comparator <Consulta> anoComparator = new Comparator<Consulta>() {

		@Override
		public int compare(Consulta c5, Consulta c6) {
			String ano1 = c5.getAno();
			String ano2 = c6.getAno();

			return ano1.compareTo(ano2);
		}
	};










	
}

	
    
	



	












	

	 

	

	
	

