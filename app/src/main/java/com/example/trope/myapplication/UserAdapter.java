package com.example.trope.myapplication;

import android.icu.text.SimpleDateFormat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Date;
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
        User tmpuser = list.get(i);
        holder.name.setText(tmpuser.getName());
        long diffInSeconds = (new Date().getTime() - tmpuser.getBirthday().getTime()) / 1000;
        long years =  diffInSeconds/(604800*52);
        String formattedDate = new SimpleDateFormat("dd/MM/yyyy").format(tmpuser.getBirthday());
        holder.date.setText(formattedDate + " - " + Long.toString(years )+ " Year" + (years>=1?"s":""));
    }
    @Override
    public int getItemCount(){
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public TextView date;

        public ViewHolder(View itemView){
            super(itemView);
            name = itemView.findViewById(R.id.birthdayName);
            date = itemView.findViewById(R.id.birthdayDate);
        }
    }
}
