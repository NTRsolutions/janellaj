package com.janelaaj.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.component.CircleImageView;


public class SelectTYpeActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView headertitel, headersubtitle, codeTextView;
    private CircleImageView logoImage;
    View otpsendLayout;
    Spinner typeSpinneer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecttype);
        iniView();

    }


    public void iniView() {
        this.headertitel = this.findViewById(R.id.headertitel);
        this.headersubtitle = this.findViewById(R.id.headersubtitle);
        this.logoImage = this.findViewById(R.id.logoImage);
        this.typeSpinneer = this.findViewById(R.id.typeSpinneer);
        this.settypeSpinneerValue();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.otpsendLayout) {

        }


    }

    private void settypeSpinneerValue() {
        final String postal_address_array[] = {"I am...","I am Docter", "We're Pharmacy", "We'r Daignostic Lab"};
        ArrayAdapter<String> postalAdapter = new ArrayAdapter<String>(this, R.layout.spinner_row, postal_address_array);
        typeSpinneer.setAdapter(postalAdapter);
        typeSpinneer.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String str = postal_address_array[position];
                if (str.equals("I am Docter")) {
                    Intent intent = new Intent(SelectTYpeActivity.this, ProfileRegistrationActivity.class);
                    startActivity(intent);
                } else if (str.equals("We're Pharmacy")) {
                    Intent intent = new Intent(SelectTYpeActivity.this, ProfileRegistrationActivity.class);
                    startActivity(intent);
                } else if (str.equals("We'r Daignostic Lab")) {
                    Intent intent = new Intent(SelectTYpeActivity.this, ProfileRegistrationActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {
        }

        public void onNothingSelected(AdapterView parent) {
        }
    }
}
