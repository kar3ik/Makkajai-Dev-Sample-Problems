import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Track {
    private static final int MORNING_SESSION_DURATION = 180;  // 9am to 12pm
    private static final int AFTERNOON_SESSION_DURATION = 240;  // 1pm to 5pm
    private static final LocalTime MORNING_START = LocalTime.of(9, 0);
    private static final LocalTime AFTERNOON_START = LocalTime.of(13, 0);

    private Session morningSession;
    private Session afternoonSession;

    public Track() {
        this.morningSession = new Session(MORNING_SESSION_DURATION, MORNING_START);
        this.afternoonSession = new Session(AFTERNOON_SESSION_DURATION, AFTERNOON_START);
    }

    public boolean addTalk(Talk talk) {
        if (!morningSession.addTalk(talk)) {
            return afternoonSession.addTalk(talk);
        }
        return true;
    }

    public List<String> getSchedule() {
        List<String> schedule = new ArrayList<>(morningSession.getSchedule());
        schedule.add("12:00PM Lunch");
        schedule.addAll(afternoonSession.getSchedule());

        // Determine Networking Event time
        LocalTime networkingStart = AFTERNOON_START.plusMinutes(afternoonSession.getCurrentDuration());
        if (networkingStart.isBefore(LocalTime.of(16, 0))) {
            networkingStart = LocalTime.of(16, 0);
        }
        schedule.add(networkingStart + " Networking Event");

        return schedule;
    }
}
