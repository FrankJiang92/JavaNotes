package designpattern.adapter;

/**
 * 普通音频播放器实现类
 * 若为mp3文件，直接播放
 * 若为mp4文件，使用适配器进行播放
 * @author FrankJiang
 */
public class MediaPlayerImpl implements MediaPlayer {

	@Override
	public void play(String type, String name) {
		if (MediaType.TYPE_MP3.equals(type)) {
			// mp3文件，直接播放
			System.out.println("----->播放Mp3文件：" + name );
		} else {
			// 非mp3文件，交给适配器处理
			MediaAdapter adapter = new MediaAdapter(type);
			adapter.play(type, name);
		}
		
	}
	

}
