package pl.grzegorz2047.pobproject;

import pl.grzegorz2047.pobproject.interfaces.Destroyable;
import pl.grzegorz2047.pobproject.interfaces.Interactive;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by s416045 on 2016-06-13.
 */
public class Parser {

    public static GameEntity parse(String[] splitted) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        GameEntity gameEntity;
        if (splitted.length <= 2) {
            return null;
        }
        String className = splitted[1];
        Class<?> clazz = Class.forName(className);
        Constructor<?> ctor;
        ctor = clazz.getConstructor(String[].class);
        Object object = ctor.newInstance(new Object[]{splitted});
        gameEntity = new GameEntity((Destroyable) object, (Interactive) object);
        return gameEntity;
    }

}
