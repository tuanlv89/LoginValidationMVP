package com.application.tuanlv.loginmvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.application.tuanlv.loginmvp.Presenter.ILoginPresenter;
import com.application.tuanlv.loginmvp.Presenter.LoginPresenter;
import com.application.tuanlv.loginmvp.View.ILoginView;

import es.dmoral.toasty.Toasty;

public class MainActivity extends AppCompatActivity implements ILoginView {
    EditText edtEmail, edtPassword;
    Button btnLogin;

    ILoginPresenter loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Init view
        initView();

        // Init
        loginPresenter = new LoginPresenter(this);
        // Event
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edtEmail.getText().toString();
                String password = edtPassword.getText().toString();
                loginPresenter.onLogin(email, password);
            }
        });

    }



    private void initView() {
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
    }


    @Override
    public void onLoginSuccess(String message) {
        Toasty.success(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginError(String message) {
        Toasty.error(this, message, Toast.LENGTH_SHORT).show();
    }
}
