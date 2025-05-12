package com.alienkrishn.repohelper;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.StyleSpan;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ClipboardManager clipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        // Set styled about text
        TextView tvAbout = findViewById(R.id.tvAbout);
        String aboutText = "AlienKrishn Repository\n\n" +
            "Version 2.0\n\n" +
            "This repository serves as an extended package source for Termux users, " +
            "providing specialized tools and utilities not found in the official repositories.\n\n" +
            "• 70+ Hacking & Security Tools\n" +
            "• Regular Updates\n" +
            "• Non-Root Functionality\n" +
            "• Educational Use Only\n\n" +
            "Developer: @alienkrishn\n" +
            "YouTube: AlienKrishn";

        SpannableString spannableString = new SpannableString(aboutText);
        spannableString.setSpan(new StyleSpan(Typeface.BOLD), 0, 18, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvAbout.setText(spannableString);

        // Setup repo button
        Button btnAddRepo = findViewById(R.id.btnAddRepo);
        btnAddRepo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String command = "apt update && apt upgrade -y && " +
                        "curl -sL https://raw.githubusercontent.com/Anon4You/alienkrishn/main/addrepo | bash";
                    copyToClipboard(command);
                    Toast.makeText(MainActivity.this, 
                                   "Repository install command copied!\nOpen Termux and paste", 
                                   Toast.LENGTH_LONG).show();
                }
            });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_tools:
                startActivity(new Intent(this, ToolsActivity.class));
                return true;

            case R.id.menu_github:
                openUrl("https://github.com/Anon4You/");
                return true;
            case R.id.menu_youtube:
                openUrl("https://youtube.com/@alienkrishnorg");
                return true;

            case R.id.menu_contact:
                openUrl("https://t.me/nullxvoid");
                return true;

            case R.id.menu_exit:
                finishAffinity();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void copyToClipboard(String text) {
        ClipData clip = ClipData.newPlainText("Termux Command", text);
        clipboard.setPrimaryClip(clip);
    }

    private void openUrl(String url) {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        } catch (Exception e) {
            Toast.makeText(this, "Error: Couldn't open link", Toast.LENGTH_SHORT).show();
        }
    }
}
