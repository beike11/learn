package TestWait;

/**
 * @author stevenw
 * @date 2018/7/20
 */
public class ThreadWait implements Runnable{
    private  String TheardName ;
    @Override
    public void run() {
        synchronized (WaitNotifyTest.shareObj) {
            while (WaitNotifyTest.shareObj) {
                System.out.println("线程"+ getCurrentThread().getName()+ "开始等待");
                long startTime = System.currentTimeMillis();
                try {
                    WaitNotifyTest.shareObj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                long endTime = System.currentTimeMillis();
                System.out.println("线程" + getCurrentThread().getName()
                        + "等待时间为：" + (endTime - startTime));
            }
        }
        System.out.println("线程" + getCurrentThread().getName() + "等待结束");
    }
    protected Thread getCurrentThread(){
        return Thread.currentThread();
    }
}
