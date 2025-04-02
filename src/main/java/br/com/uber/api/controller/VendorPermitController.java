package br.com.uber.api.controller;

import br.com.uber.model.VendorPermit;
import br.com.uber.service.api.VendorPermitApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/vendor-permit")
public class VendorPermitController {

    private final VendorPermitApi vendorPermitApi;

    @GetMapping
    public Flux<VendorPermit> getVendorPermit() {
        return vendorPermitApi.get();
    }
}
