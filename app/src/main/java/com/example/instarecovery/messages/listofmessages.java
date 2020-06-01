package com.example.instarecovery.messages;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.instarecovery.R;

import java.util.List;

public class listofmessages extends AppCompatActivity {
    ListView listView;
    ChatAdapter chatAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofmessages);
        Intent intent = getIntent();
        int position=intent.getIntExtra("position",-99);
        listView=findViewById(R.id.listoftext);
        chatAdapter=new ChatAdapter(this, (List<Conversation>) chats.messagesList.get(position).getConversation());
        listView.setAdapter(chatAdapter);

    }
}
