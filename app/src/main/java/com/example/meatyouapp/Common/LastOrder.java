package com.example.meatyouapp.Common;

import java.util.ArrayList;
import java.util.List;

public class LastOrder {
    private static LastOrder lastOrder=null;
    private LastOrder() {}
    public static LastOrder getLastOrder()
    {
        if(lastOrder==null)
        {
            lastOrder= new LastOrder();
        }
        return lastOrder;
    }

    private static int sauceNumber=0;
    private static boolean isOrderComplete=false;
    private static  int totalPrice=0;
    private static String foodChosen;
    private static String drinkChosen;

    private static List<String> salads= new ArrayList<String>();
    private static List<String> spreads= new ArrayList<String>();
    private static List<String> extras= new ArrayList<String>();

    public static int getSauceNumber() {
        return lastOrder.sauceNumber;
    }

    public static void setSauceNumber(int sauceNumber) {
        lastOrder.sauceNumber = sauceNumber;
    }

    public static int getTotalPrice() {
        return lastOrder.totalPrice;
    }

    public static void setTotalPrice(int totalPrice) {
        lastOrder.totalPrice = totalPrice;
    }

    public static String getDrinkChosen() {
        return lastOrder.drinkChosen;
    }

    public static void setDrinkChosen(String drinkChosen) {
        lastOrder.drinkChosen = drinkChosen;
    }

    public static String getFoodChosen() {
        return lastOrder.foodChosen;
    }

    public static void setFoodChosen(String foodChosen) {
        lastOrder.foodChosen = foodChosen;
    }



    public static List<String> getExtras() {
        return lastOrder.extras;
    }
    public static void setExtras(List<String> extras) {
        lastOrder.extras.addAll(extras) ;
    }
    public static List<String> getSalads() {
        return lastOrder.salads;
    }
    public static void setSalads(List<String> salads) {
        lastOrder.salads.addAll(salads);
    }
    public static List<String> getSpreads() {
        return lastOrder.spreads;
    }
    public static void setSpreads(List<String> spreads) {
        lastOrder.spreads.addAll(spreads);
    }
    public void clearLists(){
        spreads.clear();
        salads.clear();
        extras.clear();

    }


    public static boolean getOrderFinishState(){
        return lastOrder.isOrderComplete;
    }

    public static void setIsOrderComplete(boolean isOrderComplete) {
        lastOrder.isOrderComplete = isOrderComplete;
    }
}

