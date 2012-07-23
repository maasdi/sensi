package com.sensi.web.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sensi.service.UserService;
import com.sensi.web.controller.BaseController;

/**
 *
 * @author <a href="mailto:maas.dianto@gmail.com">Maas Dianto</a>
 * Jul 21, 2012
 */

@Controller
public class UserListController extends BaseController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/user/list", method=RequestMethod.GET)
	public String showList(Model model, @RequestParam(value="start", defaultValue="0") int start, @RequestParam(value="end", defaultValue="10") int end){
		
		model.addAttribute("users", userService.findUsers(start, end));
		model.addAttribute("no", start);
		model.addAttribute("count", userService.countUsers());
		
		return "user/list";
	}

}
