package agency.yad.mototaxi24.network;

import android.support.annotation.NonNull;

import agency.yad.mototaxi24.model.response.AuthResponse;
import agency.yad.mototaxi24.model.response.BaseResponse;
import agency.yad.mototaxi24.model.response.OrdersResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Alexandr
 */

public interface NetworkInterface {

    @POST("dispatcher/auth")
    Observable<AuthResponse> tryAuth(@NonNull @Query("email") String email,
                                     @NonNull @Query("password") String password);

    @POST("order/create")
    Observable<BaseResponse> addOrder(@NonNull @Query("token") String token,
                                      @NonNull @Query("name") String name,
                                      @NonNull @Query("phone") String phone,
                                      @NonNull @Query("order_time") Long time,
                                      @NonNull @Query("address") String address,
                                      @NonNull @Query("bike_type") String bikeType,
                                      @NonNull @Query("weight") Integer weight,
                                      @NonNull @Query("price") Float price,
                                      @NonNull @Query("amount_clients") Integer clientsAmount,
                                      @NonNull @Query("additional_info") String additionalInfo,
                                      @Query("order_datetime") Integer orderDateTime);

    @POST("order/delete")
    Observable<BaseResponse> deleteOrder(@NonNull @Query("id") Integer id);

    @GET("orders/active")
    Observable<OrdersResponse> getActiveOrders();

    @GET("orders/all")
    Observable<OrdersResponse> getOrders();

}
