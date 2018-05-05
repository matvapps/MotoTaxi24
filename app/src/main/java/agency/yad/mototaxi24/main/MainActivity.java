package agency.yad.mototaxi24.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.auth.AuthActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button buttonDriver;
    private Button buttonDispatcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonDriver = findViewById(R.id.button_driver);
        buttonDispatcher = findViewById(R.id.button_dispatcher);


        buttonDriver.setOnClickListener(this);
        buttonDispatcher.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_dispatcher: {
                AuthActivity.start(MainActivity.this);
                break;
            }
        }
    }
}
