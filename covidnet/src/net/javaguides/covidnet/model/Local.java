package net.javaguides.covidnet.model;

public class Local {

	protected int id;
	protected String nome;
	protected String endereco;
	protected int camas_disponiveis;
	protected int camas_ocupadas;
	protected int latitude;
	protected int longitude;
	

	public Local(String name, String address, int Av_beds, int Oc_beds) {
		super();
		this.nome = name;
		this.endereco = address;
		this.camas_disponiveis = Av_beds;
		this.camas_ocupadas = Oc_beds;
		this.getCoor();
	}

	public Local(int id, String name, String address, int Av_beds, int Oc_beds) {
		super();
		this.id = id;
		this.nome = name;
		this.endereco = address;
		this.camas_disponiveis = Av_beds;
		this.camas_ocupadas = Oc_beds;
		this.getCoor();
	}
	
	private void getCoor() {
		
		GoogleMapsFake google = new GoogleMapsFake();
		Coordenadas coor = google.getCordenadas(endereco);
		latitude = coor.getLatitude();
		longitude = coor.getLongitude();
		
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
	public void setNome(String name) {
		this.nome = name;
	}
	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
		this.getCoor();
	}

	public int getCamas_disponiveis() {
		return camas_disponiveis;
	}

	public void setCamas_disponiveis(int camas_disponiveis) {
		this.camas_disponiveis = camas_disponiveis;
	}

	public int getCamas_ocupadas() {
		return camas_ocupadas;
	}
	
	public void setCamas_ocupadas(int camas_ocupadas) {
		this.camas_ocupadas = camas_ocupadas;
	}
	
	public int getLatitude() {
		return latitude;
	}
	public int getLongitude() {
		return longitude;
	}
}

