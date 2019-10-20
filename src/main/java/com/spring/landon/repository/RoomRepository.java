package com.spring.landon.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.spring.landon.entity.RoomEntity;

public interface RoomRepository extends CrudRepository<RoomEntity, Long> {

	List<RoomEntity> findByRoomNumber(Integer roomNumber);
}
