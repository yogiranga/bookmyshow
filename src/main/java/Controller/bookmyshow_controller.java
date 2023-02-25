package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.bookmyshowdao;
import DTO.bookingdto;
@WebServlet("/booking")
public class bookmyshow_controller extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String s1=req.getParameter("customer_name");
	String s2=req.getParameter("movie_name");
	String s3=req.getParameter("seat_number");
	String s4=req.getParameter("ticket_price");
	double d=Double.parseDouble(s4);
	String s5=req.getParameter("number_of_seats");
	int numberofseats= Integer.parseInt(s5);
	double ticket_price=d*numberofseats;
	
	
	bookingdto dto=new bookingdto();
	dto.setCustomer_name(s1);
	dto.setMovie_name(s2);
	dto.setSeat_number(s3);
	dto.setTicket_price(ticket_price);
	dto.setNumber_of_seats(numberofseats);
	
	
	bookmyshowdao dao=new bookmyshowdao();
	dao.insert(dto);
	}

}
