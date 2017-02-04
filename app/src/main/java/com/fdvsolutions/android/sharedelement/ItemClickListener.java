package com.fdvsolutions.android.sharedelement;

/**
 * Created by diego on 04/02/17.
 */
public interface ItemClickListener {

    /**
     * Called when a item is clicked
     * @param holder The ViewHolder for the clicked item
     * @param position The position in the grid of the item that was clicked
     */
    void onItemClicked(SimpleItemRecyclerViewAdapter.ViewHolder holder, int position);

}
