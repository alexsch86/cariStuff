package org.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
@RequestMapping("/")
public class CariStuffApplication {

	public static void main(String[] args) {
		SpringApplication.run(CariStuffApplication.class, args);
	}

    @RequestMapping(method = RequestMethod.GET)
    public String stuff(){
        return "stff";
    }
}
