package org.webonise.springcollectionassignment;

import java.sql.SQLException;

public interface DataCollection {
    /**
     * This interface will fetch data from database and present it using different collections.
     *
     * @throws SQLException
     */
    void fetchAndViewData() throws SQLException;
}
