package org.webonise.springcollectionassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CollectionFactory {
    @Autowired
    private DataCollection listView;
    @Autowired
    private DataCollection setView;
    @Autowired
    private DataCollection mapView;

    public DataCollection getCollection(String collectionType) {
        switch (collectionType) {
            case Application.Arraylist:
                return listView;
            case Application.HashMap:
                return mapView;
            case Application.HashSet:
                return setView;
        }
        throw new IllegalArgumentException("Invalid choice!");
    }
}
