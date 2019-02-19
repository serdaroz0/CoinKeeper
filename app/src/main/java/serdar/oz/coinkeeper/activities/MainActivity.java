package serdar.oz.coinkeeper.activities;

import android.os.Bundle;
import android.support.design.bottomnavigation.LabelVisibilityMode;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.coinkeeper.R;
import serdar.oz.coinkeeper.database.AppDatabase;
import serdar.oz.coinkeeper.fragments.CoinsActionFragment;
import serdar.oz.coinkeeper.fragments.MainFragment;
import serdar.oz.coinkeeper.fragments.MenuFragment;
import serdar.oz.coinkeeper.fragments.NewsFragment;
import serdar.oz.coinkeeper.database.DatabaseInitalizer;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private static final String BACK_STACK_ROOT_TAG = "fragment";

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
        switch (item.getItemId()) {
            case R.id.navigation_home:
                changeFragment("main", null);
                return true;
            case R.id.navigation_news:
                changeFragment("news", null);
                return true;
            case R.id.navigation_coins:
                changeFragment("coinsAction", null);
                return true;
            case R.id.navigation_menu:
                changeFragment("menu", null);
                return true;
        }
        return false;
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseInitalizer.populateAsync(AppDatabase.getAppDatabase(this));
        ButterKnife.bind(this);
        if (savedInstanceState == null)
            changeFragment("main", null);
        navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setItemIconTintList(null);
        navigation.setLabelVisibilityMode(LabelVisibilityMode.LABEL_VISIBILITY_LABELED);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    public void changeFragment(String fragmentName, Bundle bundle) {
        Fragment fragment = null;
        switch (fragmentName) {
            case "news":
                fragment = NewsFragment.newInstance();
                break;
            case "coinsAction":
                fragment = CoinsActionFragment.newInstance();
                break;
            case "main":
                fragment = MainFragment.newInstance();
                break;
            case "menu":
                fragment = MenuFragment.newInstance();
                break;

        }
        Objects.requireNonNull(fragment).setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).addToBackStack(BACK_STACK_ROOT_TAG).commit();

    }


}
