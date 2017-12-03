package com.vteam.foodfriends.ui.update;

import android.content.Context;
import android.content.Intent;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.bumptech.glide.Glide;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.vteam.foodfriends.R;
import com.vteam.foodfriends.data.model.User;
import com.vteam.foodfriends.data.preferences.AppPreferences;
import com.vteam.foodfriends.data.remote.FirebaseUserService;
import com.vteam.foodfriends.ui.adapter.RestaurantAdapter;
import com.vteam.foodfriends.ui.base.BaseFragment;
import com.vteam.foodfriends.ui.home.HomeContract;

import butterknife.BindView;

import static android.app.Activity.RESULT_OK;

/**
 * Created by phuongbka on 12/3/17.
 */

public class UpdateFragment extends BaseFragment implements UpdateContract.View {
    @BindView(R.id.edit_txt_birth)
    TextInputEditText mBirth;
    @BindView(R.id.edit_txt_email)
    TextInputEditText mEmail;
    @BindView(R.id.edit_txt_password)
    TextInputEditText mPassword;
    @BindView(R.id.edit_txt_phone)
    TextInputEditText mPhone;
    @BindView(R.id.edit_txt_username)
    TextInputEditText mUsername;
    @BindView(R.id.rb_male)
    RadioButton mMale;
    @BindView(R.id.rb_female)
    RadioButton mFemale;
    @BindView(R.id.civ_avatar)
    ImageView mAvatar;

    private UpdateContract.Presenter mPresenter;
    private AppPreferences mApp;
    private StorageReference mStorage = FirebaseStorage.getInstance().getReference();
    private static final int GALLERY_INTENT = 2;
    private Uri downloadUri;

    public UpdateFragment(){};

    @Override
    public void setPresenter(UpdateContract.Presenter presenter) {

    }

    @Override
    public int getContentLayout() {
        return R.layout.fragment_update_info;
    }

    @Override
    public void initView(View view) {

    }

    private void getImageAlbum() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,GALLERY_INTENT);
    }

    @Override
    public void initData() {

        mPresenter = new UpdatePresenter(mContext,this);
        fillText("21312","hungnv@gmail.com","123456"
                ,"hung","1234564",true);
        mAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getImageAlbum();
            }
        });
    }

    public void fillText(String birth, String email, String password, String username, String phone, boolean male){
        mBirth.setText(birth);
        mEmail.setText(email);
        mPassword.setText(password);
        mPhone.setText(phone);
        mUsername.setText(username);
        if(male){
            mMale.toggle();
        } else{
            mFemale.toggle();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == GALLERY_INTENT && resultCode == RESULT_OK){
            final Uri uri = data.getData();

            StorageReference filepath = mStorage.child("Avatars").child(uri.getLastPathSegment());

            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    downloadUri = taskSnapshot.getDownloadUrl();
                    Log.d("downloadUri ","" + downloadUri);
                    Glide.with(mContext).load(downloadUri).into(mAvatar);
                }
            });
        }
    }
}
