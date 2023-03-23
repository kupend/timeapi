package com.example.timezone.timezoneapi.domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponseTimeZone {
    
    private String abbreviation;
    private String timeapi;
    private String utc_datetime;
}

