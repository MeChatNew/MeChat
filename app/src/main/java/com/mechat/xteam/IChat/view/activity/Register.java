package com.mechat.xteam.IChat.view.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.mechat.xteam.IChat.R;
import com.mechat.xteam.IChat.util.CheckLogin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity implements View.OnClickListener{
    private EditText inputEmail, inputPassword,inputRePassword;
    private Button btnRegister, btnReturnLogin;
    private ProgressBar progressBar;
    private FirebaseAuth auth;
    CheckLogin checkLogin;
    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        checkLogin=new CheckLogin();
        init();

    }

    private void init() {
        auth=FirebaseAuth.getInstance();
        inputEmail= (EditText) findViewById(R.id.edt_rgemail);
        inputPassword= (EditText) findViewById(R.id.edt_rvpass);
        inputRePassword= (EditText) findViewById(R.id.edt_rvrepass);
        btnRegister= (Button) findViewById(R.id.btn_register);
        btnReturnLogin= (Button) findViewById(R.id.btn_rg_login);
        progressBar= (ProgressBar) findViewById(R.id.rv_progressBar);
        btnRegister.setOnClickListener(this);
        btnReturnLogin.setOnClickListener(this);
    }

    private boolean validate(String inputEmail) {
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX .matcher(inputEmail);
        return matcher.find();
    }

    @Override
    public void onClick(View view) {

       switch (view.getId()){
           case R.id.btn_register:
               checkInput();

               break;
           case R.id.btn_reset_password:
               break;
           case R.id.btn_rg_login:
               finish();
               break;
       }
    }

    private void checkInput() {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();
        String repassword = inputRePassword.getText().toString().trim();
        if(!validate(email)){
            inputEmail.setError("Email không hợp lệ!");
            return;
        }
        if (TextUtils.isEmpty(email)) {
            inputEmail.setError("Không để trống email!");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            inputPassword.setError("Không để trống mật khẩu!");
            return;
        }
        if(TextUtils.isEmpty(repassword)){
            inputRePassword.setError("Không để trống mật khẩu!");
        }

        if (password.length() < 6 ||repassword.length() < 6 ) {
            inputPassword.setError("Mật khẩu lớn hơn 6 kí tự!");
            return;
        }
        if (repassword.length() < 6 ) {
            inputRePassword.setError("Mật khẩu lớn hơn 6 kí tự!");
            return;
        }
        if(!password.equals(repassword)){
            inputRePassword.setError("Mật khẩu không khớp!");
            return;
        }

//        checkLogin.checkEmail(this, email);
//        checkLogin.checkPassword(this, password);
//        checkLogin.checkRePassword(this, password, repassword);

        final ProgressDialog progressDialog = new ProgressDialog(this);
        checkLogin.showDialog(progressDialog);
////        progressBar.setVisibility(View.VISIBLE);
//        final ProgressDialog progressDialog = new ProgressDialog(Register.this);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Authenticating...");
//        progressDialog.show();
        if (email == null || email.equals("")) {
            checkLogin.hideDialog(progressDialog);

        } else {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Toast.makeText(Register.this, "Tạo tài khoản mới thành công", Toast.LENGTH_SHORT).show();
//                progressBar.setVisibility(View.GONE);
//                progressDialog.dismiss();
                    checkLogin.hideDialog(progressDialog);
                    if (!task.isSuccessful()) {
                        Toast.makeText(Register.this, "Đăng kí thất bại" + task.getException(),
                                Toast.LENGTH_SHORT).show();
                    } else {
                        startActivity(new Intent(Register.this, LoginActivity.class));
                        finish();
                    }
                }
            });
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
//        progressBar.setVisibility(View.GONE);
//        progressDialog.dismiss();

    }
}
