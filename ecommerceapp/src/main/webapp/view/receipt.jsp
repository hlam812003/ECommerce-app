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
                <title>Fashi | Payment Receipt</title>

                <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
                    rel="stylesheet">
            </head>

            <body>
                <div align="center">
                    <h1>Fashi</h1>
                    <h2>Thank you for purchasing our products</h2>
                    <br>
                    <h3>Order #${invoice.invoiceId}:</h3>
                    <table>
                        <tr>
                            <td><b>Issue Date: </b></td>
                            <td>${invoice.invoiceDateTime}</td>
                        </tr>
                        <tr>
                            <td><b>Customer: </b></td>
                            <td>${detail.firstName} ${detail.lastName}</td>
                        </tr>
                        <tr>
                            <td><b>Company:</b></td>
                            <td>${detail.companyName}</td>
                        </tr>
                        <tr>
                            <td><b>Email Address:</b></td>
                            <td>${detail.emailAddress}</td>
                        </tr>
                        <tr>
                            <td><b>Phone Number:</b></td>
                            <td>${detail.phoneNumber}</td>
                        </tr>
                        <tr>
                            <td><b>Street Address:</b></td>
                            <td>${detail.streetAddress}</td>
                        </tr>
                        <tr>
                            <td><b>City:</b></td>
                            <td>${detail.cityName}</td>
                        </tr>
                        <tr>
                            <td><b>Country:</b></td>
                            <td>${detail.countryName}</td>
                        </tr>
                        <tr>
                            <td><b>Postal Code:</b></td>
                            <td>${detail.postCode}</td>
                        </tr>
                        <tr>
                            <td>----------------------------</td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><b>Subtotal:</b></td>
                            <td>$${detail.subtotalAmount}</td>
                        </tr>
                        <tr>
                            <td><b>Tax Rate:</b></td>
                            <td>5%</td>
                        </tr>
                        <tr>
                            <td><b>Total:</b></td>
                            <td>$${detail.totalAmount}</td>
                        </tr>
                        <tr>
                            <td><b>Payment Method:</b></td>
                            <td>$${detail.paymentMethod}</td>
                        </tr>
                    </table>
                </div>

            </body>

            </html>