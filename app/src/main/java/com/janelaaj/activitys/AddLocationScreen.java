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
public class AddLocationScreen extends AppCompatActivity implements View.OnClickListener {

    private TextView headertitel, headersubtitle, codeTextView;
    private CircleImageView logoImage;
    View otpsendLayout;
    Spinner selectOptionSpinneer, stateSpinneer;
    private Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addlocation_screen);
        iniView();

    }


    public void iniView() {
        this.headertitel = this.findViewById(R.id.headertitel);
        this.headersubtitle = this.findViewById(R.id.headersubtitle);
        this.logoImage = this.findViewById(R.id.logoImage);
        this.selectOptionSpinneer = this.findViewById(R.id.selectOptionSpinneer);

        this.stateSpinneer = this.findViewById(R.id.stateSpinneer);
        this.btn_next = this.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        this.settypeSpinneerValue();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_next) {
            Intent intent = new Intent(AddLocationScreen.this, ManageLocationActivity.class);
            startActivity(intent);
        }
    }


    private void settypeSpinneerValue() {
        String postal_address_array[] = {"I am Docter", "We're Pharmacy", "We'r Daignostic Lab"};
        String state_address_array[] = {"Andaman and Nicobar", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar"};
        ArrayAdapter<String> postalAdapter = new ArrayAdapter<String>(this, R.layout.spinner_row, postal_address_array);
        selectOptionSpinneer.setAdapter(postalAdapter);
        selectOptionSpinneer.setOnItemSelectedListener(new MyOnItemSelectedListener());

        ArrayAdapter<String> StateAdapter = new ArrayAdapter<String>(this, R.layout.spinner_row, state_address_array);
        stateSpinneer.setAdapter(StateAdapter);
        stateSpinneer.setOnItemSelectedListener(new MyOnItemSelectedListener());


    }

    public class MyOnItemSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> parent,
                                   View view, int pos, long id) {
        }

        public void onNothingSelected(AdapterView parent) {
        }
    }
}
