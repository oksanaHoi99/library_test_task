package org.bookLibrary;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Author {
    private String fullName;
}
