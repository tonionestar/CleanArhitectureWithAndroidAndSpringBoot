package ro.ovidiuconeac.client.features.featurex.presentation.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ro.ovidiuconeac.client.features.cache.Cache;
import ro.ovidiuconeac.client.features.common.Presenter;
import ro.ovidiuconeac.client.features.featurex.presentation.presenter.MainPresenter;
import ro.ovidiuconeac.client.features.featurex.presentation.presenter.MainPresenterImpl;
import ro.ovidiuconeac.presentationlayer.R;

public class MainActivity extends AppCompatActivity implements MainView {

    // Fruit1
    @BindView(R.id.progressBarFruit1)
    ProgressBar progressBarFruit1;
    @BindView(R.id.fruit1)
    EditText fruit1;
    @BindView(R.id.get_fruit1)
    Button getFruit1;
    // Fruit2
    @BindView(R.id.progressBarFruit2)
    ProgressBar progressBarFruit2;
    @BindView(R.id.fruit2)
    EditText fruit2;
    @BindView(R.id.get_fruit2)
    Button getFruit2;
    // Cheese1
    @BindView(R.id.progressBarCheese1)
    ProgressBar progressBarCheese1;
    @BindView(R.id.cheese1)
    EditText cheese1;
    @BindView(R.id.get_cheese1)
    Button getCheese1;
    // Cheese2
    @BindView(R.id.progressBarCheese2)
    ProgressBar progressBarCheese2;
    @BindView(R.id.cheese2)
    EditText cheese2;
    @BindView(R.id.get_cheese2)
    Button getCheese2;
    // Sweet1
    @BindView(R.id.progressBarSweet1)
    ProgressBar progressBarSweet1;
    @BindView(R.id.sweet1)
    EditText sweet1;
    @BindView(R.id.get_sweet1)
    Button getSweet1;
    // Sweet2
    @BindView(R.id.progressBarSweet2)
    ProgressBar progressBarSweet2;
    @BindView(R.id.sweet2)
    EditText sweet2;
    @BindView(R.id.get_sweet2)
    Button getSweet2;

    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        progressBarFruit1.setVisibility(View.INVISIBLE);
        progressBarFruit2.setVisibility(View.INVISIBLE);
        progressBarCheese1.setVisibility(View.INVISIBLE);
        progressBarCheese2.setVisibility(View.INVISIBLE);
        progressBarSweet1.setVisibility(View.INVISIBLE);
        progressBarSweet2.setVisibility(View.INVISIBLE);
        presenter = new MainPresenterImpl(this);
        // Hide keyboard
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("presenter_uuid", presenter.getUuid().toString());
        cachePresenter(presenter);
        // Fruit1
        outState.putInt("progressBarFruit1", progressBarFruit1.getVisibility());
        outState.putBoolean("fruit1", fruit1.isEnabled());
        outState.putString("fruit1_txt", fruit1.getText().toString());
        outState.putBoolean("getFruit1", getFruit1.isEnabled());
        // Fruit2
        outState.putInt("progressBarFruit2", progressBarFruit2.getVisibility());
        outState.putBoolean("fruit2", fruit2.isEnabled());
        outState.putString("fruit2_txt", fruit2.getText().toString());
        outState.putBoolean("getFruit2", getFruit2.isEnabled());
        // Cheese1
        outState.putInt("progressBarCheese1", progressBarCheese1.getVisibility());
        outState.putBoolean("cheese1", cheese1.isEnabled());
        outState.putString("cheese1_txt", cheese1.getText().toString());
        outState.putBoolean("getCheese1", getCheese1.isEnabled());
        // Cheese2
        outState.putInt("progressBarCheese2", progressBarCheese2.getVisibility());
        outState.putBoolean("cheese2", cheese2.isEnabled());
        outState.putString("cheese2_txt", cheese2.getText().toString());
        outState.putBoolean("getCheese2", getCheese2.isEnabled());
        // Sweet1
        outState.putInt("progressBarSweet1", progressBarSweet1.getVisibility());
        outState.putBoolean("sweet1", sweet1.isEnabled());
        outState.putString("sweet1_txt", sweet1.getText().toString());
        outState.putBoolean("getSweet1", getSweet1.isEnabled());
        // Sweet2
        outState.putInt("progressBarSweet2", progressBarSweet2.getVisibility());
        outState.putBoolean("sweet2", sweet2.isEnabled());
        outState.putString("sweet2_txt", sweet2.getText().toString());
        outState.putBoolean("getSweet2", getSweet2.isEnabled());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        restorePresenter(UUID.fromString(savedInstanceState.getString("presenter_uuid")));
        // Fruit1
        progressBarFruit1.setVisibility(savedInstanceState.getInt("progressBarFruit1") == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        fruit1.setEnabled(savedInstanceState.getBoolean("fruit1"));
        fruit1.setText(savedInstanceState.getString("fruit1_txt"));
        getFruit1.setEnabled(savedInstanceState.getBoolean("getFruit1"));
        // Fruit2
        progressBarFruit2.setVisibility(savedInstanceState.getInt("progressBarFruit2") == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        fruit2.setEnabled(savedInstanceState.getBoolean("fruit2"));
        fruit1.setText(savedInstanceState.getString("fruit2_txt"));
        getFruit2.setEnabled(savedInstanceState.getBoolean("getFruit2"));
        // Cheese1
        progressBarCheese1.setVisibility(savedInstanceState.getInt("progressBarCheese1") == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        cheese1.setEnabled(savedInstanceState.getBoolean("cheese1"));
        cheese1.setText(savedInstanceState.getString("cheese1_txt"));
        getCheese1.setEnabled(savedInstanceState.getBoolean("getCheese1"));
        // Cheese2
        progressBarCheese2.setVisibility(savedInstanceState.getInt("progressBarCheese2") == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        cheese2.setEnabled(savedInstanceState.getBoolean("cheese2"));
        cheese2.setText(savedInstanceState.getString("cheese2_txt"));
        getCheese2.setEnabled(savedInstanceState.getBoolean("getCheese2"));
        // Sweet1
        progressBarSweet1.setVisibility(savedInstanceState.getInt("progressBarSweet1") == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        sweet1.setEnabled(savedInstanceState.getBoolean("sweet1"));
        sweet1.setText(savedInstanceState.getString("sweet1_txt"));
        getSweet1.setEnabled(savedInstanceState.getBoolean("getSweet1"));
        // Sweet2
        progressBarSweet2.setVisibility(savedInstanceState.getInt("progressBarSweet2") == View.VISIBLE ? View.VISIBLE : View.INVISIBLE);
        sweet2.setEnabled(savedInstanceState.getBoolean("sweet2"));
        sweet2.setText(savedInstanceState.getString("sweet2_txt"));
        getSweet2.setEnabled(savedInstanceState.getBoolean("getSweet2"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @OnClick(R.id.get_fruit1)
    @Override
    public void requestFruit1() {
        enableUiFruit1(false);
        presenter.requestFruit1();
    }

    @Override
    public void postFruit1(String fruit) {
        enableUiFruit1(true);
        fruit1.setText(fruit);
    }

    @Override
    public void enableUiFruit1(boolean enable) {
        if (enable) {
            progressBarFruit1.setVisibility(View.INVISIBLE);
        } else {
            progressBarFruit1.setVisibility(View.VISIBLE);
        }
        fruit1.setEnabled(enable);
        getFruit1.setEnabled(enable);
    }

    @Override
    public void postFruit1RequestError() {
        Toast.makeText(this, getString(R.string.fruit1_request_error), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.get_fruit2)
    @Override
    public void requestFruit2() {
        enableUiFruit2(false);
        presenter.requestFruit2();
    }

    @Override
    public void postFruit2(String fruit) {
        enableUiFruit2(true);
        fruit2.setText(fruit);
    }

    @Override
    public void enableUiFruit2(boolean enable) {
        if (enable) {
            progressBarFruit2.setVisibility(View.INVISIBLE);
        } else {
            progressBarFruit2.setVisibility(View.VISIBLE);
        }
        fruit2.setEnabled(enable);
        getFruit2.setEnabled(enable);
    }

    @Override
    public void postFruit2RequestError() {
        Toast.makeText(this, getString(R.string.fruit2_request_error), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.get_cheese1)
    @Override
    public void requestCheese1() {
        enableUiCheese1(false);
        presenter.requestCheese1();
    }

    @Override
    public void postCheese1(String cheese) {
        enableUiCheese1(true);
        cheese1.setText(cheese);
    }

    @Override
    public void enableUiCheese1(boolean enable) {
        if (enable) {
            progressBarCheese1.setVisibility(View.INVISIBLE);
        } else {
            progressBarCheese1.setVisibility(View.VISIBLE);
        }
        cheese1.setEnabled(enable);
        getCheese1.setEnabled(enable);
    }

    @Override
    public void postCheese1RequestError() {
        Toast.makeText(this, getString(R.string.cheese1_request_error), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.get_cheese2)
    @Override
    public void requestCheese2() {
        enableUiCheese2(false);
        presenter.requestCheese2();
    }

    @Override
    public void postCheese2(String cheese) {
        enableUiCheese2(true);
        cheese2.setText(cheese);
    }

    @Override
    public void enableUiCheese2(boolean enable) {
        if (enable) {
            progressBarCheese2.setVisibility(View.INVISIBLE);
        } else {
            progressBarCheese2.setVisibility(View.VISIBLE);
        }
        cheese2.setEnabled(enable);
        getCheese2.setEnabled(enable);
    }

    @Override
    public void postCheese2RequestError() {
        Toast.makeText(this, getString(R.string.cheese2_request_error), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.get_sweet1)
    @Override
    public void requestSweet1() {
        enableUiSweet1(false);
        presenter.requestSweet1();
    }

    @Override
    public void postSweet1(String sweet) {
        enableUiSweet1(true);
        sweet1.setText(sweet);
    }

    @Override
    public void enableUiSweet1(boolean enable) {
        if (enable) {
            progressBarSweet1.setVisibility(View.INVISIBLE);
        } else {
            progressBarSweet1.setVisibility(View.VISIBLE);
        }
        sweet1.setEnabled(enable);
        getSweet1.setEnabled(enable);
    }

    @Override
    public void postSweet1RequestError() {
        Toast.makeText(this, getString(R.string.sweet1_request_error), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.get_sweet2)
    @Override
    public void requestSweet2() {
        enableUiSweet2(false);
        presenter.requestSweet2();
    }

    @Override
    public void postSweet2(String sweet) {
        enableUiSweet2(true);
        sweet2.setText(sweet);
    }

    @Override
    public void enableUiSweet2(boolean enable) {
        if (enable) {
            progressBarSweet2.setVisibility(View.INVISIBLE);
        } else {
            progressBarSweet2.setVisibility(View.VISIBLE);
        }
        sweet2.setEnabled(enable);
        getSweet2.setEnabled(enable);
    }

    @Override
    public void postSweet2RequestError() {
        Toast.makeText(this, getString(R.string.sweet2_request_error), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void cachePresenter(Presenter presenter) {
        Cache.getInstance().cachePresenterFor(presenter.getUuid(), presenter);
    }

    @Override
    public void restorePresenter(UUID uuid) {
        presenter = (MainPresenter) Cache.getInstance().restorePresenterFor(uuid);
        presenter.setScreen(this);
    }
}