package convertor;

import org.springframework.core.convert.converter.Converter;

import com.spring.landon.entity.ReservationEntity;
import com.spring.landon.model.response.ReservationResponse;

public class ReservationEntityToReservationResponseConverter implements Converter<ReservationEntity, ReservationResponse>{

	@Override
	public ReservationResponse convert(ReservationEntity source) {
		ReservationResponse reservationResponse = new ReservationResponse();

		reservationResponse.setCheckin(source.getCheckIn());
		reservationResponse.setCheckout(source.getCheckOut());

		return reservationResponse;
	}


}
