package demo_oop_02.service;

public abstract class FacebookService2 {
    public abstract void run();
    public void stop() {
        System.out.println("Exit!");
    }
}
