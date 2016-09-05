package designpattern.adapter;

/**
 * Rmvb媒体播放器，播放rmvb文件
 * @author FrankJiang
 */
public class RmvbMediaPlayer implements AdvanceMediaPlayer {

	@Override
	public void play(String name) {
		System.out.println("----->播放Rmvb文件：" + name);
	}

}
