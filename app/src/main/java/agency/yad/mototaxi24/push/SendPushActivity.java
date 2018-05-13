package agency.yad.mototaxi24.push;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.model.response.BaseResponse;

public class SendPushActivity extends BaseActivity implements SendPushView{

    private Button sendPushBtn;
    private EditText pushMessageEdtxt;

    private SendPushPresenter presenter;

    @Override
    protected boolean getUseArrowBack() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return "Отправить Push";
    }


    public static void start(Activity activity) {
        Intent intent = new Intent(activity, SendPushActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void initViews() {
        pushMessageEdtxt = findViewById(R.id.message_edtxt);
        sendPushBtn = findViewById(R.id.send_btn);

        sendPushBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!pushMessageEdtxt.getText().toString().isEmpty()) {
                    presenter.sendPush(pushMessageEdtxt.getText().toString());
                    pushMessageEdtxt.setText(null);
                    Toast.makeText(SendPushActivity.this, "Сообщение успешно отправлено", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(SendPushActivity.this, "Сообщение не может быть пустым", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_send_push;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = new SendPushPresenter();
        presenter.attachView(this);

    }

    @Override
    public void onSendPush(BaseResponse response) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading(boolean show) {

    }
}
