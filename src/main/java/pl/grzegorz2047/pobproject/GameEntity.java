package pl.grzegorz2047.pobproject;

import pl.grzegorz2047.pobproject.interfaces.Destroyable;
import pl.grzegorz2047.pobproject.interfaces.Interactive;

/**
 * Created by s416045 on 2016-06-13.
 */
public class GameEntity {


    private Destroyable destroyable;
    private Interactive interactive;

    public GameEntity(Destroyable destroyable, Interactive interactive) {
        this.destroyable = destroyable;
        this.interactive = interactive;
    }

    public GameEntity(Destroyable destroyable, Interactive interactive, String entityType) {
        this.destroyable = destroyable;
        this.interactive = interactive;
    }

    public Destroyable getDestroyable() {
        return destroyable;
    }

    public Interactive getInteractive() {
        return interactive;
    }

}
