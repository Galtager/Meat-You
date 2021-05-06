package com.example.meatyouapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.meatyouapp.Common.User;
import com.google.android.material.chip.Chip;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnLogin,btnLanguage;
    User user=User.getUser();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLanguage = findViewById(R.id.btnLanguage);
        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLoginDialog();
            }
        });
        btnLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLanguageDialog();
            }
        });


    }

    private void restartActivity() {
            Intent intent = getIntent();
            finish();
            startActivity(intent);
        }

    private void showLanguageDialog() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this,R.style.AlertDialogCustom);
        View itemView= LayoutInflater.from(this).inflate(R.layout.layout_language_chooser,null);
        builder.setView(itemView);
        final AlertDialog dialog = builder.create();
        Chip hebrewChip = (Chip)itemView.findViewById(R.id.hebrewChip);
        Chip englishChip =(Chip)itemView.findViewById(R.id.englishChip);

        hebrewChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAppLocale("iw");
                dialog.dismiss();
                restartActivity();
            }
        });
        englishChip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setAppLocale("en");
                dialog.dismiss();
                restartActivity();
            }
        });
        dialog.show();
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(user.getLoggedIn())
            gotoHomeActivity();
    }

    private void showLoginDialog() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this,R.style.AlertDialogCustom);
        builder.setTitle(getString(R.string.login));
        View itemView= LayoutInflater.from(this).inflate(R.layout.layout_login,null);
        final MaterialEditText edt_name = (MaterialEditText)itemView.findViewById(R.id.edtName);
        final MaterialEditText edt_address = (MaterialEditText)itemView.findViewById(R.id.edtAddress);
        final MaterialEditText edt_phone = (MaterialEditText)itemView.findViewById(R.id.edtPhone);

        builder.setView(itemView);
        builder.setNegativeButton(getString(R.string.cancel),new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.setPositiveButton(getString(R.string.loginBtn), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(TextUtils.isEmpty(edt_name.getText().toString())) {
                    Toast.makeText(MainActivity.this, getString(R.string.enterName), Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(edt_address.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, getString(R.string.enterAddress), Toast.LENGTH_SHORT).show();
                    return;
                }
                else if(TextUtils.isEmpty(edt_phone.getText().toString()))
                {
                    Toast.makeText(MainActivity.this, getString(R.string.enterPhone), Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(MainActivity.this, getString(R.string.loginSuccess), Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
                user.setLoggedIn(true);
                gotoHomeActivity(edt_name.getText().toString(),edt_address.getText().toString(),edt_phone.getText().toString());
            }
        });
        builder.setView(itemView);
        AlertDialog dialog = builder.create();
        dialog.show();
    }
    private void gotoHomeActivity(String currentName,String currentAddress,String currentPhone) {
        user.setName(currentName);
        user.setAddress(currentAddress);
        user.setPhone(currentPhone);
        startActivity(new Intent(MainActivity.this,Home.class));
        finish();
    }
    private void gotoHomeActivity(){
        startActivity(new Intent(MainActivity.this,Home.class));
        finish();
    }
    private void setAppLocale(String localeCode){
        Resources resources = getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.JELLY_BEAN_MR1){
            configuration.setLocale(new Locale(localeCode.toLowerCase()));
        }
        else {
            configuration.locale = new Locale(localeCode.toLowerCase());
        }
        resources.updateConfiguration(configuration,displayMetrics);
        }
    }
