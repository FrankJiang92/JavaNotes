package designpattern.adapter;

/**
 * 音频播放器，只能播放mp3文件
 * @author FrankJiang
 */
public interface MediaPlayer {

	public void play(String type, String name);
	
}
