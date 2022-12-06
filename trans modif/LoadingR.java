package affichage;

import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import listener.Mouse2;

public class LoadingR extends JLabel{
	public Fenetre f;
	JPanel load;
	JButton att;
	JButton closcon;
	JButton ret;
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
	public JButton getAtt() {
		return att;
	}

	public void setAtt(JButton att) {
		this.att = att;
	}

	public JButton getCloscon() {
		return closcon;
	}

	public void setCloscon(JButton closcon) {
		this.closcon = closcon;
	}

	public LoadingR(Fenetre f){
		this.f=f;
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

		ImageIcon im=new ImageIcon("multi\\receive1.png");
		
		att=new JButton(im);
		att.setBackground(Color.white);
		Mouse2 m=new Mouse2(this);
		att.addMouseListener(m);
		att.setBounds(100, 400, 100, 50);
		
		load=new JPanel();
		load.setBounds(100, 400, 100, 50);
		JLabel miandry=new JLabel();
		miandry.setFont(new Font("VERDANA",Font.PLAIN,18));
		miandry.setText("Loading....");
		load.setBackground(Color.white);
		load.add(miandry);
		
		closcon=new JButton("Annuler");
		closcon.setBounds(205, 400, 25, 35);
		closcon.addMouseListener(m);
		
		ImageIcon rt=new ImageIcon("multi\\ret.png");
		ret=new JButton(rt);
		ret.setBounds(5, 55, 45, 40);
		ret.addMouseListener(m);
		ret.setBackground(Color.white);
		ret.setBorder(new RoundBTn(15));

		this.add(ret);
		this.setOpaque(true);
		this.setBackground(Color.white);
		this.add(att);
		this.add(closcon);
		logname.add(anarany);
		body.add(sary);
		this.add(logname);
		this.add(body);
		this.add(pan);
		this.repaint();
	}
}
