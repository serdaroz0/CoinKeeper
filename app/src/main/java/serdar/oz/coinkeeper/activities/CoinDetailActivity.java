package serdar.oz.coinkeeper.activities;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import serdar.oz.coinkeeper.R;
import serdar.oz.coinkeeper.models.icon.IconModel;
import serdar.oz.coinkeeper.services.IconRequest;
import serdar.oz.coinkeeper.services.ServicesApi;
import serdar.oz.coinkeeper.utils.Util;

public class CoinDetailActivity extends AppCompatActivity {
    @BindView(R.id.tvPercentChange1h)
    TextView tvPercentChange1h;
    @BindView(R.id.tvPercentChange7d)
    TextView tvPercentChange7d;
    @BindView(R.id.tvPercentChange24h)
    TextView tvPercentChange24h;
    @BindView(R.id.tvCirculatingSupply)
    TextView tvCirculatingSupply;
    @BindView(R.id.tvMaxSupply)
    TextView tvMaxSupply;
    @BindView(R.id.tvCoinName)
    TextView tvCoinName;
    @BindView(R.id.ivIcon)
    ImageView ivIcon;
    Long coinId;
    private IconModel iconModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coin_detail);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            try {
                coinId = extras.getLong("coinId", -1);
                if (coinId != -1)
                    getIcon(String.valueOf(coinId));
                tvMaxSupply.setText(String.valueOf(extras.getLong("maxSupply")));
                tvCirculatingSupply.setText(String.valueOf(extras.getSerializable("circulatingSupply")));
                tvPercentChange24h.setText(String.valueOf(extras.getDouble("24hChange")));
                tvPercentChange7d.setText(String.valueOf(extras.getDouble("7dChange")));
                tvPercentChange1h.setText(String.valueOf(extras.getDouble("1hChange")));
                tvCoinName.setText(extras.getString(extras.getString("coinName")));
            } catch (Exception ex) {/*pass*/}
        }


    }

    private void getIcon(String iconId) {
        ProgressDialog progressDialog = Util.showProgressDialog(this);
        ServicesApi iconService = IconRequest.getApiClient().create(ServicesApi.class);
        Call<IconModel> icon = iconService.getIcon(iconId);
        icon.enqueue(new Callback<IconModel>() {
            @Override
            public void onResponse(@NonNull Call<IconModel> call, @NonNull Response<IconModel> response) {
                if (response.isSuccessful()) {
                    iconModel = response.body();
                    if (!iconModel.getData().get2().getLogo().equals(""))
                        try {
                            CircularProgressDrawable circularProgressDrawable = new CircularProgressDrawable(CoinDetailActivity.this);
                            circularProgressDrawable.setStrokeWidth(8f);
                            circularProgressDrawable.setCenterRadius(64f);
                            circularProgressDrawable.setColorSchemeColors(Color.BLACK);
                            circularProgressDrawable.start();
                            Glide.with(CoinDetailActivity.this).load(iconModel.getData().get2().getLogo()).apply(new RequestOptions()
                                    .centerCrop()
                                    .placeholder(circularProgressDrawable)
                                    .error(R.drawable.ic_investor)
                                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                                    .priority(Priority.HIGH)).into(ivIcon);
                            ivIcon.setScaleType(ImageView.ScaleType.FIT_XY);
                        } catch (Exception ex) {
                            //pass
                        }
                } else
                    Util.errorMessage(CoinDetailActivity.this, response.code());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<IconModel> call, Throwable t) {
                progressDialog.dismiss();
                Util.networkErrorMessage(CoinDetailActivity.this);
            }
        });
    }

    public void backPressed(View view) {
        onBackPressed();
    }

}
