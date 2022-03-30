package com.query_zeroum.treinamento.Repository;

import com.query_zeroum.treinamento.Entity.Tb_book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Tb_book, Integer> {

    //public List<Tb_book> findByOrderByName();
    //public List<Tb_book> findByOrderByAuthorAscPublicationDateDesc();
}
