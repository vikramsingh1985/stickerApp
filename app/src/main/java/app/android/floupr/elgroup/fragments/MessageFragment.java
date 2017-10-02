package app.android.floupr.elgroup.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.android.floupr.elgroup.stickerapp.R;

/**
 * Created by vikram on 30/9/17.
 */

public class MessageFragment extends Fragment {
    private View rootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_gif, container, false);
        //initViews();
        return rootView;
    }
}
