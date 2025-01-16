package com.app.controller.study;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BmiController {

	@RequestMapping("/quiz04/ask-bmi")
    public String askBmi() {
        return "/quiz04/ask-bmi";
    }
	
	@RequestMapping("/quiz04/result-bmi")
	public String resultBmi(@RequestParam String name, @RequestParam double height, @RequestParam double weight, Model model) {
		
		// BMI 계산
        double heightInMeters = height / 100;  // 키가 cm로 들어온 경우 미터로 변환
        double bmi = weight / (heightInMeters * heightInMeters);
        String formattedBmi = String.format("%.4f", bmi);
		
		System.out.println("이름: "+name);
		System.out.println("키: "+height);
		System.out.println("몸무게: "+weight);
		
		model.addAttribute("name", name);
        model.addAttribute("height", height);
        model.addAttribute("weight", weight);
        model.addAttribute("bmi", formattedBmi);
		
		return "/quiz04/result-bmi";
	}
}
