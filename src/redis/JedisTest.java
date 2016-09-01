package redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;

public class JedisTest {

	public static void main(String[] args) {
		System.out.println("-----------Connect-----------");
		Jedis jedis = new Jedis("115.159.221.50", 6379);
		System.out.println("Status: " + jedis.ping());
		System.out.println("Name:" + jedis.get("name"));
		
		System.out.println("-----------String------------");
		// redis String
		jedis.set("age", "24");
		System.out.println("Age:" + jedis.get("age"));
		
		// redis list
		System.out.println("-----------List------------");
		jedis.lpush("majorlist", "Java");
		jedis.lpush("majorlist", "sql");
		jedis.lpush("majorlist", "c");
		
		List<String> majorList = jedis.lrange("majorlist", 0, 10);
		for (int i = 0; i < majorList.size(); i++) {
			System.out.println("MajorList:" + majorList.get(i));
		}
		
		// redis get all 
		System.out.println("-----------All Key------------");
		Set<String> keyList = jedis.keys("*");
		for (String key : keyList) {
			System.out.println("----->" + key);
		}
		jedis.disconnect();
	}
}
