package vivz.slidenerd;

import vivz.slidenerd.MyBoundService.MyBindingObject;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MyActivity extends Activity {

	MyBoundService service;
	boolean bound =false;
	Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bound);
        Log.d("VIVZ", "created"+Counter.getCounter());
    }
    @Override
    protected void onPause() {
    	// TODO Auto-generated method stub
    	super.onPause();
    	Log.d("VIVZ", "paused"+Counter.getCounter());
    	/*
    	if(bound)
    	{
    		unbindService(connection);
    		Log.d("VIVZ", "paused with unbind"+Counter.getCounter());
    	}
    	*/
    }
    
    public void processClick(View v)
    {
    	/*
    	intent=new Intent(this, MyBoundService.class);
    	bindService(intent, connection, Context.BIND_AUTO_CREATE);
    	if(bound)Toast.makeText(this, ""+service.getRandomNumber(), Toast.LENGTH_SHORT).show();
    	Log.d("VIVZ", "button clicked"+Counter.getCounter());
    	*/
    }
    
    ServiceConnection connection=new ServiceConnection() {
		
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub
			Log.d("VIVZ", "on service disconnected"+Counter.getCounter());
			service=null;
		}
		
		public void onServiceConnected(ComponentName name, IBinder s) {
			// TODO Auto-generated method stub
			MyBindingObject o=(MyBindingObject)s;
			service=o.getService();
			Log.d("VIVZ", "on service connected"+Counter.getCounter());

			
		}
	};
}
