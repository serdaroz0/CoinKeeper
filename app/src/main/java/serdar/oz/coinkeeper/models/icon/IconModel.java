package serdar.oz.coinkeeper.models.icon;

import com.google.gson.annotations.SerializedName;

public class IconModel {
    @SerializedName("status")
    private Status status;
    @SerializedName("data")
    private Data data;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
