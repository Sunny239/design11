package com.product;

import java.util.Comparator;
import java.util.Date;

public class ComparatorDate implements Comparator {

	@Override
	public int compare(Object obj1, Object obj2) {
		Date begin = (Date)obj1;
		Date end = (Date)obj2;
		 if (begin.after(end)) {  
	            return 1;  
	        } else {  
	            return -1;  
	        } 
	}

	
}
