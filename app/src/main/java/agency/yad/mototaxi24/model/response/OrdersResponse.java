package agency.yad.mototaxi24.model.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import agency.yad.mototaxi24.model.Order;

/**
 * Created by Alexandr
 */

public class OrdersResponse {

    @SerializedName("code")
    @Expose
    private Integer code;

    @SerializedName("orders")
    @Expose
    private List<Order> orders;

    public OrdersResponse() {
    }

    public OrdersResponse(Integer code, List<Order> orders) {
        this.code = code;
        this.orders = orders;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
