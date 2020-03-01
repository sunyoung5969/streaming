package secondtest;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;

import java.awt.GridLayout;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;

public class MediaRegister extends JFrame { // 프레임창을 이용해 작품등록하는 클래스 
	
	Singleton mSingleton = Singleton.getInstance();
	MediaInfo inputMInfo = new MediaInfo();
	StaticCode pcount = new StaticCode();
	ArrayList<String> genreArry = new ArrayList<String>();
	ArrayList<String> subArry = new ArrayList<String>();
	ArrayList<String> dubbingArry = new ArrayList<String>();

	private JTextField textField_0;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JCheckBox[] genreCheckbox = new JCheckBox[6];
	private JCheckBox[] subCheckBox = new JCheckBox[4];
	private JCheckBox[] dBCheckBox = new JCheckBox[4];
	private JComboBox genreCB = new JComboBox();
	private JComboBox countryCB = new JComboBox();
	private JComboBox releaseCB = new JComboBox();

	public MediaRegister() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setTitle("작품 등록");

		getContentPane().setBackground(Color.DARK_GRAY);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 430, 349);
		getContentPane().add(panel_1);
		panel_1.setLayout(new GridLayout(5, 0, 0, 2));

		JLabel lblNewLabel_0 = new JLabel("작품명");
		lblNewLabel_0.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_0.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_0.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_0);

		textField_0 = new JTextField();
		textField_0.setHorizontalAlignment(SwingConstants.CENTER);
		textField_0.setToolTipText("");
		panel_1.add(textField_0);
		textField_0.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("시청등급");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("스트리밍시간");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("감독");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_3.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("출연");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 13));
		lblNewLabel_4.setForeground(Color.LIGHT_GRAY);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(textField_4);
		textField_4.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(430, 0, 430, 349);
		getContentPane().add(panel);
		panel.setLayout(new GridLayout(5, 0, 0, 2));

		JLabel label_1 = new JLabel("장 르");
		label_1.setFont(new Font("굴림", Font.PLAIN, 13));
		label_1.setForeground(Color.LIGHT_GRAY);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);

		genreCB = new JComboBox();
		genreCB.setModel(new DefaultComboBoxModel(
				new String[] { "SF", "판타지", "액션", "미스터리", "공포", "스릴러", "멜로", "드라마", "코미디", "음악", "다큐멘터리", "애니메이션" }));
		panel.add(genreCB);
		

		JLabel label_2 = new JLabel("출시국가");
		label_2.setFont(new Font("굴림", Font.PLAIN, 13));
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_2);

		countryCB = new JComboBox();
		countryCB.setModel(
				new DefaultComboBoxModel(new String[] { "한국", "미국", "독일", "영국", "스페인", "프랑스", "이탈리아", "일본", "중국" }));
		panel.add(countryCB);

		JLabel label_3 = new JLabel("출시년도");
		label_3.setFont(new Font("굴림", Font.PLAIN, 13));
		label_3.setForeground(Color.LIGHT_GRAY);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_3);

		releaseCB = new JComboBox();
		releaseCB.setModel(new DefaultComboBoxModel(
				new String[] { "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009",
						"2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000" }));
		panel.add(releaseCB);

		JLabel label_4 = new JLabel("자막");
		label_4.setFont(new Font("굴림", Font.PLAIN, 13));
		label_4.setForeground(Color.LIGHT_GRAY);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_4);

		JPanel subChB = new JPanel();
		panel.add(subChB);
		subChB.setLayout(new GridLayout(2, 1, 0, 3));

		subCheckBox[0] = new JCheckBox("KOR");
		subChB.add(subCheckBox[0]);

		subCheckBox[1] = new JCheckBox("ENG");
		subChB.add(subCheckBox[1]);

		subCheckBox[2] = new JCheckBox("JAP");
		subChB.add(subCheckBox[2]);

		subCheckBox[3] = new JCheckBox("CHI");
		subChB.add(subCheckBox[3]);

		JLabel label_5 = new JLabel("더빙");
		label_5.setFont(new Font("굴림", Font.PLAIN, 13));
		label_5.setForeground(Color.LIGHT_GRAY);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_5);

		JPanel dubbingChB = new JPanel();
		panel.add(dubbingChB);
		dubbingChB.setLayout(new GridLayout(2, 1, 0, 3));

		dBCheckBox[0] = new JCheckBox("KOR");
		dubbingChB.add(dBCheckBox[0]);

		dBCheckBox[1] = new JCheckBox("ENG");
		dubbingChB.add(dBCheckBox[1]);

		dBCheckBox[2] = new JCheckBox("JAP");
		dubbingChB.add(dBCheckBox[2]);

		dBCheckBox[3] = new JCheckBox("CHI");
		dubbingChB.add(dBCheckBox[3]);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 348, 862, 69);
		getContentPane().add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnNewButton = new JButton("등 록");
		btnNewButton.setFont(new Font("굴림", Font.PLAIN, 13));
		panel_2.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("취 소");
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("굴림", Font.PLAIN, 13));

		// setSize(490,449);
		setBounds(525, 280, 878, 450);

//		setResizable(false);
		setVisible(true);

		btnNewButton.addMouseListener(new MouseRegisterL());

	}

	class MouseRegisterL implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			MediaInfo mi = new MediaInfo();

			mi.setMediaName(textField_0.getText());
			textField_0.setText("");

			mi.setMovieRatings(textField_1.getText());
			textField_1.setText("");

			mi.setRuningTime(textField_2.getText());
			textField_2.setText("");

			mi.setFilmDrector(textField_3.getText());
			textField_3.setText("");

			mi.setLeadActor(textField_4.getText());
			textField_4.setText("");

			mi.setGenre(String.valueOf(genreCB.getSelectedItem()));

			if (subCheckBox[0].isSelected()) 
				mi.setSubtitles("KOR");
				
			if (subCheckBox[1].isSelected()) 
				mi.setSubtitles(mi.getSubtitles()+"ENG");
				
			if (subCheckBox[2].isSelected()) 
				mi.setSubtitles(mi.getSubtitles()+"JAP");
				
			if (subCheckBox[3].isSelected()) 
				mi.setSubtitles(mi.getSubtitles()+"CHI");
				
			
			if (dBCheckBox[0].isSelected()) 
				mi.setDubbing("KOR");
				
			if (dBCheckBox[1].isSelected()) 
				mi.setDubbing(mi.getSubtitles()+"ENG");
				
			if (dBCheckBox[2].isSelected()) 
				mi.setDubbing(mi.getSubtitles()+"JAP");
				
			if (dBCheckBox[3].isSelected()) 
				mi.setDubbing(mi.getSubtitles()+"CHI");

			

			mi.setCountry(String.valueOf(countryCB.getSelectedItem()));
			
			mi.setReleaseYear(String.valueOf(countryCB.getSelectedItem()));
			
			pcount.prductCount++;
			
			System.out.println("작품등록이 완료되었습니다.");

			mSingleton.mediaInfo.add(mi);
			
			System.out.println(mSingleton.mediaInfo.get(0).getGenre());
			
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
