package com.vjam.demo.ui.fav;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
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
 * Use the {@link FavFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavFragment extends BaseFragment implements FavMvpView {

    @BindView(R.id.fav_rv)
    RecyclerView favRv;
    Unbinder unbinder;
    @BindView(R.id.no_item_message_textView)
    TextView noItemMessageTextView;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    private ArrayList<Item> albumList;
    private FavItemAdaper adapter;

    public FavFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment FavFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FavFragment newInstance() {
        FavFragment fragment = new FavFragment();
        return fragment;
    }

    @Inject
    FavMvpPresenter<FavMvpView> mFavPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fav, container, false);
        unbinder = ButterKnife.bind(this, view);
        getActivityComponent().inject(this);
        mFavPresenter.onAttach(this);


        albumList = new ArrayList<>();
        adapter = new FavItemAdaper(getActivity(), albumList, null);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        favRv.setLayoutManager(mLayoutManager);
        //recyclerView.addItemDecoration(new GridSpacingItemDecoration(2, ViewUtils.dpToPx(10,this), true));
        favRv.setItemAnimator(new DefaultItemAnimator());
        favRv.setAdapter(adapter);

        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) view.findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void loadFavItemsInRv(List<Item> items) {
        noItemMessageTextView.setVisibility(View.GONE);
        albumList.addAll(items);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showNoItemMessage() {
        noItemMessageTextView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void openActivityOnTokenExpire() {

    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onError(int resId) {

    }

    @Override
    public void onError(String message) {

    }

    @Override
    public boolean isNetworkConnected() {
        return false;
    }

    @Override
    public void hideKeyboard() {

    }
}
