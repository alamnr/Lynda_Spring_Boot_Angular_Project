package com.spring.landon.model.response;

import com.spring.landon.model.Links;

public class ReservationResponse {

	private Long id;
	private Integer price;
	private Integer roomNumber;
	private Links links;


	public ReservationResponse() {
		super();
	}
	public ReservationResponse(Integer price, Integer roomNumber) {
		super();
		this.price = price;
		this.roomNumber = roomNumber;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	public Links getLinks() {
		return links;
	}
	public void setLinks(Links links) {
		this.links = links;
	}



}
