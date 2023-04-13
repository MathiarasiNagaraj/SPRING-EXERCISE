package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "api")

public class SassController {
	@Autowired
	UserServiceInterface user;


	@GetMapping
	public ModelAndView home(ModelAndView md) {
		
		md.setViewName("home");
		return md;
	}
	@GetMapping("/createuser")
	public ModelAndView createUser(ModelAndView md)
	{
		User user=new User();
		md.addObject("User",user);
		md.setViewName("usercreateForm");
		return md;
	}
	@PostMapping("/createuser")
	public ModelAndView setUser(ModelAndView md,User userObject) {
	    int id=userObject.getId();
	    if(user.findUser(id)==1)
	    {
		user.createUser(userObject);
	    
		md.setViewName("success");
		md.addObject("UserID",userObject.getId());
		return md;
	    }
	    
	    md.setViewName("userexist");
	    return md;
	}
    
	
	@GetMapping("/checkbalance")
	public ModelAndView checkBalance(ModelAndView md)
	{
		User user=new User();
		md.addObject("User",user);
		md.setViewName("balanceForm");
		return md;
	}
	@PostMapping("/checkbalance")
	public ModelAndView checkBalance(ModelAndView md,User userObject) {
		int balance=user.checkBalance(userObject.getId());
		System.out.println(userObject);
		md.addObject("UserID",userObject.getId());
		md.addObject("Amount",balance);
		md.setViewName("balance");
		return md;
	}
	@GetMapping("/domoneytransfer")
	public ModelAndView doMoneyTransfer(ModelAndView md)
	{
		Transaction trans=new Transaction();
		md.addObject("Transaction",trans);
		md.setViewName("moneytransfer");
		return md;
	}
	@PostMapping("/domoneytransfer")
	public ModelAndView doMoneyTransfer(ModelAndView md,Transaction tr)
	{
		int crediterPrevBalance=user.checkBalance(tr.getCreditId());
		int debiterPrevBalance=user.checkBalance(tr.getDebitId());
		
		int result=user.doMoneyTransfer(tr.getCreditId(), tr.getDebitId(), tr.getAmount());
		if(result==1)
		{
		int crediterBalance=user.checkBalance(tr.getCreditId());
		int debiterBalance=user.checkBalance(tr.getDebitId());
		md.addObject("CreditId",tr.getCreditId());
		md.addObject("debitId",tr.getDebitId());
		md.addObject("CrediterpreviousCurrentBalance",crediterPrevBalance);
		md.addObject("Debitorpreviouscurrentbalance",debiterPrevBalance);
		md.addObject("CrediterCurrentBalance",crediterBalance);
		md.addObject("Debitorcurrentbalance",debiterBalance);
		
		md.setViewName("moneytransferResult");
		return md;
		}
		md.setViewName("moneytransferFailure");
		return md;
		
	}


}
