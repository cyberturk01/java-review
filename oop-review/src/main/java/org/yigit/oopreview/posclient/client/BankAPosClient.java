package org.yigit.oopreview.posclient.client;


import org.yigit.oopreview.constant.StaticConstants;
import org.yigit.oopreview.model.pos.PosClientRequest;
import org.yigit.oopreview.model.pos.PosClientResponse;
import org.yigit.oopreview.posclient.AbstractPosClient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class BankAPosClient extends AbstractPosClient {

    // orderId needs to be created from date that's why we use polymorphism
    public UUID generateOrderId(){
        return UUID.fromString(formatDate(new Date()));
    }

    // return dummy response
    @Override
    public PosClientResponse auth(PosClientRequest posClientRequest) {
        return new PosClientResponse(1, null, posClientRequest.getRequestedAmount());
    }

    // return dummy response
    @Override
    public PosClientResponse auth3D(PosClientRequest posClientRequest) {
        return new PosClientResponse(1, null, posClientRequest.getRequestedAmount());

    }

    private String formatDate(Date date){
        return new SimpleDateFormat(StaticConstants.DATE_FORMAT_PATTERN).format(date);
    }
}
