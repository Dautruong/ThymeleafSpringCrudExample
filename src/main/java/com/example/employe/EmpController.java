package com.example.employe;


import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class EmpController {
	
	private EmpService empService = new EmpServiceImpl();
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(Model model) {
        List emplList = empService.findAll();
        model.addAttribute("employees", emplList);
        return "index";
    }

	@RequestMapping(value = "/new" )
	public String show(Model model, @ModelAttribute("employee") Employee employee) {
		return "newEmployee";
	}
	@RequestMapping(value =  "/edit",  method = RequestMethod.POST )
	public String editEmp(Model model, @ModelAttribute("employee") Employee employee) {
		employee.setId((int)(Math.random() * 100));
		model.addAttribute("employee", new Employee());
		empService.save(employee);
		return "redirect:/index";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Model model, @ModelAttribute("employee") Employee employee) {
		empService.save(employee);
	    return "redirect:/index";
	}
	
	@RequestMapping("/edit/{id}")
	public String Edit(@PathVariable("id") int id, @ModelAttribute("employee") Employee employee, Model model) {
		employee = empService.findById(id);
		model.addAttribute("employee",employee);
		empService.update(id, employee);
		return "editEmployee";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {
		empService.remove(id);
	    return "redirect:/index";       
	}
}


