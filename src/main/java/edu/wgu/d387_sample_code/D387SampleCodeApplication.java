package edu.wgu.d387_sample_code;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class D387SampleCodeApplication {

	static ExecutorService messageExecutor = Executors.newFixedThreadPool(2);

	public static void main(String[] args) {
		SpringApplication.run(D387SampleCodeApplication.class, args);

		messageExecutor.execute(() -> {
			Locale locale = Locale.US;
			ResourceBundle bundle = ResourceBundle.getBundle("welcome", locale);
			System.out.println(bundle.getString("welcome"));
		});

		messageExecutor.execute(() -> {
			Locale locale = Locale.CANADA_FRENCH;
			ResourceBundle bundle = ResourceBundle.getBundle("welcome", locale);
			System.out.println(bundle.getString("welcome"));
		});

		ZoneId eastern = ZoneId.of("America/New_York");
		ZoneId mountain = ZoneId.of("America/Denver");
		ZoneId utc = ZoneId.of("UTC");

		LocalDateTime localDateTime = LocalDateTime.now();

		ZonedDateTime localTime = localDateTime.atZone(ZoneId.systemDefault());

		System.out.println("Eastern: "
				+ localTime.withZoneSameInstant(eastern).toLocalDateTime());

		System.out.println("Mountain: "
				+ localTime.withZoneSameInstant(mountain).toLocalDateTime());

		System.out.println("UTC: "
				+ localTime.withZoneSameInstant(utc).toLocalDateTime());

		messageExecutor.shutdown();
	}
}
