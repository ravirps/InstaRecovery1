package com.example.instarecovery.messages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.instarecovery.MainActivity;
import com.example.instarecovery.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class chats extends AppCompatActivity {
    public static List<messages> messagesList;
    private ListView listView;
    private MessageAdapter messageAdapter;
    public void setUsername() {
        if (messagesList.size() < 2) {
            MainActivity.username = messagesList.get(0).getParticipants().get(0);
        } else {
            if (messagesList.get(0).getParticipants().get(0) == messagesList.get(1).getParticipants().get(0) ||
                    messagesList.get(0).getParticipants().get(0) == messagesList.get(1).getParticipants().get(1)) {
                MainActivity.username = messagesList.get(0).getParticipants().get(0);
            } else {
                MainActivity.username = messagesList.get(0).getParticipants().get(1);
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chats);
        listView=findViewById(R.id.listview);
        Gson gson=new Gson();
        Type listType = new TypeToken<List<messages>>(){}.getType();
        messagesList = gson.fromJson(MainActivity.messagedata, listType);
        if(messagesList!=null)setUsername();
        messageAdapter=new MessageAdapter(this,messagesList);
        listView.setAdapter(messageAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(chats.this,listofmessages.class);
                intent.putExtra("position",i);
                startActivity(intent);
            }
        });
    }
}
