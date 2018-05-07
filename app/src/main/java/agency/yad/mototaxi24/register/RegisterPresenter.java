package agency.yad.mototaxi24.register;

import agency.yad.mototaxi24.base.Presenter;

/**
 * Created by Alexandr.
 */
public class RegisterPresenter implements Presenter<RegisterView>{

    RegisterView view;

    @Override
    public void attachView(RegisterView view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
