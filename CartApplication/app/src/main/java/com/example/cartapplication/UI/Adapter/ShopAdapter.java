package com.example.cartapplication.UI.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartapplication.R;
import com.example.cartapplication.UI.Model.Cart;
import com.example.cartapplication.UI.Model.Product;

import java.util.ArrayList;
import java.util.List;


public class ShopAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context mContext;
    int counter;
    private List<Cart> shopList;
    TextView textView;
    public ShopAdapter(Context context, List<Cart> productList) {
        mContext = context;
        this.shopList = productList;

        if (this.shopList == null) {
            this.shopList = new ArrayList<>();
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.card_layout, parent, false);

        return new ShopAdapter.ShopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            final Cart product=shopList.get(position);

            Product prod = product.getProduct();
            if(holder instanceof ShopViewHolder){
            final ShopViewHolder shopViewHolder = (ShopViewHolder) holder;
            shopViewHolder.bookImage.setImageResource(prod.getImage());
            shopViewHolder.bookName.setText(prod.getName());
            String price = Integer.toString(prod.getPrice());
            shopViewHolder.bookPrice.setText(price);
            shopViewHolder.bookQuantity.setText(Integer.toString(product.getQuantity()));
            int total = getTotal(product.getQuantity(),prod.getPrice());
            shopViewHolder.totalPrice.setText(Integer.toString(total));

        }
    }



    private int getTotal(int quantity,int price) {

        return  quantity*price;
    }
    public int getCartTotal(List<Cart> cartList) {
        int cartTotal=0;

        for(Cart cartitem: cartList) {
            Product cartProduct =cartitem.getProduct();
            cartTotal = cartTotal+ getTotal(cartitem.getQuantity(),cartProduct.getPrice());
        }
        return cartTotal;

    }

    @Override
    public int getItemCount() {
        return this.shopList.size() ;
    }

    private class ShopViewHolder extends RecyclerView.ViewHolder {
        ImageView bookImage;
        TextView bookName;
        TextView bookPrice;
        TextView bookQuantity;
        TextView totalPrice;

        public ShopViewHolder(View view) {
            super(view);
            bookImage = view.findViewById(R.id.b_icon);
            bookName= view.findViewById(R.id.b_name);
            bookPrice= view.findViewById(R.id.b_price);
            bookQuantity =  view.findViewById(R.id.b_quantity);
            totalPrice= view.findViewById(R.id.b_price_total);

        }
    }
}
