package sg.edu.rp.c346.id19043996.knowyourfacts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;

// TODO: Done by Shufang
public class MainActivity extends AppCompatActivity {

    // TODO: Declaring objects
    Button btnReadLater;
    ViewPager viewPager;
    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Binding objects
        viewPager = findViewById(R.id.viewpager);
        btnReadLater = findViewById(R.id.btnRead);

        FragmentManager fragmentManager = getSupportFragmentManager();

        al = new ArrayList<>();
        al.add(new Frag1());
        al.add(new Frag2());


        adapter = new MyFragmentPagerAdapter(fragmentManager, al);

        viewPager.setAdapter(adapter);


        btnReadLater.setOnClickListener(view -> finish());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int itemId = item.getItemId();
        final int nextId = R.id.action_next;
        final int previousId = R.id.action_previous;
        final int randomId = R.id.action_random;

        switch (itemId) {

            case nextId:
                int max = viewPager.getChildCount();
                if (viewPager.getCurrentItem() < max - 1) {
                    int nextPage = viewPager.getCurrentItem() + 1;
                    viewPager.setCurrentItem(nextPage, true);
                }
                return true;

            case previousId:
                if (viewPager.getCurrentItem() > 0) {
                    int previousPage = viewPager.getCurrentItem() - 1;
                    viewPager.setCurrentItem(previousPage, true);
                }
                return true;

            case randomId:
                Random random = new Random();
                viewPager.setCurrentItem(random.nextInt(3), true);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        int fragsViewPager = viewPager.getCurrentItem();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();
        sharedPreferencesEditor.putInt("fragsViewPager", fragsViewPager);
        sharedPreferencesEditor.apply();
        Log.d("SAVE", String.valueOf(fragsViewPager));
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int fragsViewPager = sharedPreferences.getInt("fragsViewPager", 0);
        viewPager.setCurrentItem(fragsViewPager, true);

        Log.d("RESTORE", String.valueOf(fragsViewPager));
    }
}