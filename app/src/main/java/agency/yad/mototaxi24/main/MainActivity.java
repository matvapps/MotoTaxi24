package agency.yad.mototaxi24.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.auth.AuthActivity;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.data.preferences.KeyValueStorage;
import agency.yad.mototaxi24.dispatcher.DispatcherMainActivity;
import agency.yad.mototaxi24.driver.DriverMainActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button buttonDriver;
    private Button buttonDispatcher;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected boolean getUseArrowBack() {
        return false;
    }

    @Override
    protected String getToolbarTitle() {
        return "Главная";
    }

    @Override
    protected void initViews() {
        buttonDriver = findViewById(R.id.button_driver);
        buttonDispatcher = findViewById(R.id.button_dispatcher);

        buttonDriver.setOnClickListener(this);
        buttonDispatcher.setOnClickListener(this);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_main;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (keyValueStorage.getLoginedUser() != null && keyValueStorage.isNowLogIn()) {
            switch (keyValueStorage.getLoginedUser()) {
                case KeyValueStorage.USER_DISPATCHER: {
                    DispatcherMainActivity.start(this);
                    finish();
                    break;
                }
                case KeyValueStorage.USER_DRIVER: {
                    DriverMainActivity.start(this);
                    finish();
                    break;
                }
                default:
                    break;
            }
        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_dispatcher: {
                AuthActivity.start(MainActivity.this, AuthActivity.USER_DISPATCHER);
                break;
            }
            case R.id.button_driver: {
                AuthActivity.start(MainActivity.this, AuthActivity.USER_DRIVER);
                break;
            }

        }
    }
}
