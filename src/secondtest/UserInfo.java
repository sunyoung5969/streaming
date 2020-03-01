package secondtest;

import javax.swing.DefaultComboBoxModel;

public class UserInfo {
	private int membership;
	private String name;
	private String birthdate;
	private String id;
	private String pw;
	private String emailid;
	private String emailpw;
	private int identity;
	private String[] genre = { id, "SF", "액션", "미스터리", "스릴러", "공포", "드라마", "멜로", "코미디", "애니메이션" };
							//"SF-1", "액션-2", "미스터리-3", "스릴러-4", "공포-5", "드라마-6","멜로-7", "코미디-8", "애니메이션-9"
	
	private int[] watched = {0,0,0,0,0,0,0,0,0,0};

	public void Userinfo() {
		// TODO Auto-generated method stub
		membership =0; name = ""; birthdate = ""; 
		id = ""; pw = ""; emailid = ""; emailpw = "";
		identity = 0;
	}


	public int getIdentity() {
		return identity;
	}


	public void setIdentity(int identity) {
		this.identity = identity;
	}


	public int getMembership() {
		return membership;
	}

	public void setMembership(int membership) {
		this.membership = membership;
	}

	public String getGenre(int index) {
	
		return genre[index];
	}

	public void setGenre(int index, String genre) {
		this.genre[index] = genre;
	}

	public int getWatched(int index) {
		return watched[index];
	}

	public void setWatched(int index, int watched) {
		this.watched[index] = watched;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getEmailpw() {
		return emailpw;
	}

	public void setEmailpw(String emailpw) {
		this.emailpw = emailpw;
	}
}
