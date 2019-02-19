package serdar.oz.coinkeeper.models.icon;

import com.google.gson.annotations.SerializedName;

public class Data {
    @SerializedName("2")
    private Two two;

    public Two get2() {
        return two;
    }

    public void set2(Two two) {
        this.two = two;
    }
}
