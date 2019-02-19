
package serdar.oz.coinkeeper.models.coin;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class USD {

    @SerializedName("last_updated")
    private String mLastUpdated;
    @SerializedName("market_cap")
    private Double mMarketCap;
    @SerializedName("percent_change_1h")
    private Double mPercentChange1H;
    @SerializedName("percent_change_24h")
    private Double mPercentChange24H;
    @SerializedName("percent_change_7d")
    private Double mPercentChange7D;
    @SerializedName("price")
    private Double mPrice;
    @SerializedName("volume_24h")
    private Double mVolume24H;

    public String getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public Double getMarketCap() {
        return mMarketCap;
    }

    public void setMarketCap(Double marketCap) {
        mMarketCap = marketCap;
    }

    public Double getPercentChange1H() {
        return mPercentChange1H;
    }

    public void setPercentChange1H(Double percentChange1H) {
        mPercentChange1H = percentChange1H;
    }

    public Double getPercentChange24H() {
        return mPercentChange24H;
    }

    public void setPercentChange24H(Double percentChange24H) {
        mPercentChange24H = percentChange24H;
    }

    public Double getPercentChange7D() {
        return mPercentChange7D;
    }

    public void setPercentChange7D(Double percentChange7D) {
        mPercentChange7D = percentChange7D;
    }

    public Double getPrice() {
        return mPrice;
    }

    public void setPrice(Double price) {
        mPrice = price;
    }

    public Double getVolume24H() {
        return mVolume24H;
    }

    public void setVolume24H(Double volume24H) {
        mVolume24H = volume24H;
    }

}
