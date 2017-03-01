package testdemo.com.searchfragmenttest.fragments;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.futuremind.recyclerviewfastscroll.FastScroller;

import testdemo.com.searchfragmenttest.R;
import testdemo.com.searchfragmenttest.adapters.EmployeesRecyclerAdapter;
import testdemo.com.searchfragmenttest.customview.CustomScrollerViewProvider;
import testdemo.com.searchfragmenttest.decoration.DividerDecoration;
import testdemo.com.searchfragmenttest.model.EmployeeListRestrictionsParcelable;
import testdemo.com.searchfragmenttest.utilities.PreferencesUtilities;

public class SearchListFragment extends RecyclerFragment {

    private final String TAG = "SearchListFragment";

    protected EmployeesRecyclerAdapter mAdapter;

    public SearchListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView: " + container);

        String searchString = PreferencesUtilities.getLastSearchStringPreference(getActivity());

        View rootView = inflater.inflate(R.layout.fragment_recycler, container, false);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.section_list);

        FastScroller fastScroller = (FastScroller) rootView.findViewById(R.id.fastscroll);
        fastScroller.setViewProvider(new CustomScrollerViewProvider());

        mRecyclerView.setLayoutManager(getLayoutManager());
        mRecyclerView.addItemDecoration(getItemDecoration());

        mRecyclerView.getItemAnimator().setAddDuration(1000);
        mRecyclerView.getItemAnimator().setChangeDuration(1000);
        mRecyclerView.getItemAnimator().setMoveDuration(1000);
        mRecyclerView.getItemAnimator().setRemoveDuration(1000);

        mAdapter = getAdapter(); // EmployeesRecyclerAdapter

        // if search string is empty then display all employees
        if (searchString.isEmpty()) {
            mAdapter.populateEmployeeList();
        }
        else {
            mAdapter.searchEmployeeList(searchString); // searchString here
        }

        // set title for action bar
        String title = getResources().getString(R.string.title_search_results);
        title += " \"" + searchString + "\"";

        mAdapter.setOnItemClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
        //Log.d(TAG, "mAdapter: " + mAdapter);

        // Must be called AFTER RecyclerView.setAdapter()
        fastScroller.setRecyclerView(mRecyclerView);

        ActionBar actionBar = ((AppCompatActivity)getActivity()).getSupportActionBar();
        actionBar.setTitle(title);

        return rootView;
    }

    @Override
    protected RecyclerView.LayoutManager getLayoutManager() {
        return new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
    }

    @Override
    protected RecyclerView.ItemDecoration getItemDecoration() {
        //We must draw dividers ourselves if we want them in a list
        return new DividerDecoration(getActivity());
    }

    @Override
    protected int getDefaultItemCount() {
        return 100;
    }

//    @Override
    protected EmployeesRecyclerAdapter getAdapter() {

        return new EmployeesRecyclerAdapter(getActivity());
    }
}
