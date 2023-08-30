package org.yigit.controller;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yigit.model.Reader;

@Component
@Qualifier("MASTER")
public class ListenMasterCassette implements MinutesListen{
    @Override
    public void listen(Reader reader) {
        System.out.println("Master listened by Reader "+ reader.getName() +" is " + reader.getMinutesListen() +" Minutes");
    }
}
