package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloController{
	
	@GetMapping("hello")
	public String hello(Model model) {
		model.addAttribute("data","hello!!");
		return "hello"; //templates에 있는 hello.html에 가라~
		//templates/hello.html
	}
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) { //required의 디퐅트는 true => 그래서 값을 넘겨야 함. //http://127.0.0.1:8080/hello-mvc?name=spring!!!!!
		model.addAttribute("name", name);
		return "hello-template"; 
	}
	
	@GetMapping("hello-string")
	@ResponseBody //html 바디에 내가 직접 넣어주겠다.
	//view 이런게 없고 이거는 직접 바론 내려감. => html 소스코드 없이 바로 직접 body에 접근해서 넣어줌. => 웹 브라우저 소스 코드를 보면 html태그가 하나도 없음.
	public String helloString(@RequestParam("name") String name) {
		return "hello " + name; //"hello spring"
	}
	
	@GetMapping("hello-api")
	@ResponseBody
	public Hello helloApi(@RequestParam("name") String name) {
		Hello hello = new Hello(); //객체가 오면 기본 디폴트가 json방식으로 데이터를 만들어서 http응답에 반환하겠다가 기본.
		hello.setName(name);
		return hello;
	}
	
	static class Hello{
		private String name;

		//property 접근 방식 => getter, setter
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
}