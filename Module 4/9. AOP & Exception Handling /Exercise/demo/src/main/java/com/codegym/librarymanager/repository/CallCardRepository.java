package com.codegym.librarymanager.repository;

import com.codegym.librarymanager.model.CallCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CallCardRepository extends JpaRepository<CallCard, Integer> {

    Optional<CallCard> getCallCardByCode(int code);
}