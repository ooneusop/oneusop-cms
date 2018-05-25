package com.oneusop.cms.controller;

import com.alibaba.fastjson.JSONObject;
import com.oneusop.cms.api.response.CmsContentAdminResponse;
import com.oneusop.cms.config.CmsPropertiesConfig;
import com.oneusop.cms.util.ThymeleafUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.FileWriter;

@RestController
public class CmsContentAdminController {
    @Autowired
    private CmsPropertiesConfig cmsConfig;
    private static final String CONTENT = "/content";

    @RequestMapping(value = "/api/cms/content/save", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CmsContentAdminResponse save(@RequestBody JSONObject param) throws Exception {
        String title = param.getString("title");
        String description = param.getString("description");
        String templateName = param.getString("template");
        String filePath = this.getWebContentFilePath(cmsConfig.getFilePath(), templateName);

        Context context = new Context();
        context.setVariable("title", title);
        context.setVariable("description", description);
        FileWriter writer = new FileWriter(filePath);
        TemplateEngine templateEngine = ThymeleafUtil.getTemplateEngine();

        String html = templateEngine.process(templateName, context);
        templateEngine.process(templateName, context, writer);
        return new CmsContentAdminResponse(filePath);
    }

    private String getWebContentFilePath(String filePath, String path) {
        return filePath + CONTENT + "/"+path+"1.html";
    }
}
