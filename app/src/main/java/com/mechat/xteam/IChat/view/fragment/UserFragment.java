package com.mechat.xteam.IChat.view.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.mechat.xteam.IChat.R;
import com.mechat.xteam.IChat.util.CheckLogin;
import com.mechat.xteam.IChat.view.activity.LoginActivity;

import static android.content.ContentValues.TAG;

/**
 * Created by it-36 on 10/27/17.
 */

public class UserFragment extends Fragment implements View.OnClickListener {
    Button btnSignOut,btnChangePassword,btnChangeSub;
    FirebaseAuth auth;
    private Dialog dialog;
    FirebaseUser user;
    EditText edtEmailChange,edtPassOld,edtPassNew;
    public static UserFragment newInstance() {

        Bundle args = new Bundle();

        UserFragment fragment = new UserFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.roomchat, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        auth=FirebaseAuth.getInstance();

        btnSignOut= (Button) view.findViewById(R.id.btn_sign_out);
        btnSignOut.setOnClickListener(this);
        btnChangePassword= (Button) view.findViewById(R.id.btn_changepassword);
        btnChangePassword.setOnClickListener(this);
    }
    public void signOut(){
        auth.signOut();
    }

    // this listener will be called when there is change in firebase user session
    FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser user = firebaseAuth.getCurrentUser();
            if (user == null) {
                // user auth state is changed - user is null
                // launch login activity
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
            }
        }
    };

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_sign_out:
                Log.d(TAG, "onClick: ");
                Toast.makeText(getActivity(), "xxx", Toast.LENGTH_SHORT).show();
                signOut();
                getActivity().startActivity(new Intent(getContext(),LoginActivity.class));
                break;
            case R.id.btn_changepassword:
                dialog = new Dialog(getActivity());
                // khởi tạo dialog
                dialog.setContentView(R.layout.dialog_custom);
                //set chiều dài chiều rộng cho dialog
                WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
                lp.copyFrom(dialog.getWindow().getAttributes());
                lp.width = WindowManager.LayoutParams.MATCH_PARENT;
                dialog.show();
                dialog.getWindow().setAttributes(lp);
                // xét layout cho dialog
                // xét tiêu đề cho dialog
                edtEmailChange= (EditText) dialog.findViewById(R.id.edt_emailchane);
                edtPassNew= (EditText) dialog.findViewById(R.id.edt_pass_new);
                edtPassOld= (EditText) dialog.findViewById(R.id.edt_pass_old);

                 btnChangeSub = (Button) dialog.findViewById(R.id.btn_changesubmit);
                // khai báo control trong dialog để bắt sự kiện
                btnChangeSub.setOnClickListener(this);
                // bắt sự kiện cho nút đăng kí
                dialog.show();
                // hiển thị dialog
                break;
            case R.id.btn_changesubmit:
                final CheckLogin checkLogin=new CheckLogin();
                final ProgressDialog progressDialog=new ProgressDialog(getActivity());
                checkLogin.showDialog(progressDialog);
                String email=edtEmailChange.getText().toString().trim();
                final String passnew=edtPassNew.getText().toString().trim();
                String passold=edtPassOld.getText().toString().trim();

                if(email.equals("")|passnew.equals("")|passold.equals("")){
                    Toast.makeText(getActivity(), "Không được để trống", Toast.LENGTH_SHORT).show();
                    checkLogin.hideDialog(progressDialog);
//                    return;
                }else {
                    user = FirebaseAuth.getInstance().getCurrentUser();

// Get auth credentials from the user for re-authentication. The example below shows
// email and password credentials but there are multiple possible providers,
// such as GoogleAuthProvider or FacebookAuthProvider.
                    AuthCredential credential = EmailAuthProvider
                            .getCredential(email, passold);

// Prompt the user to re-provide their sign-in credentials
                    user.reauthenticate(credential)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        user.updatePassword(passnew).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {
                                                    Toast.makeText(getActivity(), "Đổi mật khẩu thành công!", Toast.LENGTH_SHORT).show();
                                                    checkLogin.hideDialog(progressDialog);
                                                    dialog.dismiss();
                                                } else {
                                                    Toast.makeText(getActivity(), "Đổi mật khẩu thất bại!", Toast.LENGTH_SHORT).show();
                                                }
                                            }
                                        });
                                    } else {
                                        Log.d(TAG, "Có lỗi xảy ra!Hmm...");
                                    }
                                }
                            });
                }
                break;
        }
    }
}
