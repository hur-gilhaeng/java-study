package chapter03;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int track;
	private int year;
	
	public Song() {
		System.out.println("곡 입력 완료!!");
	}
	public Song(String artist,String title) {
		this();
		this.title = title;
		this.artist = artist;
	}
	public Song(String artist,String title,String album,int year,int track,String composer) {
		this();
		this.title = title;
		this.artist = artist;
		this.album = album;
		this.year = year;
		this.track = track;
		this.composer = composer;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	public int getTrack() {
		return track;
	}
	public void setTrack(int track) {
		this.track = track;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	public void show() {
		System.out.println(
				artist+" "+
				title+" ("+
				album+","+
				year+","+
				track+"번 track,"+
				composer+"작곡)"
				);
	}
}
