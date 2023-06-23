import demo_oop_02.Facebook;
import demo_oop_02.service.FacebookService;
import demo_oop_02.service.FacebookUSA;
import demo_oop_02.service.FacebookVN;
import demo_oop_03.AccountModel;
import demo_oop_03.UserModel;


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
        AccountModel accountHiep = new AccountModel();
        accountHiep.setUsername("Do Tuan Hiep");
        accountHiep.setPassword("125641");

        UserModel hiep = new UserModel();
        hiep.setName("Tuan Hiep");
        hiep.setAccountModel(accountHiep);
        System.out.println(hiep);
    }
}
