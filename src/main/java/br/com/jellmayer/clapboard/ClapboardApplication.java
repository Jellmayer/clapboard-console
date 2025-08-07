package br.com.jellmayer.clapboard;

import br.com.jellmayer.clapboard.main.Main;
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

		Main main = new Main();
		main.searchSerie();
	}
}
