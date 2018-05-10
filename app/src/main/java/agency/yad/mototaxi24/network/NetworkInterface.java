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
    Observable<AuthResponse> tryAuthDispatcher(@NonNull @Query("email") String email,
                                               @NonNull @Query("password") String password);

    @POST("driver/auth")
    Observable<AuthResponse> tryAuthDriver(@NonNull @Query("email") String email,
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

    @POST("driver/register")
    Observable<BaseResponse> registerDriver(@NonNull @Query("photo") Integer photo,
                                            @NonNull @Query("photo_bike") Integer photo_bike,
                                            @NonNull @Query("fio") String fio,
                                            @NonNull @Query("birthday") String birthday,
                                            @NonNull @Query("phone") String phone,
                                            @NonNull @Query("email") String email,
                                            @NonNull @Query("address") String address,
                                            @NonNull @Query("metro") String metro,
                                            @NonNull @Query("experience_year") String experience_year,
                                            @NonNull @Query("bike_model") String bike_model,
                                            @NonNull @Query("bike_type") String bike_type,
                                            @NonNull @Query("bike_year") String bike_year,
                                            @NonNull @Query("bike_color") String bike_color,
                                            @NonNull @Query("exist_docs") String exist_docs,
                                            @NonNull @Query("exist_to") String exist_to,
                                            @NonNull @Query("exist_clothes") String exist_clothes,
                                            @NonNull @Query("client_weight") Integer client_weight,
                                            @NonNull @Query("videoregistrator") String videoregistrator,
                                            @NonNull @Query("hobbies") String hobbies,
                                            @NonNull @Query("password") String password,
                                            @NonNull @Query("password2") String password2,
                                            @NonNull @Query("photo1") Integer photo1,
                                            @NonNull @Query("photo2") Integer photo2,
                                            @NonNull @Query("photo3") Integer photo3,
                                            @NonNull @Query("photo4") Integer photo4,
                                            @NonNull @Query("photo5") Integer photo5,
                                            @NonNull @Query("photo6") Integer photo6,
                                            @NonNull @Query("photo7") Integer photo7,
                                            @NonNull @Query("photo8") Integer photo8,
                                            @NonNull @Query("photo9") Integer photo9,
                                            @NonNull @Query("photo10") Integer photo10);

    @POST("order/delete")
    Observable<BaseResponse> deleteOrder(@NonNull @Query("id") Integer id);
    @POST("order/done")
    Observable<BaseResponse> doneOrder(@NonNull @Query("id") Integer id);
    @POST("driver/takeorder")
    Observable<BaseResponse> takeOrder(@NonNull @Query("order_id") Integer orderId,
                                       @NonNull @Query("token") String token);



    @POST("driver/myorders")
    Observable<OrdersResponse> getMyOrders(@NonNull @Query("token") String token);
    @GET("orders/active")
    Observable<OrdersResponse> getActiveOrders();
    @GET("orders/all")
    Observable<OrdersResponse> getOrders();

}
