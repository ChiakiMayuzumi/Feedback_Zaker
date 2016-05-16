package com.example.chiakimayuzumi.feedback_zaker;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chiakimayuzumi on 16/5/13.
 */
public class CommonQuestionFragment extends Fragment {
  private View mMainView;
  private ExpandableListView mExpandableListView;

  //定义容器和适配器
  private List<String> group_list;

  private List<String> item_lt;//item里面的文字

  private List<List<String>> item_list;//装所有item里面的文字

  private List<Integer> item_img;//item里面的图片

  private List<List<Integer>> item_list2;//装所有item里面的图像

  private List<Integer> gr_list;//组的箭头图标

  private List<List<Integer>> gr_list2; //装所有组的箭头图标

  private MyExpandableListViewAdapter adapter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    LayoutInflater inflater = getActivity().getLayoutInflater();
    mMainView = inflater.inflate(R.layout.fragment_feedback_commonquestion, (ViewGroup)getActivity().findViewById(R.id.vp_FindFragment_pager), false);

    initData();

    adapter = new MyExpandableListViewAdapter(getContext());
    mExpandableListView = (ExpandableListView) mMainView.findViewById(R.id.list);
    mExpandableListView.setGroupIndicator(null);
    mExpandableListView.setAdapter(adapter);

    mExpandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
      @Override
      public void onGroupExpand(int i) {

        //这里写怎么改变箭头方向，待续

      }
    });



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

  private void initData(){

    //设置一下数据

    group_list = new ArrayList<String>();
    group_list.add("可以调整正文字体的大小吗？");
    group_list.add("为什么找不到本地资讯了？");
    group_list.add("错过了推送，要去哪里看？");
    group_list.add("推送消息太多，要怎么关闭一些？");
    group_list.add("在哪里可以看到和下载到Zaker的封面？");
    group_list.add("如何收藏文章？");
    group_list.add("有些不雅评论要如何举报呢？");
    group_list.add("为什么有些页面，底部会有一个横幅广告，能去掉吗？");
    group_list.add("为什么有Zaker帐号登录入口，却没有地方可以注册Zaker帐号？");
    group_list.add("为什么使用新浪微博授权过后无法成功登录？");
    group_list.add("为什么有些页面，底部会有一个横幅广告，能去掉吗？");

    item_lt = new ArrayList<String>();
    item_lt.add("我也不知道呀QAQ");

    item_list = new ArrayList<List<String>>();
    item_list.add(item_lt);
    item_list.add(item_lt);
    item_list.add(item_lt);
    item_list.add(item_lt);
    item_list.add(item_lt);
    item_list.add(item_lt);
    item_list.add(item_lt);
    item_list.add(item_lt);
    item_list.add(item_lt);

    item_img = new ArrayList<Integer>();
    item_img.add(R.drawable.arrowwhiteleft);

    item_list2 = new ArrayList<List<Integer>>();
    item_list2.add(item_img);
    item_list2.add(item_img);
    item_list2.add(item_img);
    item_list2.add(item_img);
    item_list2.add(item_img);
    item_list2.add(item_img);
    item_list2.add(item_img);
    item_list2.add(item_img);
    item_list2.add(item_img);
    item_list2.add(item_img);
    item_list2.add(item_img);


    gr_list = new ArrayList<Integer>();
    gr_list.add(R.drawable.arrowwhiteleft);

    gr_list2 = new ArrayList<List<Integer>>();
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);
    gr_list2.add(gr_list);

    //数据填充完毕

  }

  class MyExpandableListViewAdapter extends BaseExpandableListAdapter{

      private Context context;

      public MyExpandableListViewAdapter(Context context)
      {
        this.context = context;
      }

      /**
       *
       * 获取组的个数
       *
       * @return
       * @see android.widget.ExpandableListAdapter#getGroupCount()
       */
      @Override
      public int getGroupCount()
      {
        return group_list.size();
      }

      /**
       *
       * 获取指定组中的子元素个数
       *
       * @param groupPosition
       * @return
       * @see android.widget.ExpandableListAdapter#getChildrenCount(int)
       */
      @Override
      public int getChildrenCount(int groupPosition)
      {
        return item_list.get(groupPosition).size();
      }

      /**
       *
       * 获取指定组中的数据
       *
       * @param groupPosition
       * @return
       * @see android.widget.ExpandableListAdapter#getGroup(int)
       */
      @Override
      public Object getGroup(int groupPosition)
      {
        return group_list.get(groupPosition);
      }

      /**
       *
       * 获取指定组中的指定子元素数据。
       *
       * @param groupPosition
       * @param childPosition
       * @return
       * @see android.widget.ExpandableListAdapter#getChild(int, int)
       */
      @Override
      public Object getChild(int groupPosition, int childPosition)
      {
        return item_list.get(groupPosition).get(childPosition);
      }

      /**
       *
       * 获取指定组的ID，这个组ID必须是唯一的
       *
       * @param groupPosition
       * @return
       * @see android.widget.ExpandableListAdapter#getGroupId(int)
       */
      @Override
      public long getGroupId(int groupPosition)
      {
        return groupPosition;
      }

      /**
       *
       * 获取指定组中的指定子元素ID
       *
       * @param groupPosition
       * @param childPosition
       * @return
       * @see android.widget.ExpandableListAdapter#getChildId(int, int)
       */
      @Override
      public long getChildId(int groupPosition, int childPosition)
      {
        return childPosition;
      }

      /**
       *
       * 组和子元素是否持有稳定的ID,也就是底层数据的改变不会影响到它们。
       *
       * @return
       * @see android.widget.ExpandableListAdapter#hasStableIds()
       */
      @Override
      public boolean hasStableIds()
      {
        return true;
      }

      /**
       *
       * 获取显示指定组的视图对象
       *
       * @param groupPosition 组位置
       * @param isExpanded 该组是展开状态还是伸缩状态
       * @param convertView 重用已有的视图对象
       * @param parent 返回的视图对象始终依附于的视图组
       * @return
       * @see android.widget.ExpandableListAdapter#getGroupView(int, boolean, android.view.View,
       *      android.view.ViewGroup)
       */
      @Override
      public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
      {
        GroupHolder groupHolder = null;
        if (convertView == null)
        {

          convertView = LayoutInflater.from(context).inflate(R.layout.expandlist_group, null);
          groupHolder = new GroupHolder();
          groupHolder.txt = (TextView)convertView.findViewById(R.id.txt);
          convertView.setTag(groupHolder);
        }
        else
        {
          groupHolder = (GroupHolder)convertView.getTag();
        }


        groupHolder.txt.setText(group_list.get(groupPosition));
        return convertView;
      }

      /**
       *
       * 获取一个视图对象，显示指定组中的指定子元素数据。
       *
       * @param groupPosition 组位置
       * @param childPosition 子元素位置
       * @param isLastChild 子元素是否处于组中的最后一个
       * @param convertView 重用已有的视图(View)对象
       * @param parent 返回的视图(View)对象始终依附于的视图组
       * @return
       * @see android.widget.ExpandableListAdapter#getChildView(int, int, boolean, android.view.View,
       *      android.view.ViewGroup)
       */
      @Override
      public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
      {
        ItemHolder itemHolder = null;
        if (convertView == null)
        {
          convertView = LayoutInflater.from(context).inflate(R.layout.expandlist_item, null);
          itemHolder = new ItemHolder();
          itemHolder.txt = (TextView)convertView.findViewById(R.id.txt);
          itemHolder.img = (ImageView)convertView.findViewById(R.id.img);
          convertView.setTag(itemHolder);
        }
        else
        {
          itemHolder = (ItemHolder)convertView.getTag();
        }
        itemHolder.txt.setText(item_list.get(groupPosition).get(childPosition));
        itemHolder.img.setBackgroundResource(item_list2.get(groupPosition).get(childPosition));
        return convertView;
      }

      /**
       *
       * 是否选中指定位置上的子元素。
       *
       * @param groupPosition
       * @param childPosition
       * @return
       * @see android.widget.ExpandableListAdapter#isChildSelectable(int, int)
       */
      @Override
      public boolean isChildSelectable(int groupPosition, int childPosition)
      {
        return true;
      }

    }



  class GroupHolder
  {
    public TextView txt;

  }

  class ItemHolder
  {
    public ImageView img;

    public TextView txt;
  }

}

