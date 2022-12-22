package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import affichage.FrameConfig;
import affichage.*;
import traitement.*;

public class MouseSend implements MouseListener{
	Send sen;
	
	public MouseSend(Send sen) {
		super();
		this.sen = sen;
	}

	public Send getSen() {
		return sen;
	}

	public void setSen(Send sen) {
		this.sen = sen;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==sen.getPara()) {
			try {
				new FrameConfig();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource()==sen.getSnd()) {
			
			System.out.println(sen.getValfil());
			Sends sp=new Sends();
		
			try {
				RunSend rs=new RunSend(sp.getliste()[sp.getliste().length-1],9090, sen.getValfil(),sen);
				rs.start();
				sen.remove(sen.getSnd());
				sen.revalidate();
				sen.add(sen.getLoad());
				sen.repaint();
			} catch (Exception e1) {
			}
			sen.setValfil(null);
		}
		if(e.getSource()==sen.getRet()){
			sen.removeAll();
			sen.revalidate();
			sen.f.remove(sen);
			sen.f.getContentPane().add(new Lab(sen.f));
			sen.f.repaint();
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
