package com.example.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exception.InsufficientBalanceException;

@Service("bankservice")
@Transactional
public class BankService {
	@Autowired
     UserDAO dao;
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	void doCredit(int crid,int amount)
	{
		System.out.println(crid);
		User dto=dao.findById(crid).orElse(null);
		System.out.println(dto);
		dto.setAmount(amount+dto.getAmount());
	    dao.save(dto);
		
	}
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = {InsufficientBalanceException.class})
	void doDebit(int drid,int amount) throws InsufficientBalanceException
	{
		System.out.println(drid);
		User dto=dao.findById(drid).orElse(null);
		System.out.println(dto);
		int oldamount=dto.getAmount();
		if(oldamount<amount)
		{
			throw new InsufficientBalanceException("Insufficient balance");
			
		}
		int newamount=oldamount-amount;
		dto.setAmount(newamount);
		dao.save(dto);
	
	}
}
