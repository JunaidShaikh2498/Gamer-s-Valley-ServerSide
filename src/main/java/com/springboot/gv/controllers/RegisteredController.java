package com.springboot.gv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.gv.entities.*;
import com.springboot.gv.entities.InsertUser;
import com.springboot.gv.services.CustomerService;
import com.springboot.gv.services.ExpertService;
import com.springboot.gv.services.RegisteredService;


@RestController
@RequestMapping("/registered")
@CrossOrigin("http://localhost:3000")
public class RegisteredController {

	
	@Autowired
    private RegisteredService rs;

    @Autowired
    private CustomerService cs;
    
    @Autowired
    private ExpertService es;
    
    @Autowired
    JavaMailSender sender;

    @PostMapping("/save")
    public boolean saveRegistration(@RequestBody InsertUser iu) {
    	boolean flag = false;
    	RegisteredUser rr = new RegisteredUser(iu.getRoleId(),iu.getUsername(),iu.getPassword(),iu.getApproved());
    	RegisteredUser r= rs.saveRegistered(rr);
        
        Customer c = new Customer(iu.getFirstname(),iu.getLastname(),iu.getEmail(),iu.getContact(),iu.getAddress(),r);
        cs.saveCustomer(c);
        SimpleMailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setFrom("hrishi3bhogade@gmail.com");
        mailMsg.setTo(c.getEmail());
        mailMsg.setSubject("Wait for Admin's Approval");
        mailMsg.setText("Congratulations "+c.getFirstname()+". You have registered successfully. You can now login and enjoy the services of Gamers Valley. Gamers Valley will enhace your gaming experience with optimistic suggestions and feedbacks from our authorised experts. Thank you!!!");
        sender.send(mailMsg);

        if(rr!=null && c!=null) {
        	flag = true;
        }
        return flag;
    }
    @PostMapping("/saveExp")
    public boolean saveExpReg(@RequestBody InsertExpert ie) {
    	boolean flag = true;
    	try {
	    	RegisteredUser rr = new RegisteredUser(ie.getRoleId(),ie.getUsername(),ie.getPassword(),ie.getApproved());
	    	RegisteredUser r= rs.saveRegistered(rr);
	        
	        Expert e = new Expert(ie.getFirstname(),ie.getLastname(),ie.getEmail(),ie.getQualification(),r);
	        es.saveExpert(e);
	        SimpleMailMessage mailMsg = new SimpleMailMessage();
	        mailMsg.setFrom("hrishi3bhogade@gmail.com");
	        mailMsg.setTo(e.getEmail());
	        mailMsg.setSubject("Wait for Admin's Approval");
	        mailMsg.setText("Congratulations "+e.getFirstName()+". You have registered successfully as an Expert. Please wait for Admin's approval. You can login after Admin's approval. Thank you!!!");
	        sender.send(mailMsg);
    	}catch(Exception e) {
    		flag = false;
    	}
        
        return flag;
    }
}
