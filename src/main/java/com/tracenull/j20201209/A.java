package com.tracenull.j20201209;

/**
 * 一个JDK线程池BUG引发的GC机制思考
 * https://mp.weixin.qq.com/s/81qQI10005BSZN9mTwsw1g
 * https://stackoverflow.com/questions/24376768/can-java-finalize-an-object-when-it-is-still-in-scope
 */
class A {
    @Override
    protected void finalize() {
        System.out.println(this + " was finalized!");
    }

    public static void main(String[] args) throws InterruptedException {
        A a = new A();
        System.out.println("Created " + a);
        for (int i = 0; i < 1_000_000_000; i++) {
            if (i % 1_000_00 == 0)
                System.gc();
        }
        System.out.println("done.");
    }
}
