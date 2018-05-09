package com.example.trope.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    protected List<User> list;
    public UserAdapter(List<User> list){
        this.list = list;
    }
    @Override
    public UserAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.users_room,null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(UserAdapter.ViewHolder holder, int i){
        holder.name.setText(list.get(i).getName());
    }
    @Override
    public int getItemCount(){
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;

        public ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.birthdayName);
        }
    }
}
