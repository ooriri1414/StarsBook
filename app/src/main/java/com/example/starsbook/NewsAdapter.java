package com.example.starsbook;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<Post> {
    private Context context;
    private List<Post> posts;
    public NewsAdapter(Context context, int resource, int textViewResourceId, List<Post> posts){
        super(context, resource, textViewResourceId, posts);
        this.context = context;
        this.posts = posts;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = ((Activity) context).getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.news_list, parent, false);
        ImageView postImage = (ImageView) view.findViewById(R.id.ivPostImageNewsList);
        TextView postText = (TextView) view.findViewById(R.id.tvPostTextNewsList);
        Post temp = posts.get(position);
        postImage.setImageBitmap(temp.getImage());
        postText.setText(temp.getText());
        return view;
    }

}
