package com.neil.castellino.ivtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class ArrayAdapterGames extends ArrayAdapter<Game> {
    Context context;
    List<Game> gameList;

    public ArrayAdapterGames(@NonNull Context context, @NonNull ArrayList<Game> gameList) {
        super(context, -1, gameList);
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null)
            listItem = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);

        Game currentGame = gameList.get(position);

        ImageView image = (ImageView) listItem.findViewById(R.id.imageViewListItem);
        String imageUrl = currentGame.getThumbURL();
        imageUrl = imageUrl.substring(0, 4) + "s" + imageUrl.substring(4);
        Glide.with(listItem).load(imageUrl).into(image);

        TextView name = (TextView) listItem.findViewById(R.id.titleTextViewListItem);
        name.setText(currentGame.getTitle());

        TextView release = (TextView) listItem.findViewById(R.id.authorTextViewListItem);
        release.setText(currentGame.getName());

        return listItem;
    }
}
