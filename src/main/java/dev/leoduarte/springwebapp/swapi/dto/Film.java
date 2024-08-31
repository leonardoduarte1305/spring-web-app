package dev.leoduarte.springwebapp.swapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Film {

    @JsonProperty("characters")
    private List<String> characters;

    @JsonProperty("created")
    private OffsetDateTime created;

    @JsonProperty("director")
    private String director;

    @JsonProperty("edited")
    private OffsetDateTime edited;

    @JsonProperty("episode_id")
    private Integer episodeId;

    @JsonProperty("opening_crawl")
    private String openingCrawl;

    @JsonProperty("planets")
    private List<String> planets;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("release_date")
    private String releaseDate;

    @JsonProperty("species")
    private List<String> species;

    @JsonProperty("starships")
    private List<String> starships;

    @JsonProperty("title")
    private String title;

    @JsonProperty("url")
    private String url;

    @JsonProperty("vehicles")
    private List<String> vehicles;

}
