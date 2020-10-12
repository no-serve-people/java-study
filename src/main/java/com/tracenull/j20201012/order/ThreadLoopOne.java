package com.tracenull.j20201012.order;

/**
 * https://mp.weixin.qq.com/s/BTUZM32NwmAywjsuiX_Xvg
 * Thread Join
 */
public class ThreadLoopOne {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Work(null));
        Thread t2 = new Thread(new Work(t1));
        Thread t3 = new Thread(new Work(t2));
        t1.start();
        t2.start();
        t3.start();
    }

    static class Work implements Runnable {
        private Thread beforeThread;

        public Work(Thread beforeThread) {
            this.beforeThread = beforeThread;
        }


        @Override
        public void run() {
            // 如果有线程,就 join 进来,没有的话就直接输出
            if (beforeThread != null) {
                try {
                    beforeThread.join();
                    System.out.println("thread start : " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("thread start : " + Thread.currentThread().getName());
            }
        }
    }

}

