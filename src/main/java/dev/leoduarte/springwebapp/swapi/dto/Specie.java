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
public class Specie {

    @JsonProperty("average_height")
    private String averageHeight;

    @JsonProperty("average_lifespan")
    private String averageLifespan;

    @JsonProperty("classification")
    private String classification;

    @JsonProperty("created")
    private OffsetDateTime created;

    @JsonProperty("designation")
    private String designation;

    @JsonProperty("edited")
    private OffsetDateTime edited;

    @JsonProperty("eye_colors")
    private String eyeColors;

    @JsonProperty("hair_colors")
    private String hairColors;

    @JsonProperty("homeworld")
    private String homeworld;

    @JsonProperty("language")
    private String language;

    @JsonProperty("name")
    private String name;

    @JsonProperty("people")
    private List<String> people;

    @JsonProperty("films")
    private List<String> films;

    @JsonProperty("skin_colors")
    private String skinColors;

    @JsonProperty("url")
    private String url;

}
