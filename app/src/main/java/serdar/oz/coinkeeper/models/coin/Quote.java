
package serdar.oz.coinkeeper.models.coin;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Quote {

    @SerializedName("USD")
    private USD mUSD;

    public USD getUSD() {
        return mUSD;
    }

    public void setUSD(USD uSD) {
        mUSD = uSD;
    }

}
