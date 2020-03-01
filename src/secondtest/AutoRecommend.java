package secondtest;

import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle.Control;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.poi.ss.examples.formula.SettingExternalFunction.BloombergAddIn;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.Color;

public class AutoRecommend extends JFrame {

	Singleton storege = Singleton.getInstance();
	StaticCode ip = new StaticCode();
	BufferedImage img = null;

	AutoRecommend(int close) {
		System.exit(close);
	}

	AutoRecommend(String routine) {
		this();
	}

	AutoRecommend() {

		setBackground(Color.BLACK);
		getContentPane().setBackground(Color.BLACK);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		Container reContainer = getContentPane();
		getContentPane().setLayout(null);
		setTitle("작품추천");
		randomAllProduct(); // 등록된작품 랜덤으로 섞기

 //---------------------------------좋아하는 장르 앞쪽배치
		Sortclass sc = new Sortclass();
		FavoriteGenre[] fg = new FavoriteGenre[9];
		FavoriteGenre best = new FavoriteGenre("", 0);
		sc.sort(fg);
		best = fg[0];
		int k = 0;
		for (int i = 0; i < storege.mediaInfo.size(); i++) {
			if (best.getGenreName().equals(storege.mediaInfo.get(i).getGenre())) {
				MediaInfo tempArry = new MediaInfo();
				tempArry = storege.mediaInfo.get(k);
				storege.mediaInfo.set(k, storege.mediaInfo.get(i));
				storege.mediaInfo.set(i, tempArry);
				k++;
				if (k == 4)
					break;
			}
		}

// ------------------------------포스터이미지 배열에 넣기
		ImageIcon[] Poster = new ImageIcon[storege.mediaInfo.size()];

		for (int i = 0; i < storege.mediaInfo.size(); i++) {
//			Poster[i] = new ImageIcon("C:\\Users\\Sun\\Desktop\\191201\\secondtest2222\\Poster/"
//					+ storege.mediaInfo.get(i).getMediaName() + ".jpg");
			Poster[i] = new ImageIcon("..\\PosterImages\\"
			+ storege.mediaInfo.get(i).getMediaName() + ".jpg");
		}
		
//---------------------------------라벨에 포스터 넣기
		JLabel lblNewLabel = new JLabel(Poster[0]); // 많이본 장르 출력해야됨
		lblNewLabel.setBounds(0, 0, 380, 180);
		getContentPane().add(lblNewLabel);

		JLabel label = new JLabel(Poster[1]); // 많이본 장르 출력해야됨
		label.setBounds(386, 0, 380, 180);
		getContentPane().add(label);

		JLabel label_1 = new JLabel(Poster[2]); // 많이본 장르 출력해야됨
		label_1.setBounds(772, 0, 380, 180);
		getContentPane().add(label_1);

		JLabel label_2 = new JLabel(Poster[3]); // 많이본 장르 출력해야됨
		label_2.setBounds(1159, 0, 380, 180);
		getContentPane().add(label_2);

		JLabel label_3 = new JLabel(Poster[4]);
		label_3.setBounds(0, 190, 380, 180);
		getContentPane().add(label_3);

		JLabel label_4 = new JLabel(Poster[5]);
		label_4.setBounds(386, 190, 380, 180);
		getContentPane().add(label_4);

		JLabel label_5 = new JLabel(Poster[6]);
		label_5.setBounds(772, 190, 380, 180);
		getContentPane().add(label_5);

		JLabel label_6 = new JLabel(Poster[7]);
		label_6.setBounds(1159, 190, 380, 180);
		getContentPane().add(label_6);

		JLabel label_7 = new JLabel(Poster[8]);
		label_7.setBounds(0, 383, 380, 180);
		getContentPane().add(label_7);

		JLabel label_8 = new JLabel(Poster[9]);
		label_8.setBounds(386, 383, 380, 180);
		getContentPane().add(label_8);

		JLabel label_9 = new JLabel(Poster[10]);
		label_9.setBounds(772, 383, 380, 180);
		getContentPane().add(label_9);

		JLabel label_10 = new JLabel(Poster[11]);
		label_10.setBounds(1159, 383, 380, 180);
		getContentPane().add(label_10);

		JLabel label_11 = new JLabel(Poster[12]);
		label_11.setBounds(0, 573, 380, 180);
		getContentPane().add(label_11);

		JLabel label_12 = new JLabel(Poster[13]);
		label_12.setBounds(386, 573, 380, 180);
		getContentPane().add(label_12);

		JLabel label_13 = new JLabel(Poster[14]);
		label_13.setBounds(772, 573, 380, 180);
		getContentPane().add(label_13);

		JLabel label_14 = new JLabel(Poster[15]);
		label_14.setBounds(1159, 573, 380, 180);
		getContentPane().add(label_14);
	

		setBounds(180, 100, 1555, 795);
		setVisible(true);

//--------------------------------------각 라벨 마우스 액션
		lblNewLabel.addMouseListener(new MouseLPoster0());
		label.addMouseListener(new MouseLPoster1());
		label_1.addMouseListener(new MouseLPoster2());
		label_2.addMouseListener(new MouseLPoster3());
		label_3.addMouseListener(new MouseLPoster4());
		label_4.addMouseListener(new MouseLPoster5());
		label_5.addMouseListener(new MouseLPoster6());
		label_6.addMouseListener(new MouseLPoster7());
		label_7.addMouseListener(new MouseLPoster8());
		label_8.addMouseListener(new MouseLPoster9());
		label_9.addMouseListener(new MouseLPoster10());
		label_10.addMouseListener(new MouseLPoster11());
		label_11.addMouseListener(new MouseLPoster12());
		label_12.addMouseListener(new MouseLPoster13());
		label_13.addMouseListener(new MouseLPoster14());
		label_14.addMouseListener(new MouseLPoster15());
	}

//-------------------------------------라벨 마우스 액션 기능구현 *160~582줄 까지*
	class MouseLPoster0 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(0));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster1 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(1));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster2 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(2));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster3 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(3));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster4 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(4));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster5 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(5));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster6 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(6));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster7 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(7));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster8 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(8));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster9 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(9));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster10 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(10));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster11 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(11));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster12 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(12));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster13 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(13));
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

	class MouseLPoster14 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(14));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

	class MouseLPoster15 implements MouseListener {
		JDCreat jd = new JDCreat();

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			jd.movieJD(storege.mediaInfo.get(15));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
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

//--------------------------------------JDialog생성 클래스
	class JDCreat {

		MediaInfo mediainfo = new MediaInfo();
		BufferedImage img = null;
		JDialog jD = new JDialog();

		void movieJD(MediaInfo mi) {

			JPanel jp2 = new JPanel();
			JPanel jp1 = new JPanel();
			JButton jb1 = new JButton("바로시청");
			JButton jb2 = new JButton("돌아가기");
			JLabel jl1 = new JLabel();
			JLabel jl2 = new JLabel();
			JLabel jl3 = new JLabel();
			JLabel jl4 = new JLabel();
			JLabel jl5 = new JLabel();
			JLabel jl6 = new JLabel();
			JLabel jl7 = new JLabel();
			JLabel jl8 = new JLabel();
			JLabel jl9 = new JLabel();
			JLabel jl10 = new JLabel();

			jD.setLayout(null);
			jp1.setLayout(null);

			jp2.setLayout(new GridLayout(1, 2, 3, 3));

			jl1.setText(mi.getMediaName());
			jl1.setBounds(30, 30, 450, 40);
			jl1.setFont(new Font("굴림", Font.BOLD, 30));
			jl1.setForeground(Color.LIGHT_GRAY);

			jl2.setText("ㅣ장 르 - " + mi.getGenre() + "ㅣ");
			jl2.setBounds(30, 70, 130, 40);
			jl2.setForeground(Color.LIGHT_GRAY);

			jl3.setText("ㅣ출시년도 - " + mi.getReleaseYear() + "ㅣ");
			jl3.setBounds(180, 70, 130, 40);
			jl3.setForeground(Color.LIGHT_GRAY);

			jl4.setText("ㅣ출시국가 - " + mi.getCountry() + "ㅣ");
			jl4.setBounds(315, 70, 130, 40);
			jl4.setForeground(Color.LIGHT_GRAY);

			jl5.setText("ㅣ러닝타임 - " + mi.getRuningTime() + "ㅣ");
			jl5.setBounds(30, 90, 130, 40);
			jl5.setForeground(Color.LIGHT_GRAY);

			jl6.setText("ㅣ관람등급 - " + mi.getMovieRatings() + " ㅣ");
			jl6.setBounds(180, 90, 200, 40);
			jl6.setForeground(Color.LIGHT_GRAY);

			jl7.setText("ㅣ감 독 - " + mi.getFilmDrector() + "ㅣ");
			jl7.setBounds(30, 110, 200, 40);
			jl7.setForeground(Color.LIGHT_GRAY);

			jl8.setText("ㅣ출 연 - " + mi.getLeadActor() + "ㅣ");
			jl8.setBounds(180, 110, 350, 40);
			jl8.setForeground(Color.LIGHT_GRAY);

			jl9.setText("ㅣ자 막 - " + mi.getSubtitles() + "ㅣ");
			jl9.setBounds(30, 130, 200, 40);
			jl9.setForeground(Color.LIGHT_GRAY);

			jl10.setText("ㅣ더 빙 - " + mi.getDubbing() + "ㅣ");
			jl10.setBounds(180, 130, 200, 40);
			jl10.setForeground(Color.LIGHT_GRAY);

			jD.add(jl1);
			jD.add(jl2);
			jD.add(jl3);
			jD.add(jl4);
			jD.add(jl5);
			jD.add(jl6);
			jD.add(jl7);
			jD.add(jl8);
			jD.add(jl9);
			jD.add(jl10);
			jp2.add(jb1);
			jp2.add(jb2);

			JLayeredPane jlp = new JLayeredPane();
			jlp.setSize(800, 500);
			jlp.setLayout(null);

			try {
				img = ImageIO
						.read(new File("C:\\Users\\Sun\\Desktop\\191201\\Poster_large/" + mi.getMediaName() + ".jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Imgpanel panel = new Imgpanel();
			panel.setSize(800, 500);
			jlp.add(panel);
			jD.add(jlp);

			// jp1.setBackground(Color.BLACK);
			jD.setBounds(500, 200, 800, 500);

			jp1.setLocation(0, 0);
			jp1.setSize(800, 415);
			jp2.setLocation(0, 415);
			jp2.setSize(800, 50);

			jD.add(jp1);
			jD.add(jp2);
			jD.setSize(800, 500);
			jD.setVisible(true);

//--------------------------------시청하기 버튼액션
			class ButtonLWatch implements ActionListener {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					SubDubbing sd = new SubDubbing();
					sd.jDSD(mi);
//					setVisible(false);
//					jD.setVisible(false);

				}

			}
//--------------------------------돌아가기 버튼액션			
			class ButtonLClose implements ActionListener {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					jD.setVisible(false);
				}
			}

			jb1.addActionListener(new ButtonLWatch());
			jb2.addActionListener(new ButtonLClose());
		}

		class Imgpanel extends JPanel {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, null);
			}
		}

		class SubDubbing extends Thread {

			void jDSD(MediaInfo mi) {

				JDialog jDSD = new JDialog();

				JPanel jpSD2 = new JPanel();
				JPanel jpSD1 = new JPanel();

				JButton jbSD1 = new JButton("확인");
				JButton jbSD2 = new JButton("취소");

				JLabel jlSD1 = new JLabel();
				JLabel jlSD2 = new JLabel();

				JComboBox subCB = new JComboBox();
				JComboBox dubCB = new JComboBox();

				jDSD.setLayout(null);
				jpSD1.setLayout(new GridLayout(2, 2, 3, 3));
				jpSD2.setLayout(new GridLayout(1, 2, 0, 0));

				jlSD1.setText("자 막");
				jlSD1.setHorizontalAlignment(SwingConstants.CENTER);
				jlSD1.setForeground(Color.LIGHT_GRAY);

				jlSD2.setText("더 빙");
				jlSD2.setHorizontalAlignment(SwingConstants.CENTER);
				jlSD2.setForeground(Color.LIGHT_GRAY);

				jpSD2.add(jbSD1);
				jpSD2.add(jbSD2);

				String[] sub = mi.getSubtitles().split("/");
				// kor eng jap chi
				jpSD1.add(jlSD1);

				if (sub.length == 0) {
//					subCB = new JComboBox();
					subCB.setModel(new DefaultComboBoxModel(new String[] { "없음" }));
					jpSD1.add(subCB);
				} else if (sub.length == 1) {
//					subCB = new JComboBox();
					subCB.setModel(new DefaultComboBoxModel(new String[] { "없음", sub[0] }));
					jpSD1.add(subCB);
				} else if (sub.length == 2) {
//					subCB = new JComboBox();
					subCB.setModel(new DefaultComboBoxModel(new String[] { "없음", sub[0], sub[1] }));
					jpSD1.add(subCB);
				} else if (sub.length == 3) {
//					subCB = new JComboBox();
					subCB.setModel(new DefaultComboBoxModel(new String[] { "없음", sub[0], sub[1], sub[2] }));
					jpSD1.add(subCB);
				} else if (sub.length == 4) {
//					subCB = new JComboBox();
					subCB.setModel(new DefaultComboBoxModel(new String[] { "없음", sub[0], sub[1], sub[2], sub[3] }));
					jpSD1.add(subCB);
				}

				jpSD1.add(jlSD2);

				String[] dubbing = mi.getDubbing().split("/");

				if (dubbing.length == 0) {
//					dubCB = new JComboBox();
					dubCB.setModel(new DefaultComboBoxModel(new String[] { "없음" }));
					jpSD1.add(dubCB);
				} else if (dubbing.length == 1) {
//					dubCB = new JComboBox();
					dubCB.setModel(new DefaultComboBoxModel(new String[] { "없음", dubbing[0] }));
					jpSD1.add(dubCB);
				} else if (dubbing.length == 2) {
//					dubCB = new JComboBox();
					dubCB.setModel(new DefaultComboBoxModel(new String[] { "없음", dubbing[0], dubbing[1] }));
					jpSD1.add(dubCB);
				} else if (dubbing.length == 3) {
//					dubCB = new JComboBox();
					dubCB.setModel(new DefaultComboBoxModel(new String[] { "없음", dubbing[0], dubbing[1], dubbing[2] }));
					jpSD1.add(dubCB);
				} else if (sub.length == 4) {
//					dubCB = new JComboBox();
					dubCB.setModel(new DefaultComboBoxModel(
							new String[] { "없음", dubbing[0], dubbing[1], dubbing[2], dubbing[3] }));
					jpSD1.add(dubCB);
				}

				jpSD1.setBackground(Color.BLACK);
				jpSD2.setBackground(Color.BLACK);
				jDSD.setBounds(700, 400, 414, 180);

				jpSD1.setLocation(0, 0);
				jpSD1.setSize(400, 100);
				jpSD2.setLocation(0, 100);
				jpSD2.setSize(400, 40);

				jDSD.add(jpSD1);
				jDSD.add(jpSD2);

				jDSD.setVisible(true);

				class ButtonLS implements ActionListener {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						jDSD.setVisible(false);
						setVisible(false);
						jD.setVisible(false);
			
						Streaming st = new Streaming();
						String selecsub = String.valueOf(subCB.getSelectedItem());
						String selecdub = String.valueOf(dubCB.getSelectedItem());

						System.out.println("잠시 후 스트리밍이 시작 됩니다.\n");
						if (storege.userInfo.get(ip.ipid).getMembership() == 13)
							st.mP​remium(mi, selecsub, selecdub);
						else if (storege.userInfo.get(ip.ipid).getMembership() == 9)
							st.mStandard(mi, selecsub, selecdub);
						System.out.println("\n스트리밍이 끝났습니다.\n");

						JDialog satisfaction = new JDialog();
						satisfaction.setLayout(null);

						JLabel sfjl1 = new JLabel("스트리밍에 만족하셨습니까?");
						sfjl1.setLocation(40, 20);
						sfjl1.setSize(200, 80);
						sfjl1.setFont(new Font("돋움", Font.BOLD, 15));

						JPanel sfjp1 = new JPanel();
						sfjp1.setLayout(new GridLayout(1, 2, 1, 1));
						sfjp1.setBounds(0, 110, 300, 40);

						JButton sfjb1 = new JButton("예");
						JButton sfjb2 = new JButton("아니오");
						sfjp1.add(sfjb1);
						sfjp1.add(sfjb2);
						satisfaction.add(sfjl1);
						satisfaction.add(sfjp1);
						satisfaction.setBounds(780, 400, 300, 200);
						satisfaction.setVisible(true);

						class ButtonLike implements ActionListener {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub

								for (int i = 0; i < 10; i++) {
									int get = 0;
									if (mi.getGenre().equals(storege.userInfo.get(ip.ipid).getGenre(i))) {
										get = storege.userInfo.get(ip.ipid).getWatched(i);
										get++;
										storege.userInfo.get(ip.ipid).setWatched(i, get);
										break;
									}
								}
								System.out.println(mi.getGenre() + "장르의 선호도가 증가했습니다.\n");

								System.out.println("1.로그아웃");
								satisfaction.setVisible(false);
								
								try {
									sleep(1000);
									//new AutoRecommend();
									new AutoRecommend();
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
						class ButtonHate implements ActionListener {
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								satisfaction.setVisible(false);
								dispose();
								try {
									sleep(1000);
									new AutoRecommend();
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}
						sfjb1.addActionListener(new ButtonLike());
						sfjb2.addActionListener(new ButtonHate());

					}

				}

				// --------------------------------돌아가기 버튼액션
				class ButtonLC implements ActionListener {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub

						jDSD.setVisible(false);
					}
				}

				jbSD1.addActionListener(new ButtonLS());
				jbSD2.addActionListener(new ButtonLC());

			}

		}
	}

//--------------------------------등록되어있는 작품 랜덤으로 섞는 함수
	void randomAllProduct() {
		MediaInfo temp = new MediaInfo();

		for (int i = 0; i < 300; i++) {
			int random = (int) (Math.random() * storege.mediaInfo.size());
			temp = storege.mediaInfo.get(0);
			storege.mediaInfo.set(0, storege.mediaInfo.get(random));
			storege.mediaInfo.set(random, temp);

		}
	}

}

//--------------------------------가장 많이본 장르 판단하는 클래스
class Sortclass {
	StaticCode sc = new StaticCode();
	Singleton storege = Singleton.getInstance();

	FavoriteGenre sort(FavoriteGenre[] searchArry) {

		searchArry[0] = new FavoriteGenre("액션", storege.userInfo.get(sc.ipid).getWatched(1));
		searchArry[1] = new FavoriteGenre("sf", storege.userInfo.get(sc.ipid).getWatched(2));
		searchArry[2] = new FavoriteGenre("미스터리", storege.userInfo.get(sc.ipid).getWatched(3));
		searchArry[3] = new FavoriteGenre("스릴러", storege.userInfo.get(sc.ipid).getWatched(4));
		searchArry[4] = new FavoriteGenre("공포", storege.userInfo.get(sc.ipid).getWatched(5));
		searchArry[5] = new FavoriteGenre("드라마", storege.userInfo.get(sc.ipid).getWatched(6));
		searchArry[6] = new FavoriteGenre("멜로", storege.userInfo.get(sc.ipid).getWatched(7));
		searchArry[7] = new FavoriteGenre("코미디", storege.userInfo.get(sc.ipid).getWatched(8));
		searchArry[8] = new FavoriteGenre("애니메이션", storege.userInfo.get(sc.ipid).getWatched(9));

		Arrays.sort(searchArry, Collections.reverseOrder());

		return searchArry[0];
	}
}
