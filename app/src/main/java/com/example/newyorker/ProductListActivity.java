package com.example.newyorker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        mRecyclerView = findViewById(R.id.recyclerview_products);
        new FirebaseDBHelper().readProducts(new FirebaseDBHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Products> products, List<String> keys) {
                findViewById(R.id.progressBar).setVisibility(View.GONE);
                new RecyclerView_Config().setConfig(mRecyclerView,ProductListActivity.this, products, keys);
            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.productlist_activity_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.new_product:
                startActivity(new Intent(this, NewProduct.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
