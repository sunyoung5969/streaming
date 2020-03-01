package secondtest;

public class FavoriteGenre implements Comparable<FavoriteGenre> {	// 선호하는 장르 정렬 클래스
	private String genreName;	//장르
	private int watched;		//시청횟수

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
	public int compareTo(FavoriteGenre favoriteGenre) {	// 정렬
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
