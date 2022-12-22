package traitement;

import java.io.IOException;

public class RunReceive1 extends Thread{
	public void run() {
		try {
			try (Receive1 rc = new Receive1()) {
				rc.serv();
			}
			System.out.println("Go1");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
