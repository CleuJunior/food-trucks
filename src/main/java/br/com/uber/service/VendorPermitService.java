package br.com.uber.service;

import br.com.uber.api.query.ViewQueryRequest;
import br.com.uber.model.Status;
import br.com.uber.model.VendorPermit;
import br.com.uber.service.api.VendorPermitApi;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VendorPermitService {

    private final VendorPermitApi vendorPermitApi;

    public Mono<Page<VendorPermit>> getVendoPermit(ViewQueryRequest request) {

        return Flux.defer(() -> filterByCoordinate(request))
                .collectList()
                .map(list -> this.paged(list, request));
    }

    private Flux<VendorPermit> filterByCoordinate(ViewQueryRequest request) {
        var vendorFlux = vendorPermitApi.get();

        var latitude=  Optional.ofNullable(request.getLatitude())
                .map(la -> vendorFlux.filter(v -> la == v.getLatitude()))
                .orElse(vendorFlux);

        return Optional.ofNullable(request.getLongitude())
                .map(lo -> latitude.filter(v -> lo == v.getLongitude()))
                .orElse(latitude);
    }

    private Page<VendorPermit> paged(List<VendorPermit> content, ViewQueryRequest request) {
        var start = request.getPage() * request.getSize();
        var end = Math.min(start + request.getSize(), content.size());

        if (start > content.size()) {
            return new PageImpl<>(Collections.emptyList(),
                    PageRequest.of(
                            request.getPage(),
                            request.getSize()),
                    content.size()
            );
        }

        var paginatedList = content.subList(start, end);

        return new PageImpl<>(paginatedList,
                PageRequest.of(
                        request.getPage(),
                        request.getSize()),
                content.size()
        );
    }
}
