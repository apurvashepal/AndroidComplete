package com.example.cartapplication.UI.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartapplication.R;
import com.example.cartapplication.UI.Fragment.ProductFragment;
import com.example.cartapplication.UI.Model.Cart;
import com.example.cartapplication.UI.Model.Product;
import com.example.cartapplication.UI.Product.IProductOperations;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<Product> productList;
    private Product currentProduct;
    public CardView cardView;
    Cart cart;
    public  List<Cart> cartList= new ArrayList<>();;
    private IProductOperations productAddListener;
    private static final int HEADER_VIEW = 1001;
    private static final int CARD_VIEW = 1002;

    public View view;

    public ProductAdapter(Context context, List<Product> productList) {
        mContext = context;
        this.productList = productList;

        if (this.productList == null) {
            this.productList = new ArrayList<>();
        }
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view = LayoutInflater.from(mContext).inflate(R.layout.grid_view_layout, parent, false);

        return new ProductViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final Product product = productList.get(position);
        if (holder instanceof ProductViewHolder) {
            final ProductViewHolder productHolder = (ProductViewHolder) holder;

            productHolder.prodImage.setImageResource(product.getImage());
            productHolder.prodName.setText(product.getName());
            String s = Integer.toString(product.getPrice());
            productHolder.prodPrice.setText(s);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Product productAdd =productList.get(position);
                    productAddListener= new ProductFragment();
                    productAddListener.IAddtoCart(productAdd);
                    productList.add(product);
                    //Toast.makeText(mContext, "You have clicked" + product.getName() , Toast.LENGTH_SHORT).show();

                }
            });

        }
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    @Override
    public void onClick(View view) {

    }


    public class ProductViewHolder extends RecyclerView.ViewHolder  {
        ImageView prodImage;
        TextView prodName;
        TextView prodPrice;
        Toolbar toolbar;
        ImageButton shoppingCart;
        public Product currentProduct;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            prodImage = itemView.findViewById(R.id.c_icon);
            prodName =  itemView.findViewById(R.id.c_name);
            prodPrice = itemView.findViewById(R.id.c_price);
            cardView =  itemView.findViewById(R.id.cart_item);
            toolbar = itemView.findViewById(R.id.toolbar);

        }


    }

    public void setProductAddListener(IProductOperations productAddListener) {
        this.productAddListener = productAddListener;

    }
}