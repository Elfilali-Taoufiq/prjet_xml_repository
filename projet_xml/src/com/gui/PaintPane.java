package com.gui;

import java.awt.Graphics;
import java.awt.List;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.bo.Line;
import com.bo.Point;
import com.util.*;



public class PaintPane extends JPanel{ 
	

	private ArrayList<Line> lines =new ArrayList<Line>();	
	private Line selectedLine;
	private boolean drawMode=true;


	public PaintPane( final Mainframe parent){
	
	addMouseListener(new MouseAdapter() {
		
		
		Point point;
	
		
		
		
		public void mousePressed(MouseEvent e) {
			
			
			point=new Point(e.getX(), e.getY());
		
		}
		
		
	public void mouseReleased(MouseEvent e) {
			
			Point lpoint=new Point(e.getX(), e.getY());
			Line lineDistanceMin = null;
			if(drawMode){
			lines.add(new Line(point, lpoint)); 
			repaint();
			}
			else{
				if(lines.size()!=0){
				 lineDistanceMin=lines.get(0);
				for(Line it:lines){
					if(Utils.distancePointLine(lpoint, it)< Utils.distancePointLine(lpoint, lineDistanceMin)){
						
						lineDistanceMin=it;
					}
				}
						
				}
				
				selectedLine=lineDistanceMin;
				String comment=JOptionPane.showInputDialog("entrez votre commentaire");
				selectedLine.addCommente(comment );
				
				
				parent.writeinCommentLab(getSelectedLine().getComment());
				

				 }
				
				 
			}
		
		
	});
}


		 public void convertToXml(){
			 
			 
		 }
   public void drawLines(Graphics g){
	   for (Line it: lines) {
		   g.drawLine(it.getA().getX(), it.getA().getY(), it.getB().getX(), it.getB().getY());
		   
	}
	   
   }

		 public  void paint(Graphics g){
			 super.paint(g) ;
			 drawLines(g);
		 }
	
	public void add(Line l){
		lines.add(l);
	
	}



	public ArrayList<Line> getLines() {
		return lines;
	}


	
	public void setLines(ArrayList<Line> lines) {
		this.lines = lines;
	}


	
	public boolean isDrawMode() {
		return drawMode;
	}


	public void setDrawMode(boolean drawMode) {
		this.drawMode = drawMode;
	}


	
	public Line getSelectedLine() {
		return selectedLine;
	}


	
	public void setSelectedLine(Line selectedLine) {
		this.selectedLine = selectedLine;
	}
	
	
	
	
	
	

}
