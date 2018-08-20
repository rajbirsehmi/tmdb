package com.creative.tmdb.model;

import android.content.Context;

import com.creative.tmdb.permissioncheck.Permission;
import com.creative.tmdb.presenter.PermissionCheck;

public class PermissionCheckImpl {

    private PermissionCheck permissionCheck;
    private Context context;

    public PermissionCheckImpl(PermissionCheck permissionCheck, Context context) {
        this.permissionCheck = permissionCheck;
        this.context = context;
    }

    public boolean isPermissionGranted() {
        return Permission.checkIfGranted(context);
    }
}
