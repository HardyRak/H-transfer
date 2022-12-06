package affichage;

import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.*;
import javax.swing.JTextField;
import java.awt.*;
import listener.MouseConfig;
import traitement.Sends;

public class FrameConfig extends JFrame{
	JTextField js;
	JButton conf;
	
	public JTextField getJs() {
		return js;
	}

	public void setJs(JTextField js) {
		this.js = js;
	}

	public JButton getConf() {
		return conf;
	}

	public void setConf(JButton conf) {
		this.conf = conf;
	}

	public FrameConfig() throws IOException {
		this.setVisible(true);
		this.setSize(new Dimension(300,150));
		this.setTitle("Configuration");
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		JLabel pan=new JLabel();
		pan.setOpaque(true);
		pan.setBackground(Color.white);

		pan.setFont(new Font("VERDANA",Font.PLAIN,18));
		pan.setText("L'adresse IP:");
		js=new JTextField();
		js.setBounds(120, 40, 155, 35);
		Sends sen=new Sends();
		if (sen.getFile().exists()) {
			js.setText(sen.getliste()[sen.getliste().length-1]);
			js.setFont(new Font("VERDANA",Font.PLAIN,18));	
		}
		MouseConfig mc=new MouseConfig(this);
		ImageIcon ic=new ImageIcon("multi\\conf.png");
		conf=new JButton(ic);
		conf.setBounds(130,80,25,25);
		conf.addMouseListener(mc);
		conf.setBackground(Color.white);
		
		pan.add(conf);
		pan.add(js);
		this.getContentPane().add(pan);
	}
	
	public String makatextfiel() {
		String st=js.getText();
		return st;
	}
	public void mouse(String ip) {
		File f=null;
    	f=new File("C:\\conf\\utilisateur\\ipconf");
    	f.mkdirs();
		FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(f+"\\ipconfig.xhs", true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
        } catch (IOException e1) {
			e1.printStackTrace();
		} finally {
            try {
                pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {
            }
        }
        try (FileWriter fw2 = new FileWriter(f+"\\ipconfig.xhs", true);
                BufferedWriter b = new BufferedWriter(fw2);
                PrintWriter p = new PrintWriter(b);) {
        		p.println(ip);
        } catch (IOException i) {
            i.printStackTrace();
        }
	}
}
