package com.codegym.librarymanager.service;

import com.codegym.librarymanager.model.CallCard;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface ICallCardService {

    Page<CallCard> listCallCards(Pageable pageable);

    void saveCallCard(CallCard callCard);

    void removeCallCard(int id);

    CallCard findCallCardById(int id);

    CallCard getCallCardByCode(int code);
}