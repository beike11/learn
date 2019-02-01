package TestWait;

/**
 * @author stevenw
 * @date 2018/7/20
 */
public class ThreadNotify implements Runnable{

    @Override
    public void run() {
        try {
            // 给等待线程等待时间
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (WaitNotifyTest.shareObj) {
            System.out.println("线程" + getCurrentThread().getName() + "开始准备通知");
            WaitNotifyTest.shareObj = false;
            WaitNotifyTest.shareObj.notifyAll();
            System.out.println("线程" + getCurrentThread().getName() + "通知结束");
        }
        System.out.println("线程" + getCurrentThread().getName() + "运行结束");
    }
    protected Thread getCurrentThread(){
        return Thread.currentThread();
    }
}
