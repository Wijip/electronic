package com.example.electronic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;

import java.util.Locale;

public class settingAct extends AppCompatActivity {
    public static final String KEY_PREF_LANGUAGE = "list";
    public String languagePref_ID="0";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        openFragment(new SettingFragment());

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String languagePref_ID = sharedPref.getString(KEY_PREF_LANGUAGE, "3");
        switch (languagePref_ID) {
            case "1":
                Locale localeEN = new Locale("EN");
                setLocaleOnCreate(localeEN);
                break;
            case "2":
                Locale localeDE = new Locale("DE");
                setLocaleOnCreate(localeDE);
                break;
            case "3":
                Locale localeIN = new Locale("IN");
                setLocaleOnCreate(localeIN);
                break;

        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String languagePref_ID_RES = sharedPref.getString(KEY_PREF_LANGUAGE, "3");
        if (!languagePref_ID.equals(languagePref_ID_RES)) {
            languagePref_ID_RES = languagePref_ID;
            switch (languagePref_ID_RES) {
                case "1":
                    Locale localeEN = new Locale("EN");
                    setLocaleOnCreate(localeEN);
                    break;
                case "2":
                    Locale localeDE = new Locale("DE");
                    setLocaleOnCreate(localeDE);
                    break;
                case "3":
                    Locale localeIN = new Locale("IN");
                    setLocaleOnCreate(localeIN);
                    break;

            }
        }
    }

    public void setLocaleOnCreate(Locale locale) {
        Locale.setDefault(locale);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
    }

    public void setLocale(Locale locale) {
        Locale.setDefault(locale);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = locale;
        res.updateConfiguration(conf, dm);
        recreate();
        //finish();
        //startActivity(getIntent());
    }

    public void startSettingsActivity(View view) {
        Intent intent = new Intent(this, settingAct.class);
        startActivity(intent);
    }

    private void openFragment(Fragment fragment) {
        openFragment(fragment, false);
    }

    private void openFragment(Fragment fragment, boolean addToBackstack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        if (addToBackstack)
            transaction.addToBackStack(null);
        transaction.commit();
    }
}
