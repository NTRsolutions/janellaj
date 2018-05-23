package com.janelaaj.activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.component.CircleImageView;
import com.janelaaj.utilities.Utility;

import static com.janelaaj.utilities.Utility.getTextFromView;
import static com.janelaaj.utilities.Utility.isEmptyStr;
import static com.janelaaj.utilities.Utility.isNonEmptyStr;


public class VarifyOTPActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView headertitel, headersubtitle, otpsendTextView;
    private Button submitOTP, resendNo, chnageNo;
    private EditText passcodeCharOne, passcodeCharTwo, passcodeCharThree, passcodeCharFour;



    View.OnKeyListener onKeyListener = new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (keyCode == KeyEvent.KEYCODE_DEL) {
                if (Utility.isEmptyView(v)) {
                    View prevFocusView = findViewById(getCurrentFocus().getNextFocusLeftId());
                    if (prevFocusView != null) {
                        prevFocusView.requestFocus();
                    }
                }
            }
            return false;
        }
    };
    TextWatcher passcodeTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            submitOTP.setEnabled(isNonEmptyStr(getPassword()));
            if (getCurrentFocus() == null) {
                return;
            }
            View nextFocusView = findViewById(getCurrentFocus().getNextFocusRightId());
            View prevFocusView = findViewById(getCurrentFocus().getNextFocusLeftId());
            if (isNonEmptyStr(s.toString()) && nextFocusView != null) {
                nextFocusView.requestFocus();
            } else if (isEmptyStr(s.toString()) && prevFocusView != null) {
                prevFocusView.requestFocus();
            }
        }
    };
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

        passcodeCharOne.addTextChangedListener(passcodeTextWatcher);
        passcodeCharTwo.addTextChangedListener(passcodeTextWatcher);
        passcodeCharThree.addTextChangedListener(passcodeTextWatcher);
        passcodeCharFour.addTextChangedListener(passcodeTextWatcher);

        passcodeCharOne.setOnKeyListener(onKeyListener);
        passcodeCharTwo.setOnKeyListener(onKeyListener);
        passcodeCharThree.setOnKeyListener(onKeyListener);
        passcodeCharFour.setOnKeyListener(onKeyListener);


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

    private String getPassword() {
        return getTextFromView(passcodeCharOne) + getTextFromView(passcodeCharTwo) +
                getTextFromView(passcodeCharThree) + getTextFromView(passcodeCharFour);
    }
}
