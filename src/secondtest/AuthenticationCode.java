package secondtest;

import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class AuthenticationCode extends Thread { // �����ڵ� �߱� Ŭ����

	StaticCode random = new StaticCode();

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		random.timeCode = (int) (Math.random() * 8999 + 1000);		// ����ƽ ������ �����ڵ� ����
		try {
			sleep(1000);	
			random.timeCode = (int) (Math.random() * 8999 + 1000);	// 30���� ���ο� �����ڵ�� ����
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

class CodePopUp extends JFrame{	// �����ڵ� �˾�â ���� Ŭ����

	StaticCode code = new StaticCode();
	JLabel jl1 = new JLabel();
	JLabel jl2 = new JLabel();
	int time = code.second30time;	// �����ʽð� �˷��ִ� ����

	CodePopUp() {	// �����ڵ� �˾�â

		setTitle("AuthenticationCode");
		Container mcontainer = getContentPane();
		mcontainer.setLayout(new GridLayout(2, 1, 5, 5));
		jl1.setFont(new Font("����", Font.BOLD, 13));
		mcontainer.add(jl1);

		jl2.setFont(new Font("����", Font.BOLD, 45));
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
						jl1.setText(String.valueOf("                       �Է����ѽð� :" + code.second30time));
						jl2.setText(String.valueOf("   " + code.timeCode));
						time--;						// ����ƽ ������ �״�� ����� �� �ߺ����� �˾�â�� ���� �ð��ʰ��Ұ� ��� �þ
//						code.second30time--;
						code.second30time = time;  	// ***�˾�â�� �ߺ����� �� ǥ�õǴ� �ð��� 1�ʾ��� ���ҵ� �� �ֵ���***

					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				if(code.second30time <=0) {	// �����ð��ʰ� ������ �˾�â ����
					setVisible(false);
					code.second30time = 30;	// �Է½ð� 30�ʷ� �ʱ�ȭ
				}

			}

		}
		AuthenticationCode kk = new AuthenticationCode();
		Timethread tt = new Timethread();
		tt.start();

//		setDefaultCloseOperation(EXIT_ON_CLOSE);	// ���� �����ڵ� �˾�â ���ԵǸ� ���α׷� �����
	}

}