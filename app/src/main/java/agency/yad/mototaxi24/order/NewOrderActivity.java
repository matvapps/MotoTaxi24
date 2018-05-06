package agency.yad.mototaxi24.order;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;

public class NewOrderActivity extends BaseActivity {


    private EditText clientNameEdtxt;
    private EditText clientPhoneEdtxt;
    private EditText arrivalTimeEdtxt;
    private EditText addressEdtxt;
    private EditText motoTypeEdtxt;
    private EditText passengerWeightEdtxt;
    private EditText serviceCostEdtxt;
    private EditText humanQuantEdtxt;
    private EditText additionalInfoEdtxt;

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, NewOrderActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected boolean getUseArrowBack() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return "Новый заказ";
    }

    @Override
    protected void initViews() {
        clientNameEdtxt = findViewById(R.id.client_name_edtxt);
        clientPhoneEdtxt = findViewById(R.id.client_phone_edtxt);
        arrivalTimeEdtxt = findViewById(R.id.arrival_time_edtxt);
        addressEdtxt = findViewById(R.id.address_edtxt);
        motoTypeEdtxt = findViewById(R.id.moto_type_edtxt);
        passengerWeightEdtxt = findViewById(R.id.passenger_weight_edtxt);
        serviceCostEdtxt = findViewById(R.id.service_cost_edtxt);
        humanQuantEdtxt = findViewById(R.id.human_quant_edtxt);
        additionalInfoEdtxt = findViewById(R.id.additional_info_edtxt);
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_new_order;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
}
