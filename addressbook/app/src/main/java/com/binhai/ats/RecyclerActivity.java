package com.binhai.ats;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.binhai.adapter.MyRecyclerViewAdapter;
import com.binhai.beans.UserBean;
import com.example.addressbook.MyRecyclerViewAdapter;
import com.example.addressbook.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.View;
import android.widget.Toast;

import com.example.one.R;

import java.util.ArrayList;
import java.util.List;

public class RecyclerActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MyRecyclerViewAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.recyclerView);
       //实现列表的间隔线
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, LinearLayoutManager.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(this,R.drawable.item_line);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);

        //设置RecyclerView管理器
         recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));//线性布局
//         recyclerView.setLayoutManager(new GridLayoutManager(this, 3));//3列网格布局
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));//3列瀑布布局
        //初始化适配器
         mAdapter = new MyRecyclerViewAdapter(getUserList());
        //单击事件监听
        mAdapter.setItemOnClickListener(new MyRecyclerViewAdapter.ItemClickListener() {
            @Override
            public void onClick(int index) {
                Toast.makeText(RecyclerActivity.this, "点击"+index, Toast.LENGTH_SHORT).show();
            }
        });
        //长按事件监听
        mAdapter.setItemOnLongClickListener(new MyRecyclerViewAdapter.ItemLongClickListener() {
            @Override
            public void onLongClick(int index) {
                mAdapter.deleteItem(index);
            }
        });
        //设置添加或删除item时的动画，这里使用默认动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //设置适配器
        recyclerView.setAdapter(mAdapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
    private List getUserList(){
        List list = new ArrayList();
        UserBean userBean1 = new UserBean();
        UserBean userBean2 = new UserBean();
        UserBean userBean3 = new UserBean();
        UserBean userBean4 = new UserBean();
        UserBean userBean5 = new UserBean();
        UserBean userBean6 = new UserBean();
        UserBean userBean7 = new UserBean();
        UserBean userBean8 = new UserBean();
        UserBean userBean9 = new UserBean();
        UserBean userBean10 = new UserBean();
        userBean1.setName("李红军");
        userBean2.setName("王莹莹");
        userBean3.setName("杨阳");
        userBean4.setName("张艳武");
        userBean5.setName("高薇");
        userBean6.setName("刘子渊");
        userBean7.setName("谢锦锦");
        userBean8.setName("孙凯俐");
        userBean9.setName("于芳");
        userBean10.setName("巩晨静");

        userBean1.setXingbie("男");
        userBean2.setXingbie("女");
        userBean3.setXingbie("女");
        userBean4.setXingbie("女");
        userBean5.setXingbie("女");
        userBean6.setXingbie("男");
        userBean7.setXingbie("女");
        userBean8.setXingbie("女");
        userBean9.setXingbie("女");
        userBean10.setXingbie("女");

        userBean10.setTel("131233447878");
        userBean1.setTel("13455235097");
        userBean2.setTel("15677889983");
        userBean3.setTel("12334444333");
        userBean4.setTel("16755535555");
        userBean5.setTel("15642244555");
        userBean6.setTel("133445556566");
        userBean7.setTel("135662545355");
        userBean8.setTel("13422334456");
        userBean9.setTel("15677765554");
        userBean10.setTel("18977889933");
        list.add(userBean1);
        list.add(userBean2);
        list.add(userBean3);
        list.add(userBean4);
        list.add(userBean5);
        list.add(userBean6);
        list.add(userBean7);
        list.add(userBean8);
        list.add(userBean9);
        list.add(userBean10);
        return list;
    }
}
