import java.util.ArrayList;
import java.util.List;

public class Conference {
    private List<Track> tracks;

    public Conference() {
        this.tracks = new ArrayList<>();
    }

    public void addTalk(Talk talk) {
        boolean added = false;
        for (Track track : tracks) {
            if (track.addTalk(talk)) {
                added = true;
                break;
            }
        }
        if (!added) {  // Create a new track if the talk couldn't fit in existing ones
            Track newTrack = new Track();
            newTrack.addTalk(talk);
            tracks.add(newTrack);
        }
    }

    public void scheduleConference(List<Talk> talks) {
        for (Talk talk : talks) {
            addTalk(talk);
        }
    }

    public void printSchedule() {
        int trackCount = 1;
        for (Track track : tracks) {
            System.out.println("Track " + trackCount + ":");
            for (String event : track.getSchedule()) {
                System.out.println(event);
            }
            System.out.println();
            trackCount++;
        }
    }
}
