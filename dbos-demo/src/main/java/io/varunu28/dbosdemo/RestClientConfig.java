package io.varunu28.dbosdemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Bean
    public RestClient kayneQuotesRestClient(@Value("${api.kayne-quotes.url}") String kayneQuotesUrl) {
        return RestClient.builder()
                .baseUrl(kayneQuotesUrl)
                .build();
    }
}
