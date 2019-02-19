
package serdar.oz.coinkeeper.models.coin;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@SuppressWarnings("unused")
public class Data {

    @SerializedName("circulating_supply")
    private Long mCirculatingSupply;
    @SerializedName("cmc_rank")
    private Long mCmcRank;
    @SerializedName("date_added")
    private String mDateAdded;
    @SerializedName("id")
    private Long mId;
    @SerializedName("last_updated")
    private String mLastUpdated;
    @SerializedName("max_supply")
    private Long mMaxSupply;
    @SerializedName("name")
    private String mName;
    @SerializedName("num_market_pairs")
    private Long mNumMarketPairs;
    @SerializedName("platform")
    private Object mPlatform;
    @SerializedName("quote")
    private Quote mQuote;
    @SerializedName("slug")
    private String mSlug;
    @SerializedName("symbol")
    private String mSymbol;
    @SerializedName("tags")
    private List<String> mTags;
    @SerializedName("total_supply")
    private Long mTotalSupply;

    public Long getCirculatingSupply() {
        return mCirculatingSupply;
    }

    public void setCirculatingSupply(Long circulatingSupply) {
        mCirculatingSupply = circulatingSupply;
    }

    public Long getCmcRank() {
        return mCmcRank;
    }

    public void setCmcRank(Long cmcRank) {
        mCmcRank = cmcRank;
    }

    public String getDateAdded() {
        return mDateAdded;
    }

    public void setDateAdded(String dateAdded) {
        mDateAdded = dateAdded;
    }

    public Long getId() {
        return mId;
    }

    public void setId(Long id) {
        mId = id;
    }

    public String getLastUpdated() {
        return mLastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        mLastUpdated = lastUpdated;
    }

    public Long getMaxSupply() {
        return mMaxSupply;
    }

    public void setMaxSupply(Long maxSupply) {
        mMaxSupply = maxSupply;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Long getNumMarketPairs() {
        return mNumMarketPairs;
    }

    public void setNumMarketPairs(Long numMarketPairs) {
        mNumMarketPairs = numMarketPairs;
    }

    public Object getPlatform() {
        return mPlatform;
    }

    public void setPlatform(Object platform) {
        mPlatform = platform;
    }

    public Quote getQuote() {
        return mQuote;
    }

    public void setQuote(Quote quote) {
        mQuote = quote;
    }

    public String getSlug() {
        return mSlug;
    }

    public void setSlug(String slug) {
        mSlug = slug;
    }

    public String getSymbol() {
        return mSymbol;
    }

    public void setSymbol(String symbol) {
        mSymbol = symbol;
    }

    public List<String> getTags() {
        return mTags;
    }

    public void setTags(List<String> tags) {
        mTags = tags;
    }

    public Long getTotalSupply() {
        return mTotalSupply;
    }

    public void setTotalSupply(Long totalSupply) {
        mTotalSupply = totalSupply;
    }

}
