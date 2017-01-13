package com.example.khoavin.nativemusic.ToolsFactory;

import java.text.DecimalFormat;

/**
 * Created by OatOal on 1/13/2017.
 */

public  class CommonTools {

    public static String FormatListenerCount(long count)
    {
        DecimalFormat df = new DecimalFormat("0.#");

        if(count < 0) return "0";
        if(count < 1000) return String.valueOf(count);
        if(count < 1000000) return df.format(count / 1000f) + " K";
        if(count < 1000000000) return df.format(count / 1000000f) + " M";
        if(count == 1000000000) return "1 B";
        return "> 1B";
    }
}
