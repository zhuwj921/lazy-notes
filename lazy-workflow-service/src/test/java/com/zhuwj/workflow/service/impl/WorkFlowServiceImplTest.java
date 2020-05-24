package com.zhuwj.workflow.service.impl;

import com.zhuwj.workflow.WorkflowApplication;
import com.zhuwj.workflow.model.Leave;
import com.zhuwj.workflow.service.IWorkFlowService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WorkflowApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WorkFlowServiceImplTest {

    @Autowired
    private IWorkFlowService workFlowService;


    @Test
    void statrProcess() {
    }

    @Test
    void apply() {
        Leave leave = new Leave();
        leave.setTaskId("1");
        leave.setSubmit(true);
        ProcessInstance processInstance = workFlowService.statrProcess();
        Task task = workFlowService.createTask(processInstance);
        leave.setTaskId(task.getId());
        leave.setProcessInstance(processInstance);
        workFlowService.apply(leave);
        leave.setAgree1(true);
        workFlowService.approve1(leave);
        leave.setAgree2(true);
        workFlowService.approve2(leave);

        List<HistoricProcessInstance> list = workFlowService.findHistoricData("1");
        list.stream().forEach(historicProcessInstance -> System.out.println(historicProcessInstance.toString()));
    }
}