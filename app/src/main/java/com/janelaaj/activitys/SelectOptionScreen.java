package com.janelaaj.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.component.CircleImageView;

/**
 * Created On 18-05-2018
 *
 * @author Altametrics Inc.
 */
public class SelectOptionScreen extends AppCompatActivity implements View.OnClickListener {

    private TextView headertitel, headersubtitle, codeTextView;
    private CircleImageView logoImage;
    View otpsendLayout;
    Spinner selectOptionSpinneer;
    Button btn_addthislocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectotion_screen);
        iniView();

    }


    public void iniView() {
        this.headertitel = this.findViewById(R.id.headertitel);
        this.headersubtitle = this.findViewById(R.id.headersubtitle);
        this.logoImage = this.findViewById(R.id.logoImage);
        this.selectOptionSpinneer = this.findViewById(R.id.selectOptionSpinneer);
        this.settypeSpinneerValue();
        btn_addthislocation = this.findViewById(R.id.btn_addthislocation);
        btn_addthislocation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_addthislocation) {
            Intent intent = new Intent(SelectOptionScreen.this, AddLocationScreen.class);
            startActivity(intent);
        }


    }

    private void settypeSpinneerValue() {
        String postal_address_array[] = {"Sector 1", "Sector 2", "Sector 3"};
        ArrayAdapter<String> postalAdapter = new ArrayAdapter<String>(this, R.layout.spinner_row, postal_address_array);
        selectOptionSpinneer.setAdapter(postalAdapter);
        selectOptionSpinneer.setOnItemSelectedListener(new MyOnItemSelectedListener());


    }

    public class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {
        }

        public void onNothingSelected(AdapterView parent) {
        }
    }
}
