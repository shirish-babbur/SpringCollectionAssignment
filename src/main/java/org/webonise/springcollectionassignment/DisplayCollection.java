package org.webonise.springcollectionassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class DisplayCollection {
    private static final Logger LOGGER = Logger.getLogger(DisplayCollection.class.getName());
    @Autowired
    private LoggerManager loggerManager;

    public void Display(Map userMap) {
        if (!userMap.isEmpty()) {
            Iterator iterator = userMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                LOGGER.info("Key:" + entry.getKey() + "\t Value:");
                Users user = (Users) entry.getValue();
                user.showDetails();
            }
        } else {
            LOGGER.severe("Map is Empty!");
        }
    }

    public void Display(List userList) {
        if (!userList.isEmpty()) {
            Iterator<Users> iterator = userList.iterator();
            while (iterator.hasNext()) {
                Users user = iterator.next();
                user.showDetails();
            }
        } else {
            LOGGER.severe("List is Empty!");
        }
    }

    public void Display(Set userSet) {
        if (!userSet.isEmpty()) {
            Iterator<Users> iterator = userSet.iterator();
            while (iterator.hasNext()) {
                Users user = iterator.next();
                user.showDetails();
            }
        } else {
            LOGGER.severe("Set is Empty!");
        }
    }
}
