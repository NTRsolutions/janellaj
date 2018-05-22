package com.janelaaj.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.janelaaj.R;
import com.janelaaj.component.CircleImageView;


public class UploadDocumentActivity extends AppCompatActivity implements View.OnClickListener {

    private CircleImageView logoImage;
    private Button edit, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_document);
        iniView();

    }


    public void iniView() {
        this.exit = findViewById(R.id.exit);
        exit.setOnClickListener(this);
        this.edit = findViewById(R.id.edit);
        edit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.exit) {
            Intent intent = new Intent(UploadDocumentActivity.this, WelcomeRegistrationActivity.class);
            startActivity(intent);
        } else if (v.getId() == R.id.edit) {
            Intent intent = new Intent(UploadDocumentActivity.this, WelcomeRegistrationActivity.class);
            startActivity(intent);
        }

    }
}
