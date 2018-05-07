package agency.yad.mototaxi24.orderlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.model.Order;

/**
 * Created by Alexandr.
 */
public class OrderListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private String orderType;
    private List<Order> orderList;


    public void setItems(List<Order> orders) {
        orderList.addAll(orders);
        notifyDataSetChanged();
    }

    public void addItem(Order order) {
        orderList.add(order);
        notifyItemInserted(orderList.size() - 1);
    }

    public OrderListAdapter(String orderType) {
        this.orderType = orderType;
        this.orderList = new ArrayList<>();
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (orderType) {
            case OrderListActivity.ORDERS_MY: {
//                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.active_order_item, null);
            }
            case OrderListActivity.ORDERS_ACTIVE_DISPATCHER:
            case OrderListActivity.ORDERS_ACTIVE_DRIVER: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_active, parent, false);
                return new ActiveOrdersViewHolder(view);
            }
            case OrderListActivity.ORDERS_HISTORY: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_history, parent, false);
                return new HistoryOrdersViewHolder(view);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public Order getItem(int position) {
        return orderList.get(position);
    }

    private class MyOrdersViewHolder extends BaseOrdersViewHolder {

        public MyOrdersViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class HistoryOrdersViewHolder extends BaseOrdersViewHolder {

        public HistoryOrdersViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class ActiveOrdersViewHolder extends BaseOrdersViewHolder {

        public ActiveOrdersViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class BaseOrdersViewHolder extends RecyclerView.ViewHolder {

        private TextView dateText;
        private TextView infoText;

        public BaseOrdersViewHolder(View itemView) {
            super(itemView);

            dateText = itemView.findViewById(R.id.date_txt);
            infoText = itemView.findViewById(R.id.info_text);

        }
    }

}
