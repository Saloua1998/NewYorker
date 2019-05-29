package com.example.newyorker.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD:app/src/main/java/com/example/newyorker/Activities/NewProduct.java
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.example.newyorker.FirebaseDBHelper;
import com.example.newyorker.Products;
import com.example.newyorker.R;
import java.util.List;

public class NewProduct extends AppCompatActivity {
    private EditText mBrand_editTxt;
    private EditText mPrice_editTxt;
    private Spinner mProduct_categories_spinner;
    private Button mAdd_btn;
=======

public class NewProduct extends AppCompatActivity {
>>>>>>> parent of c3a8252... now you can add a product:app/src/main/java/com/example/newyorker/NewProduct.java

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
<<<<<<< HEAD:app/src/main/java/com/example/newyorker/Activities/NewProduct.java
        mBrand_editTxt = findViewById(R.id.brand_editTxt);
        mPrice_editTxt = findViewById(R.id.price_editTxt);
        mProduct_categories_spinner=findViewById(R.id.product_categories_spinner);

        mAdd_btn = findViewById(R.id.add_btn);
        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Products products = new Products();
                products.setBrand(mBrand_editTxt.getText().toString());
                products.setPrice(mPrice_editTxt.getText().toString());
                products.setCategory(mProduct_categories_spinner.getSelectedItem().toString());

                new FirebaseDBHelper().addProduct(products, new FirebaseDBHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Products> products, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewProduct.this, "De gegevens zijn met succes aangepast", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });
            }
        });
=======
>>>>>>> parent of c3a8252... now you can add a product:app/src/main/java/com/example/newyorker/NewProduct.java
    }
}
