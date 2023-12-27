package com.pms.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.pms.dao.Pmsdao;
import com.pms.model.Login;
import com.pms.model.Medicine;

@Controller
public class MainController {

	@Autowired
	private Pmsdao pmsdao;
	
	@RequestMapping("/loginpage")
	public String showloginpage() {
		return "loginpage";
	}
  
	//handler for handle login page
	@RequestMapping(path = "/loginpage", method = RequestMethod.POST)
	public String login(@RequestParam("username") String user, @RequestParam("password") String pwd, Model model) {
		Login login = pmsdao.getLogin(user, pwd);

		if (login != null) {
			model.addAttribute("loginuser", login);
			return "Main";
		} else {
			model.addAttribute("error", "Invalid name & password");
			return "redirect:/loginpage";
		}
	}
	
	@RequestMapping("/Main")
	public String showmain() {
		return "Main";
	}
	
	@RequestMapping("/add-medicine")
	public String handlemedicine() {
		return "add_medicine";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	//handler for handle add medicine form
	@RequestMapping(path = "/handle-medicine",method = RequestMethod.POST)
	public RedirectView handleform(@ModelAttribute Medicine medi,HttpServletRequest request) {
		//call the save medicine function for saving medicine detail in database
		this.pmsdao.savemedicine(medi);
		
		//creating redirect view object for redirect the page
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath()+"/Main");
		return redirectView;
	}
	
	   //handler for show all medicine
		@RequestMapping("/show-medicine")
		public String showmedicinelist(Model model) {
		//getting all medicie detail from the database
		  List<Medicine> medicinelist = this.pmsdao.getmedicine();
		  //save into model attribute
		  model.addAttribute("medicine", medicinelist);
			return "all_medicine";
		}
		
		//handler for delete medicine
		@RequestMapping("/delete/{medicineId}")
		public RedirectView deletemedicine(@PathVariable("medicineId") int medicineId,HttpServletRequest request) {
			this.pmsdao.deletemedicine(medicineId);
			//create RedirectView Object
			RedirectView redirectView = new RedirectView();
			redirectView.setUrl(request.getContextPath()+"/show-medicine");
			return redirectView;
		}
		
		//handler for update
		@RequestMapping("/update/{medicineId}")
		public String updatemedicine(@PathVariable("medicineId") int medicineId,Model model) {
		    Medicine medicine = this.pmsdao.getMedicine(medicineId);
			model.addAttribute("m", medicine);
			return "update_medicine";
		}


	
	
	

}
