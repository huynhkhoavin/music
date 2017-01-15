package com.example.khoavin.nativemusic.ToolsFactory;

import com.example.khoavin.nativemusic.DataObject.Artist;
import com.example.khoavin.nativemusic.DataObject.KindOfMusic;
import com.example.khoavin.nativemusic.DataObject.NormalPlayList;
import com.example.khoavin.nativemusic.DataObject.SimpleSong;
import com.example.khoavin.nativemusic.DataObject.Topic;
import com.example.khoavin.nativemusic.DataObject.Video;
import com.example.khoavin.nativemusic.R;

import java.text.DecimalFormat;

import static com.example.khoavin.nativemusic.DataObject.KindOfMusic.MusicKind.*;

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
            new Video("Duyên nghèo", "Mạnh Quỳnh - Phi Nhung", "", 44000, R.drawable.video_duyenngheo),
            new Video("Căn nhà màu tím", "Mạnh Quỳnh - Phi Nhung", "", 116000, R.drawable.video_cannhamautim),
            new Video("Áo hoa", "Quang Lê - Mai Thiên Vân", "", 83000, R.drawable.video_aohoa),
            new Video("Khúc thụy du", "Khánh Ly", "", 999, R.drawable.video_khucthuydu),
            new Video("Cơn mưa ngang qua", "Sơn Tùng MTP", "", 65239000, R.drawable.video_conmuangangqua),
            new Video("Dấu mưa", "Trung Quân Idol", "", 65000, R.drawable.video_daumua),
            new Video("Sai càng sai", "Chi Dân", "", 32000, R.drawable.video_saicangsai),
            new Video("Xuân tha hương lạc xứ", "Trường Vũ", "", 325, R.drawable.video_xuanthahuonglacxu),
            new Video("Lạc trôi", "Sơn Tùng MTP", "", 999000, R.drawable.lactroi_music),
            new Video("Em của ngày hôm qua", "Sơn Tùng MTP", "", 725000, R.drawable.video_emcuangayhomqua),
            new Video("Chuyện tình Lan và Điệp", "Mạnh Quỳnh - Phi Nhung", "", 74000, R.drawable.video_chuyentinhlanvadiepp),
            new Video("Khúc thụy du", "Khánh Ly", "", 999, R.drawable.video_khucthuydu),
            new Video("Xuân tha hương lạc xứ", "Trường Vũ", "", 325, R.drawable.video_xuanthahuonglacxu),
            new Video("Cơn mưa ngang qua", "Sơn Tùng MTP", "", 152000, R.drawable.video_conmuangangqua),
            new Video("Dấu mưa", "Trung Quân Idol", "", 65000, R.drawable.video_daumua),
            new Video("Sai càng sai", "Chi Dân", "", 32000, R.drawable.video_saicangsai),
            new Video("Duyên nghèo", "Mạnh Quỳnh - Phi Nhung", "", 44000, R.drawable.video_duyenngheo),
            new Video("Ru lại câu hò", "Cẩm Ly", "", 350000, R.drawable.video_rulaicauho),

    };

    public  static NormalPlayList[] PlaylistCollectionSource = new NormalPlayList[]
            {
                    new NormalPlayList("Cẩm Ly", R.drawable.playlist_rulaicauho, "", 325000, "Ru lại câu hò"),
                    new NormalPlayList("Quang Dũng", R.drawable.playlist_anhconnoem, "", 325000, "Anh còn nợ em"),
                    new NormalPlayList("Đàm Vĩnh Hưng", R.drawable.playlist_demlangthang, "", 325000, "Đêm lang thang"),
                    new NormalPlayList("Đan Trường", R.drawable.maimaimottinhyeu, "", 325000, "Mãi mãi một tình yêu"),
                    new NormalPlayList("Hồ Ngọc Hà", R.drawable.playlist_codongiuacuoctinh, "", 325000, "Cô đơn giữa cuộc tình"),
                    new NormalPlayList("Duy Mạnh", R.drawable.playlist_kieanchoi, "", 325000, "Kiếp ăn chơi"),
                    new NormalPlayList("Noo Phước Thịnh", R.drawable.playlist_gatdinuocmat, "", 325000, "Gạt đi nước mắt"),
                    new NormalPlayList("Sơn Tùng MTP", R.drawable.playlist_lactroi, "", 325000, "Lạc trôi"),
                    new NormalPlayList("Bảo Thy", R.drawable.playlist_ngoinhahoahong, "", 325000, "Ngôi nhà hoa hồng"),
                    new NormalPlayList("Đàm Vĩnh Hưng", R.drawable.playlist_demlangthang, "", 325000, "Đêm lang thang"),
                    new NormalPlayList("Ngọc Sơn", R.drawable.playlist_noibuonhoaphuong, "", 325000, "Nỗi buồn hoa phượng"),
                    new NormalPlayList("Lý Hải", R.drawable.playlist_trondoibenem, "", 325000, "Trọn đời bên em")
            };
    public static Topic[] TopicCollectionSource = new Topic[]
            {
                    new Topic("Mừng Đảng mừng xuân", R.drawable.chude_cachmang),
                    new Topic("Chào mừng thành lập đoàn", R.drawable.chude_doan),
                    new Topic("Cải lương", R.drawable.chude_cailuong),
                    new Topic("Nhạc hải ngoại", R.drawable.chude_haingoai),
                    new Topic("Nhạc Trịnh - Những ca khúc đi cùng năm tháng", R.drawable.chude_nhactrinh),
                    new Topic("Tân cổ giao duyên", R.drawable.chude_tanco),
                    new Topic("Mừng xuân Đinh Dậu", R.drawable.chude_tetviet),
                    new Topic("Thư giản", R.drawable.chude_thugian),
                    new Topic("Tình yêu lứa đôi", R.drawable.chude_tinhyeu),
                    new Topic("DANCE 2016", R.drawable.chude_dance),
            };

    public static SimpleSong[] SongCollectionSource = new SimpleSong[]
            {
                    new SimpleSong("Hương tóc Mạ Non", R.drawable.quang_le, 10000, "Quang Lê"),
                    new SimpleSong("Chân Tình", R.drawable.nhac_dan_ca, 4634, "Cẩm Ly"),
                    new SimpleSong("Anh Còn Nợ Em", R.drawable.quang_dung, 64864, "Quang Dũng"),
                    new SimpleSong("Cha Chồng Nàng Dâu", R.drawable.vinh_thuyen_kim, 787876, "Vĩnh Thuyên Kim"),
                    new SimpleSong("Xuân Này Con Không Về", R.drawable.nhat_kim_anh, 684684, "Nhật Kim Anh"),
                    new SimpleSong("Gọi Đò", R.drawable.dan_nguyen, 486463, "Đan Nguyên"),
                    new SimpleSong( "Đồi Hoa Sim", R.drawable.duong_ngoc_thai, 2428,  "Dương Ngọc Thái"),
                    new SimpleSong("Căn Nhà Ngoại Ô", R.drawable.truong_vu, 6787, "Trường Vũ"),
            };

    public static KindOfMusic[] MusicKindCollectionSource = new KindOfMusic[]
            {
                    new KindOfMusic("Nổi bật", NEW),
                    new KindOfMusic("Nhạc trẻ",  NHAC_TRE),
                    new KindOfMusic("Tiền tuyến", NHAC_TIEN_TUYEN),
                    new KindOfMusic("Nhạc vàng", NHAC_VANG),
                    new KindOfMusic("Chèo", CHEO),
                    new KindOfMusic("Hát bội", HAT_BOI),
                    new KindOfMusic("Cải lương", CAI_LUONG),
                    new KindOfMusic("Tân cổ", TAN_CO),
                    new KindOfMusic("Đờn ca tài tử", DON_CA_TAI_TU),
                    new KindOfMusic("Ca trù", CA_TRU),
                    new KindOfMusic("Thiếu nhi", NHAC_THIEU_NHI),
                    new KindOfMusic("Mùa xuân", NHAC_XUAN),
                    new KindOfMusic("Tuổi học sinh", NHAC_HOC_SINH),
                    new KindOfMusic("Nhạc sến", NHAC_SEN),
                    new KindOfMusic("Trữ tình", NHAC_TRU_TINH),
                    new KindOfMusic("Nhã nhạc", NHA_NHAC),
                    new KindOfMusic("Nhạc chế", NHAC_CHE),
            };

    public static Topic[] MainmenuTopicCollectionSource = new Topic[]
            {
                    new Topic("Mừng Đảng mừng xuân", R.drawable.chude_cachmang),
                    new Topic("Cải lương", R.drawable.chude_cailuong),
                    new Topic("Nhạc hải ngoại", R.drawable.chude_haingoai),
                    new Topic("Tân cổ giao duyên", R.drawable.chude_tanco),
                    new Topic("Mừng xuân Đinh Dậu", R.drawable.chude_tetviet),
                    new Topic("Thư giãn", R.drawable.chude_thugian),
            };


    public static Video[] MainmenuVideoCollectionSource = new Video[]{
            new Video("Duyên nghèo", "Mạnh Quỳnh - Phi Nhung", "", 44000, R.drawable.video_duyenngheo),
            new Video("Căn nhà màu tím", "Mạnh Quỳnh - Phi Nhung", "", 116000, R.drawable.video_cannhamautim),
            new Video("Áo hoa", "Quang Lê - Mai Thiên Vân", "", 83000, R.drawable.video_aohoa),
            new Video("Cơn mưa ngang qua", "Sơn Tùng MTP", "", 65239000, R.drawable.video_conmuangangqua)
    };

    public  static NormalPlayList[] MainmenuAlbumCollectionSource = new NormalPlayList[]
            {
                    new NormalPlayList("Cẩm Ly", R.drawable.playlist_rulaicauho, "", 325000, "Ru lại câu hò"),
                    new NormalPlayList("Quang Dũng", R.drawable.playlist_anhconnoem, "", 325000, "Anh còn nợ em"),
                    new NormalPlayList("Đàm Vĩnh Hưng", R.drawable.playlist_demlangthang, "", 325000, "Đêm lang thang"),
                    new NormalPlayList("Đan Trường", R.drawable.maimaimottinhyeu, "", 325000, "Mãi mãi một tình yêu"),
                    new NormalPlayList("Hồ Ngọc Hà", R.drawable.playlist_codongiuacuoctinh, "", 325000, "Cô đơn giữa cuộc tình"),
                    new NormalPlayList("Noo Phước Thịnh", R.drawable.playlist_gatdinuocmat, "", 325000, "Gạt đi nước mắt"),
                    new NormalPlayList("Sơn Tùng MTP", R.drawable.playlist_lactroi, "", 325000, "Lạc trôi"),
                    new NormalPlayList("Bảo Thy", R.drawable.playlist_ngoinhahoahong, "", 325000, "Ngôi nhà hoa hồng"),
                    new NormalPlayList("Đàm Vĩnh Hưng", R.drawable.playlist_demlangthang, "", 325000, "Đêm lang thang"),
                    new NormalPlayList("Lý Hải", R.drawable.playlist_trondoibenem, "", 325000, "Trọn đời bên em")
            };

    public static SimpleSong[] MainmenuSongCollectionSource = new SimpleSong[]
            {
                    new SimpleSong("Hương Lúa Mạ Non", R.drawable.quang_le, 10000, "Quang Lê"),
                    new SimpleSong("Chân Tình", R.drawable.nhac_dan_ca, 4634, "Cẩm Ly"),
                    new SimpleSong("Cha Chồng Nàng Dâu", R.drawable.vinh_thuyen_kim, 787876, "Vĩnh Thuyên Kim"),
                    new SimpleSong("Xuân Này Con Không Về", R.drawable.nhat_kim_anh, 684684, "Nhật Kim Anh"),
                    new SimpleSong("Gọi Đò", R.drawable.dan_nguyen, 486463, "Đan Nguyên"),
                    new SimpleSong( "Đồi Hoa Sim", R.drawable.duong_ngoc_thai, 2428,  "Dương Ngọc Thái"),
            };

    public static Artist[] ArtistCollectionSource = new Artist[]
            {
                    new Artist("Sơn Tùng MTP", R.drawable.ca_si_son_tung),
                    new Artist("Quang Lê", R.drawable.quang_le),
                    new Artist("Bằng Kiều", R.drawable.ca_si_bang_kieu),
                    new Artist("Cẩm Ly", R.drawable.ca_si_cam_ly),
                    new Artist("Đàm Vĩnh Hưng", R.drawable.ca_si_dam_vinh_hung),
                    new Artist("Đan Trường", R.drawable.ca_si_dan_truong),
                    new Artist("Đông Nhi", R.drawable.ca_si_dong_nhi),
                    new Artist("Hồ Ngọc Hà", R.drawable.ca_si_ho_ngoc_ha),
                    new Artist("Hồ Quang Hiếu", R.drawable.ca_si_ho_quang_hieu),
                    new Artist("Hoàng Thùy Linh", R.drawable.ca_si_hoang_thuy_linh),
                    new Artist("Khởi My", R.drawable.ca_si_khoi_my),
                    new Artist("Lam Trường", R.drawable.ca_si_lam_truong),
                    new Artist("Lệ Quyên", R.drawable.ca_si_le_quyen),
                    new Artist("Minh Hằng", R.drawable.ca_si_minh_hang),
                    new Artist("Mỹ Linh", R.drawable.ca_si_my_linh),
                    new Artist("Mỹ Tâm", R.drawable.ca_si_my_tam),
                    new Artist("Noo Phước Thịnh", R.drawable.ca_si_noo),
                    new Artist("Quang Dũng", R.drawable.quang_dung),
                    new Artist("Quang Vinh", R.drawable.ca_si_quang_vinh),
                    new Artist("Thủy Tiên", R.drawable.ca_si_thuy_tien),

            };
}
