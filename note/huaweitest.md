#### 1. 括号合法性判断

给定一个只有'('和')'的字符串，判断其在语法逻辑上是否合法。


解答：这题用栈的方法，每遇到左括号进栈，遇到右括号则将左括号弹出，没得弹出则非法，最后判断栈不为空也非法。

还有一种方法：只要判断左括号和右括号的数目。用两个变量int a，b存储左右括号数。一个for循环遍历字符串，遇到左括号a++；遇到右括号b++。每次判断b是否大于a，若大于则不合法，结束（这一步是防止先出现右括号的情况，见下面童鞋的指正）。否则遍历结束后判断：若a==b，合法；若a！=b，不合法。
 
``` java
import java.util.Scanner;  
  
public class Main {  
    public static void main(String[] args) {  
        int a = 0;  
        int b = 0;  
        boolean valid = true;  
        Scanner in = new Scanner(System.in);  
        String str;  
        str = in.nextLine();  
        in.close();  
          
        char[] cArr = str.toCharArray();  
          
        for (int i = 0; i < cArr.length; i++) {  
              
            if(cArr[i]=='(')  
                a++;  
            if(cArr[i]==')')  
                b++;  
            if(b > a){  
                valid = false;  
                break;  
            }  
        }  
        if (a == b && valid)  
            System.out.println("valid");  
        else  
            System.out.println("invalid");  
    }  
  
}  
``` 

#### 2. 整数排序

输入一组大于等于0的整数，根据从大到小的顺序排序后输出；如果排序后有连续数时，只输出连续输的最大和最小数。输入的所有整数都各不相同，即不用考虑两个整数相同的情况。

如： 输入4,7,2,1,5,8,9,11

        输出11,9,7,5,4,2,1

 

解答：第一步当然是先排序，各种排序法都行。用 Java的话最方便啦，调用Arrays.sort(int[])，一步完成（当然这个是顺着排，输出的时候倒过来就行了）。接下来是去掉连续数的中间数 字。注意排序后数组的头和尾必然要输出的，于是循环从1：length-2，判断这些元素跟它前后的元素是否都相差1。

``` java
System.out.print(arr[length-1]+",");

for(i = arr.length - 2; i >0; i --){

if((arr[i] == arr[i+1] -1)&&arr[i] == arr[i-1] +1){

continue;

}

System.out.print(arr[i]+",");

}

System.out.print(arr[0]);
```
 

3.设计一个定时器管理系统，可以动态启动、停止定时器，并能根据已失去的时长自动调整剩余的时间。

运行时间限制：1Sec

内存限制：无限制

输入：启动定时器：starttimmer: ID, time

举例：

starttimmer: 1, 1000

启动一个定时器，其ID为1，定时时长time为1000ms

注：定时器ID用例保证非负整数，定时时长一定为正整数

 

停止定时器：stoptimmer: ID

举例：

stoptimmer: 1

停止一个ID为1的定时器

注：定时器ID用例保证非负整数，如果停止的定时器ID不存在，则忽略。

 

逝去时长：elapse: time

举例：

elapse: 1000

时间逝去1000ms

注：用例保证时长一定为正整数

 

输入结束

end

 

输出：

按启动顺序输出还没有停止的定时器，如ID为1的定时器还有1000ms才结束

timer: 1, 1000

如果所有定时器都停止了，输出none

none

 

样例输入：

starttimer: 1, 1000

starttimer: 2, 2000

elapse: 1000

end

样例输出：timer: 2,1000



``` java
import java.util.HashMap;  
import java.util.Iterator;  
import java.util.Scanner;  
  
public class Main {  
    static HashMap<String, Integer> timer = new HashMap<String, Integer>();  
    static boolean allStop = true; //所有定时器都停止的标志  
      
    public static void main(String[] args) {  
        Scanner in = new Scanner(System.in);  
        String str;  
        str = in.nextLine();  
        while (str != null) {  
            if (str.startsWith("starttimer:")) {  
                str = in.nextLine();  
                  
                String[] tmp = str.split("\\W+");//定时ID与定时时间分隔开  
                if (tmp.length < 2) { //判断不规范的输入  
                    System.out.println("invalid input format");  
                    break;  
                }  
                timer.put(tmp[0], Integer.parseInt(tmp[1])); //讲timer存入HashMap  
                str = in.nextLine();  
            }  
            if (str.startsWith("elapse:")){  
                str = in.nextLine();  
                  
                int elapse =  Integer.parseInt(str);  
                Iterator<String> it = timer.keySet().iterator();  
                while(it.hasNext()){  
                    String key = it.next();  
                    int rest = (Integer)timer.get(key) - elapse; //当前时间减去定时时长  
                    timer.put((String) key, rest); //重新存入HashMap  
                }  
                  
                str = in.nextLine();  
            }  
            if (str.startsWith("end")){  
                Iterator<String> it = timer.keySet().iterator();  
                  
                while(it.hasNext()){  
                    String key = it.next();  
                    if ((Integer)timer.get(key) > 0){//输出剩余时长大于0的定时器  
                        allStop = false;  
                        System.out.println("timer: "+ key +","+timer.get(key));  
                    }  
                      
                }  
                if(allStop){  
                    System.out.println("none");  
                }  
                break;  
            }                 
        }  
        in.close();  
    }  
}  
```