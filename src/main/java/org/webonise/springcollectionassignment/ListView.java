package org.webonise.springcollectionassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

@Component
public class ListView implements DataCollection {
    private static final Logger LOGGER = Logger.getLogger(ListView.class.getName());
    @Autowired
    private LoggerManager loggerManager;
    @Autowired
    private DisplayCollection displayCollection;
    private List<Users> usersList;
    @Autowired
    private DataFetcher dataFetcher;

    @Autowired
    public void setUsersList(List<Users> usersList) {
        this.usersList = usersList;
    }

    @Override
    public void fetchAndViewData() throws SQLException {
        usersList = dataFetcher.queryUsersList();
        LOGGER.info("Size of List:" + usersList.size());
        LOGGER.info("Before Sorting");
        displayCollection.Display(usersList);
        Collections.sort(usersList, new UserComparator());
        LOGGER.info("After Sorting");
        displayCollection.Display(usersList);
    }
}
