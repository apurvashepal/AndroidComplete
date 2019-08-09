package com.example.cartapplication.UI.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cartapplication.R;
import com.example.cartapplication.UI.Activity.CartActivity;

import com.example.cartapplication.UI.Adapter.ProductAdapter;
import com.example.cartapplication.UI.Model.Product;
import com.example.cartapplication.UI.Product.IProductOperations;

import java.util.ArrayList;
import java.util.List;

public class ProductFragment extends Fragment implements IProductOperations, View.OnClickListener {
    public static final String PTAG="Product";
    TextView cartTotal;
    private List<Product> productList= new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.activity_recycler_view, container, false);

        initView(mView);

        return mView;
    }

    private void initView(View mView) {
        RecyclerView mproductList = mView.findViewById(R.id.recyclerView);
        ImageButton mShoppingCart = mView.findViewById(R.id.shoppingcart);
        mShoppingCart.setOnClickListener(this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
        mproductList.setLayoutManager(gridLayoutManager);
        ProductAdapter productAdapter = new ProductAdapter(getActivity(), getProductList());
        mproductList.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();
        cartTotal = mView.findViewById(R.id.cart_total);
        cartTotal.setVisibility(View.GONE);
    }

    private List<Product> getProductList() {

        Product product;

        product = new Product();
        product.setId(1);
        product.setImage(R.raw.powerofyoursubconciousmind);
        product.setName("Power of your subconscious mind");
        int i=200;
        product.setPrice(i);
        productList.add(product);

        product = new Product();
        product.setId(2);
        product.setImage(R.raw.everyonehasastory);
        product.setName("Everyone has a story");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setId(3);
        product.setImage(R.raw.harrypotter);
        product.setName("Harry potter");
        product.setPrice(1500);
        productList.add(product);

        product = new Product();
        product.setId(4);
        product.setImage(R.raw.lifeiswhatyoumake);
        product.setName("Life is What You Make");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setId(5);
        product.setImage(R.raw.makingindiaawsome);
        product.setName("Making India Awesome");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setId(6);
        product.setImage(R.raw.stevejobs);
        product.setName("Steve Jobs");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setId(7);
        product.setImage(R.raw.thealchemist);
        product.setName("The Alchemist");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setId(8);
        product.setImage(R.raw.thegreatindiannovel);
        product.setName("The Great Indian Novel");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setId(9);
        product.setImage(R.raw.wingsoffire);
        product.setName("Wings of Fire");
        product.setPrice(150);
        productList.add(product);

        product = new Product();
        product.setId(10);
        product.setImage(R.raw.wiseandotherwise);
        product.setName("Wise and Otherwise");
        product.setPrice(150);
        productList.add(product);

        return productList;
    }


    @Override
    public void IAddtoCart(Product product) {

        this.productList.add(product);
    }
    @Override
    public void onClick(View view) {

        ShoppingCartFragment shoppingCartFragment= new ShoppingCartFragment();
        shoppingCartFragment.setProductList(productList);
        ((CartActivity) getActivity()).loadFragment(R.id.shopview,shoppingCartFragment,"Shoppingcart",true);
    }
}
