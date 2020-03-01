package secondtest;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.apache.poi.hwpf.model.SinglentonTextPiece;

//import secondtest.*;

public class SignUp extends JFrame{ // 회원가입 클래스

	Singleton mSingleton = Singleton.getInstance();
	Scan scan = new Scan();
	StaticCode ucount = new StaticCode();
	
	int membership = 0;
	
	private JRadioButton jr1;
	private JRadioButton jr2;
	
	void sign() { // 회원가입 함수
		JFrame jfmember = new JFrame();
		Container mcontainer = getContentPane();

		mcontainer.setLayout(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		UserInfo inputinfo = new UserInfo();
		
		setTitle("멤버십 선택");
		JLabel jlmem1 = new JLabel("멤버십 선택");
		jlmem1.setSize(300,30);
		jlmem1.setLocation(85,10);
		jlmem1.setFont(new Font("돋움", Font.BOLD, 20));
		mcontainer.add(jlmem1);
		
		JLabel jlmem2 = new JLabel("(HD화질까지만 지원)");
		jlmem2.setSize(300,30);
		jlmem2.setLocation(18,80);
		mcontainer.add(jlmem2);
		
		JLabel jlmem3 = new JLabel("(UHD화질 제공)");
		jlmem3.setSize(300,30);
		jlmem3.setLocation(170,80);
		mcontainer.add(jlmem3);
		
		JLabel jlmem4 = new JLabel("$9.9");
		jlmem4.setSize(300,30);
		jlmem4.setLocation(88,30);
		jlmem4.setForeground(Color.red);
		mcontainer.add(jlmem4);
		
		JLabel jlmem5 = new JLabel("$13.9");
		jlmem5.setSize(300,30);
		jlmem5.setLocation(220,30);
		jlmem5.setForeground(Color.red);
		mcontainer.add(jlmem5);
		
		jr1 = new JRadioButton("스탠다드");
		jr1.setSize(90,30);
		jr1.setLocation(30,50);
		jr1.setFont(new Font("돋움", Font.BOLD, 15));
		mcontainer.add(jr1);
		
		jr2 = new JRadioButton("프리미엄");
		jr2.setSize(100,30);
		jr2.setLocation(170,50);
		jr2.setFont(new Font("돋움", Font.BOLD, 15));
		mcontainer.add(jr2);
		
		ButtonGroup group = new ButtonGroup();
		group.add(jr1); group.add(jr2);
		
		JButton jbmem1 = new JButton("선택");
		jbmem1.setSize(70,30);
		jbmem1.setLocation(40,120);
		mcontainer.add(jbmem1);
		
		JButton jbmem2 = new JButton("취소");
		jbmem2.setSize(70,30);
		jbmem2.setLocation(180,120);
		mcontainer.add(jbmem2);
		
		
		setBounds(780, 400, 300, 200);
		setResizable(false);
		setVisible(true);
		setAlwaysOnTop(true);
		
		
		jbmem1.addMouseListener(new MouseSignL());
		jbmem2.addMouseListener(new MouseSignLClose());
		
	
		
	}
	
	
	void firstRecommend() {
		
		Singleton st = Singleton.getInstance();
		StaticCode sc = new StaticCode();

		int favorite = scan.scanInt();
		System.out.println("\n회원가입이 완료 되었습니다.");
		
		st.userInfo.get(sc.ipid).setWatched(favorite, 5);
		
		for(int i = 0; i<10; i++)
			System.out.println(st.userInfo.get(sc.ipid).getWatched(i));	
	}

	class MouseSignL implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
			setVisible(false);
			JDialog jDi = new JDialog();
			jDi.setLayout(null);
			ArrayList<UserInfo> userInfo = new ArrayList<UserInfo>();

			setTitle("회원가입");

			JLabel jl0 = new JLabel("회원가입");
			jl0.setSize(100, 30);
			jl0.setLocation(130, 10);
			jDi.add(jl0);

			JLabel jl1 = new JLabel("이름");
			jl1.setSize(100, 30);
			jl1.setLocation(60, 50);
			jDi.add(jl1);

			JTextField jf1 = new JTextField(10);
			jf1.setSize(100, 30);
			jf1.setLocation(180, 50);
			jDi.add(jf1);

			JLabel jl2 = new JLabel("생년월일");
			jl2.setSize(100, 30);
			jl2.setLocation(60, 80);
			jDi.add(jl2);

			JTextField jf2 = new JTextField(10);
			jf2.setSize(100, 30);
			jf2.setLocation(180, 80);
			jDi.add(jf2);

			JLabel jl3 = new JLabel("ID");
			jl3.setSize(100, 30);
			jl3.setLocation(60, 110);
			jDi.add(jl3);

			JTextField jf3 = new JTextField(10);
			jf3.setSize(100, 30);
			jf3.setLocation(180, 110);
			jDi.add(jf3);

			JLabel jl4 = new JLabel("비밀번호");
			jl4.setSize(100, 30);
			jl4.setLocation(60, 140);
			jDi.add(jl4);

			JTextField jf4 = new JTextField(10);
			jf4.setSize(100, 30);
			jf4.setLocation(180, 140);
			jDi.add(jf4);

			JLabel jl5 = new JLabel("EmailID");
			jl5.setSize(100, 30);
			jl5.setLocation(60, 170);
			jDi.add(jl5);

			JTextField jf5 = new JTextField(10);
			jf5.setSize(100, 30);
			jf5.setLocation(180, 170);
			jDi.add(jf5);

			JLabel jl6 = new JLabel("EmailPW");
			jl6.setSize(100, 30);
			jl6.setLocation(60, 200);
			jDi.add(jl6);

			JTextField jf6 = new JTextField(10);
			jf6.setSize(100, 30);
			jf6.setLocation(180, 200);
			jDi.add(jf6);

			JButton mbutton = new JButton("회원가입");
			mbutton.setSize(100, 30);
			mbutton.setLocation(40, 280);
			jDi.add(mbutton);

			JButton mbutton2 = new JButton("취소");
			mbutton2.setSize(100, 30);
			mbutton2.setLocation(180, 280);
			jDi.add(mbutton2);
			

			jDi.setBounds(750, 300, 350, 400);
			jDi.setResizable(false);
			jDi.setVisible(true);
			
			

			
			class MyActionL implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					setVisible(false);
					
					
					UserInfo ui = new UserInfo();

					ui.setName(jf1.getText());
					jf1.setText("");

					ui.setBirthdate(jf2.getText());
					jf2.setText("");

					ui.setId(jf3.getText());
					jf3.setText("");

					ui.setPw(jf4.getText());
					jf4.setText("");

					ui.setEmailid(jf5.getText());
					jf5.setText("");

					ui.setEmailpw(jf6.getText());
					jf6.setText("");
					
					if(jr1.isSelected())
						membership = 9;
					else if(jr2.isSelected())
						membership =13;
	
					ui.setMembership(membership);
					
					ui.setIdentity(ucount.countuser);		
					
					ucount.countuser++;			
					
					ui.setGenre(0, ui.getId());

					mSingleton.userInfo.add(ui);

					jDi.setVisible(false);
					
					System.out.println("비트리밍에 처음오신것을 환영합니다\n\n");
					
					System.out.println("고객님이 제일 좋아하는 장르를 선택해주세요.");
					
					System.out.println("\n1.SF    2.액션    3.미스터리    4.스릴러    5.공포\n\n"
							+ "6.드라마    7.멜로    8.코미디    9.애니메이션");
					
				}

			}

			class MyActionLClose implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					System.out.println("회원가입이 취소되었습니다.");
					jDi.setVisible(false);

				}

			}

			mbutton.addActionListener(new MyActionL());
			mbutton2.addActionListener(new MyActionLClose());

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

	}
	
	class MouseSignLClose implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			setVisible(false);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}


}
