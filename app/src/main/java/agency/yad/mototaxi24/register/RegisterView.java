package agency.yad.mototaxi24.register;

import agency.yad.mototaxi24.base.BaseView;
import agency.yad.mototaxi24.model.response.BaseResponse;
import agency.yad.mototaxi24.model.response.PhotoResponse;

/**
 * Created by Alexandr.
 */
public interface RegisterView extends BaseView {

    void tryRegister(BaseResponse response);
    void tryUploadPhoto(PhotoResponse response);

}
