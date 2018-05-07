package agency.yad.mototaxi24.register;

import android.os.Bundle;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.model.response.BaseResponse;

public class RegisterActivity extends BaseActivity implements RegisterView{

    @Override
    protected boolean getUseArrowBack() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        return "Регистрация";
    }

    @Override
    protected void initViews() {

    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public void tryRegister(BaseResponse response) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading(boolean show) {

    }
}
