package com.hyphenate.app.ui;


import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARCABLE = "parcable";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BaseFragment() {
    }

    public static BaseFragment newInstance(Class frgmentCla) {
        BaseFragment fragment = null;
        try {
            fragment = (BaseFragment) frgmentCla.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return fragment;
    }

  public static BaseFragment newInstance(String param1, Class frgmentCla) {
        BaseFragment fragment = null;
        try {
            fragment = (BaseFragment) frgmentCla.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public static BaseFragment newInstance(Parcelable parcelable, Class frgmentCla) {
        BaseFragment fragment = null;
        try {
            fragment = (BaseFragment) frgmentCla.newInstance();
        } catch (java.lang.InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        Bundle args = new Bundle();
        args.putParcelable(ARG_PARCABLE, parcelable);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(getFramgLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handEvent(view);
    }

    public abstract int getFramgLayout();

    public abstract void handEvent(View view);

    public <T extends View> T findView(int viewId){
        T t = getView().findViewById(viewId);
        return t;
    }

}
