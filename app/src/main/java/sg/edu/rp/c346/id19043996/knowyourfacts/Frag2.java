package sg.edu.rp.c346.id19043996.knowyourfacts;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
        View fragView1 = inflater.inflate(R.layout.fragment_frag2, container, false);

        // TODO: Binding objects
        tvFrag2 = fragView1.findViewById(R.id.tvFrag2);
        btnFrag2 = fragView1.findViewById(R.id.btnFrag2);
        linearlayoutFrag2 = fragView1.findViewById(R.id.linearlayoutFrag2);

        btnFrag2.setOnClickListener(v -> {
            Random random = new Random();
            int Frag2Color = Color.argb(255, random.nextInt(256), random.nextInt(256),
                    random.nextInt(256));
            fragView1.setBackgroundColor(Frag2Color);


            SharedPreferences Frag2SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
            SharedPreferences.Editor Frag2SharedPreferencesEditor = Frag2SharedPreferences.edit();
            Frag2SharedPreferencesEditor.putInt("Frag2Color", Frag2Color);
            Frag2SharedPreferencesEditor.apply();


        });


        return fragView1;
    }

    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences Frag2SharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        int Frag2Color = Frag2SharedPreferences.getInt("Frag2Color", 0);
        linearlayoutFrag2.setBackgroundColor(Frag2Color);
    }
}