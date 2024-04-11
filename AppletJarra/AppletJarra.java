import java.awt.*;
import java.applet.*;

public class AppletJarra extends Applet implements Runnable 
{	
	int numeroimagenes;
	String aux= new String ("");
	Thread nuevo= null;
	Image img [];
	Graphics g;
	public void init()
	{
		aux= this.getParameter ("numero") ;
		numeroimagenes= Integer.parseInt (aux);
		img=new Image [numeroimagenes];
		for (int i=0; i<numeroimagenes; i ++)
		{
			aux= this.getParameter ("imagen"+i);
			img [i]= this.getImage (this.getDocumentBase (), aux);
			
		}
		g=this.getGraphics(); 
		nuevo=new Thread (this);
		nuevo.start();
		
	}
	public void stop()
	{
		nuevo.stop();
	}
	public void run ()
	{ 
		while(nuevo!=null)
	  {
		  for(int i=0;i<numeroimagenes;i++)
		  {
			try{ nuevo.sleep (500);
			} catch (InterruptedException e){}
			g.drawImage (img[i],0,0,this);
		  }
	  }		
	}
	public void update(Graphics g)
	{
		paint(g);
	}
}
