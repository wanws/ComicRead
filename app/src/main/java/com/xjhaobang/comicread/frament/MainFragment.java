package com.xjhaobang.comicread.frament;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.xjhaobang.comicread.R;
import com.xjhaobang.comicread.adapter.UpdaterComicRvAdapter;
import com.xjhaobang.comicread.base.BaseFragment;
import com.xjhaobang.comicread.been.ComicBeen;
import com.xjhaobang.comicread.constract.GetMainDataContract;
import com.xjhaobang.comicread.listener.OnClickRecyclerViewListener;
import com.xjhaobang.comicread.model.FrescoImageLoader;
import com.xjhaobang.comicread.presenter.GetMainDataPresenterImpl;
import com.xjhaobang.comicread.utils.ProgressDialogUtil;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by PC on 2017/9/27.
 */

public class MainFragment extends BaseFragment implements GetMainDataContract.View ,OnClickRecyclerViewListener{
    private static final String TAG = "MainFragment";
    @BindView(R.id.banner)
    Banner mBanner;
    @BindView(R.id.rv_new)
    RecyclerView mRvNew;
    Unbinder unbinder;

    private List<ComicBeen> mPollingList;
    private List<ComicBeen> mUpdateList;
    private List<String> mUriList;
    private List<String> mTitleList;
    private UpdaterComicRvAdapter mUpdaterComicRvAdapter;
    private GetMainDataContract.Presenter mPresenter;

    @Override
    protected int setLayoutResourceId() {
        return R.layout.fragment_main;
    }

    @Override
    protected void initData(Bundle bundle) {
        mPollingList = new ArrayList<>();
        mUpdateList = new ArrayList<>();
        mUriList = new ArrayList<>();
        mTitleList = new ArrayList<>();
        mUpdaterComicRvAdapter = new UpdaterComicRvAdapter();
        mPresenter = new GetMainDataPresenterImpl(this);
    }

    @Override
    protected void initView() {
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);
        mBanner.setIndicatorGravity(BannerConfig.LEFT);
        mBanner.setImageLoader(new FrescoImageLoader());
        mBanner.isAutoPlay(true);
        mBanner.setDelayTime(3000);
        mRvNew.setLayoutManager(new GridLayoutManager(mBaseActivity,2));
        mRvNew.setItemAnimator(new DefaultItemAnimator());
        mUpdaterComicRvAdapter.updateData(mUpdateList);
        mRvNew.setAdapter(mUpdaterComicRvAdapter);
        ProgressDialogUtil.showDefaultDialog(mBaseActivity);
        mPresenter.getMainData();
    }

    @Override
    protected void setListener() {
        mUpdaterComicRvAdapter.setOnRecyclerViewListener(this);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public boolean onItemLongClick(int position) {
        return false;
    }

    @Override
    public void getMainDataSuccess(List<ComicBeen> pollingList, List<ComicBeen> updateList) {
        mPollingList = pollingList;
        mUpdateList = updateList;
        for (ComicBeen been : pollingList) {
            mUriList.add(been.getPicUrl());
            mTitleList.add(been.getTitle());
        }
        ProgressDialogUtil.dismiss();
        mBanner.setImages(mUriList);
        mBanner.setBannerTitles(mTitleList);
        mBanner.start();
        mUpdaterComicRvAdapter.updateData(mUpdateList);
    }

    @Override
    public void getError(String msg) {
        ProgressDialogUtil.dismiss();
        showToast(msg);
    }

}