package designpattern.adapter;

/**
 * Mp4播放器
 * @author FrankJiang
 */
public class Mp4MediaPlayer implements AdvanceMediaPlayer {

	@Override
	public void play(String name) {
		System.out.println("----->播放Mp4文件：" + name);
	}

}
