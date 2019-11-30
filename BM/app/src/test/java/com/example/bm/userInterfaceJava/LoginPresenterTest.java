package com.example.bm.userInterfaceJava;

import com.example.bm.R;
import com.example.bm.homePageActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.security.AuthProvider;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    private LoginView view;
    @Mock
    private homePageActivity homePage;
    private LoginPresenter presenter;
    private AuthProvider service;
    //private AuthProvider validate;

    @Before
    public void setUp() throws Exception {
        presenter = new LoginPresenter(view, homePage);
    }

    @Test
    public void showErrorTxtWhenUemailIsEmpty() throws Exception{
        when(view.getUserEmail()).thenReturn ("");
        presenter.onClick();
        verify(view).showUserEmailError(R.string.useremail_error);
    }
    @Test
    public void showErrorTxtWhenUPassIsEmpty() throws Exception{
        when(view.getUserEmail()).thenReturn ("done12@gmail.com");
        when(view.getUserPass()).thenReturn ("");
        presenter.onClick();

        verify(view).showUserPassError(R.string.userpass_error);    }

    @Test
    public void startHomePageActivityWhenUNameAndPassAreCorrect() throws Exception{
        when(view.getUserEmail()).thenReturn ("done12@gmail.com");
        when(view.getUserPass()).thenReturn ("done12");
        when (homePage.login("done12@gmail.com","done12")).thenReturn(true);

        presenter.onClick();
        verify(view).startHomePageAvtivity();
    }
    @Test
    public void showLoginErrorWhenUNameAndPassInvalid() throws Exception{
        when(view.getUserEmail()).thenReturn ("done12@gmail.com");
        when(view.getUserPass()).thenReturn ("done12");
        when (homePage.login("done12@gmail.com","done12")).thenReturn(false);

        presenter.onClick();
        verify(view).showLoginError(R.string.login_failed);

    }

    @Test
    public void signupActivityPage() {
        view.signUpActivity();
        return;
    }

}