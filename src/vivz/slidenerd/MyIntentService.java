package vivz.slidenerd;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class MyIntentService extends IntentService {
    public MyIntentService() {
    	super("vivz intent service");
    	Log.d("VIVZ", "constructed...");
    }
    @Override
    public void onCreate() {
    	// TODO Auto-generated method stub
    	super.onCreate();
    	Log.d("VIVZ", "on create...");
    }


	@Override
	protected void onHandleIntent(Intent intent) {
		// TODO Auto-generated method stub
		
		Log.d("VIVZ", "on handle intent..."+Thread.currentThread().getId());
		for(int i=0;i<10;i++)
		{
			try {
				Thread.sleep(100);
				Log.d("VIVZ", "loop "+i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("VIVZ", "destroyed...");
	}
}
