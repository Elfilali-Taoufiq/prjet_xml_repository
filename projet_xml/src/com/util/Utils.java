package com.util;

import com.bo.*;


public  class Utils {
	
	

	public  Utils() {
	
	}

	public static double distancePointLine(Point p,Line line){
		int x1=line.getA().getX();
		int y1=line.getA().getY();
		
		int x2=line.getB().getX();
		int y2=line.getB().getY();
return Math.abs((y2-y1)*p.getX()-(x2-x1)*p.getY()+x2*y1-y2*x1)/Math.sqrt((y2-y1)*(y2-y1)+(x2-x1)*(x2-x1));
		
		
		
	}
	
	
	
	
}
