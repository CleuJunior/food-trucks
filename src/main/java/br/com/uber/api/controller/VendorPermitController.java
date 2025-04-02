package br.com.uber.api.controller;

import br.com.uber.model.VendorPermit;
import br.com.uber.service.api.VendorPermitApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("v1/vendor-permit")
public class VendorPermitController {

    private final VendorPermitApi vendorPermitApi;

    @GetMapping
    public Mono<Page<VendorPermit>> getVendorPermit(@RequestParam(name = "number", required = false, defaultValue = "0") int number,
                                                    @RequestParam(name = "size", required = false, defaultValue = "15") int size) {
        return vendorPermitApi.get()
                .collectList()
                .map(v -> this.paged(v, number, size));
    }

    private Page<VendorPermit> paged(List<VendorPermit> content, int number, int size) {
        var start = number * size;
        var end = Math.min(start + size, content.size());

        if (start > content.size()) {
            return new PageImpl<>(Collections.emptyList(), PageRequest.of(number, size), content.size());
        }

        var paginatedList = content.subList(start, end);
        return new PageImpl<>(paginatedList, PageRequest.of(number, size), content.size());
    }
}
