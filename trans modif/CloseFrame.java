package listener;
import java.awt.event.*;
import javax.swing.*;
import affichage.*;
public class CloseFrame implements WindowListener{
	Fenetre f;
	public Fenetre getF(){
		return f;
	}
	public void setF(Fenetre f){
		this.f=f;
	}
	public CloseFrame(Fenetre f){
		this.f=f;
	}
	@Override
	public void windowOpened(WindowEvent e){

	}
	@Override
	public void windowClosing(WindowEvent e){
		if(e.getSource()==this.getF()){
			Object[] options={"Oui","Non"};
			int jopt=JOptionPane.showOptionDialog(
				new JFrame(),
				"Quitter la session??\n",
				"Quitter",
				JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE,
				null,
				options,
				options[0]
			);
			if(jopt==0){
				System.exit(1);
			}
		}
	}
	@Override
	public void windowClosed(WindowEvent e){

	}
	@Override
	public void windowIconified(WindowEvent e){

	}
	@Override
	public void windowActivated(WindowEvent e){

	}
	@Override
	public void windowDeactivated(WindowEvent e){

	}
	@Override
	public void windowDeiconified(WindowEvent e){

	}
}