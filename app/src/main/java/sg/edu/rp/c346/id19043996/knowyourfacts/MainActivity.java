package sg.edu.rp.c346.id19043996.knowyourfacts;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.Random;

// TODO:Create three menu items Previous, Random and Next.
// Implement onOptionsItemSelected() method similarly to exercise did in the worksheet.
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

            //TODO: Set to previous  fragment if not  already the  first fragment
            case previousId:
                if (viewPager.getCurrentItem() > 0) {
                    int previousPage = viewPager.getCurrentItem() - 1;
                    viewPager.setCurrentItem(previousPage, true);
                }
                return true;
            //TODO: Set to next  fragment if  not  already the  last  fragment
            case nextId:
                int max = viewPager.getChildCount();
                if (viewPager.getCurrentItem() < max - 1) {
                    int nextPage = viewPager.getCurrentItem() + 1;
                    viewPager.setCurrentItem(nextPage, true);
                }
                return true;
            //TODO:Set to a random  item
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

        // Todo: Step 1 : obtain the Default Shared Preference
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Todo: Step 2 : Create a SharedPreferences prefEdit by calling edit()
        SharedPreferences.Editor sharedPreferencesEditor = sharedPreferences.edit();

        // Todo: Step 3 : Set a key-value pair in the preferences editor
        sharedPreferencesEditor.putInt("fragsViewPager", fragsViewPager);

        // Todo: Step 4 : Call apply() to save the changes made to the SharedPreferences
        sharedPreferencesEditor.apply();

        // Todo: Step 5  : Update UI element with the saved data
        Toast.makeText(getApplicationContext(), fragsViewPager, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Todo: Step 1 : obtain the Default Shared Preference
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Todo: Step 2 : Retrieve the saved data from the SharedPreferences
        int fragsViewPager = sharedPreferences.getInt("fragsViewPager", 0);
        viewPager.setCurrentItem(fragsViewPager, true);

        // Todo: Step 3 : Update UI element with the saved data
        Toast.makeText(getApplicationContext(), fragsViewPager, Toast.LENGTH_LONG).show();
    }
}