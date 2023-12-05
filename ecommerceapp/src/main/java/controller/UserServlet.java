package controller;

import java.io.IOException;

import jakarta.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/test")
public class UserServlet extends HttpServlet {
        @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        String url = "/index.jsp";

//         // get current action
//         String action = request.getParameter("action");
//         if (action == null) {
//             action = "join";  // default action
//         }

//         // perform action and set URL to appropriate page
//         if (action.equals("join")) {
//             url = "/index.jsp";    // the "join" page
//         } else if (action.equals("add")) {
//             // get parameters from the request
//             String firstName = request.getParameter("firstName");
//             String lastName = request.getParameter("lastName");
//             String email = request.getParameter("email");

//             // store data in User object

//             User user = new User();
//             user.setEmail(email);
//             user.setFirstName(firstName);
//             user.setLastName(lastName);

//             // validate the parameters
//             String message;
//             message = "";
//             url = "/thanks.jsp";
//             UserDB.insert(user);

// //            request.setAttribute("users", UserDB.getUserLists());
//             request.setAttribute("user", user);
//             request.setAttribute("message", message);
//         }
        getServletContext()
                .getRequestDispatcher(url)
                .forward(request, response);
    }
}
