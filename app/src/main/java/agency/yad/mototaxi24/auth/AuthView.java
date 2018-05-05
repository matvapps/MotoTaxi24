package agency.yad.mototaxi24.auth;

import agency.yad.mototaxi24.base.BaseView;

/**
 * Created by Alexandr
 */

public interface AuthView extends BaseView {

    void onAuth(AuthResponse authResponse);

}
