package com.zhuwj.workflow.service.impl;

import com.zhuwj.workflow.model.Leave;
import com.zhuwj.workflow.service.IWorkFlowService;
import lombok.RequiredArgsConstructor;
import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: TODO
 * ProcessEngineConfiguration:流程引擎配置。
 * ProcessEngine:流程引擎
 * 核心七大接口
 * RepositoryService：提供一系列管理流程部署和流程定义的API。
 * RuntimeService：在流程运行时对流程实例进行管理与控制。
 * TaskService：对流程任务进行管理，例如任务提醒、任务完成和创建任务等。
 * IdentityService：提供对流程角色数据进行管理的API，这些角色数据包括用户组、用户及它们之间的关系。
 * ManagementService：提供对流程引擎进行管理和维护的服务，提供对activiti数据库的直接访问【一般不用】
 * HistoryService：对流程的历史数据进行操作，包括查询、删除这些历史数据。FormService：表单服务
 * 资源库流程规则表
 * <p>
 * 1) act_re_deployment 部署信息表
 * <p>
 * 2) act_re_model  流程设计模型部署表
 * <p>
 * 3) act_re_procdef  流程定义数据表
 * <p>
 * 运行时数据库表
 * <p>
 * 1) act_ru_execution运行时流程执行实例表
 * <p>
 * 2) act_ru_identitylink运行时流程人员表，主要存储任务节点与参与者的相关信息
 * <p>
 * 3) act_ru_task运行时任务节点表
 * <p>
 * 4) act_ru_variable运行时流程变量数据表
 * <p>
 * 历史数据库表
 * <p>
 * 1) act_hi_actinst 历史节点表
 * <p>
 * 2) act_hi_attachment历史附件表
 * <p>
 * 3) act_hi_comment历史意见表
 * <p>
 * 4) act_hi_identitylink历史流程人员表
 * <p>
 * 5) act_hi_detail历史详情表，提供历史变量的查询
 * <p>
 * 6) act_hi_procinst历史流程实例表
 * <p>
 * 7) act_hi_taskinst历史任务实例表
 * <p>
 * 8) act_hi_varinst历史变量表
 * <p>
 * 组织机构表
 * <p>
 * 1) act_id_group用户组信息表
 * <p>
 * 2) act_id_info用户扩展信息表
 * <p>
 * 3) act_id_membership用户与用户组对应信息表
 * <p>
 * 4) act_id_user用户信息表
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-21
 */

@RequiredArgsConstructor
@Service
public class WorkFlowServiceImpl implements IWorkFlowService {

    private final RuntimeService runtimeService;

    private final TaskService taskService;

    private final ProcessEngine processEngine;

    private String key = "leave";

    @Override
    public ProcessInstance statrProcess() {
        Map<String, Object> map = new HashMap<>();
        Leave leave = new Leave();
        leave.setUserId("1");
        map.put("leave", leave);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, map);
        return processInstance;

    }

    @Override
    public Task createTask(ProcessInstance processInstance) {
        Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId()).singleResult();
        return task;
    }

    @Override
    public void apply(Leave leave) {
        Map<String, Object> vars = new HashMap<>();
        Leave origin = (Leave) taskService.getVariable(leave.getTaskId(), "leave");
        origin.setDesc(leave.getDesc());
        origin.setStartDate(leave.getStartDate());
        origin.setEndDate(leave.getEndDate());
        origin.setTotalDay(leave.getTotalDay());
        origin.setApprover1(leave.getApprover1());
        origin.setApprover2(leave.getApprover2());
        origin.setSubmit(leave.getSubmit());
        vars.put("leave", origin);
        taskService.complete(leave.getTaskId(), vars);


    }

    @Override
    public void approve1(Leave leave) {
        Map<String, Object> vars = new HashMap<>();
        Task task = taskService.createTaskQuery().processInstanceId(leave.getProcessInstance().getId()).singleResult();
        Leave origin = (Leave) taskService.getVariable(task.getId(), "leave");
        origin.setApproveDesc1(leave.getApproveDesc1());
        origin.setAgree1(leave.getAgree1());
        vars.put("leave", origin);
        taskService.complete(task.getId(), vars);
    }

    @Override
    public void approve2(Leave leave) {
        Map<String, Object> vars = new HashMap<>();
        Task task = taskService.createTaskQuery().processInstanceId(leave.getProcessInstance().getId()).singleResult();
        Leave origin = (Leave) taskService.getVariable(task.getId(), "leave");
        origin.setApproveDesc2(leave.getApproveDesc2());
        origin.setAgree2(leave.getAgree2());
        vars.put("leave", origin);
        taskService.complete(task.getId(), vars);
    }

    @Override
    public List<HistoricProcessInstance> findHistoricData(String userId) {
        HistoryService historyService = processEngine.getHistoryService();

        List<HistoricProcessInstance> list = historyService.createHistoricProcessInstanceQuery().processDefinitionKey("leave").variableValueEquals("leave.userId", userId).list();
        List<Leave> leaves = new ArrayList<>();
        for (HistoricProcessInstance pi : list) {
            leaves.add((Leave) pi.getProcessVariables().get("leave"));
        }
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("datas", leaves);
        return list;
    }
}
