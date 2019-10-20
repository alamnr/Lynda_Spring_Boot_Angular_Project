package com.spring.landon.rest;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.landon.entity.ReservationEntity;
import com.spring.landon.entity.RoomEntity;
import com.spring.landon.model.request.ReservationRequest;
import com.spring.landon.model.response.ReservableRoomResponse;
import com.spring.landon.model.response.ReservationResponse;
import com.spring.landon.repository.PageableRoomRepository;
import com.spring.landon.repository.ReservationRepository;
import com.spring.landon.repository.RoomRepository;

import convertor.RoomEntityToReservablrRoomResponseConverter;

@RestController
@RequestMapping(path = ReservationConstant.ROOM_RESERVATION_V1)
public class ReservationResource {

	@Autowired
	PageableRoomRepository pageableRoomRepository;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	ReservationRepository reservationRepository;

	@Autowired
	ConversionService conversionService;

	@Autowired
	RoomEntityToReservablrRoomResponseConverter roomEntityToReservationResponseConverter;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Page<ReservableRoomResponse> getAvailableRooms(
			@RequestParam("checkin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkin,
			@RequestParam("checkout") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOut,
			Pageable pageable) {

		Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);

		return roomEntityList.map(roomEntityToReservationResponseConverter::convert);
	}

	@GetMapping(path = "/{roomId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<RoomEntity> getRoomById(@PathVariable Long roomId) {

		Optional<RoomEntity> roomEntity = roomRepository.findById(roomId);
		return new ResponseEntity<>(roomEntity.get(), HttpStatus.OK);

	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(
			@RequestBody ReservationRequest reservationRequest) {

		ReservationEntity reservationEntity = conversionService.convert(reservationRequest, ReservationEntity.class);

		reservationRepository.save(reservationEntity);

		Optional<RoomEntity> roomEntity = roomRepository.findById(reservationRequest.getRoomId());

		if(roomEntity.isPresent()) {
			roomEntity.get().addReservationEntity(reservationEntity);
			reservationEntity.setRoomEntity(roomEntity.get());
			roomRepository.save(roomEntity.get());
		}

		ReservationResponse reservationResponse  = conversionService.convert(reservationEntity, ReservationResponse.class);
		return new ResponseEntity<>(reservationResponse, HttpStatus.CREATED);
	}

	@PutMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservableRoomResponse> updateReservation(
			@RequestBody ReservationRequest reservationRequest) {
		return new ResponseEntity<>(new ReservableRoomResponse(), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{reservationId}")
	public ResponseEntity<Void> deleteReservation(@PathVariable long reservationId) {

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}