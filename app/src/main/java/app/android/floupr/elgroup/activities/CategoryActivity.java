package app.android.floupr.elgroup.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.Timer;
import java.util.TimerTask;

import app.android.floupr.elgroup.adapters.ImageAdapter;
import app.android.floupr.elgroup.adapters.TopImageAdapter;
import app.android.floupr.elgroup.stickerapp.R;

/**
 * Created by vikram on 24/9/17.
 */

public class CategoryActivity extends AppCompatActivity {
    int currentPage = 0;
    Timer timer;
    GridView gridview;
    Context context;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.
    ViewPager viewPager;
    Integer gridviewImages[] = {R.drawable.gif_active,R.drawable.sticker_active,R.drawable.message_240,R.drawable.fact_sticker_active};
    Integer topImagesYellow[] = {R.drawable.gif_active,R.drawable.sticker_active,R.drawable.message_240,R.drawable.fact_sticker_active};

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main1);

        context =this;

        gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this, gridviewImages));

        viewPager = (ViewPager) findViewById(R.id.viewpagerTop);
        viewPager.setAdapter(new TopImageAdapter(this, topImagesYellow));


        /*After setting the adapter use the timer */
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == topImagesYellow.length) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);


        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent homePage = new Intent(context, MainActivity.class);
                homePage.putExtra("index", i);
                startActivity(homePage);

            }
        });

    }
}
