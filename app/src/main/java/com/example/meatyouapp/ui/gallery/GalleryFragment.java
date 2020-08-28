package com.example.meatyouapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.meatyouapp.Common.Common;
import com.example.meatyouapp.Common.LastOrder;
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

        if(!LastOrder.isOrderComplete) {
            statusLinearlayout.setVisibility(View.GONE);
            orderStatusTV.setText(getString(R.string.none_ordering_meatyou));
        }
        else
        {
            name.setText(getString(R.string.final_name)+ "" + Common.name);
            phoneNumber.setText(getString(R.string.final_phone_number)+ "" + Common.phone);
            address.setText(getString(R.string.final_address)+ "" + Common.address);

            finalFood.setText(getString(R.string.final_typeOfFood)+ " " + LastOrder.foodChosen);
            finalSpreads.setText(getString(R.string.final_spreads)+ " " + LastOrder.spreads);
            finalSalads.setText(getString(R.string.final_salads)+ " " + LastOrder.salads);
            finalExtras.setText(getString(R.string.final_extras)+ " " + LastOrder.extras);
            finalSauce.setText(LastOrder.sauceNumber + " " +getString(R.string.final_number_sauces));
            finalPrice.setText(getString(R.string.final_price)+ " " + LastOrder.totalPrice);
            finalDrink.setText(getString(R.string.final_drinks)+ " " + LastOrder.drinkChosen);
        }

        return root;
    }
}