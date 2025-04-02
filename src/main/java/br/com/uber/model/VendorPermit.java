package br.com.uber.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorPermit {

    private int objectid;
    private String applicant;
    private FacilityType facilitytype;
    private int cnn;
    private String address;
    private String blocklot;
    private String block;
    private String lot;
    private String permit;
    private Status status;
    private String fooditems;
    private double x;
    private double y;
    private double latitude;
    private double longitude;
    private String schedule;
    private String dayshours;
    private LocalDateTime noisent;
    private LocalDateTime approved;
    private String received;
    private String priorpermit;
    private LocalDateTime expirationdate;
    private Location location;

}
