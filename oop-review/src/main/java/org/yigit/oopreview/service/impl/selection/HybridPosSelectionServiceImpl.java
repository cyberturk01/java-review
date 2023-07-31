package org.yigit.oopreview.service.impl.selection;


import org.yigit.oopreview.model.payment.AuthRequest;
import org.yigit.oopreview.model.pos.Pos;
import org.yigit.oopreview.service.PosSelectionService;
import org.yigit.oopreview.constant.StaticConstants;

public class HybridPosSelectionServiceImpl implements PosSelectionService {

    @Override
    //Since there is no cost calculation among hybrid pos,
    // we are trying to find the pos that the merchant wants the payment to be made.
    public Pos decidePaymentPos(AuthRequest authRequest) {
        return StaticConstants.POS_LIST.stream().
                filter(pos -> authRequest.getPosName().equals(pos.getName())).findFirst().orElse(StaticConstants.POS_LIST.get(0));
    }
}
