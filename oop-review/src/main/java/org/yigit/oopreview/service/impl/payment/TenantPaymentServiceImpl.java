package org.yigit.oopreview.service.impl.payment;

import org.yigit.oopreview.model.payment.PaymentResponse;
import org.yigit.oopreview.model.payment.AuthRequest;
import org.yigit.oopreview.model.payment.Payment;
import org.yigit.oopreview.model.pos.Pos;
import org.yigit.oopreview.model.pos.PosClientRequest;
import org.yigit.oopreview.model.pos.PosClientResponse;
import org.yigit.oopreview.posclient.AbstractPosClient;
import org.yigit.oopreview.posclient.client.BankAPosClient;
import org.yigit.oopreview.posclient.client.BankBPosClient;
import org.yigit.oopreview.posclient.client.BankCPosClient;
import org.yigit.oopreview.service.PaymentService;
import org.yigit.oopreview.service.PosSelectionService;
import org.yigit.oopreview.service.impl.selection.TenantPosSelectionServiceImpl;
import org.yigit.oopreview.constant.StaticConstants;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;


public class TenantPaymentServiceImpl implements PaymentService {

    private final ResourceBundle resourceBundle;

    public TenantPaymentServiceImpl(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    @Override
    public PaymentResponse auth(AuthRequest authRequest){
        PosSelectionService posSelectionService = new TenantPosSelectionServiceImpl();

        Pos pos = posSelectionService.decidePaymentPos(authRequest);

        AbstractPosClient abstractPosClient = decidePosClient(pos.getName());

        UUID orderId = abstractPosClient.generateOrderId();

        PosClientRequest posClientRequest = new  PosClientRequest(authRequest.getAmount());

        posClientRequest.setOrderId(orderId.toString());

        PosClientResponse posClientResponse = abstractPosClient.auth(posClientRequest);

        PaymentResponse paymentResponse = doErrorCodeMapping(posClientResponse, resourceBundle);

        paymentResponse.setPaymentCostAmount(calculateCommissionForTenantMerchant(
                authRequest.getAmount(), pos.getInstallmentCommissionMap().get(authRequest.getInstallment())));

        if (paymentResponse.getResult() == 1){
            initPaymentRecord(authRequest, orderId);
        }
        return paymentResponse;
    }


    @Override
    public PaymentResponse auth3D(AuthRequest auth3DRequest) {

        PosSelectionService posSelectionService = new TenantPosSelectionServiceImpl();

        Pos pos = posSelectionService.decidePaymentPos(auth3DRequest);

        AbstractPosClient abstractPosClient = decidePosClient(pos.getName());

        PosClientRequest posClientRequest = new PosClientRequest(auth3DRequest.getAmount());

        UUID orderId = abstractPosClient.generateOrderId();

        posClientRequest.setOrderId(orderId.toString());

        PosClientResponse posClientResponse = abstractPosClient.auth3D(posClientRequest);

        PaymentResponse paymentResponse = doErrorCodeMapping(posClientResponse, resourceBundle);

        if (paymentResponse.getResult() == 1){
            paymentResponse.setPaymentCostAmount(calculateCommissionForTenantMerchant(
                    auth3DRequest.getAmount(), pos.getInstallmentCommissionMap().get(auth3DRequest.getInstallment())));

            initPaymentRecord(auth3DRequest, orderId);
        }

        return paymentResponse;
    }

    public BigDecimal  calculateCommissionForTenantMerchant(BigDecimal paymentAmount, Double commissionRate) {
        return paymentAmount.multiply(new BigDecimal(commissionRate))
                .divide(new BigDecimal(100))
                .round(MathContext.DECIMAL32);
    }

    PaymentResponse doErrorCodeMapping(PosClientResponse posClientResponse, ResourceBundle resourceBundle){

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setResult(posClientResponse.getResult());

        if (posClientResponse.getResult() != 1){
            paymentResponse.
                    setResultMessage(resourceBundle.getString(
                            resourceBundle.getString("error.code." + posClientResponse.getErrorCde())));

            paymentResponse.setErrorCde(posClientResponse.getErrorCde());
        }
        return paymentResponse;
    }

    public void initPaymentRecord(AuthRequest authRequest, UUID orderId){
        Payment payment = new Payment(new Date(), authRequest.getAmount(),
                orderId, authRequest.getAmount());
        StaticConstants.CYDEO_PAYMENT_LIST.add(payment);
    }

    public AbstractPosClient decidePosClient(String posName){
        switch (posName){
            case "BANKA":
                return new BankAPosClient();
            case "BANKB":
                return new BankBPosClient();
            case "BANKC":
                return new BankCPosClient();
            default:
                return null;
        }
    }
}
