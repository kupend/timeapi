package com.example.timezone.timezoneapi.service;

import com.example.timezone.timezoneapi.domain.ApiResponseTimeZone;
import com.example.timezone.timezoneapi.domain.USATimeAPIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TimeExtractService {

    private static List<String> timezoneList = null;

    public static final String HTTP_WORLDTIMEAPI_ORG_TIMEZONE_TIMEZONEAPI = "http://worldtimeapi.org/timezone/timezoneapi/";
    @Autowired
    private RestTemplate restTemplate;

    public String getByTimeZoneApi(@RequestParam String timezone) {
        String url = HTTP_WORLDTIMEAPI_ORG_TIMEZONE_TIMEZONEAPI + timezone;
        USATimeAPIResponse currentTime = restTemplate.getForObject(url, USATimeAPIResponse.class);
        ApiResponseTimeZone time= new ApiResponseTimeZone();
        time.setAbbreviation(currentTime.getAbbreviation());
        time.setTimeapi(currentTime.getDatetime());
        time.setUtc_datetime(currentTime.getUtc_datetime());
        return timezone;
    }

    public boolean isValidTimeZone(final String timezone) {
        if (timezoneList==null || timezoneList.isEmpty()) {
            timezoneList = Arrays.asList(Objects.requireNonNull(this.restTemplate
                    .getForObject("http://worldtimeapi.org/timezone/timezoneapi/America", String[].class)));
        }
        return timezoneList
                .stream()
                .filter(tii -> timezone.equals(tii))
                .findAny()
                .isPresent();
    }


}
