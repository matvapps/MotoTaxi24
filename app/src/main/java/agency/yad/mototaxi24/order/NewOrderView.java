package agency.yad.mototaxi24.order;

import agency.yad.mototaxi24.base.BaseView;
import agency.yad.mototaxi24.model.response.BaseResponse;

/**
 * Created by Alexandr.
 */
public interface NewOrderView extends BaseView {

    void onReceiveResponse(BaseResponse response);

}
