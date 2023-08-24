package com.backy.member;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.backy.member.domain.MemberVO;
import com.backy.member.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private MemberService service;//빈에 등록된 기준으로 데이터가 들어감
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	
	//Mapping을 통해 if문 없이 응답페이지로 연결 가능해짐
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	//완성된 내용 -> /WEB-INF/views/home.jsp
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET) 
	//대신 @GetMapping 사용해도 됨, 생략해도 모든 방식을 받아들이겠다는 의미로 알아서 받음, get으로 설정해두면 post방식으로는 못넘겨받음
	public String test(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "test";
	}
	@RequestMapping(value = "/member", method = RequestMethod.GET) 
	//대신 @GetMapping 사용해도 됨, 생략해도 모든 방식을 받아들이겠다는 의미로 알아서 받음, get으로 설정해두면 post방식으로는 못넘겨받음
	public String member(Locale locale, Model model) {
		return "memberJoin";
		//완성된 내용 -> /WEB-INF/views/memberJoin.jsp
	}
	//memberJoin의 메서드가 get방식이므로 get으로 받거나 형식을 지정하지 않아야 받을수 있다.
	//대신 @GetMapping 사용해도 됨, 생략해도 모든 방식을 받아들이겠다는 의미로 알아서 받음, get으로 설정해두면 post방식으로는 못넘겨받음
	@RequestMapping(value = "/memberJoin"/*, method = RequestMethod.POST*/) 
	//응답 받기 위해서( 자료를 넘겨줌 ) model이 필요
	//MemberVO 에 맞춰서 데이터를 집어 넣어줌
	public String memberJoin(MemberVO vo, Model model) {
		//입력폼에서 입력된 데이터를 넘겨 받아서 
		//service class에게 입력에 필요한 작업을 하도록 지시하고 그 결과를 받는다.
		int rtnValue = service.save(vo);
		//받은 결과를 응답페이지에서 필요하다면 모델에 넣어준다.
		model.addAttribute("result", rtnValue);
		model.addAttribute("memberName", vo.getMemName());
		System.out.println(vo);
		return "memberJoinResult";
		//완성된 내용 -> /WEB-INF/views/memberJoinResult.jsp
}
}
