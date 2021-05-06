package com.example.meatyouapp.Common;

public class User {
    private static User user=null;
    private User(){ }
    public static User getUser(){
        if(user==null){
            user= new User();
        }
        return user;
    }
    private static String name,phone,address;
    private   static boolean loggedIn=false;

    public static String getAddress() {
        return user.address;
    }

    public static void setAddress(String address) {
        user.address = address;
    }

    public static String getName() {
        return user.name;
    }

    public static void setName(String name) {
        user.name = name;
    }

    public static String getPhone() {
        return user.phone;
    }

    public static void setPhone(String phone) {
        user.phone = phone;
    }
    public static Boolean getLoggedIn(){
        return user.loggedIn;
    }

    public static void setLoggedIn(boolean loggedIn) {
        user.loggedIn = loggedIn;
    }
}
