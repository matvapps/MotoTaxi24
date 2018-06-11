package agency.yad.mototaxi24.driver;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.main.MainActivity;
import agency.yad.mototaxi24.orderlist.OrderListActivity;

public class DriverMainActivity extends BaseActivity implements View.OnClickListener {

    private Button activeOrdersBtn;
    private Button myOrdersBtn;
    private Button logoutBtn;
    private Button changeModeBtn;


    public static void start(Activity activity) {
        Intent intent = new Intent(activity, DriverMainActivity.class);
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
        myOrdersBtn = findViewById(R.id.my_orders_btn);
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
                OrderListActivity.start(this, OrderListActivity.ORDERS_ACTIVE_DRIVER);
                break;
            }
            case R.id.my_orders_btn: {
                OrderListActivity.start(this, OrderListActivity.ORDERS_MY);
                break;
            }
            case R.id.log_out_btn: {
                keyValueStorage.setIsNowLogIn(false);
                keyValueStorage.setLoginedUser(null);
                keyValueStorage.setDriverToken(null);
                MainActivity.start(this);
                finish();
                break;
            }
            case R.id.change_mode_btn: {
                keyValueStorage.setIsNowLogIn(false);
                MainActivity.start(this);
                finish();
                break;
            }
        }
    }

    @Override
    public void showError() {

    }
}
