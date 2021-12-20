
package com.irfaan.learningspringoreilly.services;

import com.irfaan.learningspringoreilly.json.Response;
import com.irfaan.learningspringoreilly.json.Site;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Ahmad Irfaan Hibatullah
 * @version $Id: GeocoderService.java, v 0.1 2021‐12‐17 15.17 Ahmad Irfaan Hibatullah Exp $$
 */

@Service
public class GeocoderService {

    private static final String KEY = "AIzaSyDw_d6dfxDEI7MAvqfGXEIsEMwjC1PWRno";

    private final WebClient webClient;

    @Autowired
    public GeocoderService(WebClient.Builder builder) {
        String BASE_URL = "https://maps.googleapis.com";
        webClient = builder.baseUrl(BASE_URL).build();
    }

    private String encodeString(String s) {
        try {
            return URLEncoder.encode(s, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return s;
    }

    public Site getLatLong(String... address) {
        String encoded = Stream.of(address)
                .map(this::encodeString)
                .collect(Collectors.joining(","));
        String path = "/maps/api/geocode/json";
        Response response = webClient.get()
                .uri(uriBuilder -> uriBuilder.path(path)
                        .queryParam("address", encoded)
                        .queryParam("key", KEY)
                        .build()
                ).retrieve()
                .bodyToMono(Response.class)
                .block(Duration.ofSeconds(2));
        if (response != null) {
            return new Site(
                    response.getFormattedAddress(),
                    response.getLocation().getLat(),
                    response.getLocation().getLng());
        } else {
            return null;
        }
    }

}