package designpattern.adapter;

/**
 * 音频播放适配器
 * 当文件名为mp4时，使用高级音频播放器播放
 * @author FrankJiang
 */
public class MediaAdapter implements MediaPlayer {

	// 高级音频播放器
	private AdvanceMediaPlayer advanceMediaPlayer;
	
	public MediaAdapter(String type) {
		if (MediaType.TYPE_MP4.equals(type)) {
			advanceMediaPlayer = new Mp4MediaPlayer();
		} else if (MediaType.TYPE_RMVB.equals(type)) {
			advanceMediaPlayer = new RmvbMediaPlayer();
		}
	}
	
	@Override
	public void play(String type, String name) {
		if (MediaType.TYPE_MP4.equals(type)) {
			advanceMediaPlayer.play(name);
		} else if (MediaType.TYPE_RMVB.equals(type)) {
			advanceMediaPlayer.play(name);
		}
	}

}
