package traitement;

import java.io.*;
import java.net.*;

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
		String[] gettyp=str.split("[.]");
		System.out.println(str);
		String path="C:\\H-transfert\\";
		for (int i=0;i<gettyp.length ;i++ ) {
			System.out.println(gettyp[i]);
		}
		if(gettyp[gettyp.length-1].contains("zip") || gettyp[gettyp.length-1].contains("rar") || gettyp[gettyp.length-1].contains("7zp")){
			path=path+"Archives";
		}
		else if(gettyp[gettyp.length-1].contains("png") || gettyp[gettyp.length-1].contains("jpg") || gettyp[gettyp.length-1].contains("ico")){
			path=path+"Images";
		}
		else if (gettyp[gettyp.length-1].contains("mp3")) {
			path=path+"Musique";
		}
		else if (gettyp[gettyp.length-1].contains("mp4")) {
			path=path+"Vidéos";
		}
		else if (gettyp[gettyp.length-1].contains("exe")) {
			path=path+"Application";
		}
		else{
			path=path+"Autres";
		}

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
