package com.vjam.demo.ui.cart;

import android.content.Context;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.vjam.demo.R;
import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.home.HomeAdapterCallback;

import java.util.List;

/**
 * Created by anand.chandaliya on 04-04-2017.
 */

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.MyViewHolder> {

private Context mContext;
private List<Item> albumList;

private HomeAdapterCallback adapterCallback;

public class MyViewHolder extends RecyclerView.ViewHolder {
    public TextView title, count,cost;
    public ImageView thumbnail/*, overflow*/;

    public MyViewHolder(View view) {
        super(view);
        title = (TextView) view.findViewById(R.id.cart_item_name);
        count = (TextView) view.findViewById(R.id.cart_item_count);
        cost = (TextView) view.findViewById(R.id.cart_item_cost);
        thumbnail = (ImageView) view.findViewById(R.id.cart_item_icon);
        //overflow = (ImageView) view.findViewById(R.id.overflow);
    }
}


    public CartAdapter(Context mContext, List<Item> albumList, HomeAdapterCallback adapterCallback) {
        this.mContext = mContext;
        this.albumList = albumList;
        this.adapterCallback = adapterCallback;
    }

    @Override
    public CartAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cart_item_card, parent, false);

        return new CartAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final CartAdapter.MyViewHolder holder, final int position) {
        Item album = albumList.get(position);
        holder.title.setText(album.getItemName());
        holder.cost.setText("Rs " + album.getItemPrice() );
        holder.count.setText("Count : 5");

        // loading album cover using Glide library
        Glide.with(mContext).load(album.getItemImage()).into(holder.thumbnail);

        //holder.overflow.setOnClickListener(view -> showPopupMenu(holder.overflow,position));

        holder.thumbnail.setOnClickListener(v -> {
           /* Intent intent = new Intent(mContext, ShowDetailsActivity.class);
            intent.putExtra("pos",position);
            mContext.startActivity(intent);*/
            adapterCallback.onItemClicked(position);
        });
    }

    /**
     * Showing popup menu when tapping on 3 dots
     */
    private void showPopupMenu(View view, int position) {
        // inflate menu
        PopupMenu popup = new PopupMenu(mContext, view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.item_menu, popup.getMenu());
        popup.setOnMenuItemClickListener(new CartAdapter.MyMenuItemClickListener(position));
        popup.show();
    }

/**
 * Click listener for popup menu items
 */
class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

    private int postion;

    public MyMenuItemClickListener(int postion) {
        this.postion = postion;

    }



    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        switch (menuItem.getItemId()) {

            case R.id.action_add_favourite:
                if(albumList.get(postion).getIsItemFav() != null) {

                    if(albumList.get(postion).getIsItemFav()) {
                        adapterCallback.onFavClicked(albumList.get(postion).getItemId(), false);
                    }

                    else
                        adapterCallback.onFavClicked(albumList.get(postion).getItemId(), true);
                }else {
                    adapterCallback.onFavClicked(albumList.get(postion).getItemId(), true);
                }
                //menuItem.getOrder();
                Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_add_to_cart:

                if(albumList.get(postion).getIsItemAddedToCart()) {
                    adapterCallback.onAddToCartClicked(albumList.get(postion).getItemId(), false);
                }
                else
                    adapterCallback.onAddToCartClicked(albumList.get(postion).getItemId(), true);

                //menuItem.getOrder();
                Toast.makeText(mContext, "Add to cart", Toast.LENGTH_SHORT).show();
                return true;
            default:
        }
        return false;
    }
}

    @Override
    public int getItemCount() {
        return albumList.size();
    }
}
