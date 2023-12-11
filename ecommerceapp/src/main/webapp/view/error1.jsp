<%@ page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
        <%@ taglib prefix="c" uri="jakarta.tags.core" %>

            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Payment Error</title>
            </head>

            <body>
                <div align="center">
                    <h1>Payment Error</h1>
                    <br />
                    <h3>${errorMessage}</h3>
                    <br />
                </div>
            </body>

            </html>