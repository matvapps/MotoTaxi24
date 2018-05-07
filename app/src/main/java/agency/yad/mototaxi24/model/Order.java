package agency.yad.mototaxi24.model;

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
    private String name;

    @SerializedName("phone")
    @Expose
    private String phone;

    @SerializedName("order_datetime")
    @Expose
    private String order_datetime;

    @SerializedName("order_time")
    @Expose
    private String order_time;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("bike_type")
    @Expose
    private String bike_type;

    @SerializedName("weight")
    @Expose
    private Integer weight;

    @SerializedName("price")
    @Expose
    private Float price;

    @SerializedName("amount_clients")
    @Expose
    private Integer amount_clients;

    @SerializedName("additional_info")
    @Expose
    private String additional_info;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("created_at")
    @Expose
    private String created_at;

    @SerializedName("updated_at")
    @Expose
    private String updated_at;

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

    public Order(Integer id, String name, String phone, String order_datetime, String order_time,
                 String address, String bike_type, Integer weight, Float price, Integer amount_clients,
                 String additional_info, String status, String created_at, String updated_at) {
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

    public Order(Integer id, String name, String phone, String order_datetime, String order_time,
                 String address, String bike_type, Integer weight, Float price, Integer amount_clients,
                 String additional_info, String status, String created_at, String updated_at,
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOrder_datetime() {
        return order_datetime;
    }

    public void setOrder_datetime(String order_datetime) {
        this.order_datetime = order_datetime;
    }

    public String getOrder_time() {
        return order_time;
    }

    public void setOrder_time(String order_time) {
        this.order_time = order_time;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBike_type() {
        return bike_type;
    }

    public void setBike_type(String bike_type) {
        this.bike_type = bike_type;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getAmount_clients() {
        return amount_clients;
    }

    public void setAmount_clients(Integer amount_clients) {
        this.amount_clients = amount_clients;
    }

    public String getAdditional_info() {
        return additional_info;
    }

    public void setAdditional_info(String additional_info) {
        this.additional_info = additional_info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
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
