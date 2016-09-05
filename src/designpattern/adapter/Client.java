package designpattern.adapter;

/**
 * 适配器模式 客户类
 * @author FrankJiang
 */
public class Client {

	public static void main(String[] args) {
		String name1 = "Carry on till tomorrow.mp3";
		String type1 = "mp3";
		
		String name2 = "I believe i can fly.mp4";
		String type2 = "mp4";
		
		String name3 = "hero.rmvb";
		String type3 = "rmvb";
		
		MediaPlayer player = new MediaPlayerImpl();
		System.out.println(">>>>>>>>>>播放MP3");
		player.play(type1, name1);
		System.out.println(">>>>>>>>>>播放MP4");
		player.play(type2, name2);
		System.out.println(">>>>>>>>>>播放RMVB");
		player.play(type3, name3);
	}
}
