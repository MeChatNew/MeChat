package com.mechat.xteam.IChat.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.mechat.xteam.IChat.R;

/**
*Vu Huyen
 */
public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    CallbackManager callbackManager;
    LoginButton loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton)findViewById(R.id.btnLogin);
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
//                LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile"));
                Toast.makeText(LoginActivity.this, "Login Successs", Toast.LENGTH_SHORT).show();
                goToMain();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            } });
    }

    private void goToMain() {
        startActivity(new Intent(this,MainActivity.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("Inside Fb login","on Activiry result");
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
