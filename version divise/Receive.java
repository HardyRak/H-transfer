package traitement;

import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Receive extends ServerSocket{
	public Receive() throws IOException {
		super(9090);
		// TODO Auto-generated constructor stub
	}
	public void serv() throws Exception{
		Socket so=this.accept();
		
		DataInputStream dinp =new DataInputStream(so.getInputStream());
		
	
		int bytes=0;
		String  str=(String)dinp.readUTF();
		System.out.println(str);
		String path="C:\\H-transfert\\";
		File f=new File(path);
		f.mkdirs();
		FileOutputStream fos=new FileOutputStream(f+"\\"+str);
		Long size=dinp.readLong();
		byte[] buf=new byte[64*1024];

		while(size>0 && (bytes=dinp.read(buf,0,(int)Math.min(buf.length,size))) !=-1){	
			fos.write(buf,0,bytes);
			size-=bytes;
		}
	
		File fil=new File(f+"\\"+str);
		Vector<String> vct=this.getfile(fil);
		String[][] ta=this.mizara2d(vct);
		
		//--------------serveur 1--------------------
		Socket s1=new Socket("localhost",6060);
		this.mizararoa(s1, path,str, 1, ta[0]);
		
		//-------------serveur 2--------------------
		Socket s2=new Socket("localhost",5050);
		this.mizararoa(s2, path,str, 2, ta[1]);
		
		fos.close();
		this.close();
	}
	public Vector<String> getfile(File f) throws IOException {
		Path filepath=Paths.get(f.getPath());
		Charset cha=StandardCharsets.UTF_8;
		List<String> st=Files.readAllLines(filepath, cha);
		Vector<String> cont=new Vector<String>();
		for(String lin:st) {
			cont.add(lin);
		}
		return cont;
	}
	public String[][] mizara2d(Vector<String> st) {
		int len=st.size()/2;
		String[] st1=new String[len];
		for(int i=0;i<len;i++) {
			st1[i]=st.get(i);
		}
		int j=0;
		String[] st2=new String[len];
		for(int i=len;i<st.size();i++) {
			st2[j]=st.get(i);
			j++;
		}
		String[][] val=new String[2][];
		val[0]=st1;
		val[1]=st2;
		return val;
	}
	
	public void mizararoa(Socket s1,String path,String name,int nb,String[] st) throws IOException {
		DataOutputStream dout=new DataOutputStream(s1.getOutputStream());
	    String[] stt=name.split("[.]");
	    File fil1=new File(path+"//"+stt[stt.length-2]+nb+"."+stt[stt.length-1]);
	    fil1.createNewFile();
	    
	    this.writefile(st,fil1.getPath());
	    
	    String namfile=fil1.getName();
	    dout.writeUTF(namfile);
	    
	    FileInputStream fis=new FileInputStream(fil1);  
	    int bytes=0;
	    Long tfic=fil1.length();
	    dout.writeLong(tfic);

	    byte[] buf=new byte[64*1024];
	    while((bytes=fis.read(buf)) != -1){
	    	dout.write(buf,0,bytes);
	    	dout.flush();
	    }
	    fis.close();
	    fil1.delete();
	}
	public void writefile(String[] g,String path) {

		FileWriter fw = null;
        BufferedWriter bw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(path, true);
            bw = new BufferedWriter(fw);
            pw = new PrintWriter(bw);
            System.out.println("Mety");


        } catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
            try {
               // pw.close();
                bw.close();
                fw.close();
            } catch (IOException io) {
            }
        }

        try (FileWriter fw2 = new FileWriter(path, true);
                BufferedWriter b = new BufferedWriter(fw2);
                PrintWriter p = new PrintWriter(b);) {
        	
        	for(int i=0;i<g.length;i++) {        		
        		p.println(g[i]);
        	}
        } catch (IOException i) {
            i.printStackTrace();
        }
	}
}
