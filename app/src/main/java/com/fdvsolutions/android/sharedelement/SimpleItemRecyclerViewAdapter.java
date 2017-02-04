package com.fdvsolutions.android.sharedelement;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fdvsolutions.android.sharedelement.dummy.DummyContent;

import java.util.List;

/**
 * Created by diego on 04/02/17.
 */
public class SimpleItemRecyclerViewAdapter
        extends RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder> {

    private final List<DummyContent.DummyItem> mValues;
    private final ItemClickListener mListener;

    public SimpleItemRecyclerViewAdapter(List<DummyContent.DummyItem> items, ItemClickListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_content, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.mIdView.setText(mValues.get(position).id);
        holder.mContentView.setText(mValues.get(position).content);

        ViewCompat.setTransitionName(holder.mIdView, "id" + position);
        ViewCompat.setTransitionName(holder.mContentView, "content" + position);

        holder.mIdView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onItemClicked(holder, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mIdView;
        public final TextView mContentView;


        public ViewHolder(View view) {
            super(view);
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

    }
}