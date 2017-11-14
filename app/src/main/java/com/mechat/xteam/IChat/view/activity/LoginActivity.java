package com.mechat.xteam.IChat.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mechat.xteam.IChat.R;
import com.mechat.xteam.IChat.util.CheckLogin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
*Vu Huyen
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    Button btnLogin;
    Button btnRegister,btnResetPass;
    CallbackManager callbackManager;
    LoginButton loginButton;
    EditText inputEmail,inputPassword;
    FirebaseAuth auth;
    CheckLogin checkLogin;
    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_login);
        auth=FirebaseAuth.getInstance();
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }
        callbackManager = CallbackManager.Factory.create();
        btnLogin= (Button) findViewById(R.id.btn_login);
        btnRegister= (Button) findViewById(R.id.btnRegister);
        btnResetPass= (Button) findViewById(R.id.btn_reset_password);
        btnRegister.setOnClickListener(this);
        btnResetPass.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        inputEmail= (EditText) findViewById(R.id.input_email);
        inputPassword= (EditText) findViewById(R.id.input_password);
        loginButton = (LoginButton)findViewById(R.id.btnLogin);
        checkLogin=new CheckLogin();
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

    @Override
    public void onClick(View view) {
        if(view==btnRegister){
            goToRegister();
        }if(view==btnResetPass){
            goToReset();
        }if(view==btnLogin){
            goToLogin();
        }
    }

    private void goToLogin() {
        String email = inputEmail.getText().toString().trim();
        final String password = inputPassword.getText().toString().trim();
        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
//                        progressBar.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            // there was an error
                            if (password.length() < 6) {
                                inputPassword.setError(getString(R.string.minimum_password));
                            } else {
                                Toast.makeText(LoginActivity.this, getString(R.string.auth_failed), Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }

    private void goToReset() {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        if(!validate(email)){
            Toast.makeText(getApplicationContext(), "Email không hợp lệ!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Nhập Email!", Toast.LENGTH_SHORT).show();
            return;
        }
        final ProgressDialog progressDialog = new ProgressDialog(this);
        checkLogin.showDialog(progressDialog);
        if (email == null || email.equals("")) {
            Toast.makeText(this, "xxx", Toast.LENGTH_SHORT).show();
            checkLogin.hideDialog(progressDialog);

        }else {
            auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(LoginActivity.this, "Khôi phục mật khẩu thành công!", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(LoginActivity.this, "Khôi phục mật khẩu thất bại!", Toast.LENGTH_SHORT).show();
                            }
                            checkLogin.hideDialog(progressDialog);
                        }
                    });
        }
    }

    private void goToRegister() {
        startActivity(new Intent(LoginActivity.this,Register.class));
    }
    private boolean validate(String inputEmail) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(inputEmail);
        return matcher.find();
    }
}
