package agency.yad.mototaxi24.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.data.preferences.KeyValueStorage;
import agency.yad.mototaxi24.dispatcher.DispatcherMainActivity;
import agency.yad.mototaxi24.model.response.AuthResponse;
import agency.yad.mototaxi24.register.RegisterActivity;

public class AuthActivity extends BaseActivity implements AuthView {

    private final String TAG = AuthActivity.class.getSimpleName();

    private static final String USER_TYPE = "user_type";
    public static final String USER_DRIVER = "driver";
    public static final String USER_DISPATCHER = "dispatcher";

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button submit;
    private Button register;

    private AuthPresenter authPresenter;
    private String userType;

    public static void start(Activity activity, String userType) {
        Intent intent = new Intent(activity, AuthActivity.class);
        intent.putExtra(USER_TYPE, userType);
        activity.startActivity(intent);
    }

    @Override
    protected boolean getUseArrowBack() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return "Авторизация";
    }

    @Override
    protected void initViews() {

        userType = getIntent().getStringExtra(USER_TYPE);

        emailEditText = findViewById(R.id.email_edtxt);
        passwordEditText = findViewById(R.id.password_edtxt);
        submit = findViewById(R.id.submit_btn);
        register = findViewById(R.id.register_btn);

        switch (userType) {
            case USER_DISPATCHER: {
                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        authPresenter.tryAuth(
                                emailEditText.getText().toString(),
                                passwordEditText.getText().toString());
                    }
                });
                break;
            }
            case USER_DRIVER: {
                register.setVisibility(View.VISIBLE);
                register.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RegisterActivity.start(AuthActivity.this);
                    }
                });

                break;
            }
        }


    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_auth;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        switch (userType) {
            case AuthActivity.USER_DISPATCHER: {
                if (keyValueStorage.getDispatcherToken() != null) {
                    keyValueStorage.setIsNowLogIn(true);
                    DispatcherMainActivity.start(AuthActivity.this);
                    finish();
                }
                break;
            }
            case AuthActivity.USER_DRIVER: {

                break;
            }
            default:
                break;
        }

        authPresenter = new AuthPresenter();
        authPresenter.attachView(this);
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void onAuth(AuthResponse authResponse) {
        Log.d(TAG, "onAuth: " + authResponse.toString());

        switch (authResponse.getCode()) {
            // auth was complete successful
            case 0: {

                // for dispatcher
                if (userType.equals(USER_DISPATCHER)) {
                    keyValueStorage.setIsNowLogIn(true);
                    keyValueStorage.setLoginedUser(KeyValueStorage.USER_DISPATCHER);
                    keyValueStorage.setDispatcherToken(authResponse.getToken());
                    DispatcherMainActivity.start(AuthActivity.this);
                    finish();
                }
                // for Driver
                else {


                }
                keyValueStorage.setIsNowLogIn(true);
                break;
            }
            // auth not completed
            case 1: {
                Toast.makeText(this, authResponse.getMessage(), Toast.LENGTH_SHORT).show();
                break;
            }

        }

    }
}
