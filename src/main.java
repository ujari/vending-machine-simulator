// 작성자 : 최윤호
// 기능 : 자판기 자판기 프로그래밍
// 최종 업데이트 : 2024.06.07
// 언어 : JAVA
// 작업 환경 : IntelliJ IDEA
// 작업 운영체제 : Windows 11 Edu
// 프로그램 설명 : 자판기 시뮬레이터
// 작업 기기 : Samsung Galaxy Book Pro 4
import Screen.*;
import internal_data.MachineMoney;
import internal_data.User;

public class main {

    /////////프로그램 시작///////////////
    public static void main(String[] args) {
        // User 객체 생성
        User user = new User();// 각 화폐 단위별로 얼마나 가
        // MainFrame 객체 생성
        MachineMoney machineMoney = new MachineMoney();
        UserInfo userInfo = new UserInfo(user);
        MachineInfo machineInfo = new MachineInfo(machineMoney);
        Information information = new Information(user, userInfo, machineMoney, machineInfo);
        MainFrame mainFrame = new MainFrame(user, userInfo,machineMoney, machineInfo, information);


    }
}