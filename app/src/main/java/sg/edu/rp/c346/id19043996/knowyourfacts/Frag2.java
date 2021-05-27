package sg.edu.rp.c346.id19043996.knowyourfacts;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Random;

// Todo by Jun Kai , updated by Shufang
public class Frag2 extends Fragment {

    // TODO: Declaring objects
    TextView tvFrag2;
    Button btnFrag2;
    LinearLayout linearlayoutFrag2;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Todo: Inflate the layout for this fragment
        View fragView2 = inflater.inflate(R.layout.fragment_frag2, container, false);

        // TODO: Binding objects
        tvFrag2 = fragView2.findViewById(R.id.tvFrag2);
        btnFrag2 = fragView2.findViewById(R.id.btnFrag2);
        linearlayoutFrag2 = fragView2.findViewById(R.id.linearlayoutFrag2);

        btnFrag2.setOnClickListener(v -> {
            Random random = new Random();
            int frag2Color = Color.argb(255, random.nextInt(256), random.nextInt(256),
                    random.nextInt(256));
            fragView2.setBackgroundColor(frag2Color);


            // Todo: Step 1 : obtain the Default Shared Preference
            SharedPreferences frag2SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

            // Todo: Step 2 : Create a SharedPreferences prefEdit by calling edit()
            SharedPreferences.Editor frag2SharedPreferencesEditor = frag2SharedPreferences.edit();

            // Todo: Step 3 : Set a key-value pair in the preferences editor
            frag2SharedPreferencesEditor.putInt("frag2Color", frag2Color);

            // Todo: Step 4 : Call apply() to save the changes made to the SharedPreferences
            frag2SharedPreferencesEditor.apply();

            // Todo: Step 5  : check the console to see the saved data
            Log.d("CHECK:", String.valueOf(frag2Color));
        });


        return fragView2;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Todo: Step 1 : obtain the Default Shared Preference
        SharedPreferences frag2SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        // Todo: Step 2 : Retrieve the saved data from the SharedPreferences
        int frag2Color = frag2SharedPreferences.getInt("frag2Color", 0);
        linearlayoutFrag2.setBackgroundColor(frag2Color);

        // Todo: Step 3  : check the console to see the saved data
        Log.d("RESUME:", String.valueOf(frag2Color));
    }
}