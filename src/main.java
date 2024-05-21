import Screen.Information;
import Screen.MachineInfo;
import Screen.MainFrame;
import Screen.UserInfo;
import in.MachineMoney;
import in.User;

public class main {

    public static void main(String[] args) {
        // User 객체 생성
        User user = new User(10, 10, 10, 10, 10);// 각 화폐 단위별로 얼마나 가
        // MainFrame 객체 생성
        MachineMoney machineMoney = new MachineMoney();
        UserInfo userInfo = new UserInfo(user);
        MachineInfo machineInfo = new MachineInfo(machineMoney);
        Information information = new Information(user, userInfo, machineMoney, machineInfo);
        MainFrame mainFrame = new MainFrame(user, userInfo,machineMoney, machineInfo, information);


    }
}