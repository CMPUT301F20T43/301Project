package com.stl.mobilelibrary;

import java.util.regex.Pattern;

/**
 * Determine if adding book is valid
 */
public class BookValidator implements Validatable {

    private String title;
    private String author;
    private String isbn;
    private String desc;
    private String errorMessage;

    /**
     * @param title: the book's title
     * @param author: the book's author
     * @param isbn: the book's isbn
     * @param desc: the book's description
     */
    public BookValidator(String title, String author, String isbn, String desc) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.desc = desc;
        this.errorMessage = "No errors detected";
    }

    /**
     * Determines if the title is valid
     */
    public boolean isTitleValid(){
        Boolean valid = Pattern.compile("[0-9a-zA-Z'_ .!?]+").matcher(title).matches();

        if (!valid){
            errorMessage = "Invalid title format";
        }

        return valid;
    }

    /**
     * Determines if the author is valid
     */
    public boolean isAuthorValid(){
        Boolean valid = Pattern.compile("[a-zA-Z_' \\-.]+").matcher(author).matches();

        if (!valid){
            errorMessage = "Invalid author format";
        }

        return valid;
    }

    /**
     * Determines if the ISBN is valid
     */
    public boolean isISBNValid(){
        Boolean valid = Pattern.compile("(?:[x0-9]\\-?){13}").matcher(isbn).matches();

        if (!valid){
            errorMessage = "Invalid ISBN format";
        }

        return valid;
    }

    /**
     * Determines if the description is valid
     */
    public boolean isDescriptionValid(){
        Boolean valid = desc.length() > 0;

        if (!valid){
            errorMessage = "Invalid description format";
        }

        return valid;
    }

    /**
     * Determines if the book is valid
     */
    @Override
    public boolean isValid() {
        return isTitleValid() && isAuthorValid() && isISBNValid() && isDescriptionValid();
    }

    /**
     * Determines the error message to display
     */
    @Override
    public String getErrorMessage() {
        return errorMessage;
    }
}


