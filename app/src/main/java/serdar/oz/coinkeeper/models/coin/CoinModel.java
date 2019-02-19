
package serdar.oz.coinkeeper.models.coin;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CoinModel {

    @SerializedName("data")
    private List<Datum> mData;
    @SerializedName("status")
    private Status mStatus;

    public List<Datum> getData() {
        return mData;
    }

    public void setData(List<Datum> data) {
        mData = data;
    }

    public Status getStatus() {
        return mStatus;
    }

    public void setStatus(Status status) {
        mStatus = status;
    }

}
