package app.android.floupr.elgroup.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by vikram on 24/9/17.
 */

public class ListImageAdapter extends BaseAdapter {
    private Context mContext;

    // Constructor
    public ListImageAdapter(Context c, ArrayList<String> mThumbIds) {
        mContext = c;
        this.mThumbIds = mThumbIds;
    }

    public int getCount() {
        return mThumbIds.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(285, 285));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 0, 8, 0);
        }
        else
        {
            imageView = (ImageView) convertView;
        }
        try {
            InputStream inputstream = mContext.getAssets().open("files/stickers/" + mThumbIds.get(position));

            Drawable drawable = Drawable.createFromStream(inputstream, null);
            imageView.setImageDrawable(drawable);
        }catch (IOException e){
            Log.e("IOException: ",""+e.getLocalizedMessage());
        }
        return imageView;
    }

    // Keep all Images in array
    public ArrayList<String> mThumbIds ;

}