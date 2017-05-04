package com.vjam.demo.ui.cart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.vjam.demo.R;
import com.vjam.demo.data.db.item_model.Item;
import com.vjam.demo.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CartFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CartFragment extends BaseFragment implements CartMvpView {

    @BindView(R.id.cart_rv)
    RecyclerView cartRv;
    @BindView(R.id.emptyCart_textView)
    TextView emptyCartTextView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    Unbinder unbinder;

    @Inject
    CartMvpPresenter<CartMvpView> mCartPresenter;

    private ArrayList<Item> albumList;
    private CartAdapter adapter;

    public CartFragment() {
        // Required empty public constructor
    }

    public static CartFragment newInstance() {
        CartFragment fragment = new CartFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);
        unbinder = ButterKnife.bind(this, view);

        getActivityComponent().inject(this);
        mCartPresenter.onAttach(this);


        albumList = new ArrayList<>();
        adapter = new CartAdapter(getActivity(), albumList, null);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        cartRv.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, ViewUtils.dpToPx(10,this), true));
        cartRv.setItemAnimator(new DefaultItemAnimator());
        cartRv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    protected void setUp(View view) {

    }


    @Override
    public void showLoading() {
        super.showLoading();
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        super.hideLoading();
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void loadCartList(List<Item> items) {
        emptyCartTextView.setVisibility(View.GONE);
        albumList.addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showCartEmptyMessage(String message) {
        emptyCartTextView.setVisibility(View.VISIBLE);
        emptyCartTextView.setText(message);
    }
}
