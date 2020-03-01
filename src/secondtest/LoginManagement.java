package secondtest;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class LoginManagement extends JFrame{	// �α��� ���� Ŭ����

	Singleton mSingleton = Singleton.getInstance();
	StaticCode ucount = new StaticCode();
	Scan input = new Scan();

	int Login() {	// �α��� �Լ�
		int state = 0;
		String userID = "";
		String userPW = "";
		boolean existtrue = false;

		while (state != -1) {
			if (state == 0) {
				System.out.println("�α����� ��Ʈ���� ID�� �Է����ּ���\t\t 0.����ȭ������");
				userID = input.scanStr();
				if (!userID.equals("0"))
					state++;
				else if (userID.equals("0"))
					break;
			}
			if (state == 1) {
				int rr = 0;
				System.out.println("��Ʈ���� ID�� ��й�ȣ�� �Է����ּ���\t\t 0.���̵��Է�");
				userPW = input.scanStr();
				for (int i = 0; i < ucount.countuser; i++) {
					if ((userID.equals(mSingleton.userInfo.get(i).getId())
							&& userPW.equals(mSingleton.userInfo.get(i).getPw()))
							) {

						System.out.println("���õ� ��Ʈ���ְ� �Բ� �ð��� �����ּż� �����մϴ�.");
						state = -1;
						existtrue = true;
						ucount.ipid = mSingleton.userInfo.get(i).getIdentity();
						//�������� ��̸���Ʈ�� �����ϱ�����  ȸ�����Խ� ��ϵǴ� ������ȣ�� �α��ν� ����ƽ������ ����
						
						return 1;

					}

				}
				if(userID.equals("admin") && userPW.equals("123456")) {
					System.out.println("���õ� ��Ʈ���ְ� �Բ� �ð��� �����ּż� �����մϴ�.");
					state = -1;
					existtrue = true;
					return 1;
				}
					
				else if (existtrue == false) {
					System.out.println("ID ��й�ȣ�� �����ʽ��ϴ�.");
					state = 0;
				}

			}

		}
		return 0;
	}


	void searchIDPW() { // ID/PWã�� �Լ�
		Singleton mSingleton = Singleton.getInstance();
		boolean existtrue = false;

		StaticCode stc = new StaticCode();
		AuthenticationCode codetime = new AuthenticationCode();
		Scan scan = new Scan();

		System.out.println("1.IDã��\t\t2.PWã��\t\t3.�����ڵ��Է�\t\t4.����ȭ������");// 0 ����ȭ��

		int inputNum = scan.scanInt();
		
		String userID = "";
		String emailID = "";
		String emailPW = "";
		
//----------------------------------IDã��
		if (inputNum == 1) {

			int state = 0;
			int index = -1;
			
			while (state != -1) {
				

				if (state == 0) {
					existtrue = false;

					System.out.println("�̸����� �Է����ּ���. \t\t\t0.����ȭ������"); // 1
					emailID = scan.scanStr();
					
					if(emailID.equals("0"))
						break;
					
					for (int i = 0; i < ucount.countuser; i++) {
						if (emailID.equals(mSingleton.userInfo.get(i).getEmailid())) {
							index = i;
							state++;
							existtrue = true;
							break;
						}
					}
					
					if (existtrue == false) {
						System.out.println("��ϵ��� ���� �̸����Դϴ�");
						state = 0;
					}
				}

				if (state == 1) {

					existtrue = false;
					System.out.println("�̸��� ��й�ȣ�� �Է����ּ���. \t\t\t0.����ȭ������"); // 2
					emailPW = scan.scanStr();
					
					if(emailPW.equals("0"))
						state = 0;
						
					
					for (int i = 0; i < ucount.countuser; i++) {
						if (emailPW.equals(mSingleton.userInfo.get(i).getEmailpw())) {
							state++;
							existtrue = true;
							break;
						}
					}
					if (existtrue == false && !emailPW.equals("0")) {
						System.out.println("��й�ȣ�� ���� �ʽ��ϴ�");
						state = 1;
					}
				}

				if (state == 2) {
					System.out.println("��Ʈ���� ����Ʈ�� ����Ͻ� ���̵�");
					System.out.println();
					System.out.println();
					System.out.println(mSingleton.userInfo.get(index).getId());
					System.out.println();
					System.out.println();
					System.out.println("���� ���̵�� ����ϼ̽��ϴ�.");
					System.out.println();
					System.out.println("Ȯ���ϼ����� �ƹ�Ű�� �����ּ���.");
					String aaa = scan.scanStr();
					break;
				}

			}
//-------------------------------while �ݺ���-------------------------------------------			

		}
//----------------------------PW ã��
		if (inputNum == 2) {
			int index = 0;
			int state = 0;

			while (state != -1) {

				if (state == 0) {
					System.out.println("ID�� �Է����ּ���. \t\t\t0.����ȭ������");
					userID = scan.scanStr();
					for (int i = 0; i < ucount.countuser; i++) {
						if (userID.equals(mSingleton.userInfo.get(i).getId()))
							existtrue = true;
						state++;
					}
					if (existtrue == false) {
						System.out.println("��ϵ��� ���� ID�Դϴ�");
					}
				}

				if (state == 1) {

					existtrue = false;

					System.out.println("�̸����� �Է����ּ���. \t\t\t0.����ȭ������"); // 1
					emailID = scan.scanStr();

					for (int i = 0; i < ucount.countuser; i++) {
						if (emailID.equals(mSingleton.userInfo.get(i).getEmailid())) {
							state++;
							existtrue = true;
							break;
						}
					}
					if (existtrue == false) {
						System.out.println("��ϵ��� ���� �̸����Դϴ�");
						state = 1;
					}
				}

				if (state == 2) {
					existtrue = false;
					System.out.println("�̸��� ��й�ȣ�� �Է����ּ���. \t\t\t0.����ȭ������"); // 2
					emailPW = scan.scanStr();
					
					for (int i = 0; i < ucount.countuser; i++) {
						if (emailPW.equals(mSingleton.userInfo.get(i).getEmailpw())) {
							state++;
							existtrue = true;
							break;
						}
						index++;
					}
					if (existtrue == false) {
						System.out.println("��й�ȣ�� ���� �ʽ��ϴ�");
						state = 2;
					}
				}

				if (state == 3) {
					System.out.println("�ƹ�Ű�� ������ �����ڵ尡 �߱޵˴ϴ�"); // 3
					String yn = scan.scanStr();
					state++;
					try {
						codetime.start(); // �����ڵ�߱� ������ ����
					} catch (Exception IllegalThreadStateException) {
					}
				}

				if (state == 4) {
					System.out.println("�ڵ带 �Է����ּ��� (�Է����ѽð� 30��)"); // 4
					CodePopUp lll = new CodePopUp(); // �����ڵ� �˾�â

					int inputcode = scan.scanInt();

					if (inputcode == stc.timeCode) {
						lll.setVisible(false);	// �����ڵ� �°� �Է½� â �����
						System.out.println("���� �Ǿ����ϴ�.\n");
						state++;
					} else {
						System.out.println("�Է��� �ڵ尡 �ƴմϴ�. �Է� �ð��� �ʰ��Ǿ����� ���ο� �ڵ带 ��߱� �����ʽÿ�.\n1.�����ڵ� ��Ȯ��/��߱� \t 0.���"); // 5
						String input = scan.scanStr();
						if (input.equals("1")) {
							lll.dispose();
							state = 3;
						}
						else if (input.equals("0"))
							break;
					}

				}

				if (state == 5) {
					System.out.println("�����Ͻ� ��й�ȣ�� �Է����ּ���");
					String changePW = scan.scanStr();
					mSingleton.userInfo.get(index).setPw(changePW);
					System.out.println("��й�ȣ ������ �Ϸ�Ǿ����ϴ�\n");
					break;
				}

			}
// ------------------------------------------------------------------------------------------
		}
	}

}
