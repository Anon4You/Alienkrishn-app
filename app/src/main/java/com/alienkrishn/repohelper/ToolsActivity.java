package com.alienkrishn.repohelper;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class ToolsActivity extends Activity {

    private ClipboardManager clipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tools);

        clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);

        // Enable back button in action bar
        if (getActionBar() != null) {
            getActionBar().setTitle("AlienKrishn Tools");
        }}

    public void onToolClick(View view) {
        String command = "";
        String toolName = "";

        switch (view.getId()) {
                // 🔍 Reconnaissance & Scanning
            case R.id.btn_nuclei:
                toolName = "nuclei";
                command = "apt install nuclei -y";
                break;
            case R.id.btn_httpx:
                toolName = "httpx";
                command = "apt install httpx -y";
                break;
            case R.id.btn_subfinder:
                toolName = "subfinder";
                command = "apt install subfinder -y";
                break;
            case R.id.btn_naabu:
                toolName = "naabu";
                command = "apt install naabu -y";
                break;
            case R.id.btn_pandora:
                toolName = "pandora";
                command = "apt install pandora -y";
                break;
            case R.id.btn_katana:
                toolName = "katana";
                command = "apt install katana -y";
                break;
            case R.id.btn_fscan:
                toolName = "fscan";
                command = "apt install fscan -y";
                break;

                // 📱 Mobile Development
            case R.id.btn_android_sdk:
                toolName = "android-sdk";
                command = "apt install android-sdk -y";
                break;
            case R.id.btn_frida:
                toolName = "frida";
                command = "apt install frida -y";
                break;

                // 🤖 AI & Productivity
            case R.id.btn_termux_ai:
                toolName = "termux-ai";
                command = "apt install termux-ai -y";
                break;
            case R.id.btn_termux_media_downloader:
                toolName = "termux-media-downloader";
                command = "apt install termux-media-downloader -y";
                break;

                // 🔍 Information Gathering
            case R.id.btn_sherlock:
                toolName = "sherlock";
                command = "apt install sherlock -y";
                break;
            case R.id.btn_holehe:
                toolName = "holehe";
                command = "apt install holehe -y";
                break;
            case R.id.btn_byakugan:
                toolName = "byakugan";
                command = "apt install byakugan -y";
                break;
            case R.id.btn_hound:
                toolName = "hound";
                command = "apt install hound -y";
                break;
            case R.id.btn_ipinfo:
                toolName = "ipinfo";
                command = "apt install ipinfo -y";
                break;
            case R.id.btn_iplookup:
                toolName = "iplookup";
                command = "apt install iplookup -y";
                break;
            case R.id.btn_phoneinfo:
                toolName = "phoneinfo";
                command = "apt install phoneinfo -y";
                break;
            case R.id.btn_redhawk:
                toolName = "redhawk";
                command = "apt install redhawk -y";
                break;
            case R.id.btn_webinfo:
                toolName = "webinfo";
                command = "apt install webinfo -y";
                break;
            case R.id.btn_locateme:
                toolName = "locateme";
                command = "apt install locateme -y";
                break;

                // 🔐 Password Tools
            case R.id.btn_cupp:
                toolName = "cupp";
                command = "apt install cupp -y";
                break;
            case R.id.btn_hashcat:
                toolName = "hashcat";
                command = "apt install hashcat -y";
                break;
            case R.id.btn_john:
                toolName = "john";
                command = "apt install john -y";
                break;
            case R.id.btn_thc_hydra:
                toolName = "thc-hydra";
                command = "apt install thc-hydra -y";
                break;

                // 🌐 Web Security
            case R.id.btn_afrog:
                toolName = "afrog";
                command = "apt install afrog -y";
                break;
            case R.id.btn_burpsuite:
                toolName = "burpsuite";
                command = "apt install burpsuite -y";
                break;
            case R.id.btn_burpsuite_pro:
                toolName = "burpsuite-pro";
                command = "apt install burpsuite-pro -y";
                break;
            case R.id.btn_hatcloud:
                toolName = "hatcloud";
                command = "apt install hatcloud -y";
                break;
            case R.id.btn_nikto:
                toolName = "nikto";
                command = "apt install nikto -y";
                break;
            case R.id.btn_evilginx:
                toolName = "evilginx";
                command = "apt install evilginx -y";
                break;
            case R.id.btn_gophish:
                toolName = "gophish";
                command = "apt install gophish -y";
                break;
            case R.id.btn_sqlmap:
                toolName = "sqlmap";
                command = "apt install sqlmap -y";
                break;
            case R.id.btn_sqlscan:
                toolName = "sqlscan";
                command = "apt install sqlscan -y";
                break;
            case R.id.btn_zaproxy:
                toolName = "zaproxy";
                command = "apt install zaproxy -y";
                break;
            case R.id.btn_websploit:
                toolName = "websploit";
                command = "apt install websploit -y";
                break;

                // 📱 Mobile Security
            case R.id.btn_androdos:
                toolName = "androdos";
                command = "apt install androdos -y";
                break;
            case R.id.btn_androvirus:
                toolName = "androvirus";
                command = "apt install androvirus -y";
                break;
            case R.id.btn_apkeditor:
                toolName = "apkeditor";
                command = "apt install apkeditor -y";
                break;
            case R.id.btn_apktool:
                toolName = "apktool";
                command = "apt install apktool -y";
                break;
            case R.id.btn_blutter:
                toolName = "blutter";
                command = "apt install blutter -y";
                break;
            case R.id.btn_rkpairip:
                toolName = "rkpairip";
                command = "apt install rkpairip -y";
                break;

                // 🎭 Social Engineering
            case R.id.btn_beef:
                toolName = "beef";
                command = "apt install beef -y";
                break;
            case R.id.btn_instajack:
                toolName = "instajack";
                command = "apt install instajack -y";
                break;
            case R.id.btn_setoolkit:
                toolName = "setoolkit";
                command = "apt install setoolkit -y";
                break;
            case R.id.btn_snatcher:
                toolName = "snatcher";
                command = "apt install snatcher -y";
                break;
            case R.id.btn_the_theif:
                toolName = "the-theif";
                command = "apt install the-theif -y";
                break;
            case R.id.btn_venom:
                toolName = "venom";
                command = "apt install venom -y";
                break;
            case R.id.btn_weeman:
                toolName = "weeman";
                command = "apt install weeman -y";
                break;

                // ⚡ System Tools
            case R.id.btn_alienkrishn:
                toolName = "alienkrishn";
                command = "apt install alienkrishn -y";
                break;
            case R.id.btn_enctool:
                toolName = "enctool";
                command = "apt install enctool -y";
                break;
            case R.id.btn_ip_changer:
                toolName = "ip-changer";
                command = "apt install ip-changer -y";
                break;
            case R.id.btn_termux_desktop:
                toolName = "termux-desktop";
                command = "apt install termux-desktop -y";
                break;
            case R.id.btn_termux_penv:
                toolName = "termux-penv";
                command = "apt install termux-penv -y";
                break;

                // 🚨 Attack Tools
            case R.id.btn_darksploit:
                toolName = "darksploit-framework";
                command = "apt install darksploit-framework -y";
                break;
            case R.id.btn_metasploit:
                toolName = "metasploit-framework";
                command = "apt install metasploit-framework -y";
                break;
            case R.id.btn_powerdos:
                toolName = "powerdos";
                command = "apt install powerdos -y";
                break;
            case R.id.btn_slowhttptest:
                toolName = "slowhttptest";
                command = "apt install slowhttptest -y";
                break;
            case R.id.btn_spurt:
                toolName = "spurt";
                command = "apt install spurt -y";
                break;
            case R.id.btn_termsploit:
                toolName = "termsploit";
                command = "apt install termsploit -y";
                break;

                // 🛡️ Defensive Tools
            case R.id.btn_5luser:
                toolName = "5luser";
                command = "apt install 5luser -y";
                break;
            case R.id.btn_blackhat:
                toolName = "blackhat";
                command = "apt install blackhat -y";
                break;
            case R.id.btn_bitb:
                toolName = "bitb-framework";
                command = "apt install bitb-framework -y";
                break;
            case R.id.btn_cctvip:
                toolName = "cctvip";
                command = "apt install cctvip -y";
                break;
            case R.id.btn_local2onion:
                toolName = "local2onion";
                command = "apt install local2onion -y";
                break;
            case R.id.btn_maskme:
                toolName = "maskme";
                command = "apt install maskme -y";
                break;
            case R.id.btn_shorturl:
                toolName = "shorturl";
                command = "apt install shorturl -y";
                break;

                // 🖥️ Miscellaneous
            case R.id.btn_nethunter:
                toolName = "nethunter-cli";
                command = "apt install nethunter-cli -y";
                break;
            case R.id.btn_parrot:
                toolName = "parrot";
                command = "apt install parrot -y";
                break;
            case R.id.btn_random_banner:
                toolName = "random-banner";
                command = "apt install random-banner -y";
                break;
            case R.id.btn_spider:
                toolName = "spider";
                command = "apt install spider -y";
                break;
            case R.id.btn_term_helper:
                toolName = "term-helper";
                command = "apt install term-helper -y";
                break;
            case R.id.btn_webserver:
                toolName = "webserver";
                command = "apt install webserver -y";
                break;

                // 📊 Data Analysis
            case R.id.btn_pandas:
                toolName = "python-pandas";
                command = "apt install python-pandas -y";
                break;
        }

        copyToClipboard(command);
        Toast.makeText(this, 
                       toolName + " install command copied!\nPaste in Termux", 
                       Toast.LENGTH_LONG).show();
    }

    private void copyToClipboard(String text) {
        ClipData clip = ClipData.newPlainText("Termux Command", text);
        clipboard.setPrimaryClip(clip);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
