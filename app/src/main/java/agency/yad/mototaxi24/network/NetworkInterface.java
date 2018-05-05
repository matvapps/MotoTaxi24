package agency.yad.mototaxi24.network;

import android.support.annotation.NonNull;

import agency.yad.mototaxi24.auth.AuthResponse;
import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by Alexandr
 */

public interface NetworkInterface {

//    @GET("discover/movie")
//    Observable<MovieResponse> getMovies(@Query("api_key") String api_key);


    /**
     *
     * @param email required
     * @param password required
     * @return
     */
    @POST("dispatcher/auth")
    Observable<AuthResponse> tryAuth(@NonNull @Query("email") String email,
                                     @NonNull @Query("password") String password);

}
