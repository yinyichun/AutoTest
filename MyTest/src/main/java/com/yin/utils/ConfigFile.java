package com.yin.utils;

import com.yin.model.OperationName;
import java.util.ResourceBundle;
import java.util.Locale;

public class ConfigFile {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application",Locale.CANADA);
    public static String getUrl(OperationName name){
        String address = bundle.getString("test.url");
        String uri="";
        String TestUrl;
        if(name==OperationName.LOGIN){
            uri = bundle.getString("login.uri");
        }

        if(name==OperationName.ADDUSER){
            uri = bundle.getString("addUser.uri");
        }

        if(name==OperationName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }

        if(name==OperationName.GETUSERLIST){
            uri = bundle.getString("getUsrList.uri");
        }

        if(name==OperationName.UPDATEUSERINFO){
            uri = bundle.getString("updateUserInfo.uri");
        }

        TestUrl = address + uri;
        return TestUrl;
    }
}
