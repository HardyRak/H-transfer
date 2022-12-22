package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import affichage.Send;

public class Parcourfile implements ActionListener{
	Send s;
	public Send getS() {
		return s;
	}

	public void setS(Send s) {
		this.s = s;
	}
	public Parcourfile(Send s) {
		super();
		this.s = s;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		 JFileChooser fc = new JFileChooser();
		   if (fc.showOpenDialog(s) == JFileChooser.APPROVE_OPTION) {
			   //System.out.println(fc.getSelectedFile().toString());
			   s.setValfil(fc.getSelectedFile().getPath());
		      }
		  }


}


