package secondtest;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AuthenticationCode extends Thread { // 인증코드 발급 클래스

	StaticCode random = new StaticCode();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		random.timeCode = (int) (Math.random() * 8999 + 1000);		// 스태틱 변수에 인증코드 저장
		try {
			sleep(1000);	
			random.timeCode = (int) (Math.random() * 8999 + 1000);	// 30초후 새로운 인증코드로 갱신
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class CodePopUp extends JFrame{	// 인증코드 팝업창 띄우는 클래스

	StaticCode code = new StaticCode();
	JLabel jl1 = new JLabel();
	JLabel jl2 = new JLabel();
	int time = code.second30time;	// 남은초시간 알려주는 변수

	CodePopUp() {	// 인증코드 팝업창

		setTitle("AuthenticationCode");
		Container mcontainer = getContentPane();
		mcontainer.setLayout(new GridLayout(2, 1, 5, 5));
		jl1.setFont(new Font("돋움", Font.BOLD, 13));
		mcontainer.add(jl1);

		jl2.setFont(new Font("돋움", Font.BOLD, 45));
		mcontainer.add(jl2);
		
		setBounds(800, 400, 220, 150);
		
		setSize(220, 150);
		setVisible(true);

		setAlwaysOnTop(true);


		class Timethread extends Thread {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				super.run();
				while (code.second30time >= 0) {
					try {
						int secondtime = code.second30time;
						Thread.sleep(1000);
						jl1.setText(String.valueOf("                       입력제한시간 :" + code.second30time));
						jl2.setText(String.valueOf("   " + code.timeCode));
						time--;						// 스태틱 변수를 그대로 사용할 시 중복으로 팝업창을 띄우면 시간초감소가 배로 늘어남
//						code.second30time--;
						code.second30time = time;  	// ***팝업창을 중복으로 띄어도 표시되는 시간이 1초씩만 감소될 수 있도록***

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(code.second30time <=0) {	// 남은시간초가 끝나면 팝업창 종료
					setVisible(false);
					code.second30time = 30;	// 입력시간 30초로 초기화
				}

			}

		}
		AuthenticationCode kk = new AuthenticationCode();
		Timethread tt = new Timethread();
		tt.start();

//		setDefaultCloseOperation(EXIT_ON_CLOSE);	// 사용시 인증코드 팝업창 끄게되면 프로그램 종료됨
	}

}