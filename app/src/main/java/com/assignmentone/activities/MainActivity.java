package com.assignmentone.activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.assignmentone.R;
import com.assignmentone.adapter.SectionsPagerAdapter;
import com.assignmentone.interfaces.PagerClickListener;
import com.viewpagerindicator.CirclePageIndicator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements PagerClickListener {

    @BindView(R.id.container)
    ViewPager mViewPager;

    @BindView(R.id.titles)
    CirclePageIndicator circleIndicator;

    @BindView(R.id.tabs)
    TabLayout tabLayout;

    @BindView(R.id.tv_tab_click)
    TextView tvTabClick;

    @BindView(R.id.btn_blue)
    Button btnBlue;
    @BindView(R.id.btn_red)
    Button btnRed;
    @BindView(R.id.btn_green)
    Button btnGreen;

    @BindView(R.id.layout_button)
    LinearLayout layoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        createViewPager();
        setCircleIndicator();
        createTabs();
    }

    //setup tabs
    private void createTabs() {
        tabLayout.addOnTabSelectedListener(new TabSelectedListener());
        tvTabClick.setText(tabLayout.getTabAt(tabLayout.getSelectedTabPosition()).getText());
    }

    private void createViewPager() {
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // Set up the ViewPager with the sections adapter.
        mViewPager.setAdapter(mSectionsPagerAdapter);
    }

    //set circle indicator for view pager
    private void setCircleIndicator() {
        circleIndicator.setViewPager(mViewPager);
        final float density = getResources().getDisplayMetrics().density;
        circleIndicator.setFillColor(R.color.selected_dot);
        circleIndicator.setStrokeColor(R.color.unselected_dot);
        circleIndicator.setStrokeWidth(1);
        circleIndicator.setRadius(5 * density);
    }

    @Override
    public void onPageClickListener(int position) {
        //show toast which displays fragment no of clicked fragment
        Toast.makeText(MainActivity.this, String.format(getString(R.string.fragment),position), Toast.LENGTH_SHORT).show();
    }

    private class TabSelectedListener implements TabLayout.OnTabSelectedListener {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            tvTabClick.setText(tab.getText().toString());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

    @OnClick(R.id.btn_blue)
    public void onBlueButtonClick() {
        layoutButton.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
    }

    @OnClick(R.id.btn_red)
    public void onRedButtonClick() {
        layoutButton.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
    }

    @OnClick(R.id.btn_green)
    public void onGreenButtonClick() {
        layoutButton.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
    }
}
