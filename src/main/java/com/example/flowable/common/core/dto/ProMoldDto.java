package com.example.flowable.common.core.dto;

import org.flowable.engine.repository.Model;

import java.util.Date;

/**
 * @author: AAS
 * @create: 周四 11月 2019
 * @description: 流程模型 DTO
 */
public class ProMoldDto {

    private String id;
    private String name;
    private String key;
    private String category;
    private Date createTime;
    private Date lastUpdateTime;
    private Integer version;
    private String metaInfo;
    private String deploymentId;
    private String tenantId;
    private boolean hasEditorSource;


    public ProMoldDto() {
    }

    public ProMoldDto(Model m) {
        this();
        getDto(m);
    }

    public void getDto(Model m) {
        this.id = m.getId();
        this.name = m.getName();
        this.key = m.getKey();
        this.category = m.getCategory();
        this.createTime = m.getCreateTime();
        this.lastUpdateTime = m.getLastUpdateTime();
        this.version = m.getVersion();
        this.metaInfo = m.getMetaInfo();
        this.deploymentId = m.getDeploymentId();
        this.tenantId = m.getTenantId();
        this.hasEditorSource = m.hasEditorSource();
    }
}
