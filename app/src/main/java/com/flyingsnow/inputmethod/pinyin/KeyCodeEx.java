package com.flyingsnow.inputmethod.pinyin;

import android.content.res.Resources;
import android.inputmethodservice.Keyboard;
import android.view.KeyEvent;

import java.security.Key;
import java.util.Dictionary;
import java.util.Enumeration;

public final class KeyCodeEx {
    public static final int KEYCODE_EX = 300;
    public static final int KEYCODE_ZH = 301;
    public static final int KEYCODE_CH = 302;
    public static final int KEYCODE_SH = 303;
    public static final int KEYCODE_DELIMETER = 309;
    //    public static final int KEYCODE_A = 310;
    public static final int KEYCODE_AN = 311;
    public static final int KEYCODE_AO = 312;
    public static final int KEYCODE_AI = 313;
    public static final int KEYCODE_ANG = 314;
    //    public static final int KEYCODE_O = 315;
    public static final int KEYCODE_ONG = 316;
    public static final int KEYCODE_OU = 317;
    //    public static final int KEYCODE_E = 318;
    public static final int KEYCODE_EN = 319;
    public static final int KEYCODE_EI = 320;
    public static final int KEYCODE_ENG = 321;
    public static final int KEYCODE_ER = 322;
    //    public static final int KEYCODE_I = 323;
    public static final int KEYCODE_IA = 324;
    public static final int KEYCODE_IU = 325;
    public static final int KEYCODE_IE = 326;
    public static final int KEYCODE_IN = 327;
    public static final int KEYCODE_ING = 328;
    public static final int KEYCODE_IAO = 329;
    public static final int KEYCODE_IAN = 330;
    public static final int KEYCODE_IANG = 331;
    public static final int KEYCODE_IONG = 332;
    //    public static final int KEYCODE_U = 333;
    public static final int KEYCODE_UN = 334;
    public static final int KEYCODE_UA = 335;
    public static final int KEYCODE_UO = 336;
    public static final int KEYCODE_UI = 337;
    public static final int KEYCODE_UAI = 338;
    public static final int KEYCODE_UAN = 339;
    public static final int KEYCODE_UANG = 340;
    public static final int KEYCODE_V = 341;
    public static final int KEYCODE_UE = 342;
    public static final int KEYCODE_EX_END = 343;

    private static final String[] CODE_TO_STR = new String[]{
            "zh",  // 301
            "ch",
            "sh",
            "", "", "", "", "", "'",  // 304 - 309
            "a", "an", "ao", "ai", "ang",  // 310-314
            "o", "ong", "ou",  // 315-317
            "e", "en", "ei", "eng", "er",  // 318-322
            "i", "ia", "iu", "ie", "in", "ing", "iao", "ian", "iang", "iong",  // 323-332
            "u", "un", "ua", "uo", "ui", "uai", "uan", "uang",  // 333-340
            "v", "ue"  //  341-342
    };

    public static String codeToString(int keyCode) {
        if (keyCode > KEYCODE_EX && keyCode  < KEYCODE_EX_END) {
            return CODE_TO_STR[keyCode - 301];
        }
        return "";
    }

    public static boolean isComplexKey(int keyCode) {
        if (keyCode > KEYCODE_EX && keyCode  < KEYCODE_EX_END) {
            return true;
        }
        return false;
    }

    public static boolean isChineseCons(int keyCode) {
        if (keyCode > KeyEvent.KEYCODE_A && keyCode <= KeyEvent.KEYCODE_Z &&
                keyCode != KeyEvent.KEYCODE_E && keyCode != KeyEvent.KEYCODE_I &&
                keyCode != KeyEvent.KEYCODE_O && keyCode != KeyEvent.KEYCODE_U &&
                keyCode != KeyEvent.KEYCODE_V ) {
            return true;
        }
        if (keyCode > KeyCodeEx.KEYCODE_EX && keyCode < KeyCodeEx.KEYCODE_DELIMETER) {
            return true;
        }
        return false;
    }

    public static boolean isChineseVowel(int keyCode) {
        if (keyCode == KeyEvent.KEYCODE_A || keyCode == KeyEvent.KEYCODE_E || keyCode ==KeyEvent.KEYCODE_I ||
                keyCode ==KeyEvent.KEYCODE_O || keyCode == KeyEvent.KEYCODE_U ||
                keyCode == KeyEvent.KEYCODE_V || keyCode == KeyCodeEx.KEYCODE_V) {
            return true;
        }
        if (keyCode > KeyCodeEx.KEYCODE_DELIMETER && keyCode < KeyCodeEx.KEYCODE_EX_END) {
            return true;
        }
        return false;
    }

    public static int keyCodeToKeyRow(int keyCode, Resources r)
    {
        switch (keyCode){
            case KeyEvent.KEYCODE_APOSTROPHE:
            case KeyCodeEx.KEYCODE_DELIMETER:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_no_cons));
            case KeyEvent.KEYCODE_B:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_b));
            case KeyEvent.KEYCODE_P:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_p));
            case KeyEvent.KEYCODE_M:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_m));
            case KeyEvent.KEYCODE_F:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_f));
            case KeyEvent.KEYCODE_D:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_d));
            case KeyEvent.KEYCODE_T:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_t));
            case KeyEvent.KEYCODE_N:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_n));
            case KeyEvent.KEYCODE_L:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_l));
            case KeyEvent.KEYCODE_G:
            case KeyEvent.KEYCODE_K:
            case KeyEvent.KEYCODE_H:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_gkh));
            case KeyEvent.KEYCODE_J:
            case KeyEvent.KEYCODE_Q:
            case KeyEvent.KEYCODE_X:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_jqx));
            case KeyEvent.KEYCODE_Z:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_z));
            case KeyEvent.KEYCODE_C:
            case KeyEvent.KEYCODE_S:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_cs));
            case KeyCodeEx.KEYCODE_ZH:
            case KeyCodeEx.KEYCODE_CH:
            case KeyCodeEx.KEYCODE_SH:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_zhchsh));
            case KeyEvent.KEYCODE_R:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_r));
            case KeyEvent.KEYCODE_Y:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_y));
            case KeyEvent.KEYCODE_W:
                return Integer.parseInt(r.getString(R.string.toggle_row_py_w));
        }
        return 0;
    }
}
