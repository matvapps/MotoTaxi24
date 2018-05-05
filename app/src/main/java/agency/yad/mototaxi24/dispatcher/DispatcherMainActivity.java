package agency.yad.mototaxi24.dispatcher;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.auth.AuthActivity;

public class DispatcherMainActivity extends AppCompatActivity {

    public static void start(Activity activity) {
        Intent intent = new Intent(activity, DispatcherMainActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispatcher_main);
    }
}
