package com.spring.landon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.spring.landon.entity.RoomEntity;
import com.spring.landon.repository.RoomRepository;


@Component
public class H2Bootstrap  implements CommandLineRunner{

	@Autowired
	RoomRepository roomRepository;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Bootstrapping Data");

		roomRepository.save(new RoomEntity(405, "200"));
		roomRepository.save(new RoomEntity(406, "220"));
		roomRepository.save(new RoomEntity(407, "250"));

		System.out.println("Printing out Data");

		roomRepository.findAll().forEach(obj -> System.out.println(obj));

	}

}
