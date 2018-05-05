package agency.yad.mototaxi24;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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

    }
}
