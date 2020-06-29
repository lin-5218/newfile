package caozuo1;

public class FirstWaitThread extends Thread {
	private Object obj;
public FirstWaitThread (String name,Object obj)
{
	super(name);
	this.obj=obj;
}
    public void run()
    {
   
    	try {
    		// ½øÈëË¯Ãß}
    	synchronized(this.obj)
    	{
    			this.obj.wait();
    	}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	try {
    		Thread.sleep(2*1000);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}
    	
    	FrameMain.jta4.setText(this.getName());
    	
    	
    }
}
