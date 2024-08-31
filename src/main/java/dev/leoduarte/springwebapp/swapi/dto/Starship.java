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
public class Starship {

    @JsonProperty("MGLT")
    private String mglt;

    @JsonProperty("cargo_capacity")
    private String cargoCapacity;

    @JsonProperty("consumables")
    private String consumables;

    @JsonProperty("cost_in_credits")
    private String costInCredits;

    @JsonProperty("created")
    private OffsetDateTime created;

    @JsonProperty("crew")
    private Integer crew;

    @JsonProperty("edited")
    private OffsetDateTime edited;

    @JsonProperty("hyperdrive_rating")
    private String hyperdriveRating;

    @JsonProperty("length")
    private String length;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("max_atmosphering_speed")
    private String maxAtmospheringSpeed;

    @JsonProperty("model")
    private String model;

    @JsonProperty("name")
    private String name;

    @JsonProperty("passengers")
    private Integer passengers;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("pilots")
    private List<String> pilots;

    @JsonProperty("starship_class")
    private String starshipClass;

    @JsonProperty("url")
    private String url;

}
