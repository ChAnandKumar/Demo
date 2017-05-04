package com.vjam.demo.ui.item_details;

import com.vjam.demo.data.DataManager;
import com.vjam.demo.data.db.item_model.Item;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by anand.chandaliya on 12-04-2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class ShowDetailsPresenterTest {

    @Mock
    ShowDetailsMvpView view;

    @Mock
    DataManager mDataManager;

    @Test
    public void shouldWork(){
        Assert.assertEquals(1,1);
    }
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void onAttach() throws Exception {
    }

    @Inject
    DataManager dataManager;

    @Inject
    CompositeDisposable compositeDisposable;

    Item item = new Item();


    @Test
    public void shouldGetDataFromDb(){
        //given
        //ShowDetailsMvpView view = new MockView();

       // Observable<Item> itemObservable =


        Mockito.when(mDataManager.getItemData()).thenReturn(Observable.just(item));

        //Mockito.when(view.displayData(new Item()));

        //when
        ShowDetailsPresenter<ShowDetailsMvpView> presenter = new ShowDetailsPresenter<>(mDataManager, compositeDisposable);
        presenter.onAttach(view);

        //then
        //Assert.assertEquals(true,((MockView)view).isPassed);

        Mockito.verify(view).displayData(item);

    }

    /*@Inject
    ShowDetailsMvpView view;*/






}