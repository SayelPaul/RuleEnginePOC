package com.test.ruleengines.api;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

@Rule(name = "EasyRule file", description = "easy rule test")
public class EasyRulefile {
	
	   @Condition
	    public boolean when1(@Fact("card") String val) {
		   String hdfc="HDFC";
		    boolean r=val.equals(hdfc);
		    return r;
	 }
	    
	    @Action(order=1)
	    public void then1() throws Exception{
	    	System.out.println("Discount Added");
	    }

		    
		    @Action(order=2)
		    public void then2() throws Exception{
		    	System.out.println("Discount=10%");
		    }
		    
		  

	    
	    
}
