package agency.yad.mototaxi24.order;

import android.annotation.SuppressLint;
import android.util.Log;

import agency.yad.mototaxi24.base.Presenter;
import agency.yad.mototaxi24.model.response.BaseResponse;
import agency.yad.mototaxi24.network.NetworkClient;
import agency.yad.mototaxi24.network.NetworkInterface;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr.
 */
public class NewOrderPresenter implements Presenter<NewOrderView> {

    private NewOrderView view;
    private final String TAG = NewOrderView.class.getSimpleName();

    @Override
    public void attachView(NewOrderView view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @SuppressLint("CheckResult")
    public void addNewOrder(String token,
                            String name,
                            String phone,
                            String time,
                            String address,
                            String bikeType,
                            Integer weight,
                            Integer price,
                            Integer clientsAmount,
                            String additionalInfo,
                            Integer orderDateTime) {

        getObservable(token, name, phone, time, address,
                bikeType, weight, price, clientsAmount,
                additionalInfo, orderDateTime).subscribeWith(getObserver());

    }

    private Observable<BaseResponse> getObservable(String token,
                                                   String name,
                                                   String phone,
                                                   String time,
                                                   String address,
                                                   String bikeType,
                                                   Integer weight,
                                                   Integer price,
                                                   Integer clientsAmount,
                                                   String additionalInfo,
                                                   Integer orderDateTime) {

        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .addOrder(token, name, phone, time, address,
                        bikeType, weight, price, clientsAmount,
                        additionalInfo, orderDateTime)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<BaseResponse> getObserver() {
        return new DisposableObserver<BaseResponse>() {
            @Override
            public void onNext(BaseResponse authResponse) {
                Log.d(TAG, "onNext: ");
                view.onReceiveResponse(authResponse);
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
