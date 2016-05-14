package com.example.chiakimayuzumi.feedback_zaker;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chiakimayuzumi on 16/5/13.
 */
public class CommitFeedbackFragment extends Fragment {
  private View mMainView;
  @Override
  public void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);

    LayoutInflater inflater = getActivity().getLayoutInflater();
    mMainView = inflater.inflate(R.layout.fragment_feedback_commit, (ViewGroup)getActivity().findViewById(R.id.vp_FindFragment_pager), false);


  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

    ViewGroup p = (ViewGroup) mMainView.getParent();
    if (p != null) {
      p.removeAllViewsInLayout();
    }

    return mMainView;
  }



}
