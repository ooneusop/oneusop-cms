package com.oneusop.cms.service;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

@Component
public class FileComponent {
    public static final String DEFAULT_CHARSET_NAME = "UTF-8";
    public static final Charset DEFAULT_CHARSET = Charset.forName(DEFAULT_CHARSET_NAME);

    public boolean createFile(File file, String content) throws IOException {
        if (file != null) {
            FileUtils.writeStringToFile(file, content, DEFAULT_CHARSET);
            return true;
        }
        return false;
    }
}
