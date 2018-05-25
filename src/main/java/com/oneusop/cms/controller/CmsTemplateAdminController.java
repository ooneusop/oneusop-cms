package com.oneusop.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.oneusop.cms.api.response.BaseResponse;
import com.oneusop.cms.config.CmsPropertiesConfig;
import com.oneusop.cms.service.FileComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.util.Objects;

@RestController
public class CmsTemplateAdminController {
    @Autowired
    private CmsPropertiesConfig cmsConfig;
    @Autowired
    private FileComponent fileComponent;
    private static final String TEMPLATE = "/template";

    @RequestMapping(value = "/api/cms/template/save", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public BaseResponse save(@RequestBody JSONObject param) throws Exception {
        this.check(param);
        String content = param.getString("content");
        String path = param.getString("path");
        String filePath = this.getWebTemplateFilePath(cmsConfig.getFilePath(), path);
        File templateFile = new File(filePath);
        fileComponent.createFile(templateFile, content);
        return new BaseResponse("000000", "OK");
    }

    private String getWebTemplateFilePath(String filePath, String path) {
        return filePath + TEMPLATE + path;
    }

    private void check(JSONObject param) throws Exception {
        if (Objects.isNull(param))
            throw new Exception("请求参数为空");
        if (StringUtils.isEmpty(param.getString("content")))
            throw new Exception("请求参数中content为空");
        if (StringUtils.isEmpty(param.getString("path")))
            throw new Exception("请求参数中path为空");
    }
}
