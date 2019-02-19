package serdar.oz.coinkeeper.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import serdar.oz.coinkeeper.R;
import serdar.oz.coinkeeper.activities.CoinDetailActivity;
import serdar.oz.coinkeeper.models.coin.Datum;

public class CoinsAdapter extends RecyclerView.Adapter<CoinsAdapter.ViewHolder> {
    private ArrayList<Datum> coins;
    private Context context;
    private boolean fromMain;

    public CoinsAdapter(ArrayList<Datum> coins, Context context, boolean fromMain) {
        this.coins = coins;
        this.context = context;
        this.fromMain = fromMain;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tvName)
        TextView tvName;
        @BindView(R.id.tvType)
        TextView tvType;
        @BindView(R.id.tvPrice)
        TextView tvPrice;
        @BindView(R.id.tvPercentChange)
        TextView tvPercentChange;
        @BindView(R.id.cvCoins)
        CardView cvCoins;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.coins_list_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Datum coinModel = coins.get(position);
        holder.tvName.setText(coinModel.getName());
        holder.tvType.setText(coinModel.getSymbol());
        holder.tvPrice.setText(context.getString(R.string.dolar_format, coinModel.getQuote().getUSD().getPrice()));
        holder.tvPercentChange.setText("%" + coinModel.getQuote().getUSD().getPercentChange24H());
        if (coinModel.getQuote().getUSD().getPercentChange24H().toString().startsWith("-"))
            holder.tvPercentChange.setBackgroundResource(R.drawable.rounded_red);
        else
            holder.tvPercentChange.setBackgroundResource(R.drawable.rounded_green);
        holder.cvCoins.setOnClickListener(v -> {
            Intent intent = new Intent(context, CoinDetailActivity.class);
            intent.putExtra("1hChange", coinModel.getQuote().getUSD().getPercentChange1H());
            intent.putExtra("24hChange", coinModel.getQuote().getUSD().getPercentChange24H());
            intent.putExtra("7dChange", coinModel.getQuote().getUSD().getPercentChange7D());
            intent.putExtra("circulatingSupply", coinModel.getCirculatingSupply());
            intent.putExtra("maxSupply", coinModel.getMaxSupply());
            intent.putExtra("coinId", coinModel.getId());
            intent.putExtra("coinName", coinModel.getName());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return coins == null ? 0 : fromMain ? 3 : coins.size();
    }

}
