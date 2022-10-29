package com.example.android.news_app;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_activity);
    }

    public static class NewsPreferenceFragment extends PreferenceFragment implements Preference.OnPreferenceChangeListener {

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.settings_main);

            Preference search = findPreference(getString(R.string.settings_search_key));
            bindPreferenceSummaryToValue(search);
            Preference orderBy = findPreference(getString(R.string.settings_order_by_key));
            bindPreferenceSummaryToValue(orderBy);
        }

        // Use setOnPreferenceChangeListener to set the current NewsPreferenceFragment instance
        // to listen for changes to the preference we pass in
        private void bindPreferenceSummaryToValue(Preference preference) {
            preference.setOnPreferenceChangeListener(this);
            // Get the current value of the preference stored in the SharedPreferences on the device, and display
            // that in the preference summary (so that the user can see the current value of the preference)
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(preference.getContext());
            String preferenceString = preferences.getString(preference.getKey(), "");
            onPreferenceChange(preference, preferenceString);
        }

        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            // The code in this method takes care of updating the displayed preference summary after it has been changed
            String stringValue = value.toString();
            preference.setSummary(stringValue);

            if (preference instanceof ListPreference) {
                ListPreference listPreference = (ListPreference) preference;
                int prefIndex = listPreference.findIndexOfValue(stringValue);
                if (prefIndex >= 0) {
                    CharSequence[] labels = listPreference.getEntries();
                    preference.setSummary(labels[prefIndex]);
                }
            } else {
                preference.setSummary(stringValue);
            }
            return true;
        }
    }
}
