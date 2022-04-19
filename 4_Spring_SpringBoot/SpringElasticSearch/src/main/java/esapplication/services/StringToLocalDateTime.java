package esapplication.services;

import com.fasterxml.jackson.databind.util.StdConverter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StringToLocalDateTime extends StdConverter<String, LocalDateTime> {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    @Override
    public LocalDateTime convert(String value) {
//        return LocalDate.parse(value, formatter).atStartOfDay();
        return LocalDateTime.parse(value, formatter);
    }
}
