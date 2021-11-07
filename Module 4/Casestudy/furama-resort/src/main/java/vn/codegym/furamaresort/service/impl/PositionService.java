package vn.codegym.furamaresort.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.employee.Position;
import vn.codegym.furamaresort.repository.PositionRepository;
import vn.codegym.furamaresort.service.IPositionService;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    private PositionRepository positionRepository;

    @Override
    public List<Position> listAllPositions() {
        return positionRepository.findAll();
    }
}