package com.wildcodeschool.myProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@SpringBootApplication
public class MyProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyProjectApplication.class, args);
    }


 /*     
    @RequestMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }    
   
    
    
    
    @RequestMapping("/hello/{name}{title}")
    @ResponseBody
    public String hello(@PathVariable String name, @RequestParam String title) {
        return "Hello " + name + ", " + title;
    }
    
    

    
    @RequestMapping("/hello/{name}{title}")
    @ResponseBody
        
    public String hello(@PathVariable String name, @RequestParam(defaultValue="") String title) {
        if (title.length() > 0) {
            return "Hello " + name + ", " + title;
        }
        else {
            return "Hello " + name;
        }
    }
    
*/     
    
    
    @RequestMapping("/doctor/{number}")
    @ResponseBody
        
    public String hello(@PathVariable int number) {

        if ( (number >= 9) && (number <= 14) ) {
        	
        	String[] names = {"Christopher Eccleston", "David Tennant", "Matt Smith", "Peter Capaldi", "Jodie Whittaker"};
        	int nbre    = number - 9;
        	String name = names[nbre];
        	
            
        	return "\"number\"" +": " + number +", "  +"\"name\"" +": " + name;         
        }
        else {
                if ( (number >= 1) && (number <= 8) ) {
                	throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Check For Other Numbers");
                }
                else {
                    
                    throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation "+ number);
                }  
        }
    }
   
    
    
    
}
