package com.example.bm.userInterfaceJava;

public interface LoginView {
    String getUserEmail();
    void showUserEmailError (int resID);

    String getUserPass();
    void showUserPassError (int resID);

    void startHomePageAvtivity();
    void showLoginError(int resID);

    void signUpActivity();
}
