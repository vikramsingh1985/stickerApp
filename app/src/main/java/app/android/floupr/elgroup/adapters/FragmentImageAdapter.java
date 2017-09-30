package app.android.floupr.elgroup.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import app.android.floupr.elgroup.stickerapp.R;

/**
 * Created by vikram on 24/9/17.
 */

public class FragmentImageAdapter extends RecyclerView.Adapter<FragmentImageAdapter.MyViewHolder> {
    private Context mContext;

    // Constructor
    public FragmentImageAdapter(Context c, ArrayList<String> mThumbIds) {
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
                .inflate(R.layout.gif_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        try {
            InputStream inputstream = mContext.getAssets().open("files/stickers/" + listImages.get(position));

            Drawable drawable = Drawable.createFromStream(inputstream, null);
            holder.imageView.setImageDrawable(drawable);
        }catch (IOException e){
            Log.e("IOException: ",""+e.getLocalizedMessage());
        }
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            imageView.setLayoutParams(new GridView.LayoutParams(265, 265));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(35, 40, 35, 40);
        }
    }

}