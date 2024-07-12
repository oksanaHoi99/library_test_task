package org.bookLibrary;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Random;

@Data
@Builder
@ToString
public class Book {
    @Builder.Default
    private int id = new Random().nextInt(900000) + 100000;
    private String title;
    private Author author;
    private String details;
}
