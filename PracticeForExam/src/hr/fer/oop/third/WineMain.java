package hr.fer.oop.third;

import java.util.Set;
import java.util.TreeSet;

public class WineMain {
	
	public static void main(String[] args) {
		
		//Set<Wine> wines = new TreeSet<>();
		Set<Wine> wines = new TreeSet<>(Wine.COMPARE_BY_ABV);
		
		
		wines.add(new Wine("Bijelo", "Žnidaršić", 10.2, Type.WHITE));
		wines.add(new Wine("Crno", "Žnidaršić", 15.0, Type.RED));
		wines.add(new Wine("Pleševičko", "Žnidaršić", 14.5, Type.WHITE));
		
		wines.forEach((p) -> System.out.println(p.getWinery() + ", " + p.getLabel() + " - " + p.getAbv() + "%"));
		
		
	}

}
