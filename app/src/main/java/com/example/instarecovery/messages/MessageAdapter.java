package com.example.instarecovery.messages;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.instarecovery.MainActivity;
import com.example.instarecovery.R;

import java.util.ArrayList;
import java.util.List;
import java.util.MissingFormatArgumentException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MessageAdapter extends ArrayAdapter {
    private Context mContext;
    private List<messages> messageList = new ArrayList<>();

    public MessageAdapter(@NonNull Context context, List<messages> resource) {
        super(context,0,resource);
        mContext = context;
        messageList = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if(listItem == null) {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.convolist, parent, false);
        }

        messages chat = messageList.get(position);

        TextView name = (TextView) listItem.findViewById(R.id.convoname);
        String sender= "Unknown";
        if(chat.getParticipants().get(0).equals(MainActivity.username))
        {
            sender=chat.getParticipants().get(1);
        }
        else sender=chat.getParticipants().get(0);
        name.setText(sender.contains("__deleted__bhieb")?"User Account Deleted ":sender );
        return listItem;
    }
}
