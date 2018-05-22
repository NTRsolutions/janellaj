package com.janelaaj.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.component.CircleImageView;


public class VarifyOTPActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView headertitel, headersubtitle, otpsendTextView;
    private Button submitOTP, resendNo, chnageNo;
    private EditText passcodeCharOne, passcodeCharTwo, passcodeCharThree, passcodeCharFour;
    private CircleImageView logoImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_varifyotp);
        iniView();

    }


    public void iniView() {
        this.headertitel = this.findViewById(R.id.headertitel);
        this.headersubtitle = this.findViewById(R.id.headersubtitle);
        this.logoImage = this.findViewById(R.id.logoImage);
        this.otpsendTextView = this.findViewById(R.id.otpsendTextView);
        this.passcodeCharOne = this.findViewById(R.id.passcodeCharOne);
        this.passcodeCharTwo = this.findViewById(R.id.passcodeCharTwo);
        this.passcodeCharThree = this.findViewById(R.id.passcodeCharThree);
        this.passcodeCharFour = this.findViewById(R.id.passcodeCharFour);

        this.submitOTP = this.findViewById(R.id.submitOTP);
        this.resendNo = this.findViewById(R.id.resendNo);
        this.chnageNo = this.findViewById(R.id.chnageNo);


        this.submitOTP.setOnClickListener(this);
        this.resendNo.setOnClickListener(this);
        this.chnageNo.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.submitOTP) {
            Intent intent = new Intent(VarifyOTPActivity.this, SelectOptionScreen.class);
            startActivity(intent);
        } else if (v.getId() == R.id.resendNo) {

        } else if (v.getId() == R.id.chnageNo) {
            finish();
        }

    }
}
