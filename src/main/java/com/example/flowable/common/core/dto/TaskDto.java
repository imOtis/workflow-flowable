package com.example.flowable.common.core.dto;



import org.flowable.task.api.Task;

import java.util.Date;

/**
 * @author: AAS
 * @create: 周四 11月 2019
 * @description: 任务 DTO
 */
public class TaskDto {
    private String id;
    private String name;
    private Date createTime;
    private String assignee;
    private String processInstanceId;
    private String processDefinitionId;
    private String description;
    private String category;

    public TaskDto() {
    }

    public TaskDto(Task t) {
        this();
        getDto(t);
    }

    public void getDto(Task t) {
        this.id = t.getId();
        this.name = t.getName();
        this.createTime = t.getCreateTime();
        this.assignee = t.getAssignee();
        this.processInstanceId = t.getProcessInstanceId();
        this.processDefinitionId = t.getProcessDefinitionId();
        this.description = t.getDescription();
        this.category = t.getCategory();
    }
}
