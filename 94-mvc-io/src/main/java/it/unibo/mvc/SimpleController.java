package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * 
 *
 */
public final class SimpleController implements Controller {

    private final List<String> historyString;
    private Optional<String> stringToPrint;

    public SimpleController() {
        this.historyString = new ArrayList<>();
        this.stringToPrint = Optional.empty();
    }

    @Override
    public void setNextStringToPrint(final String string) {
        this.stringToPrint = Optional.of(Objects.requireNonNull(string));
    }

    @Override
    public String getNextStringToPrint() {
        return this.stringToPrint.orElseThrow(() -> new IllegalStateException("String is Unset!!"));
    }

    @Override
    public List<String> getHistoryStringPrinted() {
        return List.of(this.historyString.toString());
    }

    @Override
    public void printString() {
        System.out.println(this.getNextStringToPrint());
        this.historyString.add(this.stringToPrint.get());
        this.stringToPrint = Optional.empty();
    }
}
