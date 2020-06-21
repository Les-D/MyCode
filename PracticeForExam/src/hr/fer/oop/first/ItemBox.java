package hr.fer.oop.first;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ItemBox<T extends Item> extends SimpleArrayList<T> {
	
	public SimpleArrayList<T> calculateDiscount(double low, double high){
		
		SimpleArrayList<T> arr = new SimpleArrayList<>();
		
		for(int i = 0; i < this.size(); i++) {
			if(this.get(i) instanceof Perishable) {
				Perishable p = (Perishable) this.get(i);
				if(LocalDate.now().until(p.getBestBefore(), ChronoUnit.DAYS) < 0) {
					this.get(i).setNetSalePrice(0);
				}
				else if(LocalDate.now().until(p.getBestBefore(), ChronoUnit.DAYS) <= 5) {
					this.get(i).setNetSalePrice(this.get(i).getNetSalePrice()*(1 - high));
				}
				else if(LocalDate.now().until(p.getBestBefore(), ChronoUnit.DAYS) >= 6 &&
						LocalDate.now().until(p.getBestBefore(), ChronoUnit.DAYS) <= 10) {
					this.get(i).setNetSalePrice(this.get(i).getNetSalePrice()*(1 - low));
				}
				arr.add(this.get(i));
			}
		}
		
		return arr;
		
	}

}
