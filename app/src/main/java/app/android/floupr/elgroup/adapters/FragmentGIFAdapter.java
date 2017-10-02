package app.android.floupr.elgroup.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import app.android.floupr.elgroup.stickerapp.R;
import app.android.floupr.elgroup.views.GifWebView;

/**
 * Created by vikram on 24/9/17.
 */

public class FragmentGIFAdapter extends RecyclerView.Adapter<FragmentGIFAdapter.MyViewHolder> {
    private Context mContext;

    // Constructor
    public FragmentGIFAdapter(Context c, ArrayList<String> mThumbIds) {
        mContext = c;
        this.listImages = mThumbIds;
    }



    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter


    // Keep all Images in array
    public ArrayList<String> listImages ;


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sticker_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        InputStream stream = null;
        try {
            stream = mContext.getAssets().open("files/gif/" + listImages.get(position));
        } catch (IOException e) {
            e.printStackTrace();
        }
        holder.imageView = new GifWebView(mContext, "files/gif/" + listImages.get(position));

    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public GifWebView imageView;;

        public MyViewHolder(View view) {
            super(view);
            imageView = (GifWebView) view.findViewById(R.id.gifView);
           // imageView.setLayoutParams(new GridView.LayoutParams(265, 265));
            //imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
           // imageView.setPadding(35, 40, 35, 40);
        }
    }

}