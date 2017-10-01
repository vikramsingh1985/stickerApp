package app.android.floupr.elgroup.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import app.android.floupr.elgroup.activities.GridActivity;
import app.android.floupr.elgroup.adapters.FragmentImageAdapter;
import app.android.floupr.elgroup.stickerapp.R;

/**
 * Created by vikram on 24/9/17.
 */

public class GifFragment extends Fragment {
    private View rootView;
    AppCompatTextView baloonText,cakeText,cardText,giftText,wishesText;
    AppCompatButton baloonBtn,cakeBtn,cardBtn,giftBtn,wishesBtn;
    RecyclerView baloonRecyclerView,cakeRecyclerView,cardRecyclerView,giftRecyclerView,wishesRecyclerView;
    RecyclerView.LayoutManager layoutManager,layoutManager1,layoutManager2,layoutManager3,layoutManager4;
    FragmentImageAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String []stickers = listFiles("files/stickers");
        ArrayList<String> listImages = new ArrayList<String>(Arrays.asList(stickers));



        adapter = new FragmentImageAdapter(getActivity(),listImages);
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_gif, container, false);
        initViews();
        return rootView;
    }
    private void initViews(){
        baloonText = (AppCompatTextView) rootView.findViewById(R.id.baloonText);
        cakeText = (AppCompatTextView) rootView.findViewById(R.id.cakeText);
        cardText = (AppCompatTextView) rootView.findViewById(R.id.cardText);
        giftText = (AppCompatTextView) rootView.findViewById(R.id.giftText);
        wishesText = (AppCompatTextView) rootView.findViewById(R.id.wishesText);

        baloonBtn = (AppCompatButton) rootView.findViewById(R.id.seeAllBaloon);
        cakeBtn = (AppCompatButton) rootView.findViewById(R.id.seeAllCake);
        cardBtn = (AppCompatButton) rootView.findViewById(R.id.seeAllCard);
        giftBtn = (AppCompatButton) rootView.findViewById(R.id.seeAllGift);
        wishesBtn = (AppCompatButton) rootView.findViewById(R.id.seeAllWishes);
        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager3 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        layoutManager4 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        baloonRecyclerView = (RecyclerView) rootView.findViewById(R.id.baloonRecyclerView);
        baloonRecyclerView.setLayoutManager(layoutManager);
        cakeRecyclerView = (RecyclerView) rootView.findViewById(R.id.cakeRecyclerView);
        cakeRecyclerView.setLayoutManager(layoutManager1);
        cardRecyclerView = (RecyclerView) rootView.findViewById(R.id.cardRecyclerView);
        cardRecyclerView.setLayoutManager(layoutManager2);
        giftRecyclerView = (RecyclerView) rootView.findViewById(R.id.giftRecyclerView);
        giftRecyclerView.setLayoutManager(layoutManager3);
        wishesRecyclerView = (RecyclerView) rootView.findViewById(R.id.wishesRecyclerView);
        wishesRecyclerView.setLayoutManager(layoutManager4);
        String[] stickers = null;
        try {
             stickers = getActivity().getResources().getAssets().list("files/stickers");
        }catch (IOException e){
            Log.e("IOException: ",""+e.getLocalizedMessage());
        }
        ArrayList<String> listImages = new ArrayList<String>(Arrays.asList(stickers));

        adapter = new FragmentImageAdapter(getActivity(),listImages);
        baloonRecyclerView.setAdapter(adapter);
        cardRecyclerView.setAdapter(adapter);
        cakeRecyclerView.setAdapter(adapter);
        giftRecyclerView.setAdapter(adapter);
        wishesRecyclerView.setAdapter(adapter);


        baloonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GridActivity.class);
                startActivity(intent);
            }
        });

        cakeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GridActivity.class);
                startActivity(intent);
            }
        });

        cardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GridActivity.class);
                startActivity(intent);
            }
        });
        wishesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GridActivity.class);
                startActivity(intent);
            }
        });
        giftBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), GridActivity.class);
                startActivity(intent);
            }
        });



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

}
