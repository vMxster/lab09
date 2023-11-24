package it.unibo.mvc;

import java.util.List;

/**
 *
 */
public interface Controller {

    void setNextStringToPrint(final String string);

    String getNextStringToPrint();

    List<String> getHistoryStringPrinted();

    void printString();

}
