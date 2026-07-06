package edu.wgu.d387_sample_code.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@CrossOrigin
public class DisplayResource {

    @GetMapping("/api/display")
    public Map<String, String> getDisplayMessages() {
        Map<String, String> messages = new HashMap<>();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        executorService.execute(() -> {
            ResourceBundle bundle = ResourceBundle.getBundle("welcome", Locale.US);
            messages.put("welcomeEnglish", bundle.getString("welcome"));
        });

        executorService.execute(() -> {
            ResourceBundle bundle = ResourceBundle.getBundle("welcome", Locale.CANADA_FRENCH);
            messages.put("welcomeFrench", bundle.getString("welcome"));
        });

        executorService.shutdown();

        while (!executorService.isTerminated()) {
            // Wait for both language threads to finish
        }

        messages.put("presentationTime", getPresentationTimeMessage());

        return messages;
    }

    private String getPresentationTimeMessage() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

        LocalTime presentationTime = LocalTime.of(15, 0);

        ZonedDateTime easternTime = presentationTime.atDate(java.time.LocalDate.now())
                .atZone(ZoneId.of("America/New_York"));

        ZonedDateTime mountainTime = easternTime.withZoneSameInstant(ZoneId.of("America/Denver"));

        ZonedDateTime utcTime = easternTime.withZoneSameInstant(ZoneId.of("UTC"));

        return "Online live presentation time: "
                + easternTime.format(formatter) + " ET, "
                + mountainTime.format(formatter) + " MT, "
                + utcTime.format(formatter) + " UTC";
    }
}
