package com.example.newyorker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class ProductDetailsActivity extends AppCompatActivity {
    private EditText mBrand_editTxt;
    private EditText mPrice_editTxt;
    private Spinner mProduct_categories_spinner;
    private Button mUpdate_btn, mDelete_btn;

    private  String key;
    private  String brand;
    private  String price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        key = getIntent().getStringExtra("key");
        brand= getIntent().getStringExtra("brand");
        price= getIntent().getStringExtra("price");

        // Initializing
        mBrand_editTxt = findViewById(R.id.brand_editTxt);
        mPrice_editTxt = findViewById(R.id.price_editTxt);
        mProduct_categories_spinner = findViewById(R.id.product_categories_spinner);
        mProduct_categories_spinner.setSelection(getIndex_SpinnerItem(getIndex_SpinnerItem(mProduct_categories_spinner, category)));

        mUpdate_btn = findViewById(R.id.update_btn);
        mDelete_btn = findViewById(R.id.deleted_btn);

        mUpdate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Products products = new Products();
                products.setBrand(mBrand_editTxt.getText().toString());
                products.setPrice(mPrice_editTxt.getText().toString());
                products.setCa
            }
        });
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
