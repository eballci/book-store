package eballci.bookstore.controller;

import eballci.bookstore.model.Book;
import eballci.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "book/")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping()
    private ResponseEntity<List<Book>> getAllBooks() {
        List<Book> list = bookRepository.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    private ResponseEntity<Book> getBook(@PathVariable Optional<Long> id) {
        if (id.isEmpty())
            return ResponseEntity.badRequest().build();

        return bookRepository
                .findById(id.get())
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    private ResponseEntity<Book> createBook(@RequestBody Book sent) {
        Book book;

        try {
            book = bookRepository.save(sent);
        } catch (IllegalArgumentException exception) {
            return ResponseEntity.internalServerError().build();
        }

        return ResponseEntity.ok(book);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<Book> removeBook(@PathVariable Optional<Long> id) {
        if (id.isEmpty())
            return ResponseEntity.badRequest().build();

        Optional<Book> book = bookRepository.findById(id.get());

        book.ifPresent(value -> bookRepository.deleteById(value.getId()));

        return book
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
