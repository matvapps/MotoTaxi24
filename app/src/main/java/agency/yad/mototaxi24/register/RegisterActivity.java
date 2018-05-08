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
import agency.yad.mototaxi24.auth.AuthActivity;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.model.response.BaseResponse;

public class RegisterActivity extends BaseActivity implements RegisterView, View.OnClickListener{

    private static final int GALLERY_REQUEST = 1;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
    }


    LinearLayout uploadYourPhoto;

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

        uploadYourPhoto.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        photoPickerIntent.putExtra("image_view_id", v.findViewById(R.id.image).getId());
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
        int imageViewId = imageReturnedIntent.getIntExtra("image_view_id", 0);
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
