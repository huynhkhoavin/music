package com.example.khoavin.nativemusic.ToolsFactory;

import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.DataObject.Video;
import com.example.khoavin.nativemusic.R;

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

    public static Video[] VideoCollectionSource = new Video[]{
            new Video("Cơn mưa ngang qua", "Sơn Tùng MTP", "", 65239000, R.drawable.video_1),
            new Video("Dấu mưa", "Trung Quân Idol", "", 65000, R.drawable.video_2),
            new Video("Sai càng sai", "Chi Dân", "", 32000, R.drawable.video_3),
            new Video("Duyên nghèo", "Mạnh Quỳnh - Phi Nhung", "", 44000, R.drawable.video_4),
            new Video("Ru lại câu hò", "Cẩm Ly", "", 350000, R.drawable.video_5),
            new Video("Căn nhà màu tím", "Mạnh Quỳnh - Phi Nhung", "", 116000, R.drawable.video_6),
            new Video("Áo hoa", "Quang Lê - Mai Thiên Vân", "", 83000, R.drawable.video_1),
            new Video("Chuyện tình Lan và Điệp", "Tui Chịu", "", 74000, R.drawable.video_2),
            new Video("Khúc thụy du", "Khánh Ly", "", 999, R.drawable.video_3),
            new Video("Xuân tha hương lạc xứ", "Trường Vũ", "", 325, R.drawable.video_4),
            new Video("Lạc trôi", "Sơn Tùng MTP", "", 999000, R.drawable.video_5),
            new Video("Em của ngày hôm qua", "Sơn Tùng MTP", "", 725000, R.drawable.video_6),
            new Video("Chuyện tình Lan và Điệp", "Tui Chịu", "", 74000, R.drawable.nhac_dan_ca_8),
            new Video("Khúc thụy du", "Khánh Ly", "", 999, R.drawable.nhac_dan_ca_2),
            new Video("Xuân tha hương lạc xứ", "Trường Vũ", "", 325, R.drawable.nhac_dan_ca_3),
            new Video("Cơn mưa ngang qua", "Sơn Tùng MTP", "", 152000, R.drawable.nhac_dan_ca_4),
            new Video("Dấu mưa", "Trung Quân Idol", "", 65000, R.drawable.nhac_dan_ca_5),
            new Video("Sai càng sai", "Chi Dân", "", 32000, R.drawable.nhac_dan_ca_6),
            new Video("Duyên nghèo", "Mạnh Quỳnh - Phi Nhung", "", 44000, R.drawable.nhac_dan_ca_7)
    };

    public  static NormalPlayList[] PlaylistCollectionSource = new NormalPlayList[]
            {
                    new NormalPlayList("Cẩm Ly", R.drawable.nhac_dan_ca_1, "", 325000, "Em gái quê"),
                    new NormalPlayList("Quang Dũng", R.drawable.nhac_dan_ca_2, "", 325000, "Dũng kẹo"),
                    new NormalPlayList("Đàm Vĩnh Hưng", R.drawable.nhac_dan_ca_3, "", 325000, "Đêm lang thang"),
                    new NormalPlayList("Đan Trường", R.drawable.nhac_dan_ca_4, "", 325000, "Mãi mãi một tình yêu"),
                    new NormalPlayList("Hồ Ngọc Hà", R.drawable.nhac_dan_ca_5, "", 325000, "Qua con mê"),
                    new NormalPlayList("Duy Mạnh", R.drawable.nhac_dan_ca_6, "", 325000, "Thánh tru"),
                    new NormalPlayList("Chó Phước Thịnh", R.drawable.nhac_dan_ca_7, "", 325000, "Gâu Gâu Gâu"),
                    new NormalPlayList("Sơn Tùng MTP", R.drawable.nhac_dan_ca_8, "", 325000, "Lạc trôi"),
                    new NormalPlayList("Bảo Thy", R.drawable.nhac_dan_ca_1, "", 325000, "Ngôi nhà hoa hồng"),
                    new NormalPlayList("Vi Tiểu Bảo", R.drawable.nhac_dan_ca_2, "", 325000, "Chém gió siêu hạng"),
                    new NormalPlayList("Hoàng Lão Tà", R.drawable.nhac_dan_ca_3, "", 325000, "Đàn chỉ thần công"),
                    new NormalPlayList("Tây Độc", R.drawable.nhac_dan_ca_4, "", 325000, "Âu Dương Phong")
            };
}
