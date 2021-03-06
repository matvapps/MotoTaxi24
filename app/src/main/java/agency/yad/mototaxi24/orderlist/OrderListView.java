package agency.yad.mototaxi24.orderlist;

import agency.yad.mototaxi24.base.BaseView;
import agency.yad.mototaxi24.model.response.BaseResponse;
import agency.yad.mototaxi24.model.response.OrdersResponse;

/**
 * Created by Alexandr.
 */
public interface OrderListView extends BaseView {

    void getOrders(OrdersResponse ordersResponse);
    void onTryDeleteOrder(BaseResponse response);
    void onTryTakeOrder(BaseResponse response);
    void onTryDoneOrder(BaseResponse response);

}
