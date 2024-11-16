package com.apod.apod_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APODItem {
    private String title;
    private String credit;
    private String explanation;
    private String date;
    private String hdurl;
    @JsonProperty("service_version")
    private String serviceVersion;
    @JsonProperty("media_type")
    private String mediaType;
    private String url;
    private String copyright;
}
