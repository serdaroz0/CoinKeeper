package serdar.oz.coinkeeper.models.news;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NewsModel implements Serializable {
    @SerializedName("Data")
    @Expose
    private String Data;
    @SerializedName("Message")
    @Expose
    private String Message;
    @SerializedName("Type")
    @Expose
    private String Type;
    @SerializedName("Response")
    @Expose
    private String Response;
    @SerializedName("tags")
    @Expose
    private String tags;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("published_on")
    @Expose
    private Long published_on;
    @SerializedName("downvotes")
    @Expose
    private String downvotes;
    @SerializedName("source_info")
    @Expose
    private NewsSourceInfo newsSourceInfo;
    @SerializedName("upvotes")
    @Expose
    private String upvotes;
    @SerializedName("lang")
    @Expose
    private String lang;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("guid")
    @Expose
    private String guid;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("categories")
    @Expose
    private String categories;
    @SerializedName("imageurl")
    @Expose
    private String imageurl;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Long getPublished_on() {
        return published_on;
    }

    public void setPublished_on(Long published_on) {
        this.published_on = published_on;
    }

    public String getDownvotes() {
        return downvotes;
    }

    public void setDownvotes(String downvotes) {
        this.downvotes = downvotes;
    }

    public NewsSourceInfo getNewsSourceInfo() {
        return newsSourceInfo;
    }

    public void setNewsSourceInfo(NewsSourceInfo newsSourceInfo) {
        this.newsSourceInfo = newsSourceInfo;
    }

    public String getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(String upvotes) {
        this.upvotes = upvotes;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String Response) {
        this.Response = Response;
    }

}

