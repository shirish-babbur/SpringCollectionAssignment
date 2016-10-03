package org.webonise.springcollectionassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;

@Component
public class SetView implements DataCollection {
    private static final Logger LOGGER = Logger.getLogger(SetView.class.getName());
    @Autowired
    private LoggerManager loggerManager;
    @Autowired
    private DisplayCollection displayCollection;
    private Set<Users> usersHashSet;
    @Autowired
    private DataFetcher dataFetcher;

    @Autowired
    public void setUsersSet(Set<Users> usersSet) {
        this.usersHashSet = usersSet;
    }


    @Override
    public void fetchAndViewData() throws SQLException {
        Set<Users> userTreeSet = new TreeSet<Users>(new UserComparator());
        usersHashSet = dataFetcher.queryUsersSet();
        userTreeSet.addAll(usersHashSet);
        LOGGER.info("Size of Set:" + usersHashSet.size());
        LOGGER.info("Before Sorting:");
        displayCollection.Display(usersHashSet);
        userTreeSet.addAll(usersHashSet);
        LOGGER.info("After Sorting:");
        displayCollection.Display(userTreeSet);
    }
}
