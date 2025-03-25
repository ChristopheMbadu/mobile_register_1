package com.example.myapplicationteccart;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplicationteccart.DashboardActivity;

import java.util.List;

public class CourseAdapter extends ArrayAdapter<String> {

    private Context context;
    private List<String> courses;

    public CourseAdapter(Context context, List<String> courses) {
        super(context, 0, courses);
        this.context = context;
        this.courses = courses;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_course, parent, false);
        }

        String course = courses.get(position);
        TextView textView = convertView.findViewById(R.id.item_text);
        textView.setText(course);

        ImageView trashIcon = convertView.findViewById(R.id.trash_icon);
        trashIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((DashboardActivity) context).onDeleteItemClick(position);
            }
        });

        return convertView;
    }
}
