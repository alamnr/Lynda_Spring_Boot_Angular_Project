package com.spring.landon.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.landon.entity.ReservationEntity;

public interface ReservationRepository extends CrudRepository<ReservationEntity, Long>{

}
