package com.example.instarecovery.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.instarecovery.MainActivity;
import com.example.instarecovery.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ChatAdapter extends ArrayAdapter {
    private Context mContext;
    private  List<Conversation> convolist;


    public ChatAdapter(@NonNull Context context, List<Conversation> resource) {
        super(context,0, (List) resource);
        mContext = context;
        convolist = resource;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        Conversation chat = convolist.get(position);
        if(chat.getSender().equals(MainActivity.username))
        {
            if(listItem == null) {
                listItem = LayoutInflater.from(mContext).inflate(R.layout.urmessage, parent, false);
            }
            TextView message = (TextView) listItem.findViewById(R.id.urtext);
            String content=chat.getText()+chat.getMedia_share_url();
            message.setText(content);
            return listItem;

        }
        else
        {
            if(listItem == null) {
                listItem = LayoutInflater.from(mContext).inflate(R.layout.sendermessage, parent, false);
            }
            TextView message = (TextView) listItem.findViewById(R.id.sendrtext);
            String content=chat.getText()+chat.getMedia_share_url();
            message.setText(content);
            return listItem;
        }

    }
}
