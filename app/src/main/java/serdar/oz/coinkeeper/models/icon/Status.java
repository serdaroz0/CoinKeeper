package serdar.oz.coinkeeper.models.icon;

public class Status {

    private String elapsed;

    private String timestamp;

    private String error_message;

    private String error_code;

    private String credit_count;

    public String getElapsed() {
        return elapsed;
    }

    public void setElapsed(String elapsed) {
        this.elapsed = elapsed;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getCredit_count() {
        return credit_count;
    }

    public void setCredit_count(String credit_count) {
        this.credit_count = credit_count;
    }

}
