package com.creative.tmdb.persistence;

import android.content.Context;

public class Cache {
    public static void setTotalPages(int totalPages, Context context) {
        context.getSharedPreferences("my_perf", Context.MODE_PRIVATE).edit().putInt("total_pages", totalPages).apply();
    }

    public static int getTotalPages(Context context) {
        return context.getSharedPreferences("my_perf", Context.MODE_PRIVATE).getInt("total_pages", -1);
    }
}
