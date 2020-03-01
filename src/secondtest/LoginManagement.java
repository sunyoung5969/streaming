package secondtest;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class LoginManagement extends JFrame{	// 로그인 관리 클래스

	Singleton mSingleton = Singleton.getInstance();
	StaticCode ucount = new StaticCode();
	Scan input = new Scan();

	int Login() {	// 로그인 함수
		int state = 0;
		String userID = "";
		String userPW = "";
		boolean existtrue = false;

		while (state != -1) {
			if (state == 0) {
				System.out.println("로그인할 비트리밍 ID를 입력해주세요\t\t 0.메인화면으로");
				userID = input.scanStr();
				if (!userID.equals("0"))
					state++;
				else if (userID.equals("0"))
					break;
			}
			if (state == 1) {
				int rr = 0;
				System.out.println("비트리밍 ID의 비밀번호를 입력해주세요\t\t 0.아이디입력");
				userPW = input.scanStr();
				for (int i = 0; i < ucount.countuser; i++) {
					if ((userID.equals(mSingleton.userInfo.get(i).getId())
							&& userPW.equals(mSingleton.userInfo.get(i).getPw()))
							) {

						System.out.println("오늘도 비트리밍과 함께 시간을 보내주셔서 감사합니다.");
						state = -1;
						existtrue = true;
						ucount.ipid = mSingleton.userInfo.get(i).getIdentity();
						//유저정보 어레이리스트에 접근하기위해  회원가입시 등록되는 고유번호를 로그인시 스태틱변수에 저장
						
						return 1;

					}

				}
				if(userID.equals("admin") && userPW.equals("123456")) {
					System.out.println("오늘도 비트리밍과 함께 시간을 보내주셔서 감사합니다.");
					state = -1;
					existtrue = true;
					return 1;
				}
					
				else if (existtrue == false) {
					System.out.println("ID 비밀번호가 맞지않습니다.");
					state = 0;
				}

			}

		}
		return 0;
	}


	void searchIDPW() { // ID/PW찾기 함수
		Singleton mSingleton = Singleton.getInstance();
		boolean existtrue = false;

		StaticCode stc = new StaticCode();
		AuthenticationCode codetime = new AuthenticationCode();
		Scan scan = new Scan();

		System.out.println("1.ID찾기\t\t2.PW찾기\t\t3.인증코드입력\t\t4.메인화면으로");// 0 메인화면

		int inputNum = scan.scanInt();
		
		String userID = "";
		String emailID = "";
		String emailPW = "";
		
//----------------------------------ID찾기
		if (inputNum == 1) {

			int state = 0;
			int index = -1;
			
			while (state != -1) {
				

				if (state == 0) {
					existtrue = false;

					System.out.println("이메일을 입력해주세요. \t\t\t0.이전화면으로"); // 1
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
						System.out.println("등록되지 않은 이메일입니다");
						state = 0;
					}
				}

				if (state == 1) {

					existtrue = false;
					System.out.println("이메일 비밀번호를 입력해주세요. \t\t\t0.이전화면으로"); // 2
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
						System.out.println("비밀번호가 맞지 않습니다");
						state = 1;
					}
				}

				if (state == 2) {
					System.out.println("비트리밍 사이트에 등록하신 아이디");
					System.out.println();
					System.out.println();
					System.out.println(mSingleton.userInfo.get(index).getId());
					System.out.println();
					System.out.println();
					System.out.println("위의 아이디로 등록하셨습니다.");
					System.out.println();
					System.out.println("확인하셨으면 아무키나 눌러주세요.");
					String aaa = scan.scanStr();
					break;
				}

			}
//-------------------------------while 반복분-------------------------------------------			

		}
//----------------------------PW 찾기
		if (inputNum == 2) {
			int index = 0;
			int state = 0;

			while (state != -1) {

				if (state == 0) {
					System.out.println("ID를 입력해주세요. \t\t\t0.메인화면으로");
					userID = scan.scanStr();
					for (int i = 0; i < ucount.countuser; i++) {
						if (userID.equals(mSingleton.userInfo.get(i).getId()))
							existtrue = true;
						state++;
					}
					if (existtrue == false) {
						System.out.println("등록되지 않은 ID입니다");
					}
				}

				if (state == 1) {

					existtrue = false;

					System.out.println("이메일을 입력해주세요. \t\t\t0.이전화면으로"); // 1
					emailID = scan.scanStr();

					for (int i = 0; i < ucount.countuser; i++) {
						if (emailID.equals(mSingleton.userInfo.get(i).getEmailid())) {
							state++;
							existtrue = true;
							break;
						}
					}
					if (existtrue == false) {
						System.out.println("등록되지 않은 이메일입니다");
						state = 1;
					}
				}

				if (state == 2) {
					existtrue = false;
					System.out.println("이메일 비밀번호를 입력해주세요. \t\t\t0.이전화면으로"); // 2
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
						System.out.println("비밀번호가 맞지 않습니다");
						state = 2;
					}
				}

				if (state == 3) {
					System.out.println("아무키를 누르면 인증코드가 발급됩니다"); // 3
					String yn = scan.scanStr();
					state++;
					try {
						codetime.start(); // 인증코드발급 쓰레드 시작
					} catch (Exception IllegalThreadStateException) {
					}
				}

				if (state == 4) {
					System.out.println("코드를 입력해주세요 (입력제한시간 30초)"); // 4
					CodePopUp lll = new CodePopUp(); // 인증코드 팝업창

					int inputcode = scan.scanInt();

					if (inputcode == stc.timeCode) {
						lll.setVisible(false);	// 인증코드 맞게 입력시 창 숨기기
						System.out.println("인증 되었습니다.\n");
						state++;
					} else {
						System.out.println("입력한 코드가 아닙니다. 입력 시간이 초과되었으면 새로운 코드를 재발급 받으십시오.\n1.인증코드 재확인/재발급 \t 0.취소"); // 5
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
					System.out.println("변경하실 비밀번호를 입력해주세요");
					String changePW = scan.scanStr();
					mSingleton.userInfo.get(index).setPw(changePW);
					System.out.println("비밀번호 변경이 완료되었습니다\n");
					break;
				}

			}
// ------------------------------------------------------------------------------------------
		}
	}

}
