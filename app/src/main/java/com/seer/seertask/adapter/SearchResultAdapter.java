package com.seer.seertask.adapter;

import android.content.Context;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.seer.seertask.R;
import com.seer.seertask.model.Doc;
import com.seer.seertask.model.Result;

import org.ocpsoft.prettytime.PrettyTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultAdapter.MyViewHolder> {

    private final Context mContext;
    private List<Doc> mData;

    public SearchResultAdapter(Context mContext, List<Doc> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    public void setResultList(List<Doc> mData) {
        this.mData = mData;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.stories, parent, false);
        return new MyViewHolder(view);
    }

    String imageUrl = "";

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Doc model = mData.get(position);
        if (model.multimedia.size() > 0)
            imageUrl = model.multimedia.get(0).url;
        imageUrl = "https://www.nytimes.com/"+imageUrl;
        Glide.with(mContext)
                .load(imageUrl)
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
        holder.progress.setVisibility(View.GONE);
        holder.tvTitle.setText(model.getHeadline().main);
        holder.tvSource.setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
        holder.tvSource.setText(model.getLead_paragraph());
        holder.tvDate.setText(model.getByline().original);
    }

    @Override
    public int getItemCount() {
        if (mData != null)
            return mData.size();
        return 0;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvSource, tvDate;
        ImageView imageView;
        CardView cardView;
        ProgressBar progress;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvSource = itemView.findViewById(R.id.tvSource);
            tvDate = itemView.findViewById(R.id.tvDate);
            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.cardView);
            progress = itemView.findViewById(R.id.loader);

        }
    }
}
