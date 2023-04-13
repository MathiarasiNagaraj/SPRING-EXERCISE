package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.exception.InsufficientBalanceException;

@Service("userservice")
@Transactional
public class UserService implements UserServiceInterface {
	@Autowired
	UserDAO dao;

	@Override
	public void createUser(User user) {
		dao.save(user);

	}
	
	@Override
	public int findUser(int id)
	{
		User user = dao.findById(id).orElse(null);
		if(user==null)
			return 1;
		else
			return 0;
	
	}


	@Override
	public int checkBalance(int id) {
		User user = dao.findById(id).orElse(null);
		int currentBalance = user.getAmount();
		return currentBalance;
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
	@Transactional(propagation = Propagation.REQUIRED)
	void doCredit(int crid,int amount)
	{
		System.out.println(crid);
		User dto=dao.findById(crid).orElse(null);
		System.out.println(dto);
		dto.setAmount(amount+dto.getAmount());
	    dao.save(dto);
		
	}
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public int doMoneyTransfer(int creditID, int debitID, int amount) {
       
         try {
			doDebit(debitID, amount);
		} catch (InsufficientBalanceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
        
			doCredit(creditID, amount);
			return 1;
		
	}

}
