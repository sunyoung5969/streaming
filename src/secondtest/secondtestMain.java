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
			System.out.println("1. �α���\t\t\t2.ȸ������\t\t\t3.ID/PWã��\t\t\t4.����Ʈ����");
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
				System.out.println("����Ʈ�� ����˴ϴ�.");
				new AutoRecommend(9);
				break;
			}
		}
	}

}
