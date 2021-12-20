
package com.irfaan.learningspringoreilly.services;

import com.irfaan.learningspringoreilly.json.AstroResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Duration;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: AstroService.java, v 0.1 2021‐12‐17 14.02 Ahmad Irfaan Hibatullah Exp $$
 */

@Service
public class AstroService {

    private final RestTemplate restTemplate;
    private final String addressWeb = "http://api.open-notify.org";
    private final WebClient webClient;

    @Autowired
    public AstroService(RestTemplateBuilder restTemplateBuilder, WebClient.Builder webBuilder) {
        this.restTemplate = restTemplateBuilder.build();
        this.webClient = webBuilder.baseUrl(addressWeb).build();
    }

    public AstroResult getAstronauts() {
        String url = addressWeb + "/astros.json";
        return restTemplate.getForObject(url, AstroResult.class);
    }

    public AstroResult getAstronautsWebClient() {
        return webClient.get()
                .uri("/astros.json")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AstroResult.class)
                .block(Duration.ofSeconds(2));
    }
}