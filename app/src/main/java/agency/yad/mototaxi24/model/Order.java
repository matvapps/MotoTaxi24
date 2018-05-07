package agency.yad.mototaxi24.model;

import android.support.annotation.WorkerThread;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Alexandr
 */

public class Order {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("name")
    @Expose
    private Integer name;

    @SerializedName("phone")
    @Expose
    private Integer phone;

    @SerializedName("order_datetime")
    @Expose
    private Integer order_datetime;

    @SerializedName("order_time")
    @Expose
    private Integer order_time;

    @SerializedName("address")
    @Expose
    private Integer address;

    @SerializedName("bike_type")
    @Expose
    private Integer bike_type;

    @SerializedName("weight")
    @Expose
    private Integer weight;

    @SerializedName("price")
    @Expose
    private Integer price;

    @SerializedName("amount_clients")
    @Expose
    private Integer amount_clients;

    @SerializedName("additional_info")
    @Expose
    private Integer additional_info;

    @SerializedName("status")
    @Expose
    private Integer status;

    @SerializedName("created_at")
    @Expose
    private Integer created_at;

    @SerializedName("updated_at")
    @Expose
    private Integer updated_at;

    @SerializedName("driver_fio")
    @Expose
    private String driverFio;

    @SerializedName("driver_phone")
    @Expose
    private String driverPhone;

    @SerializedName("driver_bike_type")
    @Expose
    private String driverBikeType;

    @SerializedName("driver_bike_model")
    @Expose
    private String driverBikeModel;


    public Order() {
    }

    public Order(Integer id, Integer name, Integer phone, Integer order_datetime, Integer order_time,
                 Integer address, Integer bike_type, Integer weight, Integer price, Integer amount_clients,
                 Integer additional_info, Integer status, Integer created_at, Integer updated_at) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.order_datetime = order_datetime;
        this.order_time = order_time;
        this.address = address;
        this.bike_type = bike_type;
        this.weight = weight;
        this.price = price;
        this.amount_clients = amount_clients;
        this.additional_info = additional_info;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Order(Integer id, Integer name, Integer phone, Integer order_datetime, Integer order_time,
                 Integer address, Integer bike_type, Integer weight, Integer price, Integer amount_clients,
                 Integer additional_info, Integer status, Integer created_at, Integer updated_at,
                 String driverFio, String driverPhone, String driverBikeType, String driverBikeModel) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.order_datetime = order_datetime;
        this.order_time = order_time;
        this.address = address;
        this.bike_type = bike_type;
        this.weight = weight;
        this.price = price;
        this.amount_clients = amount_clients;
        this.additional_info = additional_info;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.driverFio = driverFio;
        this.driverPhone = driverPhone;
        this.driverBikeType = driverBikeType;
        this.driverBikeModel = driverBikeModel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Integer getOrder_datetime() {
        return order_datetime;
    }

    public void setOrder_datetime(Integer order_datetime) {
        this.order_datetime = order_datetime;
    }

    public Integer getOrder_time() {
        return order_time;
    }

    public void setOrder_time(Integer order_time) {
        this.order_time = order_time;
    }

    public Integer getAddress() {
        return address;
    }

    public void setAddress(Integer address) {
        this.address = address;
    }

    public Integer getBike_type() {
        return bike_type;
    }

    public void setBike_type(Integer bike_type) {
        this.bike_type = bike_type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getAmount_clients() {
        return amount_clients;
    }

    public void setAmount_clients(Integer amount_clients) {
        this.amount_clients = amount_clients;
    }

    public Integer getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(Integer additional_info) {
        this.additional_info = additional_info;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Integer created_at) {
        this.created_at = created_at;
    }

    public Integer getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Integer updated_at) {
        this.updated_at = updated_at;
    }

    public String getDriverFio() {
        return driverFio;
    }

    public void setDriverFio(String driverFio) {
        this.driverFio = driverFio;
    }

    public String getDriverPhone() {
        return driverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        this.driverPhone = driverPhone;
    }

    public String getDriverBikeType() {
        return driverBikeType;
    }

    public void setDriverBikeType(String driverBikeType) {
        this.driverBikeType = driverBikeType;
    }

    public String getDriverBikeModel() {
        return driverBikeModel;
    }

    public void setDriverBikeModel(String driverBikeModel) {
        this.driverBikeModel = driverBikeModel;
    }
}
