package caozuo1;

public class ThirdNotifyThread   extends Thread{
	private Object obj;
  public ThirdNotifyThread(String name,Object obj)
  {
	  super(name);
	  this.obj=obj;
  }
  public void run()
  {
  //»½ÐÑ
	  
	  synchronized(this.obj)
	  {try {
  		Thread.sleep(2*1000);
  	} catch (InterruptedException e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  	}
		  FrameMain.jta6.setText(getName());
	  this.obj.notifyAll();
  }
  }
	
}