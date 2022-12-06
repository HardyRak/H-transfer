package traitement;
import java.lang.*;
import affichage.*;
import javax.swing.*;
public class RunSend extends Thread{
	Send sen;
	Sends snd;
	
	String ip;
	int port;
	String path;

	public RunSend(String ip,int port,String path,Send sen){
		this.sen=sen;
		this.ip=ip;
		this.port=port;
		this.path=path;
	}
	public void run(){
		snd=new Sends();
		try{
			snd.send(this.ip,this.port,this.path);
		}catch(Exception e){
			JOptionPane.showMessageDialog(new JFrame(),"L'autre Ordinateur n'est pas connecter ou Fichier vide","Attente",JOptionPane.WARNING_MESSAGE);
		}
		sen.remove(sen.getLoad());
		sen.revalidate();
		sen.add(sen.getSnd());
		sen.repaint();
	}
}