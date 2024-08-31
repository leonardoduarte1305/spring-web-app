package dev.leoduarte.springwebapp.swapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Planet {

    @JsonProperty("climate")
    private String climate;

    @JsonProperty("created")
    private OffsetDateTime created;

    @JsonProperty("diameter")
    private String diameter;

    @JsonProperty("edited")
    private OffsetDateTime edited;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("gravity")
    private String gravity;

    @JsonProperty("name")
    private String name;

    @JsonProperty("orbital_period")
    private String orbitalPeriod;

    @JsonProperty("population")
    private String population;

    @JsonProperty("residents")
    private List<String> residents;

    @JsonProperty("rotation_period")
    private String rotationPeriod;

    @JsonProperty("surface_water")
    private String surfaceWater;

    @JsonProperty("terrain")
    private String terrain;

    @JsonProperty("url")
    private String url;

}
