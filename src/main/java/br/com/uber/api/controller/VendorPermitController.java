package br.com.uber.api.controller;

import br.com.uber.api.query.ViewQueryRequest;
import br.com.uber.model.VendorPermit;
import br.com.uber.service.VendorPermitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/vendor-permit")
public class VendorPermitController {

    private final VendorPermitService service;

    @PostMapping
    public Mono<Page<VendorPermit>> searchVendorPermit(@RequestBody ViewQueryRequest request) {
        log.info("Querying vendor permit: {}", request);
        return service.getVendoPermit(request);
    }
}
