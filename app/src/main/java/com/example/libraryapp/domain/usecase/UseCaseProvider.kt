package com.example.libraryapp.domain.usecase

import com.example.libraryapp.domain.repository.BookRepository

object UseCaseProvider {
    private var getBooksUseCase: GetBooksUseCase? = null
    private var getBookDetailUseCase: GetBookDetailUseCase? = null
    private var addBookUseCase: AddBookUseCase? = null
    private lateinit var bookRepository: BookRepository

    fun setBookRepository(repository: BookRepository) {
        this.bookRepository = repository
    }

    fun provideGetBooksUseCase(): GetBooksUseCase {
        if (getBooksUseCase == null) {
            getBooksUseCase = GetBooksUseCase()
        }
        return getBooksUseCase!!
    }

    // TODO implement the useCases first

   fun provideGetBookDetailUseCase(): GetBookDetailUseCase {
        if (getBookDetailUseCase == null) {
            getBookDetailUseCase = GetBookDetailUseCase(bookRepository)
        }
        return getBookDetailUseCase!!
    }

    fun provideAddBookUseCase(): AddBookUseCase {
        if (addBookUseCase == null) {
            addBookUseCase = AddBookUseCase(bookRepository)
        }
        return addBookUseCase!!
    }
}