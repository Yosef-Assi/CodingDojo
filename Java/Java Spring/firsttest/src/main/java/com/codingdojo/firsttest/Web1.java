package com.codingdojo.firsttest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Web1 {
//	@RequestMapping("/")
//	public String index(Model model) {
//		model.addAttribute("fruit","banana");
//		return "NewFile.jsp";
//	}
	@RequestMapping("/")
    public String index2(Model model) {
        String name = "Grace Hopper";
        String itemName = "Copper wire";
        double price = 5.25;
        String description = "Metal strips, also an illustration of nanoseconds.";
        String vendor = "Little Things Corner Store";
        
        model.addAttribute("name1", name);
        model.addAttribute("itemName", itemName);
        model.addAttribute("price", price);
        model.addAttribute("description", description);
        model.addAttribute("vendor", vendor);
    
        return "index.jsp";
    }
}
