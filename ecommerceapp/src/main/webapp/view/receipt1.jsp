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
                <title>Fashi | Execute Payment</title>

                <link href="https://fonts.googleapis.com/css?family=Muli:300,400,500,600,700,800,900&display=swap"
                    rel="stylesheet">
            </head>


            <body>
                <div align="center">
                    <h1>Payment Done. Thank you for purchasing our products</h1>
                    <br />
                    <h2>Receipt Details:</h2>
                    <table>
                        <tr>
                            <td><b>Merchant:</b></td>
                            <td>Fashi Ltd.</td>
                        </tr>
                        <tr>
                            <td><b>Payer:</b></td>
                            <td>${payer.firstName} ${payer.lastName}</td>
                        </tr>
                        <tr>
                            <td><b>Description:</b></td>
                            <td>${transaction.description}</td>
                        </tr>
                        <tr>
                            <td><b>Subtotal:</b></td>
                            <td>${transaction.amount.details.subtotal} USD</td>
                        </tr>
                        <tr>
                            <td><b>Shipping:</b></td>
                            <td>${transaction.amount.details.shipping} USD</td>
                        </tr>
                        <tr>
                            <td><b>Tax:</b></td>
                            <td>${transaction.amount.details.tax} USD</td>
                        </tr>
                        <tr>
                            <td><b>Total:</b></td>
                            <td>${transaction.amount.total} USD</td>
                        </tr>
                    </table>
                </div>
            </body>

            </html>