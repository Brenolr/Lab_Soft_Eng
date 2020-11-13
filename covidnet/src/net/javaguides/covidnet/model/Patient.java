package net.javaguides.covidnet.model;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class Patient {
	
	protected int id;
	protected String nome;
	protected String email;
	protected String cpf;
	// protected LocalDeAtendimento localDeAtendimento;
	protected String sintomas;
	protected int id_localDeAtendimento;
	protected int id_prontuario;
	protected String gravidade;
	protected String telefone;
	
	public Patient() {
	}
	
	public Patient(String nome, String email, String cpf, String sintomas, int id_prontuario, int id_localDeAtendimento, 
String gravidade, String telefone) {
		super();
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.sintomas = sintomas;
		this.id_prontuario = id_prontuario;
		this.id_localDeAtendimento = id_localDeAtendimento;
		this.gravidade = gravidade;
		this.telefone = telefone;
	}
	
	public Patient(int id, String nome, String email, String cpf, String sintomas, int id_prontuario, int id_localDeAtendimento, 
String gravidade, String telefone) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.sintomas = sintomas;
		this.id_prontuario = id_prontuario;
		this.id_localDeAtendimento = id_localDeAtendimento;
		this.gravidade = gravidade;
		this.telefone = telefone;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getSintomas() {
		return sintomas;
	}
	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}
	public int getId_localDeAtendimento() {
		return id_localDeAtendimento;
	}

	public void setId_localDeAtendimento(int id_localDeAtendimento) {
		this.id_localDeAtendimento = id_localDeAtendimento;
	}

	public int getId_prontuario() {
		return id_prontuario;
	}

	public void setId_prontuario(int id_prontuario) {
		this.id_prontuario = id_prontuario;
	}
	public String getGravidade() {
		return gravidade;
	}
	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}

	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
