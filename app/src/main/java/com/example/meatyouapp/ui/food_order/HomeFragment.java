package com.example.meatyouapp.ui.food_order;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.meatyouapp.Common.Common;
import com.example.meatyouapp.Common.LastOrder;
import com.example.meatyouapp.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.skydoves.powerspinner.OnSpinnerItemSelectedListener;
import com.skydoves.powerspinner.PowerSpinnerView;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HomeFragment extends Fragment {
    TextView totalPrice;
    ChipGroup spreadChipGroup;
    ChipGroup saladChipGroup;
    CheckBox riceBox,friesBox,onionRingsBox;
    EditText editTextNumOfSauces;
    RadioButton noSalad,noSpread;
    private HomeViewModel homeViewModel;
    PowerSpinnerView drinkSpinner;



    @Override

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Common.initCommon();
        final View root = inflater.inflate(R.layout.fragment_home, container, false);
        final LinearLayout steak = root.findViewById(R.id.steak);
        final LinearLayout mince = root.findViewById(R.id.mince);
        final LinearLayout lamb = root.findViewById(R.id.lamb);
        final TextView foodTv = root.findViewById(R.id.foodPrice);

        RadioGroup spreadRadioGroup = root.findViewById(R.id.spreadRadioGroup);
        spreadChipGroup = root.findViewById(R.id.spreadChipGroup);
        RadioGroup saladRadioGroup = root.findViewById(R.id.saladRadioGroup);
        saladChipGroup = root.findViewById(R.id.saladsChipGroup);
        noSpread = root.findViewById(R.id.noSpread);
        noSalad = root.findViewById(R.id.noSalad);
        final TextView textHome = root.findViewById(R.id.text_home);
        riceBox = root.findViewById(R.id.riceBox);
        friesBox = root.findViewById(R.id.friesBox);
        onionRingsBox = root.findViewById(R.id.onionRingsBox);

        editTextNumOfSauces = root.findViewById(R.id.numOfSauces);
        final LinearLayout linearLayout = root.findViewById(R.id.orderLinearLayout);
        final ScrollView scrollView = root.findViewById(R.id.scrollView);
        final LinearLayout orderBtnLayout = root.findViewById(R.id.orderBtnLayout);
        Button btnFinishOrder = root.findViewById(R.id.btnFinishOrder);
        totalPrice = root.findViewById(R.id.totalPriceTv);
        drinkSpinner = root.findViewById(R.id.drink_spinner);
        ExtrasClickListener extrasClickListener = new ExtrasClickListener();

        scrollView.setVisibility(View.GONE);
        orderBtnLayout.setVisibility(View.GONE);

        initViewsStats();

        steak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mince.isShown()){
                steak.setVisibility(View.VISIBLE);
                mince.setVisibility(View.GONE);
                lamb.setVisibility(View.GONE);
                textHome.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                orderBtnLayout.setVisibility(View.VISIBLE);
                foodTv.setText(getString(R.string.steakChoose));
                Common.totalPrice+=79;
                Common.foodChosen=getString(R.string.steak);
                }
                else {
                    mince.setVisibility(View.VISIBLE);
                    lamb.setVisibility(View.VISIBLE);
                    textHome.setVisibility(View.VISIBLE);
                    scrollView.setVisibility(View.GONE);
                    orderBtnLayout.setVisibility(View.GONE);
                    initViewsStats();
                }
                totalPrice.setText(getString(R.string.totalPrice)+ "" +Common.totalPrice);
            }
        });
        lamb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(steak.isShown()){
                steak.setVisibility(View.GONE);
                mince.setVisibility(View.GONE);
                lamb.setVisibility(View.VISIBLE);
                textHome.setVisibility(View.GONE);
                scrollView.setVisibility(View.VISIBLE);
                orderBtnLayout.setVisibility(View.VISIBLE);
                foodTv.setText(getString(R.string.lambChoose));
                Common.totalPrice+=79;
                Common.foodChosen=getString(R.string.lamb);

                }
                else
                {
                    steak.setVisibility(View.VISIBLE);
                    mince.setVisibility(View.VISIBLE);
                    textHome.setVisibility(View.VISIBLE);
                    scrollView.setVisibility(View.GONE);
                    orderBtnLayout.setVisibility(View.GONE);
                    initViewsStats();
                }
                totalPrice.setText(getString(R.string.totalPrice)+ "" + Common.totalPrice);

            }
        });
        mince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (lamb.isShown()) {
                    steak.setVisibility(View.GONE);
                    mince.setVisibility(View.VISIBLE);
                    lamb.setVisibility(View.GONE);
                    textHome.setVisibility(View.GONE);
                    scrollView.setVisibility(View.VISIBLE);
                    orderBtnLayout.setVisibility(View.VISIBLE);
                    foodTv.setText(getString(R.string.minceChoose));
                    Common.totalPrice+=55;
                    Common.foodChosen=getString(R.string.mince);

                }
                else{
                    steak.setVisibility(View.VISIBLE);
                    lamb.setVisibility(View.VISIBLE);
                    textHome.setVisibility(View.VISIBLE);
                    scrollView.setVisibility(View.GONE);
                    orderBtnLayout.setVisibility(View.GONE);
                    initViewsStats();
                }
                totalPrice.setText(getString(R.string.totalPrice)+ "" + Common.totalPrice);
            }
        });

        spreadRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId)
                {
                    case R.id.withSpread: {
                        spreadChipGroup.setVisibility(View.VISIBLE);
                        spreadChipGroup.setSelectionRequired(true);
                        Common.isSpread=true;
                        break;}
                    case R.id.noSpread:{
                        spreadChipGroup.setVisibility(View.GONE);
                        spreadChipGroup.setSelectionRequired(false);
                        Common.isSpread=false;
                        break;
                    }


                }
            }
        });
        saladRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId)
                {
                    case R.id.withSalad: {
                        saladChipGroup.setVisibility(View.VISIBLE);
                        saladChipGroup.setSelectionRequired(true);
                        Common.isSalad=true;
                        break;}
                    case R.id.noSalad:{
                        saladChipGroup.setVisibility(View.GONE);
                        saladChipGroup.setSelectionRequired(false);
                        Common.isSalad=false;
                        break;
                    }


                }
            }
        });
        riceBox.setOnClickListener(extrasClickListener);
        friesBox.setOnClickListener(extrasClickListener);
        onionRingsBox.setOnClickListener(extrasClickListener);
        editTextNumOfSauces.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override

            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                int num;
                String numOfSauce = editTextNumOfSauces.getText().toString();
                if (Common.isClicked) {
                    linearLayout.removeAllViews();
                    if (Common.numOfLastSauce >5)
                        Common.totalPrice-=(Common.numOfLastSauce -5);
                }
                try {
                    num = Integer.parseInt(numOfSauce);
                } catch (NumberFormatException e) {
                    num = 0;
                }
                if (numOfSauce.matches("[0-99]+")) {
                    for (int i = 0; i < num; i++) {
                        LayoutInflater sauceInflater = LayoutInflater.from(getActivity());
                        final LinearLayout layout = (LinearLayout) sauceInflater.inflate(R.layout.sauce_radio_group, null, false);
                        linearLayout.addView(layout);
                        Common.isSauce = true;
                    }
                }
                if (num>5)
                    Common.totalPrice+=(num-5);
                Common.numOfLastSauce =num;
                Common.isClicked=true;
                totalPrice.setText(getString(R.string.totalPrice)+ "" + Common.totalPrice);
            }
        });
        btnFinishOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showFinalOrderDialog();
                saveOrderDetails();
                moveAllDetails();
                getFragmentManager().beginTransaction().detach(HomeFragment.this).attach(HomeFragment.this).commit();
                Common.initCommon();
                initViewsStats();
            }
        });
        drinkSpinner.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener<String>() {
            @Override
            public void onItemSelected(int i, String s) {
                Common.drinkChosen=s;
            }
        });
        return root;

    }
    class ExtrasClickListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            if (((CheckBox)view).isChecked()) {
                Common.totalPrice += 13;
                Common.extras.add(((CheckBox) view).getText().toString());
            }
            else {
                Common.totalPrice -= 13;
                Common.extras.remove(((CheckBox) view).getText().toString());
            }
            totalPrice.setText(getString(R.string.totalPrice)+ "" + Common.totalPrice);


        }

    }

    private void showFinalOrderDialog() {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity(),R.style.AlertDialogCustom);
        builder.setMessage(getString(R.string.finishOrder));
        builder.setNegativeButton(getString(R.string.MyOrder),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private  void saveOrderDetails(){
        if(Common.isSpread){
        for (int i=0; i<spreadChipGroup.getChildCount();i++){
            Chip chip = (Chip)spreadChipGroup.getChildAt(i);
            if (chip.isChecked()){
                Common.spreads.add(chip.getText().toString());
            }
        }
        }
        else
            Common.spreads.add(getString(R.string.no_spread));
        if(Common.isSalad){
        for (int i=0; i<saladChipGroup.getChildCount();i++) {
            Chip chip = (Chip) saladChipGroup.getChildAt(i);
            if (chip.isChecked()) {
                Common.salads.add(chip.getText().toString());
            }
        }
        }
        else
            Common.salads.add(getString(R.string.no_salads));
        if (Common.drinkChosen.isEmpty())
            Common.drinkChosen=getString(R.string.none);

    }
    private void moveAllDetails() {
        if(LastOrder.isOrderComplete)
            clearLastOrder();
        LastOrder.foodChosen=Common.foodChosen;
        LastOrder.drinkChosen=Common.drinkChosen;
        LastOrder.totalPrice=Common.totalPrice;
        if(Common.spreads.isEmpty())
        {
            Common.spreads.add(getString(R.string.no_spread));
        }
        LastOrder.spreads.addAll(Common.spreads);
        if(Common.salads.isEmpty())
        {
            Common.salads.add(getString(R.string.no_salads));
        }
        LastOrder.salads.addAll(Common.salads);
        if(Common.extras.isEmpty())
        {
            Common.extras.add(getString(R.string.no_extras));
        }
        LastOrder.extras.addAll(Common.extras);
        LastOrder.sauceNumber = Common.numOfLastSauce;
        LastOrder.isOrderComplete =true;

        }
    private void clearLastOrder() {
        LastOrder.spreads.clear();
        LastOrder.salads.clear();
        LastOrder.extras.clear();
    }

    private void initViewsStats() {
        {
            riceBox.setChecked(false);
            friesBox.setChecked(false);
            onionRingsBox.setChecked(false);
            noSalad.setChecked(true);
            noSpread.setChecked(true);
            editTextNumOfSauces.setText("");
            drinkSpinner.clearSelectedItem();
            Common.initFoodChoic();


        }
    }

}