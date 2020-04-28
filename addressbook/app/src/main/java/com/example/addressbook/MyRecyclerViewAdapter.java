package com.example.addressbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.binhai.beans.UserBean;
import com.example.one.R;

import java.util.List;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.ViewHolder>{
    //需要的加载的数据列表(*****改动1，只需要改UserBean)
    private List<UserBean> list;
    //适配器构造方法(*****改动2，只需要改UserBean)
    public MyRecyclerViewAdapter(List<UserBean> list) {
        this.list = list;
    }
    /*
    界面控制器内部类
    (*****改动3，将你的列表项布局元素找到)
     */
    class ViewHolder extends RecyclerView.ViewHolder {
         ImageView iamge;
         TextView mText;
         TextView tel;
         ViewHolder(View itemView) {
            super(itemView);
            iamge = itemView.findViewById(R.id.head);
             mText = itemView.findViewById(R.id.name);
             tel = itemView.findViewById(R.id.tel);
        }
    }


    /**
     * 创建界面控制器
     * @param parent
     * @param viewType
     * @return
     * (*****改动4，只需要改R.layout.item_normal)
     */
    @Override
    public MyRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_normal, parent, false);
        return new MyRecyclerViewAdapter.ViewHolder(view);
    }

    /**
     * 将数据绑定到界面上
     * @param holder，界面控制器
     * @param position 列表的索引
     *
     */
    @Override
    public void onBindViewHolder(MyRecyclerViewAdapter.ViewHolder holder, final int position) {
        //绑定数据(*****改动5，只需要改的比较多，主要是数据和元素的对应)
        holder.mText.setText(list.get(position).getName());
        holder.tel.setText(list.get(position).getTel());
        String xingbie = list.get(position).getXingbie();
        if("女".equals(xingbie)){
            holder.iamge.setImageResource(R.drawable.woman);
        }else{
            holder.iamge.setImageResource(R.drawable.man);
        }

        //绑定单击事件监听
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              itemClickListener.onClick(position);
            }
        });
        //绑定长按事件监听
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                itemLongClickListener.onLongClick(position);
                return true;
            }
        });
    }

    /**
     * 获取数据的总数量
     * @return
     */
    @Override
    public int getItemCount() {
        return list.size();
    }

    /////////////////单击和长按处理事件//////////////

    public void setItemOnClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    public void setItemOnLongClickListener(ItemLongClickListener itemLongClickListener){
        this.itemLongClickListener = itemLongClickListener;
    }
    ItemClickListener itemClickListener;
    ItemLongClickListener itemLongClickListener;

    public interface ItemClickListener {
       void onClick(int index);
    }
    public interface  ItemLongClickListener{
        void onLongClick(int index);
    }
    ///////////////////以下部分可以添加业务方法///////////////////////////////////

    /**
     * 删除数据
     * @param index
     */
    public void deleteItem(int index) {
        list.remove(index);
        notifyItemRemoved(index);
    }
}
