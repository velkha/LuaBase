package lua.base.consola.luabase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Service
public class AsyncService {

    @Async("taskExecutor")
    public CompletableFuture<ResponseEntity<String>> asyncGetCall(String url, Map<String, String> params, HttpHeaders headers) {
        String formattedUrl = formatUrlWithParams(url, params);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<String> response = restTemplate.exchange(formattedUrl, HttpMethod.GET, entity, String.class);
        return CompletableFuture.completedFuture(response);
    }

    @Async("taskExecutor")
    public CompletableFuture<ResponseEntity<String>> asyncPostCall(String url, Object body, HttpHeaders headers) {
        HttpEntity<Object> entity = new HttpEntity<>(body, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);
        return CompletableFuture.completedFuture(response);
    }

    private String formatUrlWithParams(String url, Map<String, String> params) {
        if (params == null || params.isEmpty()) {
            return url;
        }
        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        params.forEach(builder::queryParam);
        return builder.toUriString();
    }

    private final RestTemplate restTemplate;

    @Autowired
    public AsyncService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
