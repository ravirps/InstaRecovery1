package com.example.instarecovery.messages;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.LayoutDirection;
import android.util.Log;
import android.widget.ListView;

import com.example.instarecovery.MainActivity;
import com.example.instarecovery.R;

import java.util.List;

public class listofmessages extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listofmessages);
        Intent intent = getIntent();
        int position=intent.getIntExtra("position",0);
        recyclerView =  findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        MyAdapter mAdapter = new MyAdapter(chats.messagesList.get(position).getConversation());
        recyclerView.setAdapter(mAdapter);

    }
}
