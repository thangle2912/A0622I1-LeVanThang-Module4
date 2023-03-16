package com.codegym.furama.service.employee;

import com.codegym.furama.model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> findAll();
    void save(Position position);
    void delete(Position position);
    void update(Position position);

}
