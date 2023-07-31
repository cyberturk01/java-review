package org.yigit.oopreview.model.payment;

import org.yigit.oopreview.enums.Localization;

import java.math.BigDecimal;

public class RefundRequest extends AbstractPaymentRequest {
    public RefundRequest(BigDecimal amount, Localization locale, String conversationId) {
        super(amount, locale, conversationId);
    }
}
