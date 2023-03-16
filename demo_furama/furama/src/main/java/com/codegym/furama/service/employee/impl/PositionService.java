package com.codegym.furama.service.employee.impl;

import com.codegym.furama.model.employee.Position;
import com.codegym.furama.repository.employee.IPositionRepository;
import com.codegym.furama.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {

   @Autowired
    IPositionRepository positionRepository;

    @Override
    public List<Position> findAll() {
        return positionRepository.findAll();
    }

    @Override
    public void save(Position position) {
        positionRepository.save(position);
    }

    @Override
    public void delete(Position position) {
        positionRepository.delete(position);
    }

    @Override
    public void update(Position position) {
        positionRepository.save(position);
    }
}
