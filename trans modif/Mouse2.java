package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.*;
import java.net.*;
import javax.swing.*;
import affichage.*;
import traitement.*;

public class Mouse2 implements MouseListener{
	LoadingR lr;
	
	public Mouse2(LoadingR lr) {
		super();
		this.lr = lr;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		RunReceive runrec = new RunReceive(lr);
		
		// TODO Auto-generated method stub
		if(e.getSource()==lr.getAtt()) {
			try {
				runrec.start();
				System.out.println("maheno");
				lr.remove(lr.getAtt());
				lr.revalidate();
				lr.add(lr.getLoad());
				lr.repaint();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==lr.getCloscon()) {
			try{
				runrec.mamono();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		if(e.getSource()==lr.getRet()){                                                                          
			lr.removeAll();
			lr.revalidate();
			lr.f.remove(lr);
			lr.f.add(new Lab(lr.f));
			lr.f.repaint();
			System.out.println("Maheno");
		}
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
