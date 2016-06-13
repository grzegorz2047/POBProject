package pl.grzegorz2047.pobproject;

import java.util.Arrays;
import java.util.List;

/**
 * Created by s416045 on 2016-06-13.
 */
public class Event {
    private List<String> eventTypes;

    public Event() {
        this.eventTypes = //new ArrayList<String>();
        Arrays.asList("Animals", "Monsters", "Weapons", "Idle");
    }

    public String callEvent() {
        int rand = Main.getRandom().nextInt(this.eventTypes.size());
        return this.eventTypes.get(rand);
    }

    public List<String> getEventTypes() {
        return eventTypes;
    }
}
