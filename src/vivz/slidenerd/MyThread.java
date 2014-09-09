package vivz.slidenerd;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;

public class MyThread extends Thread {

	ProgressBar bar = null;
	Handler handler = new Handler() {

		public void handleMessage(android.os.Message msg) {
			bar.incrementProgressBy(1);
			Log.d("numbers", msg.getData().getInt("number")+"");

		};

	};

	public MyThread(ProgressBar bar) {
		// TODO Auto-generated constructor stub
		this.bar = bar;
		start();
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 1000; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (int j = 1; j < Math.sqrt(1000); j++) {
				if (calculateDivisibilityBy(i, j)) {
					Message message=handler.obtainMessage();
					Bundle data=new Bundle();
					data.putInt("number ", i);
					message.setData(data);
					handler.sendMessage(message);
				}
			}
			
			
		}
	}

	private boolean calculateDivisibilityBy(int testNumber, int number) {
		return testNumber % number == 0;
	}
}
