package BarkingApp.repos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "log_action")
public class Logging {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String logAction;

    public Logging() {
    }

    public Logging(String logAction) {
        this.logAction = logAction;
    }

    public Long getId() {
        return id;
    }

    public String getLogAction() {
        return logAction;
    }

    public void setLogAction(String logAction) {
        this.logAction = logAction;
    }
}
