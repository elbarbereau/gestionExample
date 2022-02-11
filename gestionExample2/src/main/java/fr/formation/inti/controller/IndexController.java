package fr.formation.inti.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.formation.inti.entity.User;

@Controller
public class IndexController {

	private static final Log log = LogFactory.getLog(IndexController.class);

	@RequestMapping(value = {"/","/index"}, method = RequestMethod.GET)
	public String index(Model model,@ModelAttribute("user") User user) {
		log.info("-----------------> /index GET");
		model.addAttribute("message", "Hello Sping MVC");
		return "login";
	}
}
