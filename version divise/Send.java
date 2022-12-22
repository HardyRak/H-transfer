package affichage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.MouseSend;
import listener.Parcourfile;

public class Send extends JLabel{
	public Fenetre f;
	JPanel load;
	JButton fil;
	JButton para;
	JButton snd;
	JButton ret;
	String valfil;
	public JPanel getLoad(){
		return load;
	}
	public void setLoad(JPanel load){
		this.load=load;
	}
	public JButton getRet() {
		return ret;
	}

	public void setRet(JButton ret) {
		this.ret = ret;
	}
	public JButton getSnd() {
		return snd;
	}

	public void setSnd(JButton snd) {
		this.snd = snd;
	}

	public JButton getFil() {
		return fil;
	}

	public void setFil(JButton fil) {
		this.fil = fil;
	}

	public String getValfil() {
		return valfil;
	}

	public void setValfil(String valfil) {
		this.valfil = valfil;
	}

	public JButton getPara() {
		return para;
	}

	public void setPara(JButton para) {
		this.para = para;
	}

	public Send(Fenetre f) {
		this.f=f;
		this.setOpaque(true);
		this.setBackground(Color.white);

		JPanel pan=new JPanel();
		pan.setBounds(0, 0, 300, 50);
		pan.setBackground(Color.blue);
		
		JPanel body=new JPanel();
		body.setBounds(85, 150, 125, 125);
		JLabel sary=new JLabel();
		ImageIcon imgc=new ImageIcon("multi\\logo3.png");
		sary.setIcon(imgc);
		body.setBackground(Color.white);

		JPanel logname=new JPanel();
		logname.setBounds(85, 285, 125, 50);
		JLabel anarany=new JLabel();
		anarany.setFont(new Font("VERDANA",Font.PLAIN,18));
		anarany.setText("H-Transfert");
		logname.setBackground(Color.white);
		
		ImageIcon imc=new ImageIcon("multi\\logofile.png");
		fil=new JButton(imc);
		
		Parcourfile p=new Parcourfile(this);
		fil.setBounds(125, 325, 35, 35);
		fil.addActionListener(p);
		fil.setBackground(Color.white);
		fil.setBorder(new RoundBTn(15));

		MouseSend ms=new MouseSend(this);
		ImageIcon parametre=new ImageIcon("multi\\para.png");
		para=new JButton(parametre);
		para.setBounds(245, 55, 35, 35);
		para.addMouseListener(ms);
		para.setBackground(Color.white);
		para.setBorder(new RoundBTn(15));

		ImageIcon rt=new ImageIcon("multi\\ret.png");
		ret=new JButton(rt);
		ret.setBounds(5, 55, 45, 40);
		ret.addMouseListener(ms);
		ret.setBackground(Color.white);
		ret.setBorder(new RoundBTn(15));		

		ImageIcon isnd=new ImageIcon("multi\\snd.png");
		snd=new JButton(isnd);
		snd.setBounds(125, 375, 35, 35);
		snd.addMouseListener(ms);
		snd.setBackground(Color.white);
		snd.setBorder(new RoundBTn(15));

		load=new JPanel();
		load.setBounds(100, 375, 100, 50);
		JLabel miandry=new JLabel();
		miandry.setFont(new Font("VERDANA",Font.PLAIN,18));
		miandry.setText("Loading....");
		load.setBackground(Color.white);
		load.add(miandry);

		logname.add(anarany);
		body.add(sary);
		this.add(ret);
		this.add(snd);
		this.add(para);
		this.add(fil);
		this.add(logname);
		this.add(body);
		this.add(pan);
		this.repaint();
	}
	
}
