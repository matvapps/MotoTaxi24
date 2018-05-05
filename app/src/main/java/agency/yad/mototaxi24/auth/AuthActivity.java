package agency.yad.mototaxi24.auth;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.dispatcher.DispatcherMainActivity;

public class AuthActivity extends AppCompatActivity implements AuthView {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        emailEditText = findViewById(R.id.email_edtxt);
        passwordEditText = findViewById(R.id.password_edtxt);
        submit = findViewById(R.id.submit_btn);

        authPresenter = new AuthPresenter();
        authPresenter.attachView(this);

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
                DispatcherMainActivity.start(AuthActivity.this);
                break;
            }
            
            case 1: {
                Toast.makeText(this, authResponse.getMessage(), Toast.LENGTH_SHORT).show();
                break;
            }
            
        }
        
    }
}
