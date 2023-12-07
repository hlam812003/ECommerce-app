package com.payment.paypal;

import java.util.*;
import com.model.OrderDetail;

import com.paypal.api.payments.*;
import com.paypal.base.rest.*;

public class PaypalServices {
    private static final String CLIENT_ID = "AZuC8jj38fh6_DjDjxT2dllPfz-IDTCcc8p_gLJIShDu1xyGNVbL-JcdUhwuQ_fGmijQv-ww_AcjVpCd";
    private static final String CLIENT_SECRET = "EEcAVbsDsa75_MkjACYDRL_JqwW2ODFa43PPGiTYZIMtTPaQEpVhsytD6Q3UrPygBFNCEkmUy2J3Ipdy";
    private static final String MODE = "sandbox";

    public String authorizePayment(OrderDetail orderDetail) throws PayPalRESTException {       

        Payer payer = getPayerInformation(orderDetail);
        RedirectUrls redirectUrls = getRedirectURLs();
        List<Transaction> listTransaction = getTransactionInformation(orderDetail);
         
        Payment requestPayment = new Payment();
        requestPayment.setTransactions(listTransaction);
        requestPayment.setRedirectUrls(redirectUrls);
        requestPayment.setPayer(payer);
        requestPayment.setIntent("authorize");

        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);

        Payment approvedPayment = requestPayment.create(apiContext);

        return getApprovalLink(approvedPayment);
    }

    public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
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
        redirectUrls.setCancelUrl("http://localhost:8080/payment-cancel.html");
        redirectUrls.setReturnUrl("http://localhost:8080/review_payment");
        return redirectUrls;
    }
     
    private List<Transaction> getTransactionInformation(OrderDetail orderDetail) {
        Details details = new Details();
        details.setShipping(String.format("%.2f", orderDetail.getShipping()));
        details.setSubtotal(String.format("%.2f", orderDetail.getTotalAmount()));

        Amount amount = new Amount();
        amount.setCurrency("USD");
        amount.setTotal(String.format("%.2f", orderDetail.getTotalAmount()));
        amount.setDetails(details);

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDescription("Order at My Shop");

        List<Transaction> listTransaction = new ArrayList<>();
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
    
        APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
    
        return payment.execute(apiContext, paymentExecution);
    }
}
