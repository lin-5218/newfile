package caozuo1;

import java.util.concurrent.Semaphore;

public class SecondRunThread extends Thread{
    String content;
    Semaphore sem1,sem2,sem3;
	public SecondRunThread(Semaphore sem1,Semaphore sem2,Semaphore sem3,String content)
	{
		
		this.sem1=sem1;
		this.sem2=sem2;
		this.sem3=sem3;
		this.content=content;
	}
	public void run()
	{    
		
		try {
			sem1.acquire();
			sem3.acquire();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   

		   try {
			   Thread.sleep(2*1000);
			   
		   }catch(InterruptedException ex)
		   {
			   
		   }
		 
	FrameMain.jta5.setText(content);
	   
		sem1.release();
		sem3.release();
		
	}
}