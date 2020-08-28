package com.example.meatyouapp.Common;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class Common {
    public static String name,phone,address;
    public  static boolean loggedIn=false;
    public static int numOfLastSauce=0;
    public static boolean isClicked=false;
    public static  int totalPrice=0;
    public static String foodChosen;
    public static String drinkChosen;

    public static boolean isSpread=false;
    public static boolean isSalad=false;
    public static boolean isSauce = false;

    public static List<String> salads= new ArrayList<String>();
    public static List<String> spreads= new ArrayList<String>();
    public static List<String> extras= new ArrayList<String>();


    public static void initFoodChoic(){
        Common.totalPrice=0;
        Common.isSauce=false;
        Common.isSalad=false;
        Common.isClicked=false;
        Common.isSpread=false;
        Common.numOfLastSauce=0;
        Common.foodChosen="";
        Common.drinkChosen="";
        Common.extras.clear();
    }
    public static void initCommon(){
        Common.totalPrice=0;
        Common.isSauce=false;
        Common.isSalad=false;
        Common.isClicked=false;
        Common.isSpread=false;
        Common.extras.clear();
        Common.salads.clear();
        Common.spreads.clear();
        Common.numOfLastSauce=0;
        Common.foodChosen="";
        Common.drinkChosen="";
    }
}
