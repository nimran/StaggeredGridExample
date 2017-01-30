package com.imran.staggeredgridexample;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.List;

public class StaggeredAdapter extends RecyclerView.Adapter<StaggeredAdapter.StaggeredViewHolder> {

    private List<Model> itemList;
    private Context context;
    private ImageLoader imageLoader;

    public StaggeredAdapter(Context context, List<Model> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public StaggeredViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, null);

        return new StaggeredViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(StaggeredViewHolder holder, int position) {
        //load image
        String url = itemList.get(position).getPhoto();
        if (url.equals("")) {
            Toast.makeText(context, "Please enter a URL", Toast.LENGTH_LONG).show();
            return;
        }

        imageLoader = VolleyRequest.getInstance(context)
                .getImageLoader();
        imageLoader.get(url, ImageLoader.getImageListener(holder.image,
                android.R.drawable.ic_dialog_alert, android.R.drawable
                        .ic_dialog_alert));
        holder.image.setImageUrl(url, imageLoader);

    }


    @Override
    public int getItemCount() {
        return this.itemList.size();
    }

    public class StaggeredViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView name;
        public NetworkImageView image;

        public StaggeredViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            name = (TextView) itemView.findViewById(R.id.name);
            image = (NetworkImageView) itemView.findViewById(R.id.imageView);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
        }
    }
}
