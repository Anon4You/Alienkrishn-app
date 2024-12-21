package anon4you.github.io;

import android.app.*;
import android.os.*;
import java.util.Timer;
import java.util.TimerTask;
import android.content.Intent;

public class MainActivity extends Activity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ActionBar ab=getActionBar();
        ab.hide();
        Timer tm = new Timer();
        tm.schedule(new TimerTask(){

                @Override
                public void run()
                {
                    Intent i = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(i);
                    finish();

                }
            }, 3000);
    }
}

