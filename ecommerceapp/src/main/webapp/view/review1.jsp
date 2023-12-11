<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="description" content="Fashi Ecommerce">
                <meta name="keywords" content="Fashi, unica, creative, html">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <meta http-equiv="X-UA-Compatible" content="ie=edge">
                <title>Fashi | Review Payment</title>

                <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
                    rel="stylesheet">
            </head>

            <body>
                <div align="center">
                    <h1>Please Review Before Paying</h1>
                    <form action="paypal-execute" method="post">
                        <table>
                            <tr>
                                <td colspan="2"><b>Transaction Details:</b></td>
                                <td>
                                    <input type="hidden" name="paymentId" value="${param.paymentId}" />
                                    <input type="hidden" name="PayerID" value="${param.PayerID}" />
                                </td>
                            </tr>
                            <tr>
                                <td>Description:</td>
                                <td>${transaction.description}</td>
                            </tr>
                            <tr>
                                <td>Subtotal:</td>
                                <td>${transaction.amount.details.subtotal} USD</td>
                            </tr>
                            <tr>
                                <td>Shipping:</td>
                                <td>${transaction.amount.details.shipping} USD</td>
                            </tr>
                            <tr>
                                <td>Tax:</td>
                                <td>${transaction.amount.details.tax} USD</td>
                            </tr>
                            <tr>
                                <td>Total:</td>
                                <td>${transaction.amount.total} USD</td>
                            </tr>
                            <tr>
                                <td><br /></td>
                            </tr>
                            <tr>
                                <td colspan="2"><b>Payer Information:</b></td>
                            </tr>
                            <tr>
                                <td>First Name:</td>
                                <td>${payer.firstName}</td>
                            </tr>
                            <tr>
                                <td>Last Name:</td>
                                <td>${payer.lastName}</td>
                            </tr>
                            <tr>
                                <td>Email:</td>
                                <td>${payer.email}</td>
                            </tr>
                            <tr>
                                <td><br /></td>
                            </tr>
                            <tr>
                                <td colspan="2"><b>Shipping Address:</b></td>
                            </tr>
                            <tr>
                                <td>Recipient Name:</td>
                                <td>${shippingAddress.recipientName}</td>
                            </tr>
                            <tr>
                                <td>Line 1:</td>
                                <td>${shippingAddress.line1}</td>
                            </tr>
                            <tr>
                                <td>City:</td>
                                <td>${shippingAddress.city}</td>
                            </tr>
                            <tr>
                                <td>State:</td>
                                <td>${shippingAddress.state}</td>
                            </tr>
                            <tr>
                                <td>Country Code:</td>
                                <td>${shippingAddress.countryCode}</td>
                            </tr>
                            <tr>
                                <td>Postal Code:</td>
                                <td>${shippingAddress.postalCode}</td>
                            </tr>
                            <tr>
                                <td colspan="2" align="center">
                                    <input type="submit" value="Pay Now" />
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </body>

            </html>