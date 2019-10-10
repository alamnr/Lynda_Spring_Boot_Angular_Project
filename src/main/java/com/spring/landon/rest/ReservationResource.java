package com.spring.landon.rest;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.landon.model.request.ResrvationRequest;
import com.spring.landon.model.response.ReservationResponse;

@RestController
@RequestMapping(value=ReservationConstant.ROOM_RESERVATION_V1)
public class ReservationResource {

	//@RequestMapping(value=ReservationConstant.ROOM_RESERVATION_V1, method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	//@GetMapping( produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	@RequestMapping(method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<ReservationResponse> getAvailableRooms(
			@RequestParam("checkin")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkin,
			@RequestParam("checkout")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkOut){

		return new ResponseEntity<>(new ReservationResponse(),HttpStatus.OK);
	}


	@PostMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> createReservation(
			@RequestBody
			ResrvationRequest reservationRequest){
		return new ResponseEntity<>(new ReservationResponse(),HttpStatus.CREATED);
	}

	@PutMapping(produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<ReservationResponse> updateReservation(
			@RequestBody
			ResrvationRequest reservationRequest){
		return new ResponseEntity<>(new ReservationResponse(),HttpStatus.OK);
	}


	@DeleteMapping(path="/{reservationId}")
	public ResponseEntity<Void> deleteReservation(
			@PathVariable
			long reservationId){

		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
