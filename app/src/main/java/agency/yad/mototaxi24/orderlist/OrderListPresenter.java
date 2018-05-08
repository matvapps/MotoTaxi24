package agency.yad.mototaxi24.orderlist;

import android.annotation.SuppressLint;
import android.util.Log;

import agency.yad.mototaxi24.base.Presenter;
import agency.yad.mototaxi24.model.response.BaseResponse;
import agency.yad.mototaxi24.model.response.OrdersResponse;
import agency.yad.mototaxi24.network.NetworkClient;
import agency.yad.mototaxi24.network.NetworkInterface;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Alexandr.
 */
public class OrderListPresenter implements Presenter<OrderListView> {

    private final String TAG = OrderListPresenter.class.getSimpleName();
    private OrderListView view;

    @Override
    public void attachView(OrderListView view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }


    public void deleteOrder(int id) {
        getDeleteObservable(id).subscribeWith(getDeleteObserver());
    }

    @SuppressLint("CheckResult")
    public void getOrders(String ordersType) {
        getObservable(ordersType).subscribeWith(getObserver());
    }


    private Observable<OrdersResponse> getObservable(String ordersType) {

        Log.d(TAG, "getObservable: ");

        switch (ordersType) {
            case OrderListActivity.ORDERS_HISTORY: {

                return NetworkClient.getRetrofit().create(NetworkInterface.class)
                        .getOrders()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
            case OrderListActivity.ORDERS_ACTIVE_DISPATCHER: {

                return NetworkClient.getRetrofit().create(NetworkInterface.class)
                        .getActiveOrders()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());


            }
        }


        return null;
    }

    private Observable<BaseResponse> getDeleteObservable(int id) {
        return NetworkClient.getRetrofit().create(NetworkInterface.class)
                .deleteOrder(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }


    private DisposableObserver<OrdersResponse> getObserver() {
        return new DisposableObserver<OrdersResponse>() {
            @Override
            public void onNext(OrdersResponse orderResponse) {
                Log.d(TAG, "onNext: ");
                view.getOrders(orderResponse);
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

    private DisposableObserver<BaseResponse> getDeleteObserver() {
        return new DisposableObserver<BaseResponse>() {
            @Override
            public void onNext(BaseResponse baseResponse) {
                Log.d(TAG, "onNext: ");
                view.tryDeleteOrder(baseResponse);
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
