package net.javaguides.covidnet.model;
import java.util.Random;


public class GoogleMapsFake {
		
	public Coordenadas getCordenadas(String endereco) {
		
		Random gerador = new Random();
		int seed = endereco.hashCode();
		
		gerador.setSeed(seed);
		
		Coordenadas coor = new Coordenadas(gerador.nextInt(1000),gerador.nextInt(1000));
		
		return(coor);
	}
	
	public double getDintancia(Coordenadas A, Coordenadas B) {
		
		int x=A.getLatitude() - B.getLatitude();
		
		int y=A.getLongitude() - B.getLongitude();
		
		double D = Math.sqrt(x*x + y*y);
		
		return(D);
	}
}
