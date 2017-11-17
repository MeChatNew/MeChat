//package com.mechat.xteam.IChat.adapter;
//
//import android.content.DialogInterface;
//import android.support.annotation.NonNull;
//import android.support.v7.app.AlertDialog;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.google.android.gms.tasks.OnCompleteListener;
//import com.google.android.gms.tasks.OnFailureListener;
//import com.google.android.gms.tasks.Task;
//import com.google.firebase.auth.FirebaseAuth;
//import com.mechat.xteam.IChat.R;
//import com.mechat.xteam.IChat.model.entity.Configuration;
//import com.mechat.xteam.IChat.model.entity.data.SharedPreferenceHelper;
//
//import java.util.List;
//
//import static java.security.AccessController.getContext;
//
///**
// * Created by taipv on 11/16/2017.
// */
//
//public class UserInfoAdapter extends RecyclerView.Adapter<UserInfoAdapter.ViewHolder>{
//    private List<Configuration> profileConfig;
//
//    public UserInfoAdapter(List<Configuration> profileConfig){
//        this.profileConfig = profileConfig;
//    }
//
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.list_info_item_layout, parent, false);
//        return new ViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(ViewHolder holder, int position) {
//        final Configuration config = profileConfig.get(position);
//        holder.label.setText(config.getLabel());
//        holder.value.setText(config.getValue());
//        holder.icon.setImageResource(config.getIcon());
//        ((RelativeLayout)holder.label.getParent()).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(config.getLabel().equals(SIGNOUT_LABEL)){
//                    FirebaseAuth.getInstance().signOut();
//                    FriendDB.getInstance(getContext()).dropDB();
//                    GroupDB.getInstance(getContext()).dropDB();
//                    ServiceUtils.stopServiceFriendChat(getContext().getApplicationContext(), true);
//                    getActivity().finish();
//                }
//
//                if(config.getLabel().equals(USERNAME_LABEL)){
//                    View vewInflater = LayoutInflater.from(context)
//                            .inflate(R.layout.dialog_edit_username,  (ViewGroup) getView(), false);
//                    final EditText input = (EditText)vewInflater.findViewById(R.id.edit_username);
//                    input.setText(myAccount.name);
//                        /*Hiển thị dialog với dEitText cho phép người dùng nhập username mới*/
//                    new AlertDialog.Builder(context)
//                            .setTitle("Edit username")
//                            .setView(vewInflater)
//                            .setPositiveButton("Save", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    String newName = input.getText().toString();
//                                    if(!myAccount.name.equals(newName)){
//                                        changeUserName(newName);
//                                    }
//                                    dialogInterface.dismiss();
//                                }
//                            })
//                            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialogInterface.dismiss();
//                                }
//                            }).show();
//                }
//
//                if(config.getLabel().equals(RESETPASS_LABEL)){
//                    new AlertDialog.Builder(context)
//                            .setTitle("Password")
//                            .setMessage("Are you sure want to reset password?")
//                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    resetPassword(myAccount.email);
//                                    dialogInterface.dismiss();
//                                }
//                            })
//                            .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
//                                @Override
//                                public void onClick(DialogInterface dialogInterface, int i) {
//                                    dialogInterface.dismiss();
//                                }
//                            }).show();
//                }
//            }
//        });
//    }
//
//    /**
//     * Cập nhật username mới vào SharedPreference và thay đổi trên giao diện
//     */
//    private void changeUserName(String newName){
//        userDB.child("name").setValue(newName);
//
//
//        myAccount.name = newName;
//        SharedPreferenceHelper prefHelper = SharedPreferenceHelper.getInstance(context);
//        prefHelper.saveUserInfo(myAccount);
//
//        tvUserName.setText(newName);
//        setupArrayListInfo(myAccount);
//    }
//
//    void resetPassword(final String email) {
//        mAuth.sendPasswordResetEmail(email)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        new LovelyInfoDialog(context) {
//                            @Override
//                            public LovelyInfoDialog setConfirmButtonText(String text) {
//                                findView(com.yarolegovich.lovelydialog.R.id.ld_btn_confirm).setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View view) {
//                                        dismiss();
//                                    }
//                                });
//                                return super.setConfirmButtonText(text);
//                            }
//                        }
//                                .setTopColorRes(R.color.colorPrimary)
//                                .setIcon(R.drawable.ic_pass_reset)
//                                .setTitle("Password Recovery")
//                                .setMessage("Sent email to " + email)
//                                .setConfirmButtonText("Ok")
//                                .show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        new LovelyInfoDialog(context) {
//                            @Override
//                            public LovelyInfoDialog setConfirmButtonText(String text) {
//                                findView(com.yarolegovich.lovelydialog.R.id.ld_btn_confirm).setOnClickListener(new View.OnClickListener() {
//                                    @Override
//                                    public void onClick(View view) {
//                                        dismiss();
//                                    }
//                                });
//                                return super.setConfirmButtonText(text);
//                            }
//                        }
//                                .setTopColorRes(R.color.colorAccent)
//                                .setIcon(R.drawable.ic_pass_reset)
//                                .setTitle("False")
//                                .setMessage("False to sent email to " + email)
//                                .setConfirmButtonText("Ok")
//                                .show();
//                    }
//                });
//    }
//
//    @Override
//    public int getItemCount() {
//        return profileConfig.size();
//    }
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//        // each data item is just a string in this case
//        public TextView label, value;
//        public ImageView icon;
//        public ViewHolder(View view) {
//            super(view);
//            label = (TextView)view.findViewById(R.id.tv_title);
//            value = (TextView)view.findViewById(R.id.tv_detail);
//            icon = (ImageView)view.findViewById(R.id.img_icon);
//        }
//    }
//
//}
