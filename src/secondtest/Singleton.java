package secondtest;

import java.util.ArrayList;

public class Singleton {
	private static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;
	}
	
	StaticCode ct = new StaticCode();

	ArrayList<UserInfo> userInfo = new ArrayList<UserInfo>();

	ArrayList<MediaInfo> mediaInfo = new ArrayList<MediaInfo>();

	void randomRecommend(ArrayList<MediaInfo> ganreArry) {



		for (int i = 0; i < 300; i++) {
			ArrayList<MediaInfo> temp = new ArrayList<MediaInfo>();
			int random = (int) (Math.random() * ganreArry.size());
			temp.add(ganreArry.get(0));
			ganreArry.set(0, ganreArry.get(random));
			ganreArry.set(random, temp.get(0));
		}

	}

}
