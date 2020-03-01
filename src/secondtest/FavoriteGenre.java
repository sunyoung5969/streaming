package secondtest;

public class FavoriteGenre implements Comparable<FavoriteGenre> {	// ��ȣ�ϴ� �帣 ���� Ŭ����
	private String genreName;	//�帣
	private int watched;		//��ûȽ��

	public FavoriteGenre(String genreName, int watched) {
		this.genreName = genreName;
		this.watched = watched;
	}

	public String getGenreName() {
		return genreName;
	}

	public void setGenreName(String genreName) {
		this.genreName = genreName;
	}

	public int getWatched() {
		return watched;
	}

	public void setWatched(int watched) {
		this.watched = watched;
	}

	@Override
	public int compareTo(FavoriteGenre favoriteGenre) {	// ����
		// TODO Auto-generated method stub
		if (this.watched < favoriteGenre.watched) {
			return -1;
		} else if (this.watched == favoriteGenre.watched) {
			return 0;
		} else {
			return 1;
		}
	}
}
