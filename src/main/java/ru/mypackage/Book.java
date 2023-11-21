package ru.mypackage;

import java.util.Objects;

public class Book {
    private final String name;
    private final String authorFirstName;
    private final String authorSecondName;
    private final String secondAuthorFirstName;
    private final String secondAuthorSecondName;
    private final int publicationYear;
    private final String publisher;

    public static class BookBuilder {
        // необходимые параметры
        private final String name;
        private final String authorFirstName;
        private final String authorSecondName;
        // необязательные параметры со значениями по умолчанию
        private String secondAuthorFirstName = null;
        private String secondAuthorSecondName = null;
        private int publicationYear = 0;
        private String publisher = null;

        public BookBuilder(String name, String authorFirstName, String authorSecondName) {
            this.name = name;
            this.authorFirstName = authorFirstName;
            this.authorSecondName = authorSecondName;
        }

        public BookBuilder secondAuthorFirstName(String value) {
            secondAuthorFirstName = value;
            return this;
        }

        public BookBuilder secondAuthorSecondName(String value) {
            secondAuthorSecondName = value;
            return this;
        }

        public BookBuilder publicationYear(int value) {
            publicationYear = value;
            return this;
        }

        public BookBuilder publisher(String value) {
            publisher = value;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }

    private Book(BookBuilder bookBuilder) {
        name = bookBuilder.name;
        authorFirstName = bookBuilder.authorFirstName;
        authorSecondName = bookBuilder.authorSecondName;
        secondAuthorFirstName = bookBuilder.secondAuthorFirstName;
        secondAuthorSecondName = bookBuilder.secondAuthorSecondName;
        publicationYear = bookBuilder.publicationYear;
        publisher = bookBuilder.publisher;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(name);
        result.append(" {");
        result.append(authorFirstName);
        result.append(" ");
        result.append(authorSecondName);
        if (secondAuthorFirstName != null) {
            result.append(", ");
            result.append(secondAuthorFirstName);
        }
        if (secondAuthorSecondName != null) {
            result.append(" ");
            result.append(secondAuthorSecondName);
        }
        if (publicationYear != 0) {
            result.append(", ");
            result.append(publicationYear);
        }
        if (publisher != null) {
            result.append(", ");
            result.append(publisher);
        }
        result.append("}");
        return result.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return name.equals(book.name) && authorFirstName.equals(book.authorFirstName) && authorSecondName.equals(book.authorSecondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, authorFirstName, authorSecondName);
    }
}