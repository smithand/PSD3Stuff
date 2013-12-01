package com.sprint2.src;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public ModelAndView session(){
		return new ModelAndView("sessionForm", "command", new Session());
	}
	
	@RequestMapping(value = "/addSession", method = RequestMethod.POST)
	public String addSession(@ModelAttribute("SpringWeb")Session session, ModelMap model){
		model.addAttribute("date", session.getDate());
		model.addAttribute("duration", session.getDuration());
		model.addAttribute("repeatFrequency", session.getRepeatFrequency());
		model.addAttribute("lecturer", session.getLecturer());
		model.addAttribute("maxAttendance", session.getMaxAttendance());
		model.addAttribute("compulsory", session.isCompulsory());
		model.addAttribute("venue", session.getVenue());
		return "sessionDetail";
	}
	

@RequestMapping(value = "/viewDay", method = RequestMethod.GET)
	public ModelAndView dayTimetable(ModelMap model){
		return new ModelAndView( "day");
		
	}
	
	
	
	/**private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	*
*****@RequestMapping(value = "/", method = RequestMethod.GET)
	*public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	*/
}
