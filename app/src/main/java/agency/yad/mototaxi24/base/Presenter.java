package agency.yad.mototaxi24.base;

/**
 * Created by Alexandr
 */

public interface Presenter<V> {
    void attachView(V view);
    void detachView();
}
