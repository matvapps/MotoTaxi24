package agency.yad.mototaxi24.order;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.custom.MyDatePickerFragment;
import agency.yad.mototaxi24.model.response.BaseResponse;
import agency.yad.mototaxi24.custom.MyTimePickerFragment;

public class NewOrderActivity extends BaseActivity implements NewOrderView, View.OnClickListener {

    private final String TAG = NewOrderActivity.class.getSimpleName();

    private EditText clientNameEdtxt;
    private EditText clientPhoneEdtxt;
    private EditText arrivalTimeEdtxt;
    private EditText addressEdtxt;
    private EditText motoTypeEdtxt;
    private EditText passengerWeightEdtxt;
    private EditText serviceCostEdtxt;
    private EditText humanQuantEdtxt;
    private EditText additionalInfoEdtxt;
    private Button sendBtn;

    private NewOrderPresenter newOrderPresenter;

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
        sendBtn = findViewById(R.id.send_btn);

        sendBtn.setOnClickListener(this);

        arrivalTimeEdtxt.setFocusable(false);
        arrivalTimeEdtxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                MyTimePickerFragment myTimePickerFragment = new MyTimePickerFragment();
                myTimePickerFragment.setTimeChangeListener(new MyTimePickerFragment.onTimeChangeListener() {
                    @SuppressLint("DefaultLocale")
                    @Override
                    public void onTimeChange(TimePicker timePicker) {
                        ((EditText) view)
                                .setText(String.format("%d:%d", timePicker.getCurrentHour(), timePicker.getCurrentMinute()));

                        MyDatePickerFragment myDatePickerFragment = new MyDatePickerFragment();
                        myDatePickerFragment.setDateChangeListener(new MyDatePickerFragment.onDateChangeListener() {
                            @SuppressLint("DefaultLocale")
                            @Override
                            public void onDateChange(DatePicker datePicker) {
                                String str = ((EditText) view).getText().toString();
                                ((EditText) view)
                                        .setText(String.format("%s  %d/%d/%d", str, datePicker.getDayOfMonth(), datePicker.getMonth() + 1, datePicker.getYear()));
                            }
                        });
                        myDatePickerFragment.show(getSupportFragmentManager(), "date picker");
                    }
                });

                myTimePickerFragment.show(getSupportFragmentManager(), "time picker");
            }
        });
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_new_order;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        newOrderPresenter = new NewOrderPresenter();
        newOrderPresenter.attachView(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.send_btn: {
                String clientName = clientNameEdtxt.getText().toString();
                String clientPhone = clientPhoneEdtxt.getText().toString();
                String arrivalTime = arrivalTimeEdtxt.getText().toString();
                String address = addressEdtxt.getText().toString();
                String motoType = motoTypeEdtxt.getText().toString();
                String passengerWeight = passengerWeightEdtxt.getText().toString();
                String serviceCost = serviceCostEdtxt.getText().toString();
                String humanQuant = humanQuantEdtxt.getText().toString();
                String additionalInfo = additionalInfoEdtxt.getText().toString();


                if (!clientName.isEmpty() &&
                        !clientPhone.isEmpty() &&
                        !arrivalTime.isEmpty() &&
                        !address.isEmpty() &&
                        !motoType.isEmpty() &&
                        !passengerWeight.isEmpty() &&
                        !serviceCost.isEmpty() &&
                        !humanQuant.isEmpty() &&
                        !additionalInfo.isEmpty()) {

                    newOrderPresenter.addNewOrder(keyValueStorage.getDispatcherToken(),
                            clientName, clientPhone, arrivalTime,
                            address, motoType, Integer.parseInt(passengerWeight),
                            Float.parseFloat(serviceCost), Integer.parseInt(humanQuant),
                            additionalInfo, 4654);

                } else {
                    Toast.makeText(this, "Заполните пожалуйста все поля", Toast.LENGTH_SHORT).show();
                }


                break;
            }
        }
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading(boolean show) {

    }

    @Override
    public void onReceiveResponse(BaseResponse response) {
        if (response.getCode().equals(1))
            Toast.makeText(this, "Что то пошло не так :(", Toast.LENGTH_SHORT).show();
        else
            finish();

        Log.d(TAG, "onReceiveResponse: " + response.toString());
    }
}
