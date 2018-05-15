package agency.yad.mototaxi24.orderlist;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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
    private OrderListItemClickListener orderListItemClickListener;


    public void setItems(List<Order> orders) {
        orderList.clear();
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
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_active, parent, false);
                return new ActiveOrdersViewHolder(view);
            }
            case OrderListActivity.ORDERS_ACTIVE_DISPATCHER:
            case OrderListActivity.ORDERS_ACTIVE_DRIVER: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_active, parent, false);
                return new ActiveOrdersViewHolder(view);
            }
            case OrderListActivity.ORDERS_HISTORY: {
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order_active, parent, false);
                return new HistoryOrdersViewHolder(view);
            }
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

        String phone;

        switch (orderType) {
            case OrderListActivity.ORDERS_MY: {
                ActiveOrdersViewHolder activeOrdersViewHolder = (ActiveOrdersViewHolder) holder;

                String timeInfo = getItem(position).getOrder_time();
                String info = "Имя клиента: " + getItem(position).getName()
                        + "\n" + "Телефон: " + getItem(position).getPhone()
                        + "\n" + "Адрес: " + getItem(position).getAddress()
                        + "\n" + "Время подачи: " + getItem(position).getCreated_at()
                        + "\n" + "Вес пассажира: " + getItem(position).getWeight()
                        + "\n" + "Тип мотоцикла: " + getItem(position).getBike_type()
                        + "\n" + "Цена: " + getItem(position).getPrice()
                        + "\n" + "Прочее: " + getItem(position).getAdditional_info();

                String buttonTitle = "Завершить";
                if (getItem(position).getStatus().equals("3")) {
                    buttonTitle = "Заказ выполнен";
                    activeOrdersViewHolder.button.setClickable(false);
                    activeOrdersViewHolder.button.setEnabled(false);
                } else {
                    activeOrdersViewHolder.button.setEnabled(true);
                }

                activeOrdersViewHolder.dateText.setText(timeInfo);
                activeOrdersViewHolder.infoText.setText(info);
                activeOrdersViewHolder.button.setText(buttonTitle);
                activeOrdersViewHolder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        orderListItemClickListener.onOrderDone(getItem(position).getId());
//                        orderList.remove(position);
//                        notifyItemRemoved(position);
                    }
                });
                break;
            }
            case OrderListActivity.ORDERS_ACTIVE_DRIVER:
            case OrderListActivity.ORDERS_ACTIVE_DISPATCHER: {
                ActiveOrdersViewHolder activeOrdersViewHolder = (ActiveOrdersViewHolder) holder;
                String buttonTitle;

                if (orderType.equals(OrderListActivity.ORDERS_ACTIVE_DISPATCHER)) {
                    buttonTitle = "Отмена";
                    phone = "\n" + "Телефон: " + getItem(position).getPhone();
                } else {
                    phone = "";
                    if (getItem(position).getStatus().equals("2")) {
                        buttonTitle = "Заказ взят";
                        activeOrdersViewHolder.button.setEnabled(false);
                    } else {
                        activeOrdersViewHolder.button.setEnabled(true);
                    }
                    buttonTitle = "Взять заказ";
                }

                String timeInfo = getItem(position).getOrder_time();
                String info = "Имя клиента: " + getItem(position).getName()
                        + phone
                        + "\n" + "Адрес: " + getItem(position).getAddress()
                        + "\n" + "Время подачи: " + getItem(position).getCreated_at()
                        + "\n" + "Вес пассажира: " + getItem(position).getWeight()
                        + "\n" + "Тип мотоцикла: " + getItem(position).getBike_type()
                        + "\n" + "Цена: " + getItem(position).getPrice()
                        + "\n" + "Прочее: " + getItem(position).getAdditional_info();

                activeOrdersViewHolder.dateText.setText(timeInfo);
                activeOrdersViewHolder.infoText.setText(info);
                activeOrdersViewHolder.button.setText(buttonTitle);
                activeOrdersViewHolder.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (orderType.equals(OrderListActivity.ORDERS_ACTIVE_DISPATCHER)) {
                            orderListItemClickListener.onDeleteOrder(getItem(position).getId());
                            orderList.remove(position);
                            notifyItemRemoved(position);
                        } else {
                            orderListItemClickListener.onTakeOrder(getItem(position).getId());
                        }
                    }
                });
                break;
            }
            case OrderListActivity.ORDERS_HISTORY: {
                HistoryOrdersViewHolder historyOrdersViewHolder = (HistoryOrdersViewHolder) holder;

                String driverInfo = getItem(position).getDriverFio()
                        + "\n" + getItem(position).getDriverPhone()
                        + "\n" + getItem(position).getDriverBikeModel();

                String timeInfo = getItem(position).getOrder_time();
                String info = "Имя клиента: " + getItem(position).getName()
                        + "\n" + "Телефон: " + getItem(position).getPhone()
                        + "\n" + "Адрес: " + getItem(position).getAddress()
                        + "\n" + "Время подачи: " + getItem(position).getCreated_at()
                        + "\n" + "Вес пассажира: " + getItem(position).getWeight()
                        + "\n" + "Тип мотоцикла: " + getItem(position).getBike_type()
                        + "\n" + "Цена: " + getItem(position).getPrice()
                        + "\n" + "Прочее: " + getItem(position).getAdditional_info()
                        + "\n\n"
                        + "Статус: " + getItem(position).getStatus();

                historyOrdersViewHolder.dateText.setText(timeInfo);
                historyOrdersViewHolder.driverInfoText.setText(driverInfo);
                historyOrdersViewHolder.infoText.setText(info);

                break;
            }
        }

    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public Order getItem(int position) {
        return orderList.get(position);
    }

    public OrderListItemClickListener getOrderListItemClickListener() {
        return orderListItemClickListener;
    }

    public void setOrderListItemClickListener(OrderListItemClickListener orderListItemClickListener) {
        this.orderListItemClickListener = orderListItemClickListener;
    }

    private class MyOrdersViewHolder extends BaseOrdersViewHolder {

        public MyOrdersViewHolder(View itemView) {
            super(itemView);
        }
    }

    private class HistoryOrdersViewHolder extends BaseOrdersViewHolder {

        public TextView driverInfoText;

        public HistoryOrdersViewHolder(View itemView) {
            super(itemView);

            driverInfoText = itemView.findViewById(R.id.driver_info_text);
            driverInfoText.setVisibility(View.VISIBLE);
        }
    }

    private class ActiveOrdersViewHolder extends BaseOrdersViewHolder {

        public Button button;

        public ActiveOrdersViewHolder(View itemView) {
            super(itemView);

            button = itemView.findViewById(R.id.order_btn);
            button.setVisibility(View.VISIBLE);
        }
    }

    private class BaseOrdersViewHolder extends RecyclerView.ViewHolder {

        public TextView dateText;
        public TextView infoText;

        public BaseOrdersViewHolder(View itemView) {
            super(itemView);

            dateText = itemView.findViewById(R.id.date_txt);
            infoText = itemView.findViewById(R.id.info_text);

        }
    }

}
