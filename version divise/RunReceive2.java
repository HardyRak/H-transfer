package traitement;

public class RunReceive2 extends Thread{
	public void run() {
		try {
			try (Receive2 rc = new Receive2()) {
				rc.serv();
			}
			System.out.println("Go2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
