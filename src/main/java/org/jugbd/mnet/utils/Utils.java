package org.jugbd.mnet.utils;

import org.jugbd.mnet.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Date;

/**
 * Created by Bazlur Rahman Rokon on 7/6/14.
 */
public class Utils {
    private static final Logger log = LoggerFactory.getLogger(Utils.class);

    public static <T> void updatePersistentProperties(T entity, User user) {

        boolean isNew = false;

        try {
            for (Field field : entity.getClass().getDeclaredFields()) {
                if (field.getName().equals("id")) {
                    field.setAccessible(true);
                    if (field.get(entity) == null) {
                        isNew = true;
                    }
                }
            }

            for (Field field : entity.getClass().getSuperclass().getDeclaredFields()) {
                if (field.getName().equals("lastUpdatedBy")) {
                    field.setAccessible(true);
                    field.set(entity, user);
                } else if (field.getName().equals("dateLastUpdated")) {
                    field.setAccessible(true);
                    field.set(entity, new Date());
                }
                if (!isNew) {
                    if (field.getName().equals("createdBy")) {
                        field.setAccessible(true);
                        field.set(entity, user);
                    }
                    if (field.getName().equals("dateCreated")) {
                        field.setAccessible(true);
                        field.set(entity, new Date());
                    }
                }
            }
        } catch (IllegalAccessException e) {
            log.error("unable to update persistent properties", e);
        }
    }

    public static void main(String[] args) {
        User user = new User("rokon", "rokon");
        updatePersistentProperties(user, user);
    }
}
