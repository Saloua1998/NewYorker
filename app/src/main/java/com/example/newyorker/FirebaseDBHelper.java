package com.example.newyorker;

import android.support.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class FirebaseDBHelper {
    private FirebaseDatabase mDB;
    private DatabaseReference mReferenceProducts;
    private List<Products> products = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Products> products, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated();
        void DataIsDeleted();
    }

    public FirebaseDBHelper() {
        mDB = FirebaseDatabase.getInstance();
        mReferenceProducts = mDB.getReference("Products");
    }

    public void readProducts(final DataStatus dataStatus){
        mReferenceProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                products.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Products product = keyNode.getValue(Products.class);
                    products.add(product);
                }
                dataStatus.DataIsLoaded(products, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
