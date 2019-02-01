package TestWait;

/**
 * @author stevenw
 * @date 2018/7/20
 */
public class WaitNotifyTest {

    // 在多线程间共享的对象上使用wait
    public static Boolean shareObj = true;

    public static void main(String[] args) {
        WaitNotifyTest test = new WaitNotifyTest();
        ThreadNotify threadNotify = new ThreadNotify();


    }


}
