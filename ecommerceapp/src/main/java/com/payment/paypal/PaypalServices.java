package com.payment.paypal;

import java.util.ArrayList;
import java.util.List;

import com.model.OrderDetail;
import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Details;
import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payer;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.PaymentExecution;
import com.paypal.api.payments.RedirectUrls;
import com.paypal.api.payments.Transaction;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaypalServices {
    // private static final String CLIENT_ID =
    // "AZuC8jj38fh6_DjDjxT2dllPfz-IDTCcc8p_gLJIShDu1xyGNVbL-JcdUhwuQ_fGmijQv-ww_AcjVpCd";
    // private static final String SECRET_KEY =
    // "EEcAVbsDsa75_MkjACYDRL_JqwW2ODFa43PPGiTYZIMtTPaQEpVhsytD6Q3UrPygBFNCEkmUy2J3Ipdy";
    // private static final String MODE = "sandbox";

    public static final String CLIENT_ID = "ATBwxctchja2exEWDllNczOUS69fUG9IkTUhXDwuRIAZCeg_WMNMs2hFlgvWVcXlokf_V2xDI-pefSfG";

    public static final String SECRET_KEY = "EGCza78gqONc8tGMk5T4h7LJYb-3twjynqGWRYT6iqUWAppbOQLo6xNHI4h03DEaR6kxdc4or8ojt4o4";

    public static final String MODE = "sandbox";

    public String authorizePayment(OrderDetail orderDetail) throws PayPalRESTException {

        Payer payer = getPayerInformation(orderDetail);
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);

        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, SECRET_KEY, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, SECRET_KEY, MODE);
        return Payment.get(apiContext, paymentId);
    }

    private Payer getPayerInformation(OrderDetail orderDetail) {
        Payer payer = new Payer();
        payer.setPaymentMethod("paypal");

        PayerInfo payerInfo = new PayerInfo();
        payerInfo.setFirstName(orderDetail.getFirstName())
                .setLastName(orderDetail.getLastName())
                .setEmail(orderDetail.getEmailAddress());
        payer.setPayerInfo(payerInfo);
        return payer;
    }

    private RedirectUrls getRedirectURLs() {
        RedirectUrls redirectUrls = new RedirectUrls();
        redirectUrls.setCancelUrl("http://localhost:8080/view/payment-cancel.jsp");
        redirectUrls.setReturnUrl("http://localhost:8080/paypal-review");
        return redirectUrls;
    }

    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
        Details details = new Details();
        details.setShipping(String.format("%.2f", orderDetail.getShippingAmount()));
        details.setTax(String.format("%.2f", orderDetail.getTaxAmount()));
        details.setSubtotal(String.format("%.2f", orderDetail.getSubtotalAmount()));

        Amount amount = new Amount();
        amount.setTotal(String.format("%.2f", orderDetail.getTotalAmount()));
        amount.setCurrency("USD");
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Order at Fashi");
        transaction.setCustom(orderDetail.getInvoice().getInvoiceId().toString());
        List<Transaction> listTransaction = new ArrayList<Transaction>();
        listTransaction.add(transaction);
        return listTransaction;
    }

    private String getApprovalLink(Payment approvedPayment) {
        List<Links> links = approvedPayment.getLinks();
        String approvalLink = null;

        for (Links link : links) {
            if (link.getRel().equalsIgnoreCase("approval_url")) {
                approvalLink = link.getHref();
                break;
            }
        }
        return approvalLink;
    }

    public Payment executePayment(String paymentId, String payerId)
            throws PayPalRESTException {
        PaymentExecution paymentExecution = new PaymentExecution();
        paymentExecution.setPayerId(payerId);

        Payment payment = new Payment().setId(paymentId);

        APIContext apiContext = new APIContext(CLIENT_ID, SECRET_KEY, MODE);

        return payment.execute(apiContext, paymentExecution);
    }
}
