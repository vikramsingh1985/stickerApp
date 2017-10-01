package app.android.floupr.elgroup.activities;

import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import app.android.floupr.elgroup.adapters.ImageAdapter;
import app.android.floupr.elgroup.adapters.ListImageAdapter;
import app.android.floupr.elgroup.stickerapp.R;

/**
 * Created by vikram on 1/10/17.
 */

public class GridActivity extends AppCompatActivity{
    GridView gridView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_layout);
//        getActionBar().setDisplayHomeAsUpEnabled(true);
        gridView = (GridView) findViewById(R.id.gridview);
        String []stickers = listFiles("files/stickers");
        ArrayList<String> listImages = new ArrayList<String>(Arrays.asList(stickers));



        gridView.setAdapter(new ListImageAdapter(this, listImages));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 share();

            }
        });

    }

    private void share(){
        Intent i=new Intent(android.content.Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(android.content.Intent.EXTRA_SUBJECT,"Subject test");
        i.putExtra(android.content.Intent.EXTRA_TEXT, "extra text that you want to put");
        startActivity(Intent.createChooser(i,"Share via"));

    }

    private String[] listFiles(String dirFrom) {
        try {
            Resources res = getResources(); //if you are in an activity
            AssetManager am = res.getAssets();
            String fileList[] = am.list(dirFrom);

            if (fileList != null) {
                for (int i = 0; i < fileList.length; i++) {
                    Log.d("Images: ", fileList[i]);
                }
            }
            return fileList;
        }catch (IOException e){
            Log.e("IOException: ",""+e.getLocalizedMessage());
        }
        return  null;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
