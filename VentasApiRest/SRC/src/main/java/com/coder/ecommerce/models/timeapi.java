package com.coder.ecommerce.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;


@JsonIgnoreProperties(ignoreUnknown = true)

@Getter
@Setter
public class timeapi {
    private String currentDateTime;
    private String utcOffset;
    private Boolean isDayLightSavingsTime;
    private String dayOfTheWeek;
    private String timeZoneName;
    private Long currentFileTime;
    private String ordinalDate;
    private String serviceResponse;
}
