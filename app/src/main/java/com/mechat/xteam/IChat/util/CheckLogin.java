package com.mechat.xteam.IChat.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.regex.Pattern;

/**
 * Created by taipv on 11/14/2017.
 */

public class CheckLogin {
    private final Pattern VALID_EMAIL_ADDRESS_REGEX =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    Context ctx;

    public void checkEmail(Context ctx,String email){
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(ctx, "Nhập Email!", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!VALID_EMAIL_ADDRESS_REGEX.matcher(email).find()){
            Toast.makeText(ctx, "Nhập Email Sai!", Toast.LENGTH_SHORT).show();
        return;
        }

    }
        public void checkRePassword(Context ctx,String password,String repassword){

            if (TextUtils.isEmpty(password)||TextUtils.isEmpty(repassword)) {
                Toast.makeText(ctx, "Nhập mật khẩu!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.length() < 6 ||repassword.length() < 6 ) {
                Toast.makeText(ctx, "Mật khẩu phải lớn hơn 6 kí tự!", Toast.LENGTH_SHORT).show();
                return;
            }
            if(!password.equals(repassword)){
                Toast.makeText(ctx, "Mật khẩu phải giống nhau!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        public void checkPassword(Context ctx,String password){

            if (TextUtils.isEmpty(password)) {
                Toast.makeText(ctx, "Nhập mật khẩu!", Toast.LENGTH_SHORT).show();
                return;
            }

            if (password.length() < 6 ) {
                Toast.makeText(ctx, "Mật khẩu phải lớn hơn 6 kí tự!", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        public void showDialog(ProgressDialog progressDialog){
            progressDialog.setMessage("Đang tải...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        public void hideDialog(ProgressDialog progressDialog){
            progressDialog.dismiss();
        }

}
