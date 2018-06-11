package agency.yad.mototaxi24.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import agency.yad.mototaxi24.R;
import agency.yad.mototaxi24.data.preferences.KeyValueStorage;

public abstract class BaseActivity extends AppCompatActivity implements  BaseView{


    protected FrameLayout container;
    protected Toolbar toolbar;
    protected TextView toolbarTitle;
    protected ImageButton arrowBack;
    protected AppBarLayout appBarLayout;
    protected CoordinatorLayout coordinatorLayout;
    protected View loading;

    protected ProgressDialog progressDialog;
    protected AlertDialog dialog;


    protected KeyValueStorage keyValueStorage;


    @LayoutRes
    protected int getBaseViewLayoutId() {
        return R.layout.activity_base;
    }

    @LayoutRes
    protected int getToolbarLayoutId() {
        return R.layout.toolbar;
    }

    /**
     * Implement this to change using arrow back
     */
    protected abstract boolean getUseArrowBack();

    /**
     * Implement this to instantiate your title
     */
    protected abstract String getToolbarTitle();

    /**
     * Implement this to instantiate your container views.
     */
    protected abstract void initViews();

    /**
     * Override this if you want to change up the container content.
     */
    @LayoutRes
    protected abstract int getContentViewLayoutId();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getBaseViewLayoutId());

        container = findViewById(R.id.container);

        ViewStub toolbarStub = findViewById(R.id.toolbar_stub);
        toolbarStub.setLayoutResource(getToolbarLayoutId());
        toolbarStub.inflate();

        keyValueStorage = new KeyValueStorage(this);

        toolbar = findViewById(R.id.toolbar);
        toolbarTitle = findViewById(R.id.toolbar_title);
        arrowBack = findViewById(R.id.arrow_back);

        loading = findViewById(R.id.loading);

        appBarLayout = findViewById(R.id.appbar);
        coordinatorLayout = findViewById(R.id.main_content);

        toolbarTitle.setText(getToolbarTitle());

        if (getUseArrowBack()) {
            arrowBack.setVisibility(View.VISIBLE);
            arrowBack.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } else
            arrowBack.setVisibility(View.GONE);


        setContentFrame();
        initViews();
    }

    @Override
    public void showLoading(boolean show) {
        if (show) {
            loading.setVisibility(View.VISIBLE);
        } else {
            loading.setVisibility(View.GONE);
        }
    }

    protected void setContentFrame() {
        getLayoutInflater().inflate(getContentViewLayoutId(), container);
    }
}
