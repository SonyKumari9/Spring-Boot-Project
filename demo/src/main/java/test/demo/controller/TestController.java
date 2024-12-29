package test.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import test.demo.entity.Employee;
import test.demo.service.EmpService;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class TestController {
	
	@Autowired
	private EmpService service;
	
	@GetMapping("/")
	public String home(Model m)
	{
		List<Employee> emp =service.getAllEmp();
		m.addAttribute("emp", emp);
		
		return "index";
	}
	
	@GetMapping("/addemp")
	public String addEmpForm()
	{
		return "add_emp";
	}
	
	@PostMapping("/register")
	public String empRegister(@ModelAttribute Employee e,HttpSession session)
	{
		System.out.println(e);
		
		service.addEmp(e);
		
		session.setAttribute("msg", "Employee added Successfully...");
		return "redirect:/";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable int id,Model m)
	{
		Employee e=service.getEmpById(id);
		m.addAttribute("emp",e);
		
		return "edit";
	}
	
	@PostMapping("/update")
	public String updateEmp(@ModelAttribute Employee e,HttpSession session)
	{
		service.addEmp(e);
		session.setAttribute("msg","Emp Data Updated Successfully..");
		return "redirect:/";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEMp(@PathVariable int id,HttpSession session)
	{
		service.deleteEMp(id);
		session.setAttribute("msg","Emp Data Delete Successfully..");
		return "redirect:/";
	}
	
	
	//@GetMapping("/home")
	//public String Test() {
		//return "Just for testing !!";
	//}
	
	//@GetMapping("/test")
	//public String Test1() {
		//return "Welcone sony";
	//}
	
	//@RequestMapping("/handle")
	//@ResponseBody
	//public String handle() {
		//return "first handler";
	//}

	
	//@RequestMapping("/")
	//public String home() {
		//System.out.println("This is home Page");
		//return "home";
	//}
	
	
	

}
