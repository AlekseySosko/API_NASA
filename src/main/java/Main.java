import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.http.HttpHeaders;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    private static final String API_NASA = "https://api.nasa.gov/planetary/apod?api_key=Jlf52JcxDNmIVD1tJdb11d7WWsQctJe36ZeqXJDV";
    public static ObjectMapper mapper = new ObjectMapper();

    public static void main(String[] args) throws IOException {
        String imageUrl = getObjectNASAResponse(getResponse(API_NASA)).getUrl();
        String[] buffImageUrl = imageUrl.split("/");
        String fileName = buffImageUrl[buffImageUrl.length - 1];

        URL url = new URL(imageUrl);
        File file = new File(fileName);
        FileUtils.copyURLToFile(url, file);
    }

    public static CloseableHttpResponse getResponse(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create()
                .setDefaultRequestConfig(RequestConfig.custom()
                        .setConnectTimeout(5000)
                        .setSocketTimeout(30000)
                        .setRedirectsEnabled(false)
                        .build())
                .build();

        HttpGet request = new HttpGet(url);
        request.setHeader(HttpHeaders.ACCEPT, ContentType.APPLICATION_JSON.getMimeType());

        return httpClient.execute(request);
    }

    public static NASAResponse getObjectNASAResponse(CloseableHttpResponse response) throws IOException {
        return mapper.readValue(
                response.getEntity().getContent(),
                new TypeReference<>() {
                }
        );

    }
}
