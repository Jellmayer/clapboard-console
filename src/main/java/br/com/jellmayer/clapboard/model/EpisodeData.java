package br.com.jellmayer.clapboard.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record EpisodeData(@JsonAlias("Title") String title,
                          @JsonAlias("Episode") Integer episodeNumber,
                          String imdbRating,
                          @JsonAlias("Released") String releaseDate,
                          @JsonAlias("Runtime") String runtime) {}
