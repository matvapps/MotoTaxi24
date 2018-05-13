package agency.yad.mototaxi24.push;

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
public class SendPushPresenter implements Presenter<SendPushView> {

    private final String TAG = SendPushPresenter.class.getSimpleName();

    private SendPushView view;



    @SuppressLint("CheckResult")
    public void sendPush(String message) {
        getObservable(message).subscribeWith(getObserver());
    }

    private Observable<BaseResponse> getObservable(String message) {

        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .sendPush("Информация", message)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<BaseResponse> getObserver() {
        return new DisposableObserver<BaseResponse>() {
            @Override
            public void onNext(BaseResponse response) {
                Log.d(TAG, "onNext: ");
                view.onSendPush(response);
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



    @Override
    public void attachView(SendPushView view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
