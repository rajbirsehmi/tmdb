package com.creative.tmdb.view;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.creative.tmdb.R;
import com.creative.tmdb.adapter.MovieDetailGalleryWallpaperAdapter;
import com.creative.tmdb.model.GalleryAllWallpaperImpl;
import com.creative.tmdb.model.PermissionCheckImpl;
import com.creative.tmdb.presenter.GalleryAllWallpaper;
import com.creative.tmdb.presenter.PermissionCheck;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class GalleryWallpaperActivity extends AppCompatActivity implements GalleryAllWallpaper, PermissionCheck {

    private RecyclerView rvGallery;
    private GalleryAllWallpaperImpl galleryAllWallpaper;
    private PermissionCheckImpl permissionCheck;
    private int requestCode = 93;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_wallpaper);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getBaseContext().getResources().getString(R.string.title_activity_gallery_activity_wallpaper));

        rvGallery = findViewById(R.id.rv_gallery);
        rvGallery.setItemAnimator(new DefaultItemAnimator());
        rvGallery.setLayoutManager(new LinearLayoutManager(getBaseContext()));

        galleryAllWallpaper = new GalleryAllWallpaperImpl(this, getBaseContext());
        galleryAllWallpaper.loadAllPosters(getIntent().getIntExtra("movie_id", -1));

        permissionCheck = new PermissionCheckImpl(this, getBaseContext());
        if (!permissionCheck.isPermissionGranted()) {
            requestPermissions(new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
            }, requestCode);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode != this.requestCode) {
            Toast.makeText(this, getResources().getString(R.string.error_message_wrong_request_code), Toast.LENGTH_SHORT).show();
            return;
        }
        if (grantResults.length > 0 && grantResults[0] == PERMISSION_GRANTED && grantResults[1] == PERMISSION_GRANTED) {
            Toast.makeText(this, getResources().getString(R.string.label_permission_granted), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, getResources().getString(R.string.label_permission_denied), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setAllWallpaperGaleryAdapterToRecyclerView(MovieDetailGalleryWallpaperAdapter adapter) {
        rvGallery.setAdapter(adapter);
    }
}
