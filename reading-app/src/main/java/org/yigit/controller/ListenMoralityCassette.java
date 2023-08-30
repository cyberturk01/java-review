package org.yigit.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yigit.model.Reader;

@Component
@Qualifier("MORALITY")
public class ListenMoralityCassette implements MinutesListen {
    @Override
    public void listen(Reader reader) {
        System.out.println("MORALITY listened by Reader "+ reader.getName() +" is " + reader.getMinutesListen() +" Minutes");
    }
}
