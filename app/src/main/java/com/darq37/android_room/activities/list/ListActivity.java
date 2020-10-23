package com.darq37.android_room.activities.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.darq37.android_room.MainActivity;
import com.darq37.android_room.R;
import com.darq37.android_room.activities.product.ProductActivity;
import com.darq37.android_room.activities.product.ProductAdapter;
import com.darq37.android_room.database.RoomConstant;
import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button addProductButton = findViewById(R.id.goToProductActivity);

        RecyclerView productRV = findViewById(R.id.productListView);
        RecyclerView shoppingListRV = findViewById(R.id.shoppingListsView);

        productRV.setHasFixedSize(true);
        shoppingListRV.setHasFixedSize(true);

        productRV.setLayoutManager(new LinearLayoutManager(this));
        shoppingListRV.setLayoutManager(new LinearLayoutManager(this));

        ProductAdapter productAdapter =  new ProductAdapter(RoomConstant.getInstance(this).productDao().getAllSync());
        ShoppingListAdapter shoppingListAdapter = new ShoppingListAdapter(RoomConstant.getInstance(this).shoppingListDao().getAllSync());

        productRV.setAdapter(productAdapter);
        shoppingListRV.setAdapter(shoppingListAdapter);

        addProductButton.setOnClickListener(this::goToProductActivity);
    }

    public void goToProductActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), ProductActivity.class);
        startActivity(intent);
    }
}