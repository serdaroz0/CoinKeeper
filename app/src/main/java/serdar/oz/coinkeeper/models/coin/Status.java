
package serdar.oz.coinkeeper.models.coin;

import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Status {

    @SerializedName("credit_count")
    private Long mCreditCount;
    @SerializedName("elapsed")
    private Long mElapsed;
    @SerializedName("error_code")
    private Long mErrorCode;
    @SerializedName("error_message")
    private String mErrorMessage;
    @SerializedName("timestamp")
    private String mTimestamp;

    public Long getCreditCount() {
        return mCreditCount;
    }

    public void setCreditCount(Long creditCount) {
        mCreditCount = creditCount;
    }

    public Long getElapsed() {
        return mElapsed;
    }

    public void setElapsed(Long elapsed) {
        mElapsed = elapsed;
    }

    public Long getErrorCode() {
        return mErrorCode;
    }

    public void setErrorCode(Long errorCode) {
        mErrorCode = errorCode;
    }

    public String getErrorMessage() {
        return mErrorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        mErrorMessage = errorMessage;
    }

    public String getTimestamp() {
        return mTimestamp;
    }

    public void setTimestamp(String timestamp) {
        mTimestamp = timestamp;
    }

}
