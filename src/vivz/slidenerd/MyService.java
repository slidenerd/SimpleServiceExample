package vivz.slidenerd;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {
	public MyService() {
		Log.d("VIVZ", "constructed...");
		
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		Log.d("VIVZ", "created...");
		super.onCreate();
	}

	@Override
	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		Log.d("VIVZ", "on start...");
		for (int i = 0; i < 10; i++) {
			try {
				Log.d("VIVZ", "Inside " + i);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				Log.d("VIVZ", "Interrupted...");
				e.printStackTrace();
				stopSelf();
			}
			stopSelf();
			
		}
		return super.onStartCommand(intent, flags, startId);

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		Log.d("VIVZ", "on destroy...");
		super.onDestroy();
	}
}
