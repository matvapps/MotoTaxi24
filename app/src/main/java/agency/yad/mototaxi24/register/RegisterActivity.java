package agency.yad.mototaxi24.register;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.model.response.BaseResponse;
import agency.yad.mototaxi24.model.response.PhotoResponse;
import agency.yad.mototaxi24.network.NetworkClient;
import agency.yad.mototaxi24.network.NetworkInterface;
import agency.yad.mototaxi24.custom.MyDatePickerFragment;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends BaseActivity implements RegisterView, View.OnClickListener {

    private static final int GALLERY_REQUEST = 100;
    private int imageViewId;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, RegisterActivity.class);
        activity.startActivity(intent);
    }

    private LinearLayout uploadYourPhoto;
    private LinearLayout uploadMotoPhoto;

    private EditText nameEdtxt;
    private EditText birthdayEdtxt;
    private EditText phoneEdtxt;
    private EditText emailEdtxt;
    private EditText addressEdtxt;
    private EditText nearSubwayEdtxt;
    private EditText drivingExpEdtxt;
    private EditText motoMarkEdtxt;
    private EditText motoModelEdtxt;
    private EditText motoYearEdtxt;
    private EditText motoColorEdtxt;
    private EditText regNumAvailabilityEdtxt;
    private EditText insuranceAvailabilityEdtxt;
    private EditText trunkAvailabilityEdtxt;
    private EditText reqPassengerWeightEdtxt;
    private EditText recDevicesAvailabilityEdtxt;
    private EditText additionalSkillsEdtxt;
    private EditText passwordEdtxt;
    private EditText passwordRepeatEdtxt;

    private LinearLayout docPhoto1;
    private LinearLayout docPhoto2;
    private LinearLayout docPhoto3;
    private LinearLayout docPhoto4;
    private LinearLayout docPhoto5;
    private LinearLayout docPhoto6;
    private LinearLayout docPhoto7;
    private LinearLayout docPhoto8;
    private LinearLayout docPhoto9;
    private LinearLayout docPhoto10;

    private Button registerBtn;

    private RegisterPresenter registerPresenter;


    private String myPhotoPath = "";
    private String photoBikePath = "";
    String photo1Path = "";
    String photo2Path = "";
    String photo3Path = "";
    String photo4Path = "";
    String photo5Path = "";
    String photo6Path = "";
    String photo7Path = "";
    String photo8Path = "";
    String photo9Path = "";
    String photo10Path = "";


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


        nameEdtxt = findViewById(R.id.name_edtxt);
        birthdayEdtxt = findViewById(R.id.birthday_edtxt);
        phoneEdtxt = findViewById(R.id.phone_edtxt);
        emailEdtxt = findViewById(R.id.email_edtxt);
        addressEdtxt = findViewById(R.id.address_edtxt);
        nearSubwayEdtxt = findViewById(R.id.near_subway_edtxt);
        drivingExpEdtxt = findViewById(R.id.driving_exp_edtxt);
        motoMarkEdtxt = findViewById(R.id.moto_mark_edtxt);
        motoModelEdtxt = findViewById(R.id.moto_model_edtxt);
        motoYearEdtxt = findViewById(R.id.moto_year_edtxt);
        motoColorEdtxt = findViewById(R.id.moto_color_edtxt);
        regNumAvailabilityEdtxt = findViewById(R.id.registration_number_availability_edtxt);
        insuranceAvailabilityEdtxt = findViewById(R.id.insurance_availability_edtxt);
        trunkAvailabilityEdtxt = findViewById(R.id.trunk_edtxt);
        reqPassengerWeightEdtxt = findViewById(R.id.required_passenger_weight_edtxt);
        recDevicesAvailabilityEdtxt = findViewById(R.id.recording_devices_edtxt);
        additionalSkillsEdtxt = findViewById(R.id.additional_skills_edtxt);
        passwordEdtxt = findViewById(R.id.password_edtxt);
        passwordRepeatEdtxt = findViewById(R.id.password2_edtxt);
        registerBtn = findViewById(R.id.send_btn);


        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });


        birthdayEdtxt.setFocusable(false);
        birthdayEdtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                MyDatePickerFragment datePickerFragment = new MyDatePickerFragment();
                datePickerFragment.setDateChangeListener(new MyDatePickerFragment.onDateChangeListener() {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void onDateChange(DatePicker datePicker) {
                        ((EditText) view)
                                .setText(String.format("%d/%d/%d", datePicker.getDayOfMonth(), datePicker.getMonth() + 1, datePicker.getYear()));
                    }
                });
                datePickerFragment.show(getSupportFragmentManager(), "date picker");
            }
        });


        docPhoto1 = findViewById(R.id.doc_photo_1);
        docPhoto2 = findViewById(R.id.doc_photo_2);
        docPhoto3 = findViewById(R.id.doc_photo_3);
        docPhoto4 = findViewById(R.id.doc_photo_4);
        docPhoto5 = findViewById(R.id.doc_photo_5);
        docPhoto6 = findViewById(R.id.doc_photo_6);
        docPhoto7 = findViewById(R.id.doc_photo_7);
        docPhoto8 = findViewById(R.id.doc_photo_8);
        docPhoto9 = findViewById(R.id.doc_photo_9);
        docPhoto10 = findViewById(R.id.doc_photo_10);

        uploadYourPhoto.setOnClickListener(this);
        uploadMotoPhoto.setOnClickListener(this);

        docPhoto1.setOnClickListener(this);
        docPhoto2.setOnClickListener(this);
        docPhoto3.setOnClickListener(this);
        docPhoto4.setOnClickListener(this);
        docPhoto5.setOnClickListener(this);
        docPhoto7.setOnClickListener(this);
        docPhoto6.setOnClickListener(this);
        docPhoto8.setOnClickListener(this);
        docPhoto9.setOnClickListener(this);
        docPhoto10.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        v.setFocusable(true);
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        imageViewId = v.findViewWithTag("image_for_upload").getId();
        startActivityForResult(photoPickerIntent, GALLERY_REQUEST);
    }


    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        registerPresenter = new RegisterPresenter();
        registerPresenter.attachView(this);

    }


    @Override
    protected void onActivityResult(final int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        final File file;

        final ImageView imageView = findViewById(imageViewId);
        if (requestCode == GALLERY_REQUEST && resultCode == Activity.RESULT_OK) {
            final Uri selectedImage = data.getData();

            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
            if (cursor == null)
                return;

            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String filePath = cursor.getString(columnIndex);
            cursor.close();

            file = new File(filePath);


            RequestBody reqFile = RequestBody.create(MediaType.parse("image/*"), file);
            MultipartBody.Part body = MultipartBody.Part.createFormData("photo", file.getName(), reqFile);

            retrofit2.Call<PhotoResponse> req =
                    NetworkClient
                            .getRetrofit()
                            .create(NetworkInterface.class)
                            .postImage(body);

            Picasso.get().load(file).into(imageView);

            req.enqueue(new Callback<PhotoResponse>() {
                @Override
                public void onResponse(Call<PhotoResponse> call, Response<PhotoResponse> response) {
                    Log.d("TAG", "onResponse: " + response.body());
                    switch (response.body().getCode()) {
                        case 1: {
                            // ERROR
                            Toast.makeText(RegisterActivity.this, "Не удалось загрузить фото", Toast.LENGTH_SHORT).show();
                            break;
                        }
                        case 0: {
                            savePhotoPath(imageViewId, response.body().getPhoto());

//                            imageView.setImageBitmap(bitmap[0]);
                            break;
                        }
                    }

                }

                @Override
                public void onFailure(Call<PhotoResponse> call, Throwable t) {
                    Log.d("TAG", "onFailure: ");
                    Toast.makeText(RegisterActivity.this, "Не удалось загрузить фото", Toast.LENGTH_SHORT).show();
                    t.printStackTrace();
                }
            });

        }


    }

    private void sendData() {

        String name = nameEdtxt.getText().toString();
        String birthday = birthdayEdtxt.getText().toString();
        String phone = phoneEdtxt.getText().toString();
        String email = emailEdtxt.getText().toString();
        String address = addressEdtxt.getText().toString();
        String subway = nearSubwayEdtxt.getText().toString();
        String experience = drivingExpEdtxt.getText().toString();
        String motoMark = motoMarkEdtxt.getText().toString();
        String motoModel = motoModelEdtxt.getText().toString();
        String motoYear = motoYearEdtxt.getText().toString();
        String motoColor = motoColorEdtxt.getText().toString();
        String regNum = regNumAvailabilityEdtxt.getText().toString();
        String insurance = insuranceAvailabilityEdtxt.getText().toString();
        String trunk = trunkAvailabilityEdtxt.getText().toString();
        String reqPassengers = reqPassengerWeightEdtxt.getText().toString();
        String recDevices = recDevicesAvailabilityEdtxt.getText().toString();
        String additionalSkills = additionalSkillsEdtxt.getText().toString();
        String password = passwordEdtxt.getText().toString();
        String repeatPassword = passwordRepeatEdtxt.getText().toString();

        if (!name.isEmpty() && !birthday.isEmpty() &&
                !phone.isEmpty() && !email.isEmpty() &&
                !address.isEmpty() && !subway.isEmpty() &&
                !experience.isEmpty() && !motoMark.isEmpty() &&
                !motoModel.isEmpty() && !motoYear.isEmpty() &&
                !motoColor.isEmpty() && !regNum.isEmpty() &&
                !insurance.isEmpty() && !trunk.isEmpty() &&
                !reqPassengers.isEmpty() && !recDevices.isEmpty() &&
                !additionalSkills.isEmpty() && !password.isEmpty() &&
                !repeatPassword.isEmpty()) {

            if (!myPhotoPath.isEmpty() && !photoBikePath.isEmpty()
                    && !photo1Path.isEmpty() && !photo2Path.isEmpty()
                    && !photo3Path.isEmpty() && !photo4Path.isEmpty()
                    && !photo5Path.isEmpty() && !photo6Path.isEmpty()
                    && !photo7Path.isEmpty() && !photo8Path.isEmpty()
                    && !photo9Path.isEmpty() && !photo10Path.isEmpty()) {

                if (password.equals(repeatPassword)) {

                    Log.d("TAG", "sendData: \n" +
                            "name = " + name + "\n" +
                            "birthday = " + birthday + "\n" +
                            "phone = " + phone + "\n" +
                            "email = " + email + "\n" +
                            "address = " + address + "\n" +
                            "subway = " + subway + "\n" +
                            "experience = " + experience + "\n" +
                            "motoMark = " + motoMark + "\n" +
                            "motoModel = " + motoModel + "\n" +
                            "motoYear = " + motoYear + "\n" +
                            "motoColor = " + motoColor + "\n" +
                            "regNum = " + regNum + "\n" +
                            "insurance = " + insurance + "\n" +
                            "trunk = " + trunk + "\n" +
                            "reqPassengers = " + reqPassengers + "\n" +
                            "recDevices = " + recDevices + "\n" +
                            "additionalSkills = " + additionalSkills + "\n" +
                            "password = " + password + "\n" +
                            "repeatPassword = " + repeatPassword + "\n" +
                            "myPhotoPath = " + myPhotoPath + "\n" +
                            "photoBikePath = " + photoBikePath + "\n" +
                            "photo1Path = " + photo1Path + "\n" +
                            "photo2Path = " + photo2Path + "\n" +
                            "photo3Path = " + photo3Path + "\n" +
                            "photo4Path = " + photo4Path + "\n" +
                            "photo5Path = " + photo5Path + "\n" +
                            "photo6Path = " + photo6Path + "\n" +
                            "photo7Path = " + photo7Path + "\n" +
                            "photo8Path = " + photo8Path + "\n" +
                            "photo9Path = " + photo9Path + "\n" +
                            "photo10Path = " + photo10Path + "\n");


                    registerPresenter.registerDriver(myPhotoPath, photoBikePath, name, birthday, phone, email,
                            address, subway, experience, motoMark, motoModel, motoYear, motoColor, regNum,
                            insurance, trunk, Integer.valueOf(reqPassengers), recDevices, additionalSkills, password, repeatPassword, photo1Path,
                            photo2Path, photo3Path, photo4Path, photo5Path, photo6Path, photo7Path, photo8Path, photo9Path, photo10Path);
                } else {
                    Toast.makeText(this, "Пароли не совпадают", Toast.LENGTH_SHORT).show();
                }
            } else
                Toast.makeText(this, "Не все картинки еще загружены", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Заполните пожалуйста все поля", Toast.LENGTH_SHORT).show();
        }
    }

    private void savePhotoPath(int imageId, String path) {

        Log.d("TAG", "savePhotoPath: " + path);

        switch (imageId) {
            case R.id.your_photo_image: {
                myPhotoPath = path;
                break;
            }
            case R.id.moto_photo_image: {
                photoBikePath = path;
                break;
            }
            case R.id.doc_photo_image_1: {
                photo1Path = path;
                break;
            }
            case R.id.doc_photo_image_2: {
                photo2Path = path;
                break;
            }
            case R.id.doc_photo_image_3: {
                photo3Path = path;
                break;
            }
            case R.id.doc_photo_image_4: {
                photo4Path = path;
                break;
            }
            case R.id.doc_photo_image_5: {
                photo5Path = path;
                break;
            }
            case R.id.doc_photo_image_6: {
                photo6Path = path;
                break;
            }
            case R.id.doc_photo_image_7: {
                photo7Path = path;
                break;
            }
            case R.id.doc_photo_image_8: {
                photo8Path = path;
                break;
            }
            case R.id.doc_photo_image_9: {
                photo9Path = path;
                break;
            }
            case R.id.doc_photo_image_10: {
                photo10Path = path;
                break;
            }

        }
        Log.d("TAG", "savePhotoPath: " + myPhotoPath);

    }

    @Override
    public void tryRegister(BaseResponse response) {
        Log.d("TAG", "tryRegister: " + response.getMessage());
        switch (response.getCode()) {
            case 0: {
                Toast.makeText(this, "Регистрация прошла успешно", Toast.LENGTH_SHORT).show();
                finish();
                break;
            }
            case 1: {
                Toast.makeText(this, "Ошибка: " + response.getMessage(), Toast.LENGTH_SHORT).show();
                break;
            }

        }
    }

    @Override
    public void tryUploadPhoto(PhotoResponse response) {
        Log.d("TAG", "tryUploadPhoto: " + response.toString());
        Toast.makeText(this, response.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading(boolean show) {

    }


}
