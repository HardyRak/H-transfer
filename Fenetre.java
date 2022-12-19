package affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import listener.Mouse;

public class Fenetre extends JFrame{
	Lab lab;

	
	public Fenetre() {
		
		this.setResizable(false);
		this.setSize(new Dimension(300,500));
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setTitle("H-Transfert");
		
		//------------Create body---------------------------
		lab=new Lab(this);

		//------------header-----------------------------
		
		this.getContentPane().add(lab);
		this.setVisible(true);
	}
}
