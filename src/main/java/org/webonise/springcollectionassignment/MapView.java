package org.webonise.springcollectionassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

@Component
public class MapView implements DataCollection {
    private static final Logger LOGGER = Logger.getLogger(MapView.class.getName());
    @Autowired
    private LoggerManager loggerManager;
    private Map<Integer, Users> usersMap;
    @Autowired
    private DisplayCollection displayCollection;
    @Autowired
    private DataFetcher dataFetcher;


    @Autowired
    public void setUsersMap(Map<Integer, Users> usersMap) {
        this.usersMap = usersMap;
    }


    @Override
    public void fetchAndViewData() throws SQLException {

        Map<Integer, Users> sortedUserMap = new TreeMap<Integer, Users>();
        usersMap = dataFetcher.queryUsersMap();
        sortedUserMap.putAll(usersMap);
        LOGGER.info("Size of Map:" + usersMap.size());
        LOGGER.info("Before Sorting:");
        displayCollection.Display(usersMap);
        sortedUserMap.putAll(usersMap);
        LOGGER.info("After Sorting:");
        displayCollection.Display(sortedUserMap);
    }
}
