package com.creative.tmdb.downloadservice;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.IBinder;

import com.creative.tmdb.R;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

import androidx.core.app.NotificationManagerCompat;

public class DownloadService extends Service {
    public DownloadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new AsyncTask<String, Void, Void>() {
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                int randomid = (int) (Math.random() + 25) * 9999;
                NotificationManagerCompat
                        .from(DownloadService.this)
                        .notify(randomid, new Notification.Builder(DownloadService.this)
                                .setSmallIcon(R.drawable.icon_app)
                                .setContentTitle(getResources().getString(R.string.label_service_download_image))
                                .setContentText(getResources().getString(R.string.label_service_downloading_image))
                                .build());
            }

            @Override
            protected Void doInBackground(String... strings) {
                String url = intent.getStringExtra("url");
                String path = Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS)
                        .getPath()
                        + File.separator
                        + System.currentTimeMillis()
                        + ".jpg";
                try {
                    URL u = new URL(url);
                    URLConnection conn = u.openConnection();
                    int contentLength = conn.getContentLength();

                    DataInputStream stream = new DataInputStream(u.openStream());

                    byte[] buffer = new byte[contentLength];
                    stream.readFully(buffer);
                    stream.close();

                    DataOutputStream fos = new DataOutputStream(new FileOutputStream(path));
                    fos.write(buffer);
                    fos.flush();
                    fos.close();
                } catch (Exception e) {

                }
                return null;
            }
        }.execute();
        return super.onStartCommand(intent, flags, startId);
    }
}
