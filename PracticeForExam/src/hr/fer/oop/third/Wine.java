package hr.fer.oop.third;

import java.util.Comparator;

public class Wine implements Comparable<Wine>{
	
	private String label;
	private String winery;
	private double abv;
	private Type type;
	
	
	public Wine(String label, String winery, double abv, Type type) {
		this.label = label;
		this.winery = winery;
		this.abv = abv;
		this.type = type;
	}
	
	
	public String getLabel() {
		return label;
	}

	public String getWinery() {
		return winery;
	}

	public double getAbv() {
		return abv;
	}

	public Type getType() {
		return type;
	}
	
	
	@Override
	public int compareTo(Wine other) {
		if(!this.getType().toString().equals(other.getType().toString()))
			return -this.getType().toString().compareTo(other.getType().toString());
		else if(!this.getLabel().equals(other.getLabel()))
			return this.getLabel().compareTo(other.getLabel());
		else if(!this.getWinery().equals(other.getWinery()))
			return this.getWinery().compareTo(other.getWinery());
		else
			return 0;
	}
	
	
	public static final Comparator<Wine> COMPARE_BY_ABV = (o1, o2) -> -Double.compare(o1.getAbv(), o2.getAbv());

}
