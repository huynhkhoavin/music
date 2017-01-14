package com.example.khoavin.nativemusic.ToolsFactory;

import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.DataObject.SimpleSong;
import com.example.khoavin.nativemusic.DataObject.Topic;
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

    public static Topic[] TopicCollectionSource = new Topic[]
            {
                    new Topic("Mừng Đảng mừng xuân", R.drawable.chude_cachmang),
                    new Topic("Chào mừng thành lập đoàn", R.drawable.chude_doan),
                    new Topic("Cải lương", R.drawable.chude_cailuong),
                    new Topic("DANCE 2017", R.drawable.chude_dance),
                    new Topic("Nhạc hải ngoại", R.drawable.chude_haingoai),
                    new Topic("Nhạc Trịnh - Những ca khúc đi cùng năm tháng", R.drawable.chude_nhactrinh),
                    new Topic("Tân cổ giao duyên", R.drawable.chude_tanco),
                    new Topic("Mừng xuân Đinh Dậu", R.drawable.chude_tetviet),
                    new Topic("Thư giản", R.drawable.chude_thugian),
                    new Topic("Tình yêu lứa đôi", R.drawable.chude_tinhyeu),
            };

    public static SimpleSong[] SongCollectionSource = new SimpleSong[]
            {
                    new SimpleSong("Hương Lúa Mạ Non", R.drawable.quang_le, 10000, "Quang Lê"),
                    new SimpleSong("Chân Tình", R.drawable.nhac_dan_ca, 4634, "Cẩm Ly"),
                    new SimpleSong("Anh Còn Nợ Em", R.drawable.quang_dung, 64864, "Quang Dũng"),
                    new SimpleSong("Cha Chồng Nàng Dâu", R.drawable.vinh_thuyen_kim, 787876, "Vĩnh Thuyên Kim"),
                    new SimpleSong("Xuân Này Con Không Về", R.drawable.nhat_kim_anh, 684684, "Nhật Kim Anh"),
                    new SimpleSong("Gọi Đò", R.drawable.dan_nguyen, 486463, "Đan Nguyên"),
                    new SimpleSong( "Đồi Hoa Sim", R.drawable.duong_ngoc_thai, 2428,  "Dương Ngọc Thái"),
                    new SimpleSong("Căn Nhà Ngoại Ô", R.drawable.truong_vu, 6787, "Trường Vũ"),
            };

//    int[] songImage = {
//            R.drawable.quang_le,
//            R.drawable.nhac_dan_ca,
//            R.drawable.quang_dung,
//            R.drawable.vinh_thuyen_kim,
//            R.drawable.nhat_kim_anh,
//            R.drawable.dan_nguyen,
//            R.drawable.duong_ngoc_thai,
//            R.drawable.tuan_vu,
//            R.drawable.truong_vu
//
//    };
}
