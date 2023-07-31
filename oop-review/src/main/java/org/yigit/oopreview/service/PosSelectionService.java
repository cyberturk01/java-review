package org.yigit.oopreview.service;

import org.yigit.oopreview.model.payment.AuthRequest;
import org.yigit.oopreview.model.pos.Pos;

public interface PosSelectionService {
    Pos decidePaymentPos(AuthRequest authRequest);
}
