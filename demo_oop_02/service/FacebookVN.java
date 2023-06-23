package demo_oop_02.service;

public class FacebookVN extends FacebookService2{

    @Override
    public void run() {
        System.out.println("Facebook running VN...");
    }
    public void stop() {
        System.out.println("Exit2!");
    }
}
