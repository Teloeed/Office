package com.office;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.office.data.employee.EmploeeDAO;
import com.office.data.employee.Employee;
import com.office.db.ConnectionManager;

import java.io.*;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "simulationservlet", value = "*.html")
public class SimulationServlet extends HttpServlet {
    private String message;
    private Connection connection;
    public void init() {
        message = "Hello Boss!";
        connection = ConnectionManager.getInstance().getConnection();
        if (connection != null){
            message = "DataBase connected!";
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        if(request.getRequestURI().contains("allemployee.html")){
            List<Employee> employees = new EmploeeDAO().findAll();
            show(employees, response);
        }
//        else if {
//            List<Employee> employees = new EmploeeDAO().findAll();
//            request.setAttribute("employeeBean", new EmployeeBean(employees));
//            request.getRequestDispatcher("/employee.jsp").forward(request, response);
//        }
    }

    private void show(List<Employee> employees, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(writer, employees);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int year = Integer.parseInt(request.getParameter("year"));
//        Optional<Employee> e = new EmploeeDAO().findMaxByYear(year);
//        if(e.isPresent()) {
//            request.setAttribute("employee", e.get());
//            request.getRequestDispatcher("result.jsp").forward(request, response);
//        } else{
//            request.getRequestDispatcher("null.jsp").forward(request, response);
//        }
    }

    public void destroy() {
    }
}