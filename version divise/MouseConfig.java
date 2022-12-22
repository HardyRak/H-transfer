package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import affichage.FrameConfig;

public class MouseConfig implements MouseListener{
	FrameConfig fc;
	
	public FrameConfig getFc() {
		return fc;
	}

	public void setFc(FrameConfig fc) {
		this.fc = fc;
	}
	public MouseConfig(FrameConfig fc) {
		super();
		this.fc = fc;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==fc.getConf()) {
			String f=fc.makatextfiel();
			fc.mouse(f);
			fc.dispose();
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
