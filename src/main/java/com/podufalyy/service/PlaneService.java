package com.podufalyy.service;

import com.podufalyy.domain.Plane;
import com.podufalyy.repository.PlaneRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@AllArgsConstructor
@Service
public class PlaneService extends AbstractService<Plane, Integer> {
    public PlaneRepository planeRepository;

    @Override
    protected JpaRepository<Plane, Integer> getRepository() {
        return planeRepository;
    }
}
