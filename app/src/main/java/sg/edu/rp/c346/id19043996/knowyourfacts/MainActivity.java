package sg.edu.rp.c346.id19043996.knowyourfacts;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
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
    ArrayList<Fragment> al;
    MyFragmentPagerAdapter adapter;
    ViewPager viewPager;
    Button btnReadLater;
    AlarmManager alarmManager;
    int reqCode = 12345;
    int notificationID = 888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Initalizing objects
        viewPager = findViewById(R.id.viewpager1);
        btnReadLater = findViewById(R.id.btnBack);

        FragmentManager fm = getSupportFragmentManager();

        al = new ArrayList<>();
        al.add(new Frag1());
        al.add(new Frag2());


        adapter = new MyFragmentPagerAdapter(fm, al);

        viewPager.setAdapter(adapter);


        btnReadLater.setOnClickListener(view -> {
            finish();


            Calendar cal = Calendar.getInstance();
            cal.add(Calendar.SECOND, 300);

            Intent intent = new Intent(MainActivity.this,
                    ScheduledNotificationReceiver.class);

            PendingIntent pendingIntent = PendingIntent.getBroadcast(
                    MainActivity.this, reqCode,
                    intent, PendingIntent.FLAG_CANCEL_CURRENT);

            AlarmManager alarmManager = (AlarmManager)
                    getSystemService(Activity.ALARM_SERVICE);

            alarmManager.set(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(),
                    pendingIntent);
        });
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
}