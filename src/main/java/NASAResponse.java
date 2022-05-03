import com.fasterxml.jackson.annotation.JsonProperty;

public class NASAResponse {
    private String copyright;
    private String date;
    private String explanation;
    private String HDUrl;
    private String mediaType;
    private String serviceVersion;
    private String title;
    private String url;

    public NASAResponse(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String HDUrl,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.HDUrl = HDUrl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NASAResponse{" +
                "\ncopyright='" + copyright + '\'' +
                ",\ndate='" + date + '\'' +
                ",\nexplanation='" + explanation + '\'' +
                ",\nHDUrl='" + HDUrl + '\'' +
                ",\nmediaType='" + mediaType + '\'' +
                ",\nserviceVersion='" + serviceVersion + '\'' +
                ",\ntitle='" + title + '\'' +
                ",\nurl='" + url + '\'' +
                "\n" + '}';
    }
}
