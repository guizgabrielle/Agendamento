package Consultas;

public class Medico extends Pessoa {

	private String especialidade;
	private int id;
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public int getID() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		String string = "ID: " + String.valueOf(this.id) + "\tNome: " + this.nome + "\tEspecialidade: " + this.especialidade;
		return string;
	}
}
