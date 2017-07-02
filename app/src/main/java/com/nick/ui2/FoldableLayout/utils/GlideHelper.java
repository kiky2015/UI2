package com.nick.ui2.FoldableLayout.utils;

import android.widget.ImageView;

import com.nick.ui2.FoldableLayout.items.Painting;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GlideHelper {

    private GlideHelper() {}

    public static void loadPaintingImage(ImageView image, Painting painting) {
        Glide.with(image.getContext().getApplicationContext())
                .load(painting.getImageId())
                .dontAnimate()
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(image);
    }

}
