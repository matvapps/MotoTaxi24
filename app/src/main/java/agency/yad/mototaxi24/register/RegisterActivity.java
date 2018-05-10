package agency.yad.mototaxi24.register;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.io.IOException;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.model.response.BaseResponse;

public class RegisterActivity extends BaseActivity implements RegisterView, View.OnClickListener{

    private static final int GALLERY_REQUEST = 1;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
    }


    private LinearLayout uploadYourPhoto;
    private LinearLayout uploadMotoPhoto;

    private LinearLayout docPhoto1;
    private LinearLayout docPhoto2;
    private LinearLayout docPhoto3;
    private LinearLayout docPhoto4;
    private LinearLayout docPhoto5;
    private LinearLayout docPhoto6;



    @Override
    protected boolean getUseArrowBack() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return "Регистрация";
    }

    @Override
    protected void initViews() {

        uploadYourPhoto = findViewById(R.id.upload_your_photo);
        uploadMotoPhoto = findViewById(R.id.upload_moto_photo);
        docPhoto1 = findViewById(R.id.doc_photo_1);
        docPhoto2 = findViewById(R.id.doc_photo_2);
        docPhoto3 = findViewById(R.id.doc_photo_3);
        docPhoto4 = findViewById(R.id.doc_photo_4);
        docPhoto5 = findViewById(R.id.doc_photo_5);
        docPhoto6 = findViewById(R.id.doc_photo_6);

        uploadYourPhoto.setOnClickListener(this);
        uploadMotoPhoto.setOnClickListener(this);

        docPhoto1.setOnClickListener(this);
        docPhoto2.setOnClickListener(this);
        docPhoto3.setOnClickListener(this);
        docPhoto4.setOnClickListener(this);
        docPhoto5.setOnClickListener(this);
        docPhoto6.setOnClickListener(this);


    }

    private int imageViewId;

    @Override
    public void onClick(View v) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        imageViewId =  v.findViewWithTag("image_for_upload").getId();
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }


    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        Bitmap bitmap = null;
//        int imageViewId = imageReturnedIntent.getIntExtra("image_view_id", 0);
        ImageView imageView = findViewById(imageViewId);

        switch(requestCode) {
            case GALLERY_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    try {
                        bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    imageView.setImageBitmap(bitmap);
                }
        }
    }


    @Override
    public void tryRegister(BaseResponse response) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading(boolean show) {

    }
}
