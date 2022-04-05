package com.example.scholarlysavings;

import com.parse.ParseClassName;
import com.parse.ParseFile;
import com.parse.ParseObject;
import com.parse.ParseUser;

@ParseClassName("User")
public class UserInfo extends ParseObject{
    public static final String KEY_NAME = "Name";
    public static final String KEY_PHONE = "Phone";
    public static final String KEY_COLLEGE = "College";
    public static final String KEY_INCOME = "Income";
    public static final String KEY_EXPENSES = "Expenses";
    public static final String KEY_BALANCE = "Balance";
    public static final String KEY_PASSWORD = "Password";
    public static final String KEY_EMAIL = "Email";
    public static final String KEY_IMAGE = "Image";
    public static final String KEY_USER = "User";

    public void setName(String name) {
            put(KEY_NAME, name);
        }

    public String getName() {return getString(KEY_NAME); }

    public void setCollege(String college) { put(KEY_COLLEGE, college); }

    public String getCollege() {return getString(KEY_COLLEGE); }

    public void setPhone(String phone) { put(KEY_PHONE, phone); }

    public String getPhone() {return getString(KEY_PHONE); }

    public void setIncome(String income) { put(KEY_INCOME, income); }

    public String getIncome() {return getString(KEY_INCOME); }

    public void setExpenses(String expenses) { put(KEY_EXPENSES, expenses); }

    public String getExpenses() {return getString(KEY_EXPENSES); }

    public void setBalance(String balance) { put(KEY_BALANCE, balance); }

    public String getBalance() {return getString(KEY_BALANCE); }

    public void setPassword(String password) { put(KEY_PASSWORD, password); }

    public String getPassword() {return getString(KEY_PASSWORD); }

    public void setEmail(String email) { put(KEY_EMAIL, email); }

    public String getEmail() {return getString(KEY_EMAIL); }

    public ParseFile getImage() { return getParseFile(KEY_IMAGE); }

    public void setImage(ParseFile parsefile) { put(KEY_IMAGE, parsefile); }

    public ParseUser getUser(){
        return  getParseUser(KEY_USER);
    }

    public void setUser (ParseUser user){
        put(KEY_USER, user);
    }

}
