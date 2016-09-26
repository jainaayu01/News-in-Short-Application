package com.example.india.vaetasapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramotion.foldingcell.FoldingCell;
import com.squareup.picasso.Picasso;

/**
 * Created by india on 8/4/2016.
 */
public class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private ImageView image;
    private TextView slugTextView;
    private TextView descriptionTextView;
    private TextView articleLinkTextView;
    private TextView publishedAtTextView;
    private TextView titleTextView;
    private TextView createdAtTextView;
    private FoldingCell foldingCell;
     private FoldingCellClickListener listener;
    public NewsViewHolder(View itemView) {
        super(itemView);
        image = (ImageView)itemView.findViewById(R.id.news_image_view);
        foldingCell =(FoldingCell)itemView.findViewById(R.id.folding_cell);
        slugTextView = (TextView)itemView.findViewById(R.id.slug_textview);
        descriptionTextView =(TextView)itemView.findViewById(R.id.description_textview);
        articleLinkTextView = (TextView)itemView.findViewById(R.id.article_link_textview);
        publishedAtTextView = (TextView)itemView.findViewById(R.id.publishedAt_textview);
        titleTextView = (TextView)itemView.findViewById(R.id.title_text_view);
        createdAtTextView = (TextView)itemView.findViewById(R.id.createdAt_text_view);
        foldingCell.setOnClickListener(this);
    }

    public void bindStory(Story story, Context context) {
       slugTextView.setText(story.getSlug());
        descriptionTextView.setText(story.getDescription());
        articleLinkTextView.setText(story.getArticleLink());
        publishedAtTextView.setText(story.getPublishedAt());
        titleTextView.setText(story.getTitle());
        createdAtTextView.setText(story.getCreatedAt());
        Picasso.with(context).load(story.getThumbnailUrl())
                .placeholder(R.drawable.ic_placeholder)
                .error(R.drawable.ic_placeholder)
                .into(image);
;
    }

    @Override
    public void onClick(View view) {

            foldingCell.toggle(false);

    }

    public interface  FoldingCellClickListener{
        public Boolean foldingcellClicked();
    }



}
