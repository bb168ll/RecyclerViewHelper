package com.yl.sample.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.yl.sample.R;
import com.yl.sample.adapter.MainAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Index
 * <p>
 * Created by yangle on 2017/10/26.
 * Website：http://www.yangle.tech
 */

public class MainActivity extends AppCompatActivity implements MainAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        // Toolbar replace ActionBar
        setSupportActionBar(toolbar);

        // Item list
        List<String> itemList = new ArrayList<>();
        itemList.add("Pull up to load more");
        itemList.add("HeaderView / FooterView");
        itemList.add("Drag & Drop");

        MainAdapter mainAdapter = new MainAdapter(itemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(mainAdapter);

        // Set item click listener
        mainAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(View view, int position) {
        Intent intent = null;

        switch (position) {
            case 0:
                intent = new Intent(this, LoadMoreActivity.class);
                break;

            case 1:
                intent = new Intent(this, HeaderAndFooterViewActivity.class);
                break;

            case 2:
                intent = new Intent(this, DragAndDropActivity.class);
                break;

            default:
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
