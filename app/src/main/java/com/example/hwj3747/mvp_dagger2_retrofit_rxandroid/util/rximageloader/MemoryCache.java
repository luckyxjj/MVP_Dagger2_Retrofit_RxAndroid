package com.example.hwj3747.mvp_dagger2_retrofit_rxandroid.util.rximageloader;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

public class MemoryCache<T> extends LruCache<T, Bitmap> {

    public MemoryCache(int maxSize) {
        super(maxSize);
    }

    @Override
    protected int sizeOf(T key, Bitmap b) {
        int size = 0;
        if (b != null) {
            size = b.getRowBytes() * b.getHeight();
        }
        return size;
    }
}
