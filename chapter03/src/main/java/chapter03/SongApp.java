package chapter03;

public class SongApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Song song = new Song();
		song.setArtist("아이유");
		song.setTitle("좋은날");
		song.setAlbum("Real");
		song.setYear(2013);
		song.setTrack(3);
		song.setComposer("이민수");
		
		song.show();
		
		System.out.println(Global.global);
		Global.globalFunc();
		
		Song song2 = new Song("아이유","분홍신",null,0,0,null);
		Song song3 = new Song("이승기","내여자니까");
		
		song2.show();
		song3.show();
	}

	public static void globalTest() {
		System.out.println(Global.global);
	}

}
