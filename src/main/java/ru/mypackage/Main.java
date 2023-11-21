package ru.mypackage;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book.BookBuilder("О цвете", "Теренс", "Конран")
                .publisher("Колибри")
                .publicationYear(2018)
                .build();
        Book book2 = new Book.BookBuilder("История пантона XX век  в цвете", "Леатрис", "Эйсман")
                .secondAuthorFirstName("Кит")
                .secondAuthorSecondName("Рекер")
                .publisher("Бомбора")
                .publicationYear(2022)
                .build();
        System.out.println(book1.toString());
        System.out.println(book2.toString());
    }
}