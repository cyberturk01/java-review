package org.yigit.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.yigit.model.Reader;
import org.yigit.controller.MinutesListen;
import org.yigit.controller.PagesRead;
import org.yigit.repository.ReaderRepository;

@Component
public class ReaderService {

    MinutesListen minutesListen;
    PagesRead pagesRead;
    ReaderRepository readerRepository;

    public ReaderService(@Qualifier("MASTER") MinutesListen minutesListen, @Qualifier("RED") PagesRead pagesRead, ReaderRepository readerRepository) {
        this.minutesListen = minutesListen;
        this.pagesRead = pagesRead;
        this.readerRepository = readerRepository;
    }

    public void publishReader(Reader reader){
        minutesListen.listen(reader);
        pagesRead.read(reader);
        readerRepository.storeReader(reader);
    }
}
