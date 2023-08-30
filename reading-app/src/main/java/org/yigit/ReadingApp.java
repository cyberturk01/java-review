package org.yigit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.yigit.config.ConfigReader;
import org.yigit.model.Reader;
import org.yigit.service.ReaderService;

public class ReadingApp {
    public static void main(String[] args) {
        Reader reader= new Reader();
        reader.setName("Gokhan");
        reader.setMinutesListen(60);
        reader.setPagesRead(20);

        ApplicationContext context= new AnnotationConfigApplicationContext(ConfigReader.class);
        ReaderService readerService = context.getBean(ReaderService.class);
        readerService.publishReader(reader);
    }
}
