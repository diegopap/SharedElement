package com.fdvsolutions.android.sharedelement;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.transition.Fade;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fdvsolutions.android.sharedelement.dummy.DummyContent;

public class ItemListFragment extends Fragment implements ItemClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.item_list, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.item_list);
        recyclerView.setAdapter(new SimpleItemRecyclerViewAdapter(DummyContent.ITEMS, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onItemClicked(SimpleItemRecyclerViewAdapter.ViewHolder holder, int position) {

        ItemDetailFragment fragment = ItemDetailFragment.newInstance(holder.mIdView.getText().toString());

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            fragment.setSharedElementEnterTransition(new DetailsTransition());
            fragment.setEnterTransition(new Fade());
            setExitTransition(new Fade());
            fragment.setSharedElementReturnTransition(new DetailsTransition());
        }

        getActivity().getSupportFragmentManager().beginTransaction()
                .addSharedElement(holder.mIdView, "id")
                .addSharedElement(holder.mContentView, "content")
                .replace(R.id.frameLayout, fragment)
                .addToBackStack(null)
                .commit();
    }

}
