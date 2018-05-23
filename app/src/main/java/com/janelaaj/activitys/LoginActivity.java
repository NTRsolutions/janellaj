package com.janelaaj.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.component.CircleImageView;


public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView headertitel, headersubtitle, problemSiging, singnUp;
    private EditText emailIdView, passwordView;
    private Button loginButton;
    LinearLayout facebookButton, googleButton;
    private CircleImageView logoImage;
    View loginLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniView();

    }


    public void iniView() {
        this.headertitel = this.findViewById(R.id.headertitel);
        this.headersubtitle = this.findViewById(R.id.headersubtitle);
        this.problemSiging = this.findViewById(R.id.problemSiging);
        this.singnUp = this.findViewById(R.id.singnUp);
        this.emailIdView = this.findViewById(R.id.emailIdView);
        this.passwordView = this.findViewById(R.id.passwordView);
        this.loginButton = this.findViewById(R.id.loginButton);
        this.facebookButton = this.findViewById(R.id.facebookButton);
        this.googleButton = this.findViewById(R.id.googleButton);
        this.logoImage = this.findViewById(R.id.logoImage);
        this.loginLayout = this.findViewById(R.id.loginLayout);

        this.problemSiging.setOnClickListener(this);
        this.singnUp.setOnClickListener(this);
        this.emailIdView.setOnClickListener(this);
        this.passwordView.setOnClickListener(this);
        this.loginButton.setOnClickListener(this);
        this.facebookButton.setOnClickListener(this);
        this.googleButton.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.facebookButton) {
            openfbLoginActivity();
        } else if (v.getId() == R.id.googleButton) {
            openGoogleLoginActivity();
        }else if (v.getId() == R.id.loginButton) {
            Intent intent = new Intent(LoginActivity.this, SendOTPActivity.class);
            //  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        } else if (v.getId() == R.id.singnUp) {
            Intent intent = new Intent(LoginActivity.this, SelectTYpeActivity.class);
            startActivity(intent);
        }


    }

    public void openfbLoginActivity() {
        Intent intent = new Intent(LoginActivity.this, FBLoginActivity.class);
       // intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public void openGoogleLoginActivity() {
        Intent intent = new Intent(LoginActivity.this, GoogleLoginActivity.class);
      //  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
