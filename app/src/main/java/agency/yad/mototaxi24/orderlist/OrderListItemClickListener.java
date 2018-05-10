package agency.yad.mototaxi24.orderlist;

/**
 * Created by Alexandr
 */

public interface OrderListItemClickListener {
    void onDeleteOrder(int id);
    void onTakeOrder(int id);
    void onOrderDone(int id);
}
