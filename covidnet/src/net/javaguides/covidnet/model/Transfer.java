package net.javaguides.covidnet.model;

import java.time.LocalDateTime;

/**
 * User.java
 * This is a model class represents a User entity
 * @author Ramesh Fadatare
 *
 */
public class Transfer {

	
	protected int id;
	protected int id_local_origem;
	protected int id_local_destino;
	protected int id_paciente;
	protected LocalDateTime data_e_hora;
	protected boolean aberto;
	
	public Transfer() {
	}
	// To insert new one
	public Transfer(int id_local_origem, int id_paciente) {
		super();
		this.id_local_origem = id_local_origem;
		this.id_paciente = id_paciente;
		this.data_e_hora = LocalDateTime.now();
		this.aberto = true;
	}
	
	public Transfer(int id, int id_local_origem, int id_paciente) {
		super();
		this.id = id;
		this.id_local_origem = id_local_origem;
		this.id_paciente = id_paciente;
		this.data_e_hora = LocalDateTime.now();
		this.aberto = true;
	}
/*	
	public Transfer(int id, int id_local_origem, int id_local_destino, int id_paciente) {
		super();
		this.id = id;
		this.id_local_origem = id_local_origem;
		this.id_local_destino = id_local_destino;
		this.id_paciente = id_paciente;
		this.data_e_hora = LocalDateTime.now();
		this.aberto = true;
	}*/
	// To update
	public Transfer(int id, int id_local_origem, int id_local_destino, boolean aberto) {
		super();
		this.id = id;
		this.id_local_origem = id_local_origem;
		this.id_local_destino = id_local_destino;
		this.aberto = aberto;
	}
	// To list
	public Transfer(int id, int id_local_origem, int id_local_destino, int id_paciente, LocalDateTime time, boolean aberto) {
		super();
		this.id = id;
		this.id_local_origem = id_local_origem;
		this.id_local_destino = id_local_destino;
		this.id_paciente = id_paciente;
		this.data_e_hora = time;
		this.aberto = aberto;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	public int getId_local_origem() {
		return id_local_origem;
	}

	public void setId_local_origem(int id_local_origem) {
		this.id_local_origem = id_local_origem;
	}

	public int getId_local_destino() {
		return id_local_destino;
	}

	public void setId_local_destino(int id_local_destino) {
		this.id_local_destino = id_local_destino;
	}

	public int getId_paciente() {
		return id_paciente;
	}

	public void setId_paciente(int id_paciente) {
		this.id_paciente = id_paciente;
	}

	public LocalDateTime getData_e_hora() {
		return data_e_hora;
	}

	public void setData_e_hora(LocalDateTime data_e_hora) {
		this.data_e_hora = data_e_hora;
	}

	public boolean isAberto() {
		return aberto;
	}

	public void setAberto(boolean aberto) {
		this.aberto = aberto;
	}
	public void openRequest() {
		this.aberto = true;
	}
	public void closeRequest() {
		this.aberto = false;
	}
}
