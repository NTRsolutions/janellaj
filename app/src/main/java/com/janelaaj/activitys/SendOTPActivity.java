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


public class SendOTPActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView headertitel, headersubtitle, codeTextView;
    private Button otpSendButton;
    private CircleImageView logoImage;
    private EditText mobileNoedittextView;
    View otpsendLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendotp);
        iniView();

    }


    public void iniView() {
        this.headertitel = this.findViewById(R.id.headertitel);
        this.headersubtitle = this.findViewById(R.id.headersubtitle);
        this.logoImage = this.findViewById(R.id.logoImage);
        this.codeTextView = this.findViewById(R.id.codeTextView);
        this.mobileNoedittextView = this.findViewById(R.id.mobileNoedittextView);
        this.otpSendButton = this.findViewById(R.id.otpSendButton);
        this.otpsendLayout = this.findViewById(R.id.otpsendLayout);
        this.otpSendButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.otpSendButton) {
            Intent intent = new Intent(SendOTPActivity.this, VarifyOTPActivity.class);
            //  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


    }
}
