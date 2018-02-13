package com.bo;

import java.util.ArrayList;
import java.util.List;

public class Line  {
	
	
		private Long id; 
		 private Point a;
		 private Point b;
		 
		 private List<String> comments=new ArrayList<String>();
		 
		public Line(Point a, Point b) {
			super();
			this.a = a;
			this.b = b;
		}


		
		public void addCommente(String comment){
			comments.add(comment);
		}
		 
		
		public String getComment(){
			StringBuffer sb=new StringBuffer();
			sb.append("<html>");
			for(String it:comments){
				sb.append(it);
				sb.append("<br/>");
			}
			sb.append("</html>");
				return sb.toString();
			

 
		}
		public Long getId() {
			return id;
		}




		public void setId(Long id) {
			this.id = id;
		}




		public Point getA() {
			return a;
		}


		
		public void setA(Point a) {
			this.a = a;
		}


		
		public Point getB() {
			return b;
		}


		
		public void setB(Point b) {
			this.b = b;
		}





	
		public String toString() {
			return "Line [id=" + id + ", a=" + a + ", b=" + b + "]";
		}
		
		
		
		
}
