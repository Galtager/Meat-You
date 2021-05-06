package com.example.meatyouapp.Common;


import java.util.ArrayList;
import java.util.List;

public class NewOrder {
    private static NewOrder newOrder=null;
    private NewOrder(){ }
    public static NewOrder getNewOrder(){
        if(newOrder==null){
            newOrder= new NewOrder();
        }
        return newOrder;
    }

    private  int numOfLastSauce=0;
    private  int totalPrice=0;
    private  String foodChosen;
    private  String drinkChosen;

    private  boolean isSpread=false;
    private  boolean isSalad=false;
    private  boolean isSauce = false;
    private  boolean isClicked=false;

    private static List<String> salads= new ArrayList<String>();
    private static List<String> spreads= new ArrayList<String>();
    private static List<String> extras= new ArrayList<String>();

    public int getNumOfLastSauce() {
        return numOfLastSauce;
    }
    public void setNumOfLastSauce(int numOfLastSauce) {
        this.numOfLastSauce = numOfLastSauce;
    }
    public int getTotalPrice() {
        return totalPrice;
    }
    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }
    public String getFoodChosen() {
        return foodChosen;
    }
    public void setFoodChosen(String foodChosen) {
        this.foodChosen = foodChosen;
    }
    public String getDrinkChosen() {
        return drinkChosen;
    }
    public void setDrinkChosen(String drinkChosen) {
        this.drinkChosen = drinkChosen;
    }
    public boolean getIsSpread(){
        return isSpread;
    }
    public void setIsSpread(boolean spread) {
        isSpread = spread;
    }
    public boolean getIsSauce(){
        return isSauce;
    }
    public void setisSauce(boolean sauce) {
        isSauce = sauce;
    }
    public boolean getIsSalad(){
        return isSalad;
    }
    public void setIsSalad(boolean salad) {
        isSalad = salad;
    }
    public boolean getIsClicked(){
        return newOrder.isClicked;
    }
    public void setIsClicked(boolean clicked) {
        newOrder.isClicked = clicked;
    }


    public static void setSpreads(String spreads) {
        newOrder.spreads.add(spreads);
    }

    public static void setSalads(String salads) {
        newOrder.salads.add(salads);
    }

    public static void setExtras(String extras) {
        newOrder.extras.add(extras);
    }
    public static void deleteExtra(String element){
        newOrder.extras.remove(element);
    }

    public static List<String> getSpreads() {
        return spreads;
    }

    public static List<String> getSalads() {
        return salads;
    }

    public static List<String> getExtras() {
        return extras;
    }

    public static void initFoodChoic(){
        newOrder.totalPrice=0;
        newOrder.isSauce=false;
        newOrder.isSalad=false;
        newOrder.isClicked=false;
        newOrder.isSpread=false;
        newOrder.numOfLastSauce=0;
        newOrder.foodChosen="";
        newOrder.drinkChosen="";
        newOrder.extras.clear();
    }
    public static void initCommon(){
        newOrder.totalPrice=0;
        newOrder.isSauce=false;
        newOrder.isSalad=false;
        newOrder.isClicked=false;
        newOrder.isSpread=false;
        newOrder.extras.clear();
        newOrder.salads.clear();
        newOrder.spreads.clear();
        newOrder.numOfLastSauce=0;
        newOrder.foodChosen="";
        newOrder.drinkChosen="";
    }
}
