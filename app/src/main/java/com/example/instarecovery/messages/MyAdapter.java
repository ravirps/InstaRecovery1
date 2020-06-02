package com.example.instarecovery.messages;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.example.instarecovery.MainActivity;
import com.example.instarecovery.R;

import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Conversation> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView sendertext;
        public TextView urtext;
        public MyViewHolder(View v) {
            super(v);
            sendertext = v.findViewById(R.id.sendrtext);
            urtext=v.findViewById(R.id.urtext);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Conversation> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.sendermessage, parent, false);

        // Return a new holder instance
         MyViewHolder viewHolder = new  MyViewHolder(contactView);
        return  viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        String content=mDataset.get(position).getText()+mDataset.get(position).getMedia_share_url();
       if(mDataset.get(position).getSender().equals(MainActivity.username))
       {
           holder.sendertext.setVisibility(View.INVISIBLE);
           holder.urtext.setText(content);
           holder.urtext.setVisibility(View.VISIBLE);
       }
       else
       {
           holder.urtext.setVisibility(View.INVISIBLE);
           holder.sendertext.setText(content);
           holder.sendertext.setVisibility(View.VISIBLE);
       }

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}