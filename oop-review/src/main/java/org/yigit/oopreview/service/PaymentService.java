package org.yigit.oopreview.service;


import org.yigit.oopreview.model.payment.PaymentResponse;
import org.yigit.oopreview.model.payment.AuthRequest;

public interface PaymentService {
    PaymentResponse auth(AuthRequest authRequest);

    PaymentResponse auth3D(AuthRequest auth3DRequest);
}
