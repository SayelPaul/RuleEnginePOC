package com.test.ruleengines.api;

import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;

public class RuleBookfile  {
    public RuleBook<Object> defineHelloWorldRules() {
        return RuleBookBuilder
          .create()
            .addRule(rule -> rule.withFactType(String.class).when(f -> f.containsKey("card"))
              .then(f -> System.out.println("DISCOUNT")))
            .build();
    }

    }

	
