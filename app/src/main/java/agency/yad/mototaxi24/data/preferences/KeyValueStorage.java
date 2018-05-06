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

    public KeyValueStorage(@NonNull Context context) {
        sharedPreferences = context.getSharedPreferences("MotoTaxi24", 0);
        editor = sharedPreferences.edit();
    }

    public void setIsLogIn(@NonNull boolean isLogIn) {
        editor.putBoolean("is_log_in", isLogIn);
        editor.commit();
    }

    public boolean isLogIn() {return sharedPreferences.getBoolean("is_log_in", false);}

}
