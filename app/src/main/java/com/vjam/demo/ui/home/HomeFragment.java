package com.vjam.demo.ui.home;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.vjam.demo.R;
import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.BaseFragment;
import com.vjam.demo.ui.item_details.ShowDetailsActivity;
import com.vjam.demo.util.GridSpacingItemDecoration;
import com.vjam.demo.util.ViewUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements HomeMvpView,HomeAdapterCallback{


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.backdrop)
    ImageView backdrop;
    @BindView(R.id.love_music)
    TextView loveMusic;

    private ArrayList<Item> albumList;
    private ItemAdapter adapter;


    public HomeFragment() {
        // Required empty public constructor
    }

    @Inject
    HomeMvpPresenter<HomeMvpView> mPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this, view));
        mPresenter.onAttach(this);


        albumList = new ArrayList<>();
        adapter = new ItemAdapter(getActivity(), albumList,this);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, ViewUtils.dpToPx(10,this), true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) view.findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }


    @Override
    protected void setUp(View view) {


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //null.unbind();
    }


    @Override
    public void onFavClicked(String itemId, boolean isFav) {
        mPresenter.addToFav(itemId,isFav);
    }

    @Override
    public void onAddToCartClicked(String itemId, boolean isInCart) {
        mPresenter.addToCart(itemId,isInCart);
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(getActivity(), ShowDetailsActivity.class);
        intent.putExtra("pos",position);
        getActivity().startActivity(intent);
    }

    @Override
    public void loadItemsInViewF(List<Item> items) {
        Timber.i("loadItemsInViewF in Home Fragment: size : "+items.size());
        albumList.addAll(items);
        adapter.notifyDataSetChanged();
    }
}
