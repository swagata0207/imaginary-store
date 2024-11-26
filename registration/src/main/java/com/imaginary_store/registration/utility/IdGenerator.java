package com.imaginary_store.registration.utility;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;

public class IdGenerator {

    public static <T extends MongoRepository> String generateId(T repository) {

        long count = repository.count();

        String year = String.valueOf(LocalDate.now().getYear() - 2000);

        String hexCount;
        String month;

        if (Long.toHexString(count).length() < 6) {
            hexCount = String.format("%06X", count);
        } else {
            hexCount = Long.toHexString(count).toUpperCase();
        }

        if (LocalDate.now().getMonth().getValue() < 10)
            month = "0" + LocalDate.now().getMonth().getValue();
        else
            month = String.valueOf(LocalDate.now().getMonth().getValue());

        return year + month + hexCount; //24090001AB
    }
}
