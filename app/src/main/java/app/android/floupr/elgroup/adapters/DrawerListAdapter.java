package app.android.floupr.elgroup.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import app.android.floupr.elgroup.common.NavItem;
import app.android.floupr.elgroup.stickerapp.R;


/**
 * Created by VIKRAM SINGH on 16-Feb-17.
 */

public class DrawerListAdapter extends BaseAdapter {

    public Context mContext;
    public ArrayList<NavItem> mNavItems;

    public DrawerListAdapter(Context context, ArrayList<NavItem> navItems)
    {
        mContext = context;
        mNavItems = navItems;
    }

    @Override
    public int getCount()
    {
        return mNavItems.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mNavItems.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.drawable_view, parent, false);
        }
        else {
            view = convertView;
        }

        TextView titleView = (TextView) view.findViewById(R.id.navTitle);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        //titleView.setTypeface(Config.getTypeFace(mContext,"Exo2-Light.ttf"));
        titleView.setText(mNavItems.get(position).getTitle());
        icon.setBackgroundResource(mNavItems.get(position).getPicId());
        View lineView = view.findViewById(R.id.underlinesidebar);


        if(position ==7)
        {
//            View emptySpace =  view.findViewById(R.id.emptySapce);
//            emptySpace.setVisibility(View.INVISIBLE);

            lineView.setVisibility(View.GONE);

        }

        return view;
    }
}
