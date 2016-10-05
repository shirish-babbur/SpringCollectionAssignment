package org.webonise.springcollectionassignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

@Component
public class Application {
    private static Logger LOGGER = Logger.getLogger(Application.class.getName());
    static final String Arraylist = "ArrayList";
    static final String HashMap = "HashMap";
    static final String HashSet = "HashSet";
    static final String Exit = "exit";
    private String choice;
    private DataCollection dataCollection;
    @Autowired
    LoggerManager loggerManager;
    @Autowired
    private CollectionFactory collectionFactory;
    @Autowired
    private Scanner input;

    public void startApplication() {
        LOGGER = loggerManager.getLOGGER(LOGGER);
        do {
            LOGGER.info("Select Collection to view Data:\n1.ArrayList\n2.HashMap\n3.HashSet\n4.exit");
            choice = input.nextLine();
            try {
                switch (choice) {
                    case Arraylist:
                        dataCollection = collectionFactory.getCollection(Arraylist);
                        dataCollection.fetchAndViewData();
                        break;
                    case HashMap:
                        dataCollection = collectionFactory.getCollection(HashMap);
                        dataCollection.fetchAndViewData();
                        break;
                    case HashSet:
                        dataCollection = collectionFactory.getCollection(HashSet);
                        dataCollection.fetchAndViewData();
                        break;
                    case Exit:
                        LOGGER.info("Exiting");
                        break;
                    default:
                        LOGGER.severe("Invalid Choice!");
                }
            } catch (SQLException e) {
                LOGGER.severe(e.getMessage());
            }
        } while (!choice.equalsIgnoreCase(Exit));
    }
}
