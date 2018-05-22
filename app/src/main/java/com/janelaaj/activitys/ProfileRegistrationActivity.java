package com.janelaaj.activitys;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.janelaaj.R;
import com.janelaaj.component.CircleImageView;

public class ProfileRegistrationActivity extends AppCompatActivity {

    private TextView headertitel, headersubtitle, codeTextView;
    private CircleImageView profileimage;
    LinearLayout pagerIndicator;
    Spinner typeSpinneer;


    private ViewPager viewPager;
    private MyViewPagerAdapter myViewPagerAdapter;
    private ImageView[] dots;
    private int[] layouts;
    private Button btnNext;
    ImageView nexticon;
    private LinearLayout signupLayout, nextLayout;
Button btn_signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_viewpager);
        viewPager = this.findViewById(R.id.view_pager);
        pagerIndicator = this.findViewById(R.id.viewPagerCountDots);
        profileimage = this.findViewById(R.id.profileimage);
        nexticon = this.findViewById(R.id.nexticon);
        btnNext = this.findViewById(R.id.btn_next);
        signupLayout = this.findViewById(R.id.signupLayout);
        nextLayout = this.findViewById(R.id.nextLayout);
        btn_signup = this.findViewById(R.id.btn_signup);
        layouts = new int[]{
                R.layout.registrationfirst_page,
                R.layout.registration_second_page,
        };

        changeStatusBarColor();

        myViewPagerAdapter = new MyViewPagerAdapter();
        viewPager.setAdapter(myViewPagerAdapter);
        viewPager.addOnPageChangeListener(viewPagerPageChangeListener);
        setUiPageViewController();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int current = getItem(+1);
                if (current < layouts.length) {
                    viewPager.setCurrentItem(current);
                    if (current == myViewPagerAdapter.getCount() - 1) {
                        //btnNext.setText("Register");
                        signupLayout.setVisibility(View.VISIBLE);
                        nextLayout.setVisibility(View.GONE);
                        // nexticon.setVisibility(View.GONE);
                        profileimage.setVisibility(View.GONE);
                    } else {
                        signupLayout.setVisibility(View.GONE);
                        nextLayout.setVisibility(View.VISIBLE);
                        //btnNext.setText("Next");
                        // nexticon.setVisibility(View.VISIBLE);
                        profileimage.setVisibility(View.VISIBLE);
                    }

                } else {

                }

            }
        });

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileRegistrationActivity.this, SelectOptionScreen.class);
                startActivity(intent);
            }
        });

    }


    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    ViewPager.OnPageChangeListener viewPagerPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int position) {
            if (dotsCount <= 1 || position > dots.length) {
                return;
            }
            for (int i = 0; i < dotsCount; i++) {
                dots[i].setImageResource(R.drawable.nonselected_dot);
            }
            dots[position].setImageResource(R.drawable.selected_dot);
            if (position == myViewPagerAdapter.getCount() - 1) {
                btnNext.setText("Register");
                nexticon.setVisibility(View.GONE);
                profileimage.setVisibility(View.GONE);
            } else {
                btnNext.setText("Next");
                nexticon.setVisibility(View.VISIBLE);
                profileimage.setVisibility(View.VISIBLE);
            }

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }
    };

    private int dotsCount;

    private void setUiPageViewController() {
        pagerIndicator.removeAllViews();
        dotsCount = myViewPagerAdapter.getCount();
        if (dotsCount <= 1) {
            pagerIndicator.setVisibility(View.INVISIBLE);
            return;
        }

        dots = new ImageView[dotsCount];
        for (int i = 0; i < dotsCount; i++) {
            dots[i] = new ImageView(this);
            dots[i].setImageResource(R.drawable.nonselected_dot);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(6, 0, 6, 0);
            pagerIndicator.addView(dots[i], params);
        }
        dots[0].setImageResource(R.drawable.selected_dot);
    }


    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


    /**
     * View pager adapter
     */
    public class MyViewPagerAdapter extends PagerAdapter {
        private LayoutInflater layoutInflater;
        public MyViewPagerAdapter() {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            layoutInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(layouts[position], container, false);
            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return layouts.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }


        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View view = (View) object;
            container.removeView(view);
        }
    }

}
