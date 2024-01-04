package com.example.ebookshop.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.ebookshop.model.Book;
import com.example.ebookshop.model.Category;
import com.example.ebookshop.model.EBookShopRepository;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private EBookShopRepository eBookShopRepository;
    private LiveData<List<Category>> allCategories;
    private LiveData<List<Book>> booksOfASelectedCategory;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);

        eBookShopRepository = new EBookShopRepository(application);
    }

    public LiveData<List<Category>> getAllCategories() {

        allCategories = eBookShopRepository.getCategories();

        return allCategories;
    }

    public LiveData<List<Book>> getBooksOfASelectedCategory(int categoryId) {

        booksOfASelectedCategory = eBookShopRepository.getBooks(categoryId);
        return booksOfASelectedCategory;
    }

    public void addNewBooks(Book book) {
        eBookShopRepository.insertBook(book);
    }

    public void updateBooks(Book book) {
        eBookShopRepository.updateBook(book);
    }

    public void deleteBooks(Book book) {
        eBookShopRepository.deleteBook(book);
    }
}
