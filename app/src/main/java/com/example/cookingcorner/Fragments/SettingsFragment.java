package com.example.cookingcorner.Fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import com.example.cookingcorner.R;

/**
 * name: Komathy Mugunthan
 * Settings Fragment
 */

public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}