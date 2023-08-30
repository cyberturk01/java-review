package org.yigit.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yigit.model.Reader;

@Component
@Qualifier("RED")
public class ReadRedBooks implements PagesRead{
    @Override
    public void read(Reader reader) {
        System.out.println("Total Red book pages read by Reader "+ reader.getName() + " is " + reader.getPagesRead());
    }
}
