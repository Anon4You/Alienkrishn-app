package anon4you.github.io;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.content.Context;
import android.widget.Toast;
import android.view.Menu;
import android.widget.Checkable;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.graphics.Color;
import android.widget.TextView;
import android.widget.Button;
import android.app.ActionBar;
import android.graphics.drawable.ColorDrawable;
import org.xml.sax.Parser;
import android.text.Html;

public class HomeActivity extends Activity
{

   

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        //ActionBar ab=getActionBar();
        //ab.hide();
       
    }
    public void clickgithub(View view){
        String url="https://github.com/Anon4You/Alienkrishn-app";
        Intent in=new Intent(Intent.ACTION_VIEW);
        in.setData(Uri.parse(url));
        startActivity(in);
   }
   
    public void addrepo(View view){
        ClipboardManager cbord=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clip = ClipData.newPlainText("simple text", "curl -sL https://github.com/Anon4You/alienkrishn/raw/main/addrepo | bash");
        cbord.setPrimaryClip(clip);
        Toast.makeText(getApplicationContext(),"Open termux and paste this code",Toast.LENGTH_LONG).show();
    }
    public void addkey(View view){
        ClipboardManager cb=(ClipboardManager)getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData clp = ClipData.newPlainText("simple tect", "curl -sL https://raw.githubusercontent.com/Anon4You/alienkrishn/main/alienkrishn.key | apt-key add && sleep 2 && mv $PREFIX/etc/apt/trusted.gpg $PREFIX/etc/apt/trusted.gpg.d > /dev/null 2>&1");
        cb.setPrimaryClip(clp);
        Toast.makeText(getApplicationContext(),"Open termux and paste this code",Toast.LENGTH_LONG).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu abc)
    {
        abc.add("Dark Theme").setCheckable(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        LinearLayout lin=(LinearLayout)findViewById(R.id.homeLinearLayout1);
        TextView txt1=(TextView)findViewById(R.id.homeTextView1);
        TextView txt2=(TextView)findViewById(R.id.homeTextView2);
        TextView txt3=(TextView)findViewById(R.id.homeTextView3);
        TextView txt4=(TextView)findViewById(R.id.homeTextView4);
        TextView txt5=(TextView)findViewById(R.id.homeTextView5);
        Button btn=(Button)findViewById(R.id.homeButton1);
        Button btn2=(Button)findViewById(R.id.homeButton2);
        Button btn3=(Button)findViewById(R.id.homeButton3);
        ActionBar ab = getActionBar();
        ColorDrawable normDrawable=new ColorDrawable(Color.parseColor("#ffffff"));
        ColorDrawable darkDrawable=new ColorDrawable(Color.parseColor("#09161a"));
        
        
       
        if(item.isChecked()){
            item.setChecked(false);
            lin.setBackgroundColor(Color.parseColor("#ffffff"));
            txt1.setTextColor(Color.parseColor("#ff0505"));
            txt2.setTextColor(Color.parseColor("#000000"));
            txt3.setTextColor(Color.parseColor("#000000"));
            txt4.setTextColor(Color.parseColor("#000000"));
            txt5.setTextColor(Color.parseColor("#000000"));
            btn.setTextColor(Color.parseColor("#000000"));
            btn.setTextColor(Color.parseColor("#000000"));
            btn2.setTextColor(Color.parseColor("#000000"));
            btn3.setTextColor(Color.parseColor("#000000"));
            ab.setBackgroundDrawable(normDrawable);
            ab.setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
            }
            else{
                item.setChecked(true);
                lin.setBackgroundColor(Color.parseColor("#000000"));
                txt1.setTextColor(Color.parseColor("#09ff05"));
                txt2.setTextColor(Color.parseColor("#ffffff"));
                txt3.setTextColor(Color.parseColor("#ffffff"));
                txt4.setTextColor(Color.parseColor("#ffffff"));
                txt5.setTextColor(Color.parseColor("#fff203"));
                btn.setTextColor(Color.parseColor("#ff0505"));
                btn2.setTextColor(Color.parseColor("#ff0505"));
                btn3.setTextColor(Color.parseColor("#ff0505"));
                ab.setBackgroundDrawable(darkDrawable);
                ab.setTitle(Html.fromHtml("<font color=\"red\">" + getString(R.string.app_name) + "</font>"));
                
            }
           
        return true;
    }
    
   

}

