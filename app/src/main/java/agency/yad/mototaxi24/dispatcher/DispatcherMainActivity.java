package agency.yad.mototaxi24.dispatcher;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.main.MainActivity;
import agency.yad.mototaxi24.order.NewOrderActivity;

public class DispatcherMainActivity extends BaseActivity implements View.OnClickListener {

    private Button newOrderBtn;
    private Button activeOrdersBtn;
    private Button historyOrdersBtn;
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
        newOrderBtn = findViewById(R.id.new_order_btn);
        activeOrdersBtn = findViewById(R.id.active_order_btn);
        historyOrdersBtn = findViewById(R.id.order_history_btn);
        logoutBtn = findViewById(R.id.log_out_btn);
        changeModeBtn = findViewById(R.id.change_mode_btn);

        newOrderBtn.setOnClickListener(this);
        activeOrdersBtn.setOnClickListener(this);
        historyOrdersBtn.setOnClickListener(this);
        logoutBtn.setOnClickListener(this);
        changeModeBtn.setOnClickListener(this);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_dispatcher_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.new_order_btn: {
                NewOrderActivity.start(this);
                break;
            }
            case R.id.active_order_btn: {

                break;
            }
            case R.id.order_history_btn: {

                break;
            }
            case R.id.log_out_btn: {
                keyValueStorage.setIsLogIn(false);
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
