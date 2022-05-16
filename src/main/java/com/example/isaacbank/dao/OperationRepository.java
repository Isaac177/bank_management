package com.example.isaacbank.dao;

import com.example.isaacbank.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation,Long> {

    //This query returns a list of operations for a given account.
    // @param codeAccount is the code of the account
    // @param pageable is the Pageable object that contains the page number, page size, and sort order.

    @Query("select o from Operation o where o.account.codeAccount=:x order by  o.dateOperation desc ")
    public Page<Operation> listOperatiion(@Param("x") String codeAccount , Pageable pageable);
}
