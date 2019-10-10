package com.spring.landon.rest;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.landon.model.response.ReservationResponse;

@RestController
public class ReservationResource {

	@RequestMapping(value=ReservationConstant.ROOM_RESERVATION_V1, method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public ResponseEntity<ReservationResponse> getAvailableRooms(
			@RequestParam("checkin")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkin,
			@RequestParam("checkout")
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
			LocalDate checkOut){

		return new ResponseEntity<>(new ReservationResponse(),HttpStatus.OK);
	}

}
