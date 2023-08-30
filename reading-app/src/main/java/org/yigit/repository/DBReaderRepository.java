package org.yigit.repository;

import org.springframework.stereotype.Component;
import org.yigit.model.Reader;

@Component
public class DBReaderRepository implements ReaderRepository{

    @Override
    public void storeReader(Reader reader) {
        System.out.println("Storing reader " + reader.getName() + " to Database");
    }
}
