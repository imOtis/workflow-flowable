package com.example.flowable.api;

import com.example.flowable.common.core.dto.ProDefiDto;
import com.example.flowable.utils.ObjectUtils;
import com.example.flowable.common.core.dto.*;
import io.swagger.annotations.ApiImplicitParam;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.engine.repository.Deployment;
import org.flowable.engine.repository.ProcessDefinition;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: AAS
 * @create: 周四 11月 2019
 * @description:
 */
@Slf4j
@RestController
@RequestMapping("/handleApi")
public class ProcessHandleApi {

    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;
    @Autowired
    private RepositoryService repositoryService;


    @ResponseBody
    @ApiOperation(value = "部署流程,")
    @RequestMapping(value = "/deployProcess", method = RequestMethod.POST)
    @ApiImplicitParam(name = "classPath", value = "流程图资源路径", required = true, dataType = "String")
    public Map<String, Object> deployProcess(HttpServletRequest request,
                                             @PathVariable("classPath") String classPath) {
        Map<String, Object> map = new HashMap<>();
        if (StringUtils.isNotBlank(classPath)) {
            Deployment deploy = repositoryService.createDeployment().addClasspathResource(classPath).deploy();
            map.put("processId", deploy.getId());
            map.put("processName", deploy.getName());
            map.put("deployTime", deploy.getDeploymentTime());
            map.put("processVersion", deploy.getEngineVersion());
        }
        return map;
    }

    @ResponseBody
    @ApiOperation(value = "已部署流程列表,")
    @RequestMapping(value = "/processesList", method = RequestMethod.GET)
    public List<ProDefiDto> processesList() {
        List<ProDefiDto> result = new ArrayList<>();
        List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                .list();
        if (list.size() != 0) {
//                try {
//                    List<ProDefiDto> result = ObjectUtils.convert2Dto(new ProDefiDto(), list);
//                    return result;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
            list.forEach(value -> result.add(new ProDefiDto(value)));
            return result;
        }
        return null;
    }

    @ResponseBody
    @ApiOperation(value = "流程查询(带模糊查询),")
    @RequestMapping(value = "/process/{processName}", method = RequestMethod.GET)
    @ApiImplicitParam(name = "processName", value = "流程名称", required = true, dataType = "String")
    public List<ProDefiDto> processesDetail(@PathVariable("processName") String processName) {
        if (StringUtils.isNotBlank(processName)) {
            List<ProcessDefinition> list = repositoryService.createProcessDefinitionQuery()
                    .processDefinitionNameLike(processName).list();
            if (list.size() != 0) {
                try {
                    List<ProDefiDto> result = ObjectUtils.convert2DtoConstruc(ProDefiDto.class, list);
                    return result;
                } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
