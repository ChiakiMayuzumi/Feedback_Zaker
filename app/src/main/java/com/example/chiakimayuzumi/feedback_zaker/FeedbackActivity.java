package com.example.chiakimayuzumi.feedback_zaker;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.PagerTitleStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;


import java.util.ArrayList;

/**
 * Created by chiakimayuzumi on 16/5/13.
 */
public class FeedbackActivity extends FragmentActivity {

  private ViewPager m_vp;
  private TabLayout mTabLayout;
  private CommonQuestionFragment mfragment1;
  private CommitFeedbackFragment mfragment2;
  private CommitFeedbackWithImageFragment mfragment3;
  //页面列表
  private ArrayList<Fragment> fragmentList;
  //标题列表
  ArrayList<String>   titleList    = new ArrayList<String>();

  private PagerTitleStrip pagerTitleStrip;
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_feedback);

    mTabLayout = (TabLayout) findViewById(R.id.tab_FindFragment_title);
    m_vp = (ViewPager)findViewById(R.id.vp_FindFragment_pager);

    mfragment1 = new CommonQuestionFragment();
    mfragment2 = new CommitFeedbackFragment();
    mfragment3 = new CommitFeedbackWithImageFragment();

    fragmentList = new ArrayList<Fragment>();
    fragmentList.add(mfragment1);
    fragmentList.add(mfragment3);

    titleList.add("常见问题");
    titleList.add("提交反馈");

    m_vp.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
    m_vp.setCurrentItem(1);
    mTabLayout.setupWithViewPager(m_vp);
  }

  public class MyViewPagerAdapter extends FragmentPagerAdapter {
    public MyViewPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int arg0) {
      return fragmentList.get(arg0);
    }

    @Override
    public int getCount() {
      return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return titleList.get(position);
    }


  }




}
