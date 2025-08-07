package br.com.jellmayer.clapboard.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record SerieData (@JsonAlias("Title") String title,
                         String totalSeasons,
                         String imdbRating) {}
