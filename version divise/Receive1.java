package traitement;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Receive1 extends ServerSocket{

	public Receive1() throws IOException {
		super(6060);
		// TODO Auto-generated constructor stub
	}
	public void serv() throws Exception{
		Socket so=this.accept();
		
		DataInputStream dinp =new DataInputStream(so.getInputStream());
		
		int bytes=0;
		String  str=(String)dinp.readUTF();
		System.out.println(str);
		String path="C:\\H-transfert\\serveur1\\";
		File f=new File(path);
		f.mkdirs();
		FileOutputStream fos=new FileOutputStream(f+"\\"+str);
		Long size=dinp.readLong();
		byte[] buf=new byte[64*1024];

		while(size>0 && (bytes=dinp.read(buf,0,(int)Math.min(buf.length,size))) !=-1){	
			fos.write(buf,0,bytes);
			size-=bytes;
		}
		fos.close();
		this.close();
	}
}
