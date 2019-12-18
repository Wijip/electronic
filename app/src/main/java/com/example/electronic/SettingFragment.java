package com.example.electronic;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.ListPreference;
import androidx.preference.PreferenceFragmentCompat;
import androidx.preference.PreferenceManager;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Locale;

public class SettingFragment extends PreferenceFragmentCompat {
    public static final String TAG = "list";
    private SharedPreferences.OnSharedPreferenceChangeListener preferenceChangeListener;
    private SharedPreferences sharedPref;
    private ListPreference language;
    public static final String KEY_PREF_LANGUAGE = "list";
    public String languagePref_ID;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.OnSharedPreferenceChangeListener listener =
                new SharedPreferences.OnSharedPreferenceChangeListener() {
                    public void onSharedPreferenceChanged(SharedPreferences prefs, String key) {
                        if (key.equals(KEY_PREF_LANGUAGE)) {
                            languagePref_ID = prefs.getString(settingAct.KEY_PREF_LANGUAGE, "3");
                            switch (languagePref_ID) {
                                case "1":
                                    Locale localeEN = new Locale("EN");
                                    setLocale(localeEN);
                                    break;
                                case "2":
                                    Locale localeDE = new Locale("DE");
                                    setLocale(localeDE);
                                    break;
                                case "3":
                                    Locale localeIN = new Locale("IN");
                                    setLocale(localeIN);
                                    break;
                            }
                        }
                    }
                };
        sharedPref.registerOnSharedPreferenceChangeListener(listener);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) this.getContext());
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences().unregisterOnSharedPreferenceChangeListener((SharedPreferences.OnSharedPreferenceChangeListener) getContext());
    }

    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals(KEY_PREF_LANGUAGE)) {
            languagePref_ID = sharedPreferences.getString(settingAct.KEY_PREF_LANGUAGE, "3");
            switch (languagePref_ID) {
                case "1":
                    Locale localeEN = new Locale("EN");
                    setLocale(localeEN);
                    break;
                case "2":
                    Locale localeDE = new Locale("DE");
                    setLocale(localeDE);
                    break;
                case "3":
                    Locale localeIN = new Locale("IN");
                    setLocale(localeIN);
                    break;
            }
        }
    }

    public void setLocale(Locale locale) {
        Locale.setDefault(locale);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
//        recreate();
    }
}