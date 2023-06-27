package demo_oop_02.service;

import demo_oop_02.Facebook;

import java.util.Locale;
interface iFacebookService {
    String getAppNameV2(Facebook facebook);
    String getAppVersionV2();
    String getAppInfoV2();
}


public class FacebookService implements iFacebookService{

    @Override
    public String getAppNameV2(Facebook facebook) {
        return ("Https://" + facebook.getAppName()).toLowerCase();
    }

    @Override
    public String getAppVersionV2() {
        return "1.3.3";
    }

    @Override
    public String getAppInfoV2() {
        return null;
    }
}
