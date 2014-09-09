package vivz.slidenerd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends Activity {

	ProgressBar bar;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar=(ProgressBar) findViewById(R.id.progressBar1);
    }

    
    public void process(View v)
    {
    	Log.d("VIVZ", Thread.currentThread().getId()+"");
    	//startService(new Intent(this,MyIntentService.class));
    	MyThread mt=new MyThread(bar);
    }
}

