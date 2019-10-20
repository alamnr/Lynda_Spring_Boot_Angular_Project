package convertor;

import org.springframework.core.convert.converter.Converter;

import com.spring.landon.entity.RoomEntity;
import com.spring.landon.model.Links;
import com.spring.landon.model.Self;
import com.spring.landon.model.response.ReservableRoomResponse;
import com.spring.landon.rest.ReservationConstant;

public class RoomEntityToReservablrRoomResponseConverter implements Converter<RoomEntity, ReservableRoomResponse> {

	@Override
	public ReservableRoomResponse convert(RoomEntity source) {

		ReservableRoomResponse reservationResponse = new ReservableRoomResponse();
		reservationResponse.setId(source.getId());
		reservationResponse.setPrice(Integer.valueOf(source.getPrice()));
		reservationResponse.setRoomNumber(source.getRoomNumber());

		Links links = new Links();

		Self self = new Self();

		self.setRef(ReservationConstant.ROOM_RESERVATION_V1+"/"+source.getId());

		links.setSelf(self);

		reservationResponse.setLinks(links);

		return reservationResponse;
	}


}
