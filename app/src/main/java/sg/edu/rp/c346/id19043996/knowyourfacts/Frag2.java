package sg.edu.rp.c346.id19043996.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;


public class Frag2 extends Fragment {

    Button btnChange;
    RelativeLayout rl1;

    public Frag2() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);

        btnChange = view.findViewById(R.id.btnColor1);
        rl1 = view.findViewById(R.id.relativeLayout2);


        btnChange.setOnClickListener(view1 -> {
            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            rl1.setBackgroundColor(color);

        });

        return view;
    }
}