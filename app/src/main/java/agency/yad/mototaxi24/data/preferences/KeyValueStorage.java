package agency.yad.mototaxi24.data.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import io.reactivex.annotations.NonNull;

/**
 * Created by Alexandr.
 */
public class KeyValueStorage {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public static final String USER_DISPATCHER = "user_dispatcher";
    public static final String USER_DRIVER = "user_driver";

    public KeyValueStorage(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("MotoTaxi24", 0);
        editor = sharedPreferences.edit();
    }


    public void setDriverToken(@NonNull String driverToken) {
        editor.putString("driver_token", driverToken);
        editor.commit();
    }

    public String getDriverToken() {
        return sharedPreferences.getString("driver_token", null);
    }

    public void setDispatcherToken(@NonNull String dispatcherToken) {
        editor.putString("dispatcher_token", dispatcherToken);
        editor.commit();
    }

    public String getDispatcherToken() {
        return sharedPreferences.getString("dispatcher_token", null);
    }

    public void setIsNowLogIn(@NonNull boolean isLogIn) {
        editor.putBoolean("is_log_in", isLogIn);
        editor.commit();
    }

    public void setLoginedUser(@NonNull String user) {
        editor.putString("logined_user", user);
        editor.commit();
    }

    public String getLoginedUser() {
        return sharedPreferences.getString("logined_user", null);
    }

    public boolean isNowLogIn() {return sharedPreferences.getBoolean("is_log_in", false);}

}
