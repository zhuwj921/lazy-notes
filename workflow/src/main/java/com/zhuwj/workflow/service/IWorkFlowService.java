package com.zhuwj.workflow.service;

import com.zhuwj.workflow.model.Leave;
import org.activiti.engine.history.HistoricProcessInstance;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * Description: TODO
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-21
 */

public interface IWorkFlowService {

    ProcessInstance statrProcess();

    Task createTask(ProcessInstance processInstance);

    void apply(Leave leave);

    void approve1(Leave leave);

    void approve2(Leave leave);

    List<HistoricProcessInstance> findHistoricData(String userId);
}
