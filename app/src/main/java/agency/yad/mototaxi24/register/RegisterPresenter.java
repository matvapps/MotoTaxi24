package agency.yad.mototaxi24.register;

import android.annotation.SuppressLint;
import android.util.Log;

import agency.yad.mototaxi24.base.Presenter;
import agency.yad.mototaxi24.model.response.BaseResponse;
import agency.yad.mototaxi24.model.response.PhotoResponse;
import agency.yad.mototaxi24.network.NetworkClient;
import agency.yad.mototaxi24.network.NetworkInterface;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Alexandr.
 */
public class RegisterPresenter implements Presenter<RegisterView> {

    private final String TAG = RegisterPresenter.class.getSimpleName();
    private RegisterView view;

    @Override
    public void attachView(RegisterView view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

//    @SuppressLint("CheckResult")
//    public void postImage(MultipartBody.Part image) {
//        getUploadImageObservable(image).subscribeWith(getUploadImageObserver());
//    }

    @SuppressLint("CheckResult")
    public void registerDriver(String photo, String photo_bike, String fio, String birthday,
                               String phone, String email, String address, String metro,
                               String experience_year, String bike_model, String bike_type, String bike_year,
                               String bike_color, String exist_docs, String exist_to, String exist_clothes,
                               Integer client_weight, String videoregistrator, String hobbies, String password,
                               String password2, String photo1, String photo2, String photo3,
                               String photo4, String photo5, String photo6, String photo7,
                               String photo8, String photo9, String photo10) {

        getObservable(photo, photo_bike, fio, birthday,
                phone, email, address, metro,
                experience_year, bike_model, bike_type, bike_year,
                bike_color, exist_docs, exist_to, exist_clothes,
                client_weight, videoregistrator, hobbies, password,
                password2, photo1, photo2, photo3,
                photo4, photo5, photo6, photo7,
                photo8, photo9, photo10)
                .subscribeWith(getObserver());

    }

//    private Observable<PhotoResponse> getUploadImageObservable(MultipartBody.Part image) {
//        return NetworkClient.getRetrofit().create(NetworkInterface.class)
//                .postImage(image)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread());
//    }

    private Observable<BaseResponse> getObservable(String photo, String photo_bike,
                                                   String fio, String birthday,
                                                   String phone, String email,
                                                   String address, String metro,
                                                   String experience_year, String bike_model,
                                                   String bike_type, String bike_year,
                                                   String bike_color, String exist_docs,
                                                   String exist_to, String exist_clothes,
                                                   Integer client_weight, String videoregistrator,
                                                   String hobbies, String password,
                                                   String password2, String photo1,
                                                   String photo2, String photo3,
                                                   String photo4, String photo5,
                                                   String photo6, String photo7,
                                                   String photo8, String photo9,
                                                   String photo10) {

        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .registerDriver(photo,
                        photo_bike,
                        fio,
                        birthday,
                        phone,
                        email,
                        address,
                        metro,
                        experience_year,
                        bike_model,
                        bike_type,
                        bike_year,
                        bike_color,
                        exist_docs,
                        exist_to,
                        exist_clothes,
                        client_weight,
                        videoregistrator,
                        hobbies,
                        password,
                        password2,
                        photo1,
                        photo2,
                        photo3,
                        photo4,
                        photo5,
                        photo6,
                        photo7,
                        photo8,
                        photo9,
                        photo10)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());

    }


    private DisposableObserver<BaseResponse> getObserver() {
        return new DisposableObserver<BaseResponse>() {
            @Override
            public void onNext(BaseResponse baseResponse) {
                Log.d(TAG, "onNext: ");
                view.tryRegister(baseResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
                e.printStackTrace();
                view.showError();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: completed");
            }
        };
    }

    private DisposableObserver<PhotoResponse> getUploadImageObserver() {
        return new DisposableObserver<PhotoResponse>() {
            @Override
            public void onNext(PhotoResponse baseResponse) {
                Log.d(TAG, "onNext: ");
                view.tryUploadPhoto(baseResponse);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: " + e);
                e.printStackTrace();
                view.showError();
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: completed");
            }
        };
    }

}
