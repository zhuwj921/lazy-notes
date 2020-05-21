package com.zhuwj.workflow.model;

import lombok.Data;
import org.activiti.engine.runtime.ProcessInstance;

import java.io.Serializable;
import java.util.Date;

/**
 * Description: TODO
 *
 * @author zhuwj
 * @version V1.0
 * @date 2020-05-21
 */
@Data
public class Leave implements Serializable {

    private String userId;

    private Boolean submit;

    private Date startDate;

    private Date endDate;

    private float totalDay;

    private String desc;

    private String taskId;

    private String taskName;

    private String approver1;

    private Boolean agree1;

    private String approveDesc1;

    private String approver2;

    private Boolean agree2;

    private String approveDesc2;

    private ProcessInstance processInstance;

}
