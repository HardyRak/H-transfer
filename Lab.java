package affichage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;

import listener.Mouse;

public class Lab extends JLabel{
	public Fenetre f;
	JButton receive;
	JButton send;
	public JButton getReceive() {
		return receive;
	}
	public void setReceive(JButton receive) {
		this.receive = receive;
	}
	public JButton getSend() {
		return send;
	}
	public void setSend(JButton send) {
		this.send = send;
	}
	public Lab(Fenetre f){
		this.f=f;
		JPanel pan=new JPanel();
		pan.setBounds(0, 0, 300, 50);
		pan.setBackground(Color.blue);
	
		//-------------------body----------------------
		JPanel body=new JPanel();
		body.setBounds(85, 150, 125, 125);
		JLabel sary=new JLabel();
		ImageIcon imgc=new ImageIcon("multi\\logo3.png");
		sary.setIcon(imgc);
		this.setBackground(Color.red);

		JPanel logname=new JPanel();
		logname.setBounds(75, 285, 125, 50);
		JLabel anarany=new JLabel();
		anarany.setFont(new Font("VERDANA",Font.PLAIN,18));
		anarany.setText("H-Transfert");
		
		
		//--------------Footer------------------------
		ImageIcon imgsend=new ImageIcon("multi\\send.png");
		ImageIcon imgreceive=new ImageIcon("multi\\receive.png");
		send=new JButton(imgsend);
		receive=new JButton(imgreceive);
		send.setBounds(75, 400, 50, 50);
		receive.setBounds(155, 400, 50, 50);
		
		Mouse m=new Mouse(this);
		send.setBorder(new RoundBTn(15));
		receive.setBorder(new RoundBTn(15));
		send.addMouseListener(m);
		receive.addMouseListener(m);
		
		this.add(send);
		this.add(receive);
		
		logname.add(anarany);
		body.add(sary);
		this.add(logname);
		this.add(body);
		this.add(pan);
	}
}