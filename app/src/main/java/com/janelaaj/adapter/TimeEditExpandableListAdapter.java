package com.janelaaj.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.activitys.TimmingEditActivity;
import com.janelaaj.fragment.TimePickerFragment;

import java.util.HashMap;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class TimeEditExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles

    private HashMap<String, List<String>> _listDataChild;
    private int mYear, mMonth, mDay, mHour, mMinute;

    public TimeEditExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;
    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition)).get(childPosititon);
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.edittimelist_item, null);
        }

        CheckBox repeatCHeckBox = convertView.findViewById(R.id.repeatCHeckBox);
        final LinearLayout weekNameLayout = convertView.findViewById(R.id.weekNameLayout);
        Button from = convertView.findViewById(R.id.from);
        Button to = convertView.findViewById(R.id.to);
        final EditText frommin = convertView.findViewById(R.id.frommin);
        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = ((AppCompatActivity) _context).getSupportFragmentManager();
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(manager, "TimePicker");

            }
        });

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager manager = ((AppCompatActivity) _context).getSupportFragmentManager();
                DialogFragment newFragment = new TimePickerFragment();
                newFragment.show(manager, "TimePicker");

            }
        });


        repeatCHeckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (buttonView.isChecked()) {
                    weekNameLayout.setVisibility(View.VISIBLE);
                } else {
                    weekNameLayout.setVisibility(View.GONE);
                }

            }
        });


        //  txtListChild.setText(childText);
        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.edittimelist_group, null);
        }

        TextView lblListHeader = convertView.findViewById(R.id.lblListHeader);
        ImageView deleteButton = convertView.findViewById(R.id.deleteButton);
        if (isExpanded) {
            convertView.findViewById(R.id.expand).setVisibility(View.GONE);
            convertView.findViewById(R.id.collapse).setVisibility(View.VISIBLE);
            convertView.findViewById(R.id.listExpandLayout).setBackgroundResource(R.drawable.login_border);
            lblListHeader.setTextColor(Color.parseColor("#ffffff"));
            convertView.findViewById(R.id.timeFillLayout).setVisibility(View.VISIBLE);
            deleteButton.setBackgroundResource(R.drawable.ic_deletewhite);
            lblListHeader.setVisibility(View.GONE);
        } else {
            convertView.findViewById(R.id.expand).setVisibility(View.VISIBLE);
            convertView.findViewById(R.id.collapse).setVisibility(View.GONE);
            convertView.findViewById(R.id.listExpandLayout).setBackgroundColor(Color.parseColor("#C2C2C2"));
            lblListHeader.setTextColor(Color.parseColor("#808080"));
            convertView.findViewById(R.id.timeFillLayout).setVisibility(View.GONE);
            deleteButton.setBackgroundResource(R.drawable.ic_dustbin);
            lblListHeader.setVisibility(View.VISIBLE);

        }


        lblListHeader.setTypeface(null, Typeface.BOLD);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
