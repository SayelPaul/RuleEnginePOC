package com.test.ruleengines.api;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.deliveredtechnologies.rulebook.FactMap;

@RestController
public class MegaOfferController {
	@Autowired
	private KieSession session;
	//private Facts facts;
	//private Rules rules;
	//private EasyRulefile ERF;
	//private RulesEngine rulesengine;
	
	@PostMapping("/drools")
	public Order order1(@RequestBody Order order) {
		session.insert(order);
		session.fireAllRules();
		return order;
	}
	
	@PostMapping("/easyrule")
	public Order order2(@RequestBody Order order) {
		Facts facts = new Facts();
		facts.put("card",order.getCardType());
		Rules rules = new Rules();
        rules.register(new EasyRulefile());
        RulesEngine rulesengine=new DefaultRulesEngine();
        rulesengine.fire(rules, facts);
        return order;
	}
	
	@PostMapping("/rulebook")
	public  Order order3(@RequestBody Order order) {
		FactMap<String> facts=new FactMap<>();
		facts.setValue("card", order.getCardType());;
		RuleBookfile ruleBook = new RuleBookfile();
	    ruleBook
	      .defineHelloWorldRules()
	      .run(facts);
	    return order;
	    
	}
	
	
	@PostMapping("/openl")
	public Order order4(@RequestBody Order order) {
//		RuleEngineFactory<Simple > rulesFactory =
//
//                new RuleEngineFactory<Simple>(" TemplateRules.xls",
//
//                                                  Simple.class);
//
//         Simple rules = rulesFactory.newInstance();
//
//         rules.hello1(12);
    return order;
}	
	
	
	
}
