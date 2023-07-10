package com.mnurulefendi202102256.login;



import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.media.MediaParser;
import android.os.Bundle;
import android.provider.SearchRecentSuggestions;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ImplicitMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void nama(View view) {
        Intent nama = new Intent(Intent.ACTION_DIAL);
        startActivity(nama);
    }
    public void tampilTelepon(View view) {
        Intent teleponIntent = new Intent(Intent.ACTION_DIAL);
        startActivity(teleponIntent);
    }

    public void tampilSms(View view) {
        Intent smsIntent = new Intent(Intent.ACTION_MAIN);
        smsIntent.addCategory(Intent.CATEGORY_APP_MESSAGING);
        startActivity(smsIntent);
    }

    public void tampilKalender(View view) {
        Intent kalenderIntent = new Intent(Intent.ACTION_MAIN);
        kalenderIntent.addCategory(Intent.CATEGORY_APP_CALENDAR);
        startActivity(kalenderIntent);
    }

    public void tampilBrowser(View view) {
        Intent BrowserIntent = new Intent(Intent.ACTION_MAIN);
        BrowserIntent.addCategory(Intent.CATEGORY_APP_BROWSER);
        startActivity(BrowserIntent);
    }

    public void tampilKalkulator(View view)
    {
        ArrayList<HashMap<String, Object>> items =new ArrayList<HashMap<String,Object>>();
        final PackageManager pm = getPackageManager();

        List<PackageInfo> pack = pm.getInstalledPackages(0);

        for (PackageInfo pi : pack)
        {
            String packageName = pi.packageName.toString();

            String packageName_LowerCase = packageName.toLowerCase();

            if (packageName_LowerCase.contains("calcul"))
            {
                HashMap<String, Object> map = new HashMap<String, Object>();

                map.put("appName", pi.applicationInfo.loadLabel(pm));
                map.put("packageName", pi.packageName);

                items.add(map);
            }
        }

        int item_size = items.size();

        if(item_size >= 1)
        {
            String packageName = (String) items.get(0).get("packageName");

            Intent i = pm.getLaunchIntentForPackage(packageName);

            if (i != null){
                startActivity(i);
            }
            else {
                Toast.makeText(getApplicationContext(), "Tidak ditemukan Aplikasi",Toast.LENGTH_SHORT).show();
            }
        }
//        try {
//            Intent kalkulatorIntent = new Intent(Intent.ACTION_MAIN);
//            kalkulatorIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//
//            ComponentName cn = new ComponentName("com.android.calculator2", "com.android.calculator2.calculator");
//            kalkulatorIntent.setComponent(cn);
//
//            startActivity(kalkulatorIntent);
//        }
//        catch (ActivityNotFoundException anfe){
//            Toast.makeText(getApplicationContext(),"Aplikasi tidak ditemukan", Toast.LENGTH_LONG).show();
//        }
    }

    public void tampilKontak(View view) {
        Intent KontakIntent = new Intent(Intent.ACTION_MAIN);
        KontakIntent.addCategory(Intent.CATEGORY_APP_CONTACTS);
        startActivity(KontakIntent);
    }

    public void tampilGaleri(View view) {
        Intent GaleriIntent = new Intent(Intent.ACTION_MAIN);
        GaleriIntent.addCategory(Intent.CATEGORY_APP_GALLERY);
        startActivity(GaleriIntent);
    }

    public void tampilWifi(View view) {
        Intent wifiIntent = new Intent(Settings.ACTION_WIFI_IP_SETTINGS);
        startActivity(wifiIntent);
    }

    public void tampilSound(View view) {
        Intent SoundIntent = new Intent(Settings.ACTION_SOUND_SETTINGS);
        startActivity(SoundIntent);
    }

    public void tampilAirplane(View view) {
        Intent AirplaneIntent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
        startActivity(AirplaneIntent);
    }

    public void tampilAplikasi(View view) {
        Intent AplikasiIntent = new Intent(Settings.ACTION_APPLICATION_SETTINGS);
        startActivity(AplikasiIntent);
    }

    public void tampilBluetooth(View view) {
        Intent bluetoothIntent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
        startActivity(bluetoothIntent);
    }

//    public void tampilGDrive(View view) {
//        try {
//            Intent driveIntent = new Intent(Intent.ACTION_MAIN);
//            driveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
//
//            ComponentName cn = new ComponentName("com.android.googledrive", "com.android.calculator2.calculator");
//            driveIntent.setComponent(cn);
//
//            startActivity(driveIntent);
//        }
//        catch (ActivityNotFoundException anfe){
//            Toast.makeText(getApplicationContext(),"Aplikasi tidak ditemukan", Toast.LENGTH_LONG).show();
//        }
//    }
}