package net.javaci.javacibank.backoffice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import net.javaci.javacibank.db.dao.EmployeeDao;
import net.javaci.javacibank.db.model.Employee;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeDao employeeDao;

	@GetMapping("/add")
	public String renderAddPage(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee/add";
	}

	@PostMapping("/add")
	public String addEmployee(@ModelAttribute Employee employee) {
		employeeDao.add(employee);
		return "redirect:/employee/list";
	}

	@GetMapping("/list")
	public String renderListPage(Model model) {
		model.addAttribute("employees",employeeDao.findAll());
		return "employee/list";
	}
}
