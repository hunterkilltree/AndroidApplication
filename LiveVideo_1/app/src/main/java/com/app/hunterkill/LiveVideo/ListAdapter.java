package com.app.hunterkill.LiveVideo;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v17.leanback.widget.ImageCardView;
import android.support.v17.leanback.widget.ListRowPresenter;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

/**
 * Created by hunterkill on 21/04/2020.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private Context context;
    private List<MediaModel> elements;


    public ListAdapter(Context c, List<MediaModel> l) {
        this.context = c;
        this.elements = l;
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
//        return 0;
        return this.elements.size();
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.textName.setText(elements.get(position).getMediaTitle());
        holder.textInfo.setText(elements.get(position).getMediaInfo());

        Picasso.get()
                .load(elements.get(position).getMediaThumbnail())
                .into(holder.imgThumbnail);


      holder.itemView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus) {
                    // run scale animation and make it bigger
                    v.setBackgroundResource(R.color.colorAccent);
                }
                else {
                    // run scale animation and make it smaller
                    v.setBackgroundResource(R.color.defaultColorCard);
                }

            }

        });

    }


}
