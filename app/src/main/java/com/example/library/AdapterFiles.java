package com.example.library;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AdapterFiles extends RecyclerView.Adapter<AdapterFiles.ViewHolder>{

    RecyclerView recyclerView;
    Context context;
    ArrayList<String>items=new ArrayList<>();
    ArrayList<String>urls=new ArrayList<>();

    public void update(String name,String url)
    {
        items.add(name);
        urls.add(url);
        notifyDataSetChanged();
    }

    public AdapterFiles(RecyclerView recyclerView, Context context, ArrayList<String> items,ArrayList<String>urls) {
        this.recyclerView = recyclerView;
        this.context = context;
        this.items = items;
        this.urls=urls;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
       View view= LayoutInflater.from(context).inflate(R.layout.item_files,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        viewHolder.nameOfFile.setText(items.get(i));

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void update(List<String> newList)
    {
        items=new ArrayList<>();
        urls=new ArrayList<>();
        items.addAll(newList);
        notifyDataSetChanged();
    }

   public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView nameOfFile;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameOfFile=itemView.findViewById(R.id.nameOfFile);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position=recyclerView.getChildLayoutPosition(v);
                    Intent intent=new Intent();
//                    intent.setType(Intent.ACTION_VIEW);
//                    intent.setData(Uri.parse(urls.get(position)));
                    intent.setDataAndType(Uri.parse((urls).get(position)),Intent.ACTION_VIEW);

                    context.startActivity(intent);

                }
            });
        }
    }
}
