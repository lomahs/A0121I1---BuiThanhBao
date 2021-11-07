package vn.codegym.furamaresort.service;

import org.springframework.stereotype.Service;
import vn.codegym.furamaresort.model.employee.Position;

import java.util.List;

@Service
public interface IPositionService {

    List<Position> listAllPositions();
}