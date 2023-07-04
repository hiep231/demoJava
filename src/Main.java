import demo_oop_02.Facebook;
import demo_oop_02.service.FacebookService;
import demo_oop_02.service.FacebookUSA;
import demo_oop_02.service.FacebookVN;
import demo_oop_03.AccountModel;
import demo_oop_03.UserModel;

import javax.management.InstanceNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Student studentHoa = new Student();
//        studentHoa.setStudentCode("2387");
//        studentHoa.setStudentName("le hoa");
//
//        User hoa = new User();
//        hoa.setUsername("Thi Hoa");
//        hoa.setPassword("2255");
//        hoa.setStudent(studentHoa);
//
//
//        System.out.println(hoa.toString());


//        Facebook facebook = new Facebook();
//        facebook.setAppName("Facebook.com");
//        facebook.setAppVersion("1.3.3");
//
//        FacebookService facebookService = new FacebookService();
//        String appName = facebookService.getAppNameV2(facebook);
//        String appVersion = facebookService.getAppVersionV2();
//        System.out.println(appName);
//        System.out.println(appVersion);

//        FacebookVN facebookVN = new FacebookVN();
//        facebookVN.run();
//        facebookVN.stop();
//        FacebookUSA facebookUSA = new FacebookUSA();
//        facebookUSA.run();
//        facebookUSA.stop();


//        AccountModel accountHiep = new AccountModel();
//        accountHiep.setUsername("Do Tuan Hiep");
//        accountHiep.setPassword("125641");
//
//        UserModel hiep = new UserModel();
//        hiep.setName("Tuan Hiep");
//        hiep.setAccountModel(accountHiep);
//        System.out.println(hiep);

        System.out.println("Nhập vào chuỗi thứ nhất:");
        String chuoi1 = scanner.nextLine();
        return chuoi1 = "haha";

//        scanner.close();
    }
    static Scanner scanner = new Scanner(System.in);
    public static Integer checkInteger() {
        while (true) {
            try {
                String input = scanner.nextLine();
                Integer aInteger = Integer.parseInt(input);
                return aInteger;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next();
            }
        }
    }
}
