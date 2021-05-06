package com.example.meatyouapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.meatyouapp.Common.LastOrder;
import com.example.meatyouapp.Common.User;
import com.example.meatyouapp.R;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        LinearLayout statusLinearlayout = root.findViewById(R.id.statusLinearlayout);
        TextView orderStatusTV = root.findViewById(R.id.orderSatus);
        TextView name = root.findViewById(R.id.name);
        TextView phoneNumber = root.findViewById(R.id.phoneNumber);
        TextView address = root.findViewById(R.id.address);
        TextView finalFood = root.findViewById(R.id.finalFood);
        TextView finalSpreads = root.findViewById(R.id.finalSpreads);
        TextView finalSalads = root.findViewById(R.id.finalSalads);
        TextView finalExtras = root.findViewById(R.id.finalExtras);
        TextView finalSauce = root.findViewById(R.id.finalSauce);
        TextView finalPrice = root.findViewById(R.id.finalPrice);
        TextView finalDrink = root.findViewById(R.id.finalDrink);
        LastOrder lastOrder=LastOrder.getLastOrder();
        User user=User.getUser();

        if(!lastOrder.getOrderFinishState()) {
            statusLinearlayout.setVisibility(View.GONE);
            orderStatusTV.setText(getString(R.string.none_ordering_meatyou));
        }
        else
        {
            name.setText(getString(R.string.final_name)+ "" + user.getName());
            phoneNumber.setText(getString(R.string.final_phone_number)+ "" + user.getPhone());
            address.setText(getString(R.string.final_address)+ "" + user.getAddress());

            finalFood.setText(getString(R.string.final_typeOfFood)+ " " + lastOrder.getFoodChosen());
            finalSpreads.setText(getString(R.string.final_spreads)+ " " + lastOrder.getSpreads());
            finalSalads.setText(getString(R.string.final_salads)+ " " + lastOrder.getSalads());
            finalExtras.setText(getString(R.string.final_extras)+ " " + lastOrder.getExtras());
            finalSauce.setText(lastOrder.getSauceNumber() + " " +getString(R.string.final_number_sauces));
            finalPrice.setText(getString(R.string.final_price)+ " " + lastOrder.getTotalPrice());
            finalDrink.setText(getString(R.string.final_drinks)+ " " + lastOrder.getDrinkChosen());
        }

        return root;
    }
}