package com.alienkrishn.repohelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Button;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {

    private static final String JSON_URL = "https://raw.githubusercontent.com/Anon4You/Alienkrishn-app/main/version.json";
    private static final int CURRENT_VERSION = 1; // Update this with each release

    public static void checkForUpdate(final Activity activity) {
        new AsyncTask<Void, Void, JSONObject>() {
            @Override
            protected JSONObject doInBackground(Void... voids) {
                try {
                    URL url = new URL(JSON_URL);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestMethod("GET");

                    BufferedReader reader = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                    StringBuilder json = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        json.append(line);
                    }
                    reader.close();

                    return new JSONObject(json.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    return null; // Return null if fetch fails
                }
            }

            @Override
            protected void onPostExecute(JSONObject jsonData) {
                if (jsonData != null) {
                    try {
                        int latestVersion = jsonData.getInt("latest_version");
                        String downloadUrl = jsonData.getString("download_url");

                        if (latestVersion > CURRENT_VERSION) {
                            showUpdateDialog(activity, downloadUrl);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }.execute();
    }

    private static void showUpdateDialog(final Activity activity, final String downloadUrl) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Update Available");
        builder.setMessage("A new version is available. Please update now!");

        builder.setPositiveButton("Download", null);
        builder.setNegativeButton("Exit", null);

        final AlertDialog dialog = builder.create();
        dialog.setCancelable(false);

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                @Override
                public void onShow(DialogInterface di) {
                    // Download Button (Green)
                    Button downloadBtn = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
                    downloadBtn.setBackgroundColor(Color.parseColor("#FF4CAF50"));
                    downloadBtn.setTextColor(Color.WHITE);
                    downloadBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                activity.startActivity(new Intent(
                                                           Intent.ACTION_VIEW,
                                                           Uri.parse(downloadUrl) // Use URL from JSON
                                                       ));
                            }
                        });

                    // Exit Button (Red)
                    Button exitBtn = dialog.getButton(AlertDialog.BUTTON_NEGATIVE);
                    exitBtn.setBackgroundColor(Color.parseColor("#FFF44336"));
                    exitBtn.setTextColor(Color.WHITE);
                    exitBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                activity.finish();
                            }
                        });
                }
            });

        dialog.show();
    }
}

