package com.janelaaj.activitys;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.BackgroundColorSpan;
import android.text.style.TextAppearanceSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.component.CircleImageView;


public class FBLoginActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView headertitel, headersubtitle, connectTextView;
    private Button fbAccount, complFbRegistration;
    private CircleImageView logoImage;
    View loginfbLayout, complFbRegiLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fblogin);
        iniView();

    }


    public void iniView() {
        this.headertitel = this.findViewById(R.id.headertitel);
        this.headersubtitle = this.findViewById(R.id.headersubtitle);
        this.logoImage = this.findViewById(R.id.logoImage);
        this.loginfbLayout = this.findViewById(R.id.loginfbLayout);
        this.connectTextView = this.findViewById(R.id.connectTextView);
        this.fbAccount = this.findViewById(R.id.fbAccount);
        this.complFbRegistration = this.findViewById(R.id.complFbRegistration);
        this.complFbRegiLayout = this.findViewById(R.id.complFbRegiLayout);

        String string = "Conneting To your Facebook Account";
        Spannable spannable = new SpannableString(string);
        ColorStateList blueColor = new ColorStateList(new int[][]{new int[]{}}, new int[]{Color.BLUE});
        TextAppearanceSpan textAppearanceSpan = new TextAppearanceSpan(null, Typeface.BOLD, -1, blueColor, null);
        BackgroundColorSpan backgroundColorSpan = new BackgroundColorSpan(Color.WHITE);
        spannable.setSpan(textAppearanceSpan, 18, 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannable.setSpan(backgroundColorSpan, 18, 27, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        connectTextView.setText(spannable);

       // this.fbAccount.setOnClickListener(this);
        this.complFbRegistration.setOnClickListener(this);
        //this.complFbRegiLayout.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.fbAccount) {

        } else if (v.getId() == R.id.complFbRegistration) {
            Intent intent = new Intent(FBLoginActivity.this, SelectTYpeActivity.class);
            //  intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }


    }
}
