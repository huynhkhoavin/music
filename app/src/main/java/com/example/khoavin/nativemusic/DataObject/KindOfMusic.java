package com.example.khoavin.nativemusic.DataObject;

/**
 * Created by OatOal on 1/15/2017.
 */

public class KindOfMusic {

    private MusicKind kind;
    private String name;

    public KindOfMusic(String name, MusicKind kind) {
        this.name = name;
        this.kind = kind;
    }

    public MusicKind getKind() {
        return kind;
    }

    public void setKind(MusicKind kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public enum MusicKind
    {
        NHAC_TRE,
        NHAC_VANG,
        NHAC_TIEN_TUYEN,
        CA_TRU,
        DON_CA_TAI_TU,
        NHAC_THIEU_NHI,
        NEW,
        TAN_CO,
        NHAC_XUAN,
        NHAC_HOC_SINH,
        NHAC_SEN,
        NHAC_TRU_TINH,
        CHEO,
        HAT_BOI,
        CAI_LUONG,
        NHA_NHAC,
        NHAC_CHE
    }
}


