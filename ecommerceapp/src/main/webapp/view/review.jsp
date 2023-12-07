<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Review Payment Test</title>
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
                    <td>First Name:</td>
                    <td>${requestScope.firstName}</td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td>${requestScope.lastName}</td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td>${requestScope.emailAddress}</td>
                </tr>
                <tr>
                    <td>Subtotal:</td>
                    <td>${requestScope.subtotal} USD</td>
                </tr>
                <tr>
                    <td>Shipping:</td>
                    <td>${requestScope.shipping} USD</td>
                </tr>
                <tr>
                    <td>Total:</td>
                    <td>${requestScope.total} USD</td>
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