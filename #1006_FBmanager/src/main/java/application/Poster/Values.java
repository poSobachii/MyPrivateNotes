package application.Poster;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class Values {

    private String login;
    private String password;
    private String targetUrl;
    private String targetFolder;
    private String postedFolder;
    private int dayToPost;
    private int monthToPost;
    private int yearToPost;
    private int timeGap;
    private int timeAmplitude;
    private int hours;
    private int minutes;
    private Boolean ifStaticText = false;
    private String staticText;

    public String getStaticText() {
        return staticText;
    }

    public void setStaticText(String staticText) {
        this.staticText = staticText;
    }

    public Boolean getIfStaticText() {
        return ifStaticText;
    }

    public void setIfStaticText(Boolean ifStaticText) {
        this.ifStaticText = ifStaticText;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public String getTargetFolder() {
        return targetFolder;
    }

    public void setTargetFolder(String targetFolder) {
        this.targetFolder = targetFolder;
    }

    public String getPostedFolder() {
        return postedFolder;
    }

    public void setPostedFolder(String postedFolder) {
        this.postedFolder = postedFolder;
    }

    public int getTimeGap() {
        return timeGap;
    }

    public void setTimeGap(int timeGap) {
        this.timeGap = timeGap;
    }

    public int getTimeAmplitude() {
        return timeAmplitude;
    }

    public void setTimeAmplitude(int timeAmplitude) {
        this.timeAmplitude = timeAmplitude;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public int getDayToPost() {
        return dayToPost;
    }

    public void setDayToPost(int dayToPost) {
        this.dayToPost = dayToPost;
    }

    public int getMonthToPost() {
        return monthToPost;
    }

    public void setMonthToPost(int monthToPost) {
        this.monthToPost = monthToPost;
    }

    public int getYearToPost() {
        return yearToPost;
    }

    public void setYearToPost(int yearToPost) {
        this.yearToPost = yearToPost;
    }
}
