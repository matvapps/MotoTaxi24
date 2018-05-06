package agency.yad.mototaxi24.auth;

import android.annotation.SuppressLint;
import android.util.Log;

import agency.yad.mototaxi24.model.response.AuthResponse;
import agency.yad.mototaxi24.network.NetworkClient;
import agency.yad.mototaxi24.network.NetworkInterface;
import agency.yad.mototaxi24.base.Presenter;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr
 */

public class AuthPresenter implements Presenter<AuthView> {

    private final String TAG = AuthPresenter.class.getSimpleName();
    private AuthView view;


    public AuthPresenter() {}

    @Override
    public void attachView(AuthView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = view;
    }


    @SuppressLint("CheckResult")
    public void tryAuth(String email, String password) {
        getObservable(email, password).subscribeWith(getObserver());
    }


    private Observable<AuthResponse> getObservable(String email, String password) {
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .tryAuth(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<AuthResponse> getObserver() {
        return new DisposableObserver<AuthResponse>() {
            @Override
            public void onNext(AuthResponse authResponse) {
                Log.d(TAG, "onNext: ");
                view.onAuth(authResponse);
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
