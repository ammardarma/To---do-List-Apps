package com.ammar.finpro1todolist;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomTaskList extends BaseAdapter {
    private Activity context;
    ArrayList<Task> tasks;
    SQLiteDatabaseHandler db;
    BaseAdapter ba;

    public CustomTaskList(Activity context, ArrayList<Task> tasks, SQLiteDatabaseHandler db) {
        this.context = context;
        this.tasks = tasks;
        this.db = db;
    }

    public static class ViewHolder {
        TextView textId;
        Button deleteButton;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        ViewHolder vh;
        if(convertView == null) {
            vh = new ViewHolder();
            row = inflater.inflate(R.layout.list_item, null, true);
            vh.textId = (TextView) row.findViewById(R.id.text);
            vh.deleteButton = (Button) row.findViewById(R.id.delete);

            row.setTag(vh);
        }else {
            vh = (ViewHolder) convertView.getTag();
        }

        vh.textId.setText(tasks.get(position).getTask());
        final int positionPopup = position;

        vh.deleteButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Log.d("Last Index", "" + positionPopup);
                db.deleteTask(tasks.get(positionPopup));

                tasks = (ArrayList) db.getAllTask();
                Log.d("Country Size", "" + tasks.size());
                notifyDataSetChanged();
            }
        });
        return row;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


}
