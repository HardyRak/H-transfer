package traitement;
import java.lang.*;
import affichage.*;
public class RunReceive extends Thread{
	LoadingR r;
	Receive rc;

	public Receive getRc(){
		return rc;
	}
	public void setRc(Receive rc){
		this.rc=rc;
	}
	public RunReceive(LoadingR r){
		this.r=r;
		try{
			this.rc=new Receive();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
    public void run(){
        try{
        	rc.serv();
        	System.out.println("RUN");
        }catch(Exception e){
        	e.printStackTrace();
        }
        r.remove(r.getLoad());
        r.revalidate();
        r.add(r.getAtt());
        r.repaint();
	}
	public void mamono() throws Exception{
		this.rc.close();
	}
}