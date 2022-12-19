package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import affichage.Fenetre;
import affichage.LoadingR;
import affichage.*;

public class Mouse implements MouseListener{
	Lab f;
	public Mouse(Lab f) {
		super();
		this.f = f;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==f.getReceive()) {
			f.removeAll();
			f.revalidate();
			f.f.getContentPane().add(new LoadingR(f.f));

		}
		if(e.getSource()==f.getSend()) {
			f.removeAll();
			f.revalidate();
			f.f.getContentPane().add(new Send(f.f));
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
