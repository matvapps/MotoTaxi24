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
import agency.yad.mototaxi24.dispatcher.DispatcherMainActivity;
import agency.yad.mototaxi24.model.response.AuthResponse;

public class AuthActivity extends BaseActivity implements AuthView {

    private final String TAG = AuthActivity.class.getSimpleName();

    private EditText emailEditText;
    private EditText passwordEditText;
    private Button submit;

    private AuthPresenter authPresenter;


    public static void start(Activity activity) {
        Intent intent = new Intent(activity, AuthActivity.class);
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
        emailEditText = findViewById(R.id.email_edtxt);
        passwordEditText = findViewById(R.id.password_edtxt);
        submit = findViewById(R.id.submit_btn);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                authPresenter.tryAuth(
                        emailEditText.getText().toString(),
                        passwordEditText.getText().toString());
            }
        });
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_auth;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
            case 0: {
                keyValueStorage.setIsLogIn(true);
                DispatcherMainActivity.start(AuthActivity.this);
                finish();
                break;
            }
            
            case 1: {
                Toast.makeText(this, authResponse.getMessage(), Toast.LENGTH_SHORT).show();
                break;
            }
            
        }
        
    }
}
