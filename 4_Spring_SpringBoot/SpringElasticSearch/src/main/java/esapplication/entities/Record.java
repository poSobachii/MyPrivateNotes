package esapplication.entities;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import esapplication.services.LocalDateTimeToString;
import esapplication.services.StringToLocalDateTime;

import java.time.LocalDateTime;

public class Record {

    private String text;
    private String type;
    @JsonSerialize(using = LocalDateTimeToString.class)
    @JsonDeserialize(converter = StringToLocalDateTime.class)
    private LocalDateTime firstDate;
    @JsonSerialize(using = LocalDateTimeToString.class)
    @JsonDeserialize(converter = StringToLocalDateTime.class)
    private LocalDateTime secondDate;
    private String textDate;

    public Record() {
    }

    public Record(String text, RecType type, LocalDateTime firstDate, LocalDateTime secondDate, String textDate) {
        this.text = text;
        this.type = type.type;
        this.firstDate = firstDate;
        this.secondDate = secondDate;
        this.textDate = textDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getFirstDate() {
        return firstDate;
    }

    public void setFirstDate(LocalDateTime firstDate) {
        this.firstDate = firstDate;
    }

    public LocalDateTime getSecondDate() {
        return secondDate;
    }

    public void setSecondDate(LocalDateTime secondDate) {
        this.secondDate = secondDate;
    }

    public String getTextDate() {
        return textDate;
    }

    public void setTextDate(String textDate) {
        this.textDate = textDate;
    }
}
