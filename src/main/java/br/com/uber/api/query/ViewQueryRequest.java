package br.com.uber.api.query;

import br.com.uber.model.Status;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ViewQueryRequest {
    private Status status;
    private int page = 0;
    private int size = 15;
    private Double latitude;
    private Double longitude;
}
