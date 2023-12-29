package com.mpcortez.dscommerce.mapper.response;

import com.mpcortez.dscommerce.dto.response.PaymentResponseDTO;
import com.mpcortez.dscommerce.entities.Payment;

import java.util.Objects;

public class PaymentResponseDTOMapper {

    public static PaymentResponseDTO mapper(Payment payment) {
        return Objects.nonNull(payment)
                ? new PaymentResponseDTO(payment.getId(), payment.getMoment())
                : null;
    }
}
