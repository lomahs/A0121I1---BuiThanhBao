package com.codegym.librarymanager.service.impl;

import com.codegym.librarymanager.model.CallCard;
import com.codegym.librarymanager.repository.CallCardRepository;
import com.codegym.librarymanager.service.ICallCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CallCardService implements ICallCardService {

    private final CallCardRepository callCardRepository;

    @Autowired
    public CallCardService(CallCardRepository callCardRepository) {
        this.callCardRepository = callCardRepository;
    }

    @Override
    public Page<CallCard> listCallCards(Pageable pageable) {
        return callCardRepository.findAll(pageable);
    }

    @Override
    public void saveCallCard(CallCard callCard) {
        callCardRepository.save(callCard);
    }

    @Override
    public void removeCallCard(int id) {
        callCardRepository.deleteById(id);
    }

    @Override
    public CallCard findCallCardById(int id) {
        return callCardRepository.findById(id).orElse(null);
    }

    @Override
    public CallCard getCallCardByCode(int code) {
        return callCardRepository.getCallCardByCode(code).orElse(null);
    }
}