package tests.nbrb;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import page.objects.day21_classwork.restAssured.Search;
import page.objects.day21_classwork.restAssured.SignIn;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class NBRB {

    private static final org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger();
    public static void main(String[] args) throws URISyntaxException, IOException {
        httpGet();
        httpPost();
        //signIn();
    }
    public static void httpGet() throws IOException {
        URI url = URI.create("https://www.nbrb.by/api/exrates/currencies/1");

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        HttpResponse httpResponse = client.execute(request);
        LOGGER.info(EntityUtils.toString(httpResponse.getEntity()));
    }

    public static void httpPost() throws URISyntaxException, IOException, ParseException {
        Search search = new Search("a", true);
        ObjectMapper objectMapper = new ObjectMapper();
        CloseableHttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/ws/");
        HttpPost request = new HttpPost(builder.build());
        String body = objectMapper.writeValueAsString(search);
        request.setEntity(new StringEntity(body));
        CloseableHttpResponse httpResponse = client.execute(request);
        LOGGER.info(EntityUtils.toString(httpResponse.getEntity()));
    }
    public static void signIn() throws URISyntaxException, IOException, ParseException {
        SignIn signIn = new SignIn("a", "b");
        ObjectMapper objectMapper = new ObjectMapper();
        CloseableHttpClient client = HttpClientBuilder.create().build();
        URIBuilder builder = new URIBuilder("http://178.124.206.46:8001/app/");
        HttpPost request = new HttpPost(builder.build());
        String body = objectMapper.writeValueAsString(signIn);
        request.setEntity(new StringEntity(body));
        CloseableHttpResponse httpResponse = client.execute(request);
        LOGGER.info(EntityUtils.toString(httpResponse.getEntity()));
    }
}

