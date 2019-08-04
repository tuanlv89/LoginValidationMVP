package com.application.tuanlv.loginmvp.Model;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser {

    private String email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public int isValidData() {
        //0.Check email is empty
        //1.Check email is matches pattern
        //2.Check password length > 0
        if(TextUtils.isEmpty(getEmail()))
            return 0;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return 1;
        else if(getPassword().length()<6)
            return 2;
        else
            return -1;
    }

    /*@Override
    public boolean isValidData() {
        //1.Check email is empty
        //2.Check email is matches pattern
        //3.Check password length > 0
        return !TextUtils.isEmpty(getEmail()) &&
                Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches() &&
                getPassword().length() > 6;
    }*/
}
