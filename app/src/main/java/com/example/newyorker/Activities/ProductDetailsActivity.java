package com.example.newyorker.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.newyorker.FirebaseDBHelper;
import com.example.newyorker.Products;
import com.example.newyorker.R;

import java.util.List;

public class ProductDetailsActivity extends AppCompatActivity {
    private EditText mBrand_editTxt, mPrice_editTxt;
    private Spinner mProduct_categories_spinner;
    private Button mUpdate_btn, mDelete_btn;

    private String key, brand,  price, category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        key = getIntent().getStringExtra("key");
        brand = getIntent().getStringExtra("Brand");
        price = getIntent().getStringExtra("Price");
        category = getIntent().getStringExtra("Category");

        // Initializing
        mBrand_editTxt = findViewById(R.id.brand_editTxt);
        mBrand_editTxt.setText(brand);
        mPrice_editTxt = findViewById(R.id.price_editTxt);
        mPrice_editTxt.setText(price);
        mProduct_categories_spinner = findViewById(R.id.product_categories_spinner);
        mProduct_categories_spinner.setSelection(getIndex_SpinnerItem(mProduct_categories_spinner, category));

        mUpdate_btn = findViewById(R.id.update_btn);
        mDelete_btn = findViewById(R.id.deleted_btn);

        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Products products = new Products();
                products.setBrand(mBrand_editTxt.getText().toString());
                products.setPrice(mPrice_editTxt.getText().toString());
                products.setCategory(mProduct_categories_spinner.getSelectedItem().toString());

                new FirebaseDBHelper().updateProduct(key, products, new FirebaseDBHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Products> products, List<String> keys) {
                    }

                    @Override
                    public void DataIsInserted() {
                    }

                    @Override
                    public void DataIsUpdated() {
                        Toast.makeText(ProductDetailsActivity.this,"Product is geupdate", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void DataIsDeleted() {
                    }
                });
            }
        });

        mDelete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new FirebaseDBHelper().deleteProduct(key, new FirebaseDBHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Products> products, List<String> keys) {
                    }

                    @Override
                    public void DataIsInserted() {
                    }

                    @Override
                    public void DataIsUpdated() {
                    }

                    @Override
                    public void DataIsDeleted() {
                        Toast.makeText(ProductDetailsActivity.this, "Product is verwijdert", Toast.LENGTH_SHORT).show();
                        finish(); return;
                    }
                });
            }
        });
        onBackPressed();
    }
    private int getIndex_SpinnerItem(Spinner spinner, String item){
        int index = 0;
        for (int i = 0; i<spinner.getCount();i++){
            if(spinner.getItemAtPosition(i).equals(item)){
                index = i;
                break;
            }
        }
        return index;
    }
}
