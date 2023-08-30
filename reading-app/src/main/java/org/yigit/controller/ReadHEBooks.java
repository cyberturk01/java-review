package org.yigit.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yigit.model.Reader;

@Component
@Qualifier("HE")
public class ReadHEBooks implements PagesRead{
    @Override
    public void read(Reader reader) {
        System.out.println("Total HE book pages read by Reader "+ reader.getName() + " is " + reader.getPagesRead());
    }
}
