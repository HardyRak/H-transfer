package traitement;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

	public class Sends {
		private File file=new File("C:\\conf\\utilisateur\\ipconf\\ipconfig.xhs");
		public File getFile(){
			return file;
		}
		public void setFile(File file){
			this.file=file;
		}
		public void send(String ip,int port,String path) throws Exception{
			Socket s=new Socket(ip,port);
		    DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
		    DataInputStream dinp=new DataInputStream(s.getInputStream());
	
		    File f=new File(path);
		    String namfile=f.getName();
		    dout.writeUTF(namfile);
		    
		    FileInputStream fis=new FileInputStream(f);  
		    int bytes=0;
		    Long tfic=f.length();
		    dout.writeLong(tfic);
	
		    byte[] buf=new byte[64*1024];
		    while((bytes=fis.read(buf)) != -1){
		    	dout.write(buf,0,bytes);
		    	dout.flush();
		    }
		    fis.close();
		}
		public int test() throws IOException {
			FileReader fd=new FileReader(file);
			BufferedReader ts=new BufferedReader(fd);
			int i=0;
			while (ts.readLine()!=null) {
				i++;
			}
			return i;
		}
		public String[] getliste() throws IOException {
			String[] st=new String[this.test()];
			try (Scanner sc = new Scanner(file)) {
				for(int j=0;j<st.length;j++) {
					if(sc.hasNextLine()) {
						st[j]=sc.nextLine();
					}
				}
			}
			return st;
	}
}
