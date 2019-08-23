/*
* 四川生学教育科技有限公司
* Copyright (c) 2015-2025 Founder Ltd. All Rights Reserved.
*
* This software is the confidential and proprietary information of
* Founder. You shall not disclose such Confidential Information
* and shall use it only in accordance with the terms of the agreements
* you entered into with Founder.
*
*/

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * @author WUANG (wa@sxw.cn)
 * @description TestFinalize
 * @date 2019/8/23 14:21
 * @slogon 站在巨人的肩膀上
 * @since 3.0.0
 */
public class TestFinalize {

    public static void main(String[] args) throws InterruptedException {
        Test1 counter = new Test1();
        ReferenceQueue refQueue = new ReferenceQueue<>();
        Reference<Test1> p = new PhantomReference<>(counter, refQueue);
        System.out.println("size: " + refQueue.poll());
        counter = null;
//        System.out.println(p.get());
        System.out.println("size: " + refQueue.poll());
        System.gc();//一个不可达的对象，gc后就会放引用队列（gc帮我们放）；如果实现了finalize，Finalizer执行时会把入队的引用remove掉（显示调用remove方法）
        while (refQueue.poll() == null){}
        System.out.println("size: " + refQueue.poll());
        try {
            // Remove 是一个阻塞方法，可以指定 timeout，或者选择一直阻塞
            Reference<Test1> ref = refQueue.remove(1000L);
            if (ref != null) {
                System.out.println(ref);
            }
            System.out.println(ref == p);
        } catch (InterruptedException e) {
            // Handle it
            System.out.println(e);
        }

    }
}
class Test1{
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalized");
    }
}