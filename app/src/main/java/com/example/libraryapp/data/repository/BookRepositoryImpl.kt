package com.example.libraryapp.data.repository

import com.example.libraryapp.data.datasource.LocalBookDataSource
import com.example.libraryapp.domain.model.Book
import com.example.libraryapp.domain.repository.BookRepository

class BookRepositoryImpl: BookRepository {

    private val localDataSource = LocalBookDataSource()

    override suspend fun getBooks(): List<Book> {
        return try {
            localDataSource.getBooks()
        } catch (e: Exception) {
            throw Exception("Error fetching books", e)
        }
    }

    override suspend fun addBook(book: Book) {
        localDataSource.addBook(book)
    }

    override suspend fun getBookById(id: Int): Book? {
        return localDataSource.getBookById(id)
    }

}