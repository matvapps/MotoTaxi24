package agency.yad.mototaxi24.push;

import agency.yad.mototaxi24.base.BaseView;
import agency.yad.mototaxi24.model.response.BaseResponse;

/**
 * Created by Alexandr.
 */
public interface SendPushView extends BaseView {

    void onSendPush(BaseResponse response);

}
