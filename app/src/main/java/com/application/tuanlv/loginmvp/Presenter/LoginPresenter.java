package com.application.tuanlv.loginmvp.Presenter;

import com.application.tuanlv.loginmvp.Model.User;
import com.application.tuanlv.loginmvp.View.ILoginView;

public class LoginPresenter implements ILoginPresenter {

    ILoginView iLoginView;

    public LoginPresenter(ILoginView iLoginView) {
        this.iLoginView = iLoginView;
    }

    @Override
    public void onLogin(String email, String password) {
        User user = new User(email, password);
        int loginCode = user.isValidData();

        if(loginCode==0)
            iLoginView.onLoginError("You must enter your email!");
        else if(loginCode == 1)
            iLoginView.onLoginError("You must enter valid email!");
        else if(loginCode == 2)
            iLoginView.onLoginError("Password length must be greater than 6!");
        else
            iLoginView.onLoginSuccess("Login success!");
    }
}
