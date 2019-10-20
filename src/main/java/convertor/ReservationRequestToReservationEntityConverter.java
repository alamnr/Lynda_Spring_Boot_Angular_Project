package convertor;

import org.springframework.core.convert.converter.Converter;

import com.spring.landon.entity.ReservationEntity;
import com.spring.landon.model.request.ReservationRequest;

public class ReservationRequestToReservationEntityConverter implements Converter<ReservationRequest, ReservationEntity>{

	@Override
	public ReservationEntity convert(ReservationRequest source) {
		ReservationEntity reservationEntity = new ReservationEntity();

		reservationEntity.setCheckIn(source.getCheckin());
		reservationEntity.setCheckOut(source.getCheckout());
		if(null!=source.getId()) {
			reservationEntity.setId(source.getId());
		}

		return reservationEntity;
	}

}
