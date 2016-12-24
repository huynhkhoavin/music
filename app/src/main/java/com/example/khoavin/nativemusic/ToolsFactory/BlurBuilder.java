package com.example.khoavin.nativemusic.ToolsFactory;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsic;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;

/**
 * Created by KhoaVin on 17/12/2016.
 */

public class BlurBuilder {
    private static final float BLUR_RADIUS = 25f;

    public static Bitmap blur(Bitmap image,Context context) {
        if (null == image) return null;

        Bitmap outputBitmap = Bitmap.createBitmap(image);
        final android.support.v8.renderscript.RenderScript renderScript = android.support.v8.renderscript.RenderScript.create(context);
        android.support.v8.renderscript.Allocation tmpIn = android.support.v8.renderscript.Allocation.createFromBitmap(renderScript, image);
        android.support.v8.renderscript.Allocation tmpOut = android.support.v8.renderscript.Allocation.createFromBitmap(renderScript, outputBitmap);

        //Intrinsic Gausian blur filter
        android.support.v8.renderscript.ScriptIntrinsicBlur theIntrinsic = android.support.v8.renderscript.ScriptIntrinsicBlur.create(renderScript, android.support.v8.renderscript.Element.U8_4(renderScript));
        theIntrinsic.setRadius(BLUR_RADIUS);
        theIntrinsic.setInput(tmpIn);
        theIntrinsic.forEach(tmpOut);
        tmpOut.copyTo(outputBitmap);
        return outputBitmap;
    }
}
