package agency.yad.mototaxi24.orderlist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.base.BaseActivity;
import agency.yad.mototaxi24.model.response.OrdersResponse;

public class OrderListActivity extends BaseActivity implements OrderListView {


    private static final String ORDERS_TYPE = "orders_type";

    public static final String ORDERS_HISTORY = "order_history";
    public static final String ORDERS_ACTIVE_DISPATCHER = "orders_active_dispatcher";
    public static final String ORDERS_ACTIVE_DRIVER = "orders_active_driver";
    public static final String ORDERS_MY = "orders_my";


    private RecyclerView ordersList;

    private OrderListAdapter orderListAdapter;
    private OrderListPresenter orderListPresenter;
    private String ordersType = "";


    public static void start(Activity activity, @NonNull String ordersType) {
        Intent intent = new Intent(activity, OrderListActivity.class);
        intent.putExtra(ORDERS_TYPE, ordersType);
        activity.startActivity(intent);
    }

    @Override
    protected boolean getUseArrowBack() {
        return true;
    }

    @Override
    protected String getToolbarTitle() {
        switch (ordersType) {
            case ORDERS_MY: {
                return "Мои заказы";
            }
            case ORDERS_ACTIVE_DRIVER:
            case ORDERS_ACTIVE_DISPATCHER: {
                return "Активные заказы";
            }
            case ORDERS_HISTORY: {
                return "История заказов";
            }
        }
        return "";
    }

    @Override
    protected void initViews() {
        ordersList = findViewById(R.id.order_list);
        ordersList.setLayoutManager(new LinearLayoutManager(this));

        orderListAdapter = new OrderListAdapter(ordersType);
        ordersList.setAdapter(orderListAdapter);


    }

    @Override
    protected int getContentViewLayoutId() {
        return R.layout.activity_order_list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ordersType = getIntent().getStringExtra(ORDERS_TYPE);
        super.onCreate(savedInstanceState);

        orderListPresenter = new OrderListPresenter();
        orderListPresenter.attachView(this);

        orderListPresenter.getOrders(ordersType);

    }

    @Override
    public void getOrders(OrdersResponse ordersResponse) {
        Log.d("TAG", "getOrders: " + ordersResponse.getCode());
        orderListAdapter.setItems(ordersResponse.getOrders());
    }

    @Override
    public void showError() {

    }

    @Override
    public void showLoading(boolean show) {

    }
}
