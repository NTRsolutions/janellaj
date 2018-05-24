package com.janelaaj.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.activitys.ManageDiscountEditActivity;
import com.janelaaj.activitys.ServicesRatesEditActivity;
import com.janelaaj.activitys.TimmingEditActivity;
import com.janelaaj.utilities.Utility;

import java.util.HashMap;
import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles

    private HashMap<String, List<String>> _listDataChild;
    private LinearLayout timming, services, managediscount, editlocation;

    public ExpandableListAdapter(Context context, List<String> listDataHeader, HashMap<String, List<String>> listChildData) {
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
            convertView = infalInflater.inflate(R.layout.list_item, null);
        }
        this.timming = convertView.findViewById(R.id.timming);
        this.services = convertView.findViewById(R.id.services);
        this.managediscount = convertView.findViewById(R.id.managediscount);
        this.editlocation = convertView.findViewById(R.id.editlocation);

        timming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTimmingEditActivity(_context);
            }
        });

        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openServicesRatesEditActivity(_context);
            }
        });
        managediscount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openManageDiscountEditActivity(_context);
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
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }

        TextView lblListHeader = convertView.findViewById(R.id.lblListHeader);
        if (isExpanded) {
            convertView.findViewById(R.id.expand).setVisibility(View.GONE);
            convertView.findViewById(R.id.collapse).setVisibility(View.VISIBLE);
            convertView.findViewById(R.id.listGroupLayout).setBackgroundResource(R.drawable.login_border);
            lblListHeader.setTextColor(Color.parseColor("#ffffff"));
            convertView.findViewById(R.id.viewSpace).setVisibility(View.GONE);
        } else {
            convertView.findViewById(R.id.expand).setVisibility(View.VISIBLE);
            convertView.findViewById(R.id.collapse).setVisibility(View.GONE);
            convertView.findViewById(R.id.listGroupLayout).setBackgroundColor(Color.parseColor("#a3a3a3"));
            lblListHeader.setTextColor(Color.parseColor("#808080"));
            convertView.findViewById(R.id.viewSpace).setVisibility(View.INVISIBLE);

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


    public void openTimmingEditActivity(Context context) {
        Intent myactivity = new Intent(context.getApplicationContext(), TimmingEditActivity.class);
        myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(myactivity);

    }
    public void openServicesRatesEditActivity(Context context) {
        Intent myactivity = new Intent(context.getApplicationContext(), ServicesRatesEditActivity.class);
        myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(myactivity);

    }

    public void openManageDiscountEditActivity(Context context) {
        Intent myactivity = new Intent(context.getApplicationContext(), ManageDiscountEditActivity.class);
        myactivity.addFlags(FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(myactivity);

    }
}
