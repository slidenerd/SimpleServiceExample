package vivz.slidenerd;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.view.View;

public class MyBoundService extends Service {
	MyBindingObject binder=new MyBindingObject();
    public MyBoundService() {
    }
    public class MyBindingObject extends Binder
    {
    	public MyBoundService getService()
    	{
    		Log.d("VIVZ", "binding object called"+Counter.getCounter());
    		return MyBoundService.this;
    	}
    }
    public int getRandomNumber()
    {
    	Log.d("VIVZ", "random number fucntion call"+Counter.getCounter());
    	return (int)(Math.random()*10000);
    }
    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
    	Log.d("VIVZ", "on bind method calld"+Counter.getCounter());
        return binder;
    }
}
