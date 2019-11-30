package com.example.bm.userInterfaceJava;

import com.example.bm.R;
import com.example.bm.homePageActivity;

public class LoginPresenter<loginSucceded> {
    private LoginView view;
    private homePageActivity homePage;
    //private LoginService service;
    private String userEmail;
    private String password;

    public LoginPresenter(LoginView view, homePageActivity homePage){

        this.view = view;
        this.homePage = homePage;
    }

    public void onClick() {
    String userEmail = view.getUserEmail();
    if (userEmail.isEmpty()){
        view.showUserEmailError(R.string.useremail_error);
        return;
    }
    String password = view.getUserPass();
        if (password.isEmpty()){
            view.showUserPassError(R.string.userpass_error);
            return;
        }
        view.showLoginError(R.string.login_failed);
        boolean loginSucceded = homePage.login(userEmail, password);
        if(loginSucceded){
            view.startHomePageAvtivity();
            return;
        }
    }
}
