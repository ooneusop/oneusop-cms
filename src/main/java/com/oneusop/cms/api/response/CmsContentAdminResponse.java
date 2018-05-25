package com.oneusop.cms.api.response;

public class CmsContentAdminResponse extends BaseResponse{
    private String webUrl;

    public CmsContentAdminResponse( String webUrl) {
        super("000000", "OK");
        this.webUrl = webUrl;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }
}
