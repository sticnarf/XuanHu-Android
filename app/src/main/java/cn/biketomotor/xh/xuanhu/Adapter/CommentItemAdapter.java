package cn.biketomotor.xh.xuanhu.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cn.biketomotor.xh.xuanhu.Item.CommentItem;
import cn.biketomotor.xh.xuanhu.R;

public class CommentItemAdapter extends RecyclerView.Adapter<CommentItemAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitleName;
        private TextView tvContent;
        private TextView tvVoteUp;
        private TextView tvVoteDown;

        ViewHolder(View itemView) {
            super(itemView);
            tvTitleName = itemView.findViewById(R.id.tv_title_name);
            tvContent = itemView.findViewById(R.id.tv_content);
            tvVoteUp = itemView.findViewById(R.id.tv_vote_up);
            tvVoteDown = itemView.findViewById(R.id.tv_vote_down);
        }
    }

    public interface onItemClickListener {
        void onItemClick(int position);
    }

    private List<CommentItem> commentItemList;
    private onItemClickListener clickListener;

    public CommentItemAdapter(List<CommentItem> list) {
        this.commentItemList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.test_item_comment_at_main, parent, false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (clickListener != null) {
                    clickListener.onItemClick((Integer)v.getTag());
//                    switch (v.getId()) {
//                    }
                }
            }
        });
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.tvTitleName.setText(commentItemList.get(position).getCourseTitle() + "-" + commentItemList.get(position).getUserName());
        holder.tvContent.setText(commentItemList.get(position).getContent());
        holder.tvVoteUp.setText(String.valueOf(commentItemList.get(position).getVoteUp()));
        holder.tvVoteDown.setText(String.valueOf(commentItemList.get(position).getVoteDown()));
        holder.itemView.setTag(position);
    }

    @Override
    public int getItemCount() {
        return commentItemList.size();
    }

    public void setItemClickListener(onItemClickListener listener) {
        this.clickListener = listener;
    }
}