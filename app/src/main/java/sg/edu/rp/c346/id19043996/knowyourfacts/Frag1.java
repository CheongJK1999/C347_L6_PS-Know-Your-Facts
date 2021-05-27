package sg.edu.rp.c346.id19043996.knowyourfacts;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Random;

// Todo by Jun Kai
public class Frag1 extends Fragment {
    ImageView iv1;
    TextView tv1, tv2, tv3;
    Button btnColor;
    LinearLayout linearlayout1;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag1, container, false);

        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);
        tv3 = view.findViewById(R.id.tv3);
        iv1 = view.findViewById(R.id.iv);
        btnColor = view.findViewById(R.id.btnColor);

        String imageUrl = "https://wtffunfact.com/wp-content/uploads/2021/05/WTF-Fun-Fact-Arctic-Foxs-Colorful-Fur.png";
        Picasso.with(view.getContext()).load(imageUrl).into(iv1);

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256),
                        random.nextInt(256));
                view.setBackgroundColor(color);
            }
        });
        return view;
    }
}