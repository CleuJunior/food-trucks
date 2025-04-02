package br.com.uber.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.reactive.function.client.WebClientCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class VendorPermitClientConfig {

    @Value("${api.data.url}")
    private String vendoPermitApiUrl;


    @Bean
    public WebClient vendoPermitApiClient(List<WebClientCustomizer> customizers) {
        var builder = WebClient.builder()
                .baseUrl(vendoPermitApiUrl);

        customizers.forEach(c -> c.customize(builder));
        return builder.build();
    }

}
