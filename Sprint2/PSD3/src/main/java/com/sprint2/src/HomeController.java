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
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView session(){
		return new ModelAndView("sessionForm", "command", new Session());
	}
	
	@RequestMapping(value = "/addSession", method = RequestMethod.POST)
	public String addSession(@ModelAttribute("SpringWeb")Session session, ModelMap model){
		model.addAttribute("name", session.getName());
		model.addAttribute("type", session.getType());
		model.addAttribute("date", session.getDate());
		model.addAttribute("duration", session.getDuration());
		model.addAttribute("repeatFrequency", session.getRepeatFrequency());
		model.addAttribute("lecturer", session.getLecturer());
		model.addAttribute("maxAttendance", session.getMaxAttendance());
		model.addAttribute("compulsory", session.isCompulsory());
		model.addAttribute("venue", session.getVenue());
		return "sessionDetail";
	}
	

	@RequestMapping(value = "/viewMonday", method = RequestMethod.GET)
	public ModelAndView mondayTimetable(ModelMap model){
		return new ModelAndView( "monday");
	}



	
	@RequestMapping(value = "/viewTuesday", method = RequestMethod.GET)
	public ModelAndView tuesdayTimetable(ModelMap model){
		return new ModelAndView( "tuesday");
		
	}
	
	@RequestMapping(value = "/viewWednesday", method = RequestMethod.GET)
	public ModelAndView wednesdayTimetable(ModelMap model){
		return new ModelAndView( "wednesday");
		
	}
	
	@RequestMapping(value = "/viewThursday", method = RequestMethod.GET)
	public ModelAndView thursdayTimetable(ModelMap model){
		return new ModelAndView( "thursday");
		
	}
	
	@RequestMapping(value = "/viewFriday", method = RequestMethod.GET)
	public ModelAndView fridayTimetable(ModelMap model){
		return new ModelAndView( "friday");
		
	}
	
	
	@RequestMapping(value = "/viewWeek", method = RequestMethod.GET)
	public ModelAndView weekTimetable(ModelMap model){
		return new ModelAndView( "week");
		
	}
	
	
	
	

}
