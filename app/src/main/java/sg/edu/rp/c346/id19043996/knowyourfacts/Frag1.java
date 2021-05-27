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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.Random;

// Todo by Jun Kai , updated by Shufang
public class Frag1 extends Fragment {

    // TODO: Declaring objects
    TextView tvFrag1;
    Button btnFrag1;
    ImageView ivFrag1;
    LinearLayout linearlayoutFrag1;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        // Todo: Inflate the layout for this fragment
        View fragView1 = inflater.inflate(R.layout.fragment_frag1, container, false);

        // TODO: Binding objects
        tvFrag1 = fragView1.findViewById(R.id.tvFrag1);
        btnFrag1 = fragView1.findViewById(R.id.btnFrag1);
        linearlayoutFrag1 = fragView1.findViewById(R.id.linearlayoutFrag1);
        ivFrag1 = fragView1.findViewById(R.id.ivFrag1);

        btnFrag1.setOnClickListener(v -> {
            Random random = new Random();
            int frag1Color = Color.argb(255, random.nextInt(256), random.nextInt(256),
                    random.nextInt(256));
            fragView1.setBackgroundColor(frag1Color);

            // Todo: Step 1 : obtain the Default Shared Preference
            SharedPreferences frag1SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

            // Todo: Step 2 : Create a SharedPreferences prefEdit by calling edit()
            SharedPreferences.Editor frag1SharedPreferencesEditor = frag1SharedPreferences.edit();

            // Todo: Step 3 : Set a key-value pair in the preferences editor
            frag1SharedPreferencesEditor.putInt("frag1Color", frag1Color);

            // Todo: Step 4 : Call apply() to save the changes made to the SharedPreferences
            frag1SharedPreferencesEditor.apply();

            // Todo: Step 5  : check the console to see the saved data
            Log.d("CHECK:", String.valueOf(frag1Color));
        });


        return fragView1;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Todo: Step 1 : obtain the Default Shared Preference
        SharedPreferences frag1SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        // Todo: Step 2 : Retrieve the saved data from the SharedPreferences
        int frag1Color = frag1SharedPreferences.getInt("frag1Color", 0);
        linearlayoutFrag1.setBackgroundColor(frag1Color);

        // Todo: Step 3  : check the console to see the saved data
        Log.d("RESUME:", String.valueOf(frag1Color));
    }
}