import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Session {
    private List<Talk> talks;
    private int maxDuration;
    private int currentDuration;
    private LocalTime startTime;

    public Session(int maxDuration, LocalTime startTime) {
        this.talks = new ArrayList<>();
        this.maxDuration = maxDuration;
        this.currentDuration = 0;
        this.startTime = startTime;
    }

    public boolean addTalk(Talk talk) {
        if (currentDuration + talk.getDuration() <= maxDuration) {
            talks.add(talk);
            currentDuration += talk.getDuration();
            return true;
        }
        return false;
    }

    public List<String> getSchedule() {
        List<String> schedule = new ArrayList<>();
        LocalTime time = startTime;
        for (Talk talk : talks) {
            schedule.add(time + " " + talk.toString());
            time = time.plusMinutes(talk.getDuration());
        }
        return schedule;
    }

    public int getCurrentDuration() {
        return currentDuration;
    }
}
