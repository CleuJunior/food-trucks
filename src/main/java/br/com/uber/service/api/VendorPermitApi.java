package br.com.uber.service.api;

import br.com.uber.model.VendorPermit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class VendorPermitApi {

    private final WebClient vendorPermitApiClient;

    public Flux<VendorPermit> get() {
        return vendorPermitApiClient.get()
                .uri(builder -> builder.path("/rqzj-sfat.json").build())
                .retrieve()
                .bodyToFlux(VendorPermit.class);
    }
}
