package secondtest;

import java.io.IOException;

import javax.swing.JFrame;

import secondtest.*;

public class secondtestMain extends JFrame{

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ProductInputStream pIS = new ProductInputStream();

		try {
			pIS.mediaRead();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		StaticCode st = new StaticCode();

		Singleton stst = Singleton.getInstance();

		Scan scan = new Scan();

		SignUp ttt = new SignUp();

		LoginManagement lll = new LoginManagement();

		while (true) {
			System.out.println("1. 로그인\t\t\t2.회원가입\t\t\t3.ID/PW찾기\t\t\t4.사이트종료");
			int inputnum1 = scan.scanInt();

			if (inputnum1 == 1) {

				int grade = lll.Login();

				while (true) {
					int inputnum2 = 0;
					AutoRecommend arar = new AutoRecommend();
					
					inputnum2 = scan.scanInt();
					if (inputnum2 == 1) {
						arar.setVisible(false);
						break;
					}
				}
				
				continue;
				
			} else if (inputnum1 == 2) {
				ttt.sign();
				ttt.firstRecommend();
				continue;
			} else if (inputnum1 == 3) {
				lll.searchIDPW();
				continue;
			} else if (inputnum1 == 4) {
				System.out.println("사이트가 종료됩니다.");
				new AutoRecommend(9);
				break;
			}
		}
	}

}
