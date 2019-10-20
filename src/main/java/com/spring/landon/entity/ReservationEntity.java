package com.spring.landon.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Reservation")
public class ReservationEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@NotNull
	private LocalDate checkIn;

	@NotNull
	private LocalDate checkOut;

	@ManyToOne
	private RoomEntity roomEntity;

	public ReservationEntity() {
		super();
	}

	public ReservationEntity(@NotNull LocalDate checkIn, @NotNull LocalDate checkOut) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}



	public RoomEntity getRoomEntity() {
		return roomEntity;
	}

	public void setRoomEntity(RoomEntity roomEntity) {
		this.roomEntity = roomEntity;
	}

	@Override
	public String toString() {
		return String.format("ReservationEntity [id=%s, checkIn=%s, checkOut=%s]", id, checkIn, checkOut);
	}



}
