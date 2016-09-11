package mq.redis;

public class MqTest {

	public static byte[] redisKey = "mq".getBytes();

	static {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
        pop();
    }
 
    private static void pop() throws Exception {
    	while(true) {
	        byte[] bytes = RedisUtil.rpop(redisKey);
	        Message msg = (Message) MessageUtil.bytesToObject(bytes);
	        if(msg != null){
	            System.out.println(msg.getTitle()+"   "+msg.getInfo());
	        }
    	}
    }
 
    private static void init() throws Exception {
        Message msg1 = new Message("MQ", "内容1");
        RedisUtil.lpush(redisKey, MessageUtil.objectToBytes(msg1));
        Message msg2 = new Message("MQ", "内容2");
        RedisUtil.lpush(redisKey, MessageUtil.objectToBytes(msg2));
        Message msg3 = new Message("MQ", "内容3");
        RedisUtil.lpush(redisKey, MessageUtil.objectToBytes(msg3));
    }
	
}
