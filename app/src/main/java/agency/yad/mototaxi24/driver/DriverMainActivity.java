package agency.yad.mototaxi24.driver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.dispatcher.DispatcherMainActivity;
import agency.yad.mototaxi24.main.MainActivity;

public class DriverMainActivity extends BaseActivity implements View.OnClickListener {

    private Button activeOrdersBtn;
    private Button myOrdersBtn;
    private Button logoutBtn;
    private Button changeModeBtn;


    public static void start(Activity activity) {
        Intent intent = new Intent(activity, DispatcherMainActivity.class);
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
        activeOrdersBtn = findViewById(R.id.active_order_btn);
        myOrdersBtn = findViewById(R.id.order_history_btn);
        logoutBtn = findViewById(R.id.log_out_btn);
        changeModeBtn = findViewById(R.id.change_mode_btn);

        activeOrdersBtn.setOnClickListener(this);
        myOrdersBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
        changeModeBtn.setOnClickListener(this);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_driver_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.active_order_btn: {

                break;
            }
            case R.id.my_orders_btn: {

                break;
            }
            case R.id.log_out_btn: {
                keyValueStorage.setIsNowLogIn(false);
                MainActivity.start(this);
                finish();
                break;
            }
            case R.id.change_mode_btn: {

                break;
            }
        }
    }
}
