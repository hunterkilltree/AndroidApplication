package com.app.hunterkill.moviesapp;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v17.leanback.app.VideoSupportFragment;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by hunterkill on 9/05/2020.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private Context context;
    private List<MediaModel> elements;
    FragmentManager fragmentManager;
    ItemListenner mListener;

    public interface ItemListenner{
        void ItemClick(int pos);
    }

    public ListAdapter(Context c, List<MediaModel> l, FragmentManager fragmentManager) {
        this.context = c;
        this.elements = l;
        this.fragmentManager = fragmentManager;
    }

    public ListAdapter(Context c, List<MediaModel> l, FragmentManager fragmentManager, ItemListenner listenner) {
        this.context = c;
        this.elements = l;
        this.fragmentManager = fragmentManager;
        mListener = listenner;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName;
        TextView textInfo;
        ImageView imgThumbnail;

        public ViewHolder(View view) {
            super(view);
            textName = view.findViewById(R.id.txt_media_title);
            textInfo = view.findViewById(R.id.txt_media_info);
            imgThumbnail = view.findViewById(R.id.img_media_thumbnail);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(this.context).inflate(R.layout.layout_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return this.elements.size();
    }
    int prePos = -1;
    ViewHolder preHolder = null;
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        System.out.println("new ");
        holder.textName.setText(elements.get(position).getMediaTitle());
        holder.textInfo.setText(elements.get(position).getMediaInfo());
        Picasso.get()
                .load(elements.get(position).getMediaThumbnail())
                .into(holder.imgThumbnail);

//        System.out.println(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                holder.itemView.setSelected(false);
                if (prePos == position) {
//                System.out.println("test");
//                System.out.println(position);
//                System.out.println( elements.get(position).getMediaUrl());
////                selectFragment(position);
//                focusPosition = position;

                    mListener.ItemClick(position);
                }
                else {
//         set previous to defaultBackground
//                    if (preHolder != null) {
//                        preHolder.itemView.setBackgroundResource(R.color.defaultColorCard);
//                    }
//                    v.setBackgroundResource(R.color.colorAccent);
//                    notifyItemMoved(0, position);
//                    notifyItemMoved(position, position -1);
                    if (preHolder != null) {
//                        preHolder.itemView.setBackgroundColor(context.getResources().getColor(R.color.defaultColorCard));
                        preHolder.textName.setTextColor(context.getResources().getColor(R.color.defaultColorCard));
                    }
//                    holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
                     holder.textName.setTextColor(context.getResources().getColor(R.color.colorAccent));
                    preHolder = holder;
                    prePos = position;
                    mListener.ItemClick(-1);
//                    notifyItemRangeChanged(position, elements.size());
                }


            }
        });

//        holder.itemView.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.colorAccent));
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.defaultColorCard));
//                        Fragment fragment = null;
//                        Class fragmentClass = PlayVideoFragment.class;
//                        try {
//                            fragment = (Fragment) fragmentClass.newInstance();
//                            Bundle bundle = new Bundle();
//                            bundle.putString("link", elements.get(position).getMediaUrl());
//                            fragment.setArguments(bundle);
//
//                            // Insert the fragment by replacing any existing fragment
//                            fragmentManager.beginTransaction().replace(R.id.fragment_content, fragment).commitAllowingStateLoss();
//                        } catch (InstantiationException e) {
//                            e.printStackTrace();
//                        } catch (IllegalAccessException e) {
//                            e.printStackTrace();
//                        }
//                        break;
//                }
//                return false;
//            }
//        });

    }


}
