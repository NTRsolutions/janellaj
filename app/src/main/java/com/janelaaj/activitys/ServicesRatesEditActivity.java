package com.janelaaj.activitys;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.janelaaj.R;
import com.janelaaj.adapter.ServicesRateExpandableListAdapter;
import com.janelaaj.utilities.FontManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ServicesRatesEditActivity extends AppCompatActivity {

    ServicesRateExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    LinearLayout listGroupLayout,addserviceLayout;
    FloatingActionButton addlocation;
    Button btn_save;
    TextView rupeeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicesrateedit_screen);
        expListView = this.findViewById(R.id.listExpandble);
        listGroupLayout=this.findViewById(R.id.listGroupLayout);
        addserviceLayout=this.findViewById(R.id.addserviceLayout);
        listGroupLayout.setBackgroundResource(R.drawable.login_border);
        addlocation=this.findViewById(R.id.addlocation);
        btn_save=this.findViewById(R.id.btn_save);
        rupeeIcon=this.findViewById(R.id.rupeeIcon);
        Typeface fontawesome_font = FontManager.getFontTypefaceMaterialDesignIcons(ServicesRatesEditActivity.this, "fonts/fontawesome-webfont.ttf");
        rupeeIcon.setTypeface(fontawesome_font);
        rupeeIcon.setText(Html.fromHtml("&#xf156;"));
        prepareListData();
        listAdapter = new ServicesRateExpandableListAdapter(this, listDataHeader, listDataChild);
        expListView.setAdapter(listAdapter);
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Expanded", Toast.LENGTH_SHORT).show();
            }
        });

        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(), listDataHeader.get(groupPosition) + " Collapsed", Toast.LENGTH_SHORT).show();
            }
        });

        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                // TODO Auto-generated method stub
                Toast.makeText(
                        getApplicationContext(),
                        listDataHeader.get(groupPosition)
                                + " : "
                                + listDataChild.get(
                                listDataHeader.get(groupPosition)).get(
                                childPosition), Toast.LENGTH_SHORT)
                        .show();
                return false;
            }
        });

        addlocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addserviceLayout.setVisibility(View.VISIBLE);
            }
        });
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addserviceLayout.setVisibility(View.GONE);
            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Blood Preseure");
        listDataHeader.add("Consulation");
        listDataHeader.add("E.C.G");
        listDataHeader.add("Suger Check");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");


        listDataChild.put(listDataHeader.get(0), top250); // Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), nowShowing);
        listDataChild.put(listDataHeader.get(3), nowShowing);
    }
}
