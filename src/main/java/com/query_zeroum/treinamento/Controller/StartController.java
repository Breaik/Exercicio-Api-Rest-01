package com.query_zeroum.treinamento.Controller;

import com.query_zeroum.treinamento.Entity.Tb_book;
import com.query_zeroum.treinamento.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StartController {

    @Autowired
    private BookRepository bookRepository;
//____________________________________________________________________________________________________
    @GetMapping("/start")
    public String start(){
        return "Online";
    }
//____________________________________________________________________________________________________
    @GetMapping("/start/{codigo}")
    public ResponseEntity<Tb_book> user(@PathVariable("codigo") Integer codigo){
        return bookRepository.findById(codigo)
                .map(tb_book -> ResponseEntity.ok().body(tb_book))
                .orElse(ResponseEntity.notFound().build());
    }
//____________________________________________________________________________________________________
    @GetMapping("/start/all")
    public List<Tb_book> todos(){
         List<Tb_book> tb_books = bookRepository.findAll();
         return tb_books;
    }
//____________________________________________________________________________________________________
    @GetMapping("/start/name")
    public List<Tb_book> findOrderByname(){
        List<Tb_book> tb_books = bookRepository.findAll(Sort.by(Sort.Direction.ASC,"name"));
        return tb_books;
    }
//____________________________________________________________________________________________________
    @GetMapping("/start/nameOne")
    public List<Tb_book> findByOrderByAuthorAscPublication_dateDesc(){
        Sort sort = Sort.by(Sort.Order.asc("author"), Sort.Order.desc("publicationDate"));
        List<Tb_book> tb_books = bookRepository.findAll(sort);
        return tb_books;
    }
//____________________________________________________________________________________________________
    @PostMapping("/start/salvar")
    public Tb_book salvar(@RequestBody Tb_book tb_book){
        return bookRepository.save(tb_book);
    }
//____________________________________________________________________________________________________
    @DeleteMapping("/start/delete/{codigo}")
    public void delete(@PathVariable("codigo") Integer id){
        if (bookRepository.existsById(id)){
            bookRepository.deleteById(id);
        }
    }
//____________________________________________________________________________________________________
    @DeleteMapping("/start/delete/all")
    public void deleteAll(){
        bookRepository.deleteAll();
    }
}
