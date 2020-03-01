package secondtest;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MediaInfo extends JFrame { // 작품 정보 껍데기 클래스
	
	private String mediaName;	private String movieRatings;
	private String runingTime;	private String filmDrector;
	private String leadActor;	private String imageName;
	private String country;		private String releaseYear;
	private String genre;		private String subtitles;
	private String dubbing;

	
	MediaInfo() {
		mediaName = "";		movieRatings = "";
		runingTime = "";	filmDrector = "";
		leadActor = "";		imageName ="";
		country = "";		releaseYear = "";
		genre = "";			subtitles = "";
		dubbing = "";
	}


	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getMovieRatings() {
		return movieRatings;
	}

	public void setMovieRatings(String movieRatings) {
		this.movieRatings = movieRatings;
	}

	public String getRuningTime() {
		return runingTime;
	}

	public void setRuningTime(String runingTime) {
		this.runingTime = runingTime;
	}

	public String getFilmDrector() {
		return filmDrector;
	}

	public void setFilmDrector(String filmDrector) {
		this.filmDrector = filmDrector;
	}

	public String getLeadActor() {
		return leadActor;
	}

	public void setLeadActor(String leadActor) {
		this.leadActor = leadActor;
	}

	public String getSubtitles() {
		return subtitles;
	}

	public void setSubtitles(String subtitles) {
		this.subtitles = subtitles;
	}

	public String getDubbing() {
		return dubbing;
	}

	public void setDubbing(String dubbing) {
		this.dubbing = dubbing;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getReleaseYear() {
		return releaseYear;
	}

	public void setReleaseYear(String releaseYear) {
		this.releaseYear = releaseYear;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}
