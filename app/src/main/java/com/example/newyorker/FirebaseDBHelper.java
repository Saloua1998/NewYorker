package com.example.newyorker;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

//This class is responsible for manipulating the database
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
        //Here we reference the node "Products" from the database and all its children
        mReferenceProducts = mDB.getReference("Products");
    }

    public void readProducts(final DataStatus dataStatus){
        //Every time you update,delete or insert data the ValueEventListener will execute OnDataChange
        mReferenceProducts.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                products.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    //The value of product is given here
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

    public void addProduct(Products products, final DataStatus dataStatus){
        String key = mReferenceProducts.push().getKey();
        mReferenceProducts.child(key).setValue(products)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsInserted();
                    }
                });
    }
    public  void updateProduct(String key, Products products, final DataStatus dataStatus){
        mReferenceProducts.child(key).setValue(products)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsUpdated();
                    }
                });
    }
    public void deleteProduct(String key, final DataStatus dataStatus){
        mReferenceProducts.child(key).setValue(null)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        dataStatus.DataIsDeleted();
                    }
                });
    }
}
