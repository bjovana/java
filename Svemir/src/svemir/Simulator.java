package svemir;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Simulator extends Frame {
	
	private Svemir svemir = new Svemir();
	private Button pokreniDugme = new Button("Pokreni!");
	private Generator generator = new Generator(svemir);
	
	private void populateWindow() {
		
		add(svemir, BorderLayout.CENTER);
		
		Panel dugme = new Panel();
		dugme.add(pokreniDugme);
		add(dugme, BorderLayout.SOUTH);
		
		pokreniDugme.addActionListener((ae) ->{
			
			pokreniDugme.setEnabled(false);
			svemir.kreni();
			generator.kreni();
		});
		
		
	}
	
	public Simulator() {
		
		setBounds(new Rectangle(200,400));
		setResizable(false);
		
		populateWindow();
		
		addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				generator.interrupt();
				svemir.nit.interrupt();
				dispose();
			}
		});
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		new Simulator();
	}
}
