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
import com.vjam.demo.model.ItemModel;
import com.vjam.demo.ui.base.BaseFragment;
import com.vjam.demo.ui.item_details.ShowDetailsActivity;
import com.vjam.demo.util.GridSpacingItemDecoration;
import com.vjam.demo.util.ViewUtils;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

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

    private ArrayList<ItemModel> albumList;
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

        prepareAlbums();

        try {
            Glide.with(this).load(R.drawable.cover).into((ImageView) view.findViewById(R.id.backdrop));
        } catch (Exception e) {
            e.printStackTrace();
        }




        return view;
    }

    /**
     * Adding few albums for testing
     */
    private void prepareAlbums() {
        int[] covers = new int[]{
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11};

        ItemModel a = new ItemModel("True Romance", 13, covers[0]);
        albumList.add(a);

        a = new ItemModel("Xscpae", 8, covers[1]);
        albumList.add(a);

        a = new ItemModel("Maroon 5", 11, covers[2]);
        albumList.add(a);

        a = new ItemModel("Born to Die", 12, covers[3]);
        albumList.add(a);

        a = new ItemModel("Honeymoon", 14, covers[4]);
        albumList.add(a);

        a = new ItemModel("I Need a Doctor", 1, covers[5]);
        albumList.add(a);

        a = new ItemModel("Loud", 11, covers[6]);
        albumList.add(a);

        a = new ItemModel("Legend", 14, covers[7]);
        albumList.add(a);

        a = new ItemModel("Hello", 11, covers[8]);
        albumList.add(a);

        a = new ItemModel("Greatest Hits", 17, covers[9]);
        albumList.add(a);

        adapter.notifyDataSetChanged();
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
    public void onFavClicked(int postion) {
        mPresenter.addToFav(postion);
    }

    @Override
    public void onAddToCartClicked(int postion) {
        mPresenter.addToCart(postion);
    }

    @Override
    public void onItemClicked(int position) {
        Intent intent = new Intent(getActivity(), ShowDetailsActivity.class);
        intent.putExtra("pos",position);
        getActivity().startActivity(intent);
    }
}
