package br.com.jellmayer.clapboard;

import br.com.jellmayer.clapboard.model.SerieData;
import br.com.jellmayer.clapboard.service.ApiClient;
import br.com.jellmayer.clapboard.service.ResponseMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClapboardApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClapboardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunner foi implementado.");
		ApiClient apiClient = new ApiClient();
		ResponseMapper mapper = new ResponseMapper();
		String json = apiClient.fetchData("https://www.omdbapi.com/?t=invincible&apikey=f6a93369");
		SerieData invincible = mapper.parseJson(json, SerieData.class);
		System.out.println(invincible);
	}
}
