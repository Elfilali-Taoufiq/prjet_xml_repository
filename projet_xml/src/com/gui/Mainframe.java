package com.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.jar.JarFile;

import com.bo.Point;
import com.xml.XmlException;
import com.xml.XmlWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class Mainframe extends JFrame {
	
	private JPanel panMenu = new JPanel();
	private JPanel commentpane=new JPanel(); 
	 private PaintPane paintPane1;
	 
	private JLabel commentlab=new JLabel();

	 
	 public Mainframe(){
		 paintPane1=new PaintPane(this);
		  
		 setTitle("Application xml");
		
		
		 //menu  
		 
		 JButton convertToXmlBtn=new JButton("convertir en xml");
		 JButton changeMode=new JButton("Activer/desactiver dessin");

		 panMenu.add(convertToXmlBtn, JPanel.LEFT_ALIGNMENT);
		 panMenu.add(changeMode, JPanel.LEFT_ALIGNMENT);
		 
		 changeMode.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(paintPane1.isDrawMode())
				paintPane1.setDrawMode(false);
				else 	
					paintPane1.setDrawMode(true);

			}
			
			
				
		});

		 
		 convertToXmlBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					//convertir to xml	
				
				XmlWriter xmlWriter=new XmlWriter();
		
					try {
						xmlWriter.convert("D:\\exemple.xml",paintPane1.getLines() );
						
						System.out.println("ficier xml bien cree");
					} catch (XmlException e1) {
						System.out.println("erreur de conversion");
					}
				
			}
		});
		
		 commentlab.setText("test");
		 
		 commentpane.add(commentlab);
		 
		 add(panMenu,BorderLayout.NORTH);
		 add(commentpane,BorderLayout.SOUTH);
		 add(paintPane1);
		 
		 setVisible(true);
		 setDefaultCloseOperation(EXIT_ON_CLOSE);
		 setSize(500,400);
	 }
	 public void writeinCommentLab(String  pstring ){
	 commentlab.setText(commentlab.getText()+"  " +pstring);
	
}
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			public void run() {
				new Mainframe();
			}
		});
	}
	
	
}
		  
