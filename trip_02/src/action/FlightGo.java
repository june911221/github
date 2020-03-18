package action;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.FlightListAction;
import vo.ActionForward;
import vo.AirDto;

public class FlightGo implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		FlightListAction flight = new FlightListAction();
		AirDto dto = new AirDto();

		System.out.println("service");
		

		dto.setDday(Date.valueOf(request.getParameter("dal")));  //date->String으로 형변환
		dto.setAday(Date.valueOf(request.getParameter("dal2"))); //date->String으로 형변환
		
		dto.setDcity(request.getParameter("autocomplete"));
		dto.setAcity(request.getParameter("autocomplete2"));
		dto.setKind(request.getParameter("cp_item"));
		dto.setSeat(request.getParameter("seat_item"));

		ArrayList<AirDto> airlist = flight.Airlist(dto);

		ActionForward forward = new ActionForward();// �≪�� 媛�泥� ����
		request.setAttribute("fligthlist", airlist);
		forward.setPath("/flight_go.jsp?number="+request.getParameter("number")+"&seat="+dto.getSeat()+"&kind="+dto.getKind()+"&dcity="+dto.getDcity()+"&acity="+dto.getAcity()+"&dday="+dto.getDday()+"&aday="+dto.getAday());// �≪�� ���댁� ����
		return forward;
	}

}
