package org.yigit.oopreview.posclient.client;


import org.yigit.oopreview.model.pos.PosClientRequest;
import org.yigit.oopreview.model.pos.PosClientResponse;
import org.yigit.oopreview.posclient.AbstractPosClient;

public class BankCPosClient extends AbstractPosClient {

    // return dummy response
    @Override
    public PosClientResponse auth(PosClientRequest posClientRequest) {
        return new PosClientResponse(0, "1345", posClientRequest.getRequestedAmount());
    }

    // return dummy response
    @Override
    public PosClientResponse auth3D(PosClientRequest posClientRequest) {
        return new PosClientResponse(0, "23", posClientRequest.getRequestedAmount());
    }

}
