package com.lc.controller;

import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PaymentController {

    @PostConstruct
    public void initFlowRule(){
        List<FlowRule> flowRuleList=new ArrayList<>();
        FlowRule flowRule = new FlowRule("HelloWorld");


        flowRuleList.add(flowRule);
        FlowRuleManager.loadRules(flowRuleList);
    }
}
