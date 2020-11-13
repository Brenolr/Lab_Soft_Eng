package net.javaguides.covidnet.model;

public class Coordenadas {
	private int latitude;
	private int longitude;
	
	public Coordenadas(int latitude, int longitude) {
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public void editar(int latitude, int longitude) {
		this.latitude=latitude;
		this.longitude=longitude;
	}
	public int getLatitude() {
		return(latitude);
	}
	public int getLongitude() {
		return(longitude);
	}
	
}
