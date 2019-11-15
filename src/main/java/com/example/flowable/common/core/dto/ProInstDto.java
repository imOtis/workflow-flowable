package com.example.flowable.common.core.dto;

import org.flowable.engine.runtime.ProcessInstance;

import java.util.Date;
import java.util.Map;

/**
 * @author: AAS
 * @create: 周四 11月 2019
 * @description: 流程实例 DTO
 */
public class ProInstDto {
    private String processDefinitionId;
    private String processDefinitionName;
    private String processDefinitionKey;
    private Integer processDefinitionVersion;
    private String deploymentId;
    private String businessKey;
    private boolean isSuspended;
    private Map<String, Object> processVariables;
    private String tenantId;
    private String name;
    private String description;
    private String localizedName;
    private String localizedDescription;
    private Date startTime;
    private String startUserId;

    public ProInstDto() {
    }

    public ProInstDto(ProcessInstance processInstance) {
        this();
        getDto(processInstance);
    }

    public void getDto(ProcessInstance processInstance) {
        this.processDefinitionId = processInstance.getProcessDefinitionId();
        this.processDefinitionName = processInstance.getProcessDefinitionName();
        this.processDefinitionKey = processInstance.getProcessDefinitionKey();
        this.processDefinitionVersion = processInstance.getProcessDefinitionVersion();
        this.deploymentId = processInstance.getDeploymentId();
        this.businessKey = processInstance.getBusinessKey();
        this.isSuspended = processInstance.isSuspended();
        this.processVariables = processInstance.getProcessVariables();
        this.tenantId = processInstance.getTenantId();
        this.name = processInstance.getName();
        this.description = processInstance.getDescription();
        this.localizedName = processInstance.getLocalizedName();
        this.localizedDescription = processInstance.getLocalizedDescription();
        this.startTime = processInstance.getStartTime();
        this.startUserId = processInstance.getStartUserId();
    }

}