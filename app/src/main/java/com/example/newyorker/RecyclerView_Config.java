package com.example.newyorker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private ProductsAdapter mProductsAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Products> products, List<String> keys){
        mContext = context;
        mProductsAdapter = new ProductsAdapter(products, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mProductsAdapter);
    }

    class ProductitemView extends RecyclerView.ViewHolder {
        private TextView mBrand, mPrice, mCategory;
        private String key;

        public ProductitemView(ViewGroup parent) {
            super(LayoutInflater.from(mContext).
                    inflate(R.layout.product_list_item, parent, false));
            mBrand = itemView.findViewById(R.id.brand_txtView);
            mPrice = itemView.findViewById(R.id.price_txtView);
            mCategory = itemView.findViewById(R.id.category_txtView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ProductDetailsActivity.class);
                    intent.putExtra("key", key);
                    intent.putExtra("Brand", mBrand.getText().toString());
                    intent.putExtra("Price", mPrice.getText().toString());
                    intent.putExtra("Category", mCategory.getText().toString());
                    mContext.startActivity(intent);
                }
            });
        }
        //bind will receive data and set it in the variable
        public void bind(Products products, String key){
            mBrand.setText(products.getBrand());
            mPrice.setText(products.getPrice());
            mCategory.setText(products.getCategory());
            this.key = key;
        }
    }
    class ProductsAdapter extends RecyclerView.Adapter<ProductitemView>{
        private List<Products> mProductList;
        private List<String> mKeys;

        public ProductsAdapter(List<Products> mProductList, List<String> mKeys) {
            this.mProductList = mProductList;
            this.mKeys = mKeys;
        }

        @Override
        public ProductitemView onCreateViewHolder(ViewGroup parent, int ViewType) {
            return new ProductitemView(parent);
        }

        @Override
        public void onBindViewHolder(ProductitemView holder, int position) {
            holder.bind(mProductList.get(position), mKeys.get(position));
        }

        //returns the size of the product list
        @Override
        public int getItemCount() {return mProductList.size();}
    }
}
