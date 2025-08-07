package br.com.jellmayer.clapboard.main;

import br.com.jellmayer.clapboard.model.SeasonData;
import br.com.jellmayer.clapboard.model.SerieData;
import br.com.jellmayer.clapboard.service.ApiClient;
import br.com.jellmayer.clapboard.service.ResponseMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private final Scanner scanner = new Scanner(System.in);

    private static final String BASE_URL = "https://www.omdbapi.com/?t=";
    private static final String API_KEY = "&apikey=f6a93369";

    private static final ApiClient apiClient = new ApiClient();
    private static final ResponseMapper mapper = new ResponseMapper();

    public void searchSerie() {
        System.out.print("Serie name: ");
        String serieName = scanner.nextLine().toLowerCase().replace(" ", "+");

        try {
            String searchUrl = BASE_URL + serieName + API_KEY;
            String jsonResponse = apiClient.fetchData(searchUrl);
            SerieData serie = mapper.parseJson(jsonResponse, SerieData.class);
            System.out.println(serie);

            List<SeasonData> seasons = new ArrayList<>();

            for (int i = 1; i <= serie.totalSeasons(); i++) {
                jsonResponse = apiClient.fetchData(BASE_URL + serieName + "&season=" + i + API_KEY);
                SeasonData season = mapper.parseJson(jsonResponse, SeasonData.class);
                seasons.add(season);
            }

            seasons.forEach(s -> {
                System.out.println("\n--------------- Season " + s.seasonNumber() + " ---------------");
                s.episodes().forEach(episode ->
                        System.out.println("\t" + episode.episodeNumber() + " - " + episode.title())
                );
            });
        } catch (Exception e) {
            System.out.println("Não foi possível consultar a série '" + serieName.replace("+", " ").toUpperCase() + "'. \n ERRO: " + e.getMessage());
        }

    }
}
