package com.wb.pattern.observer.subject;

import com.wb.pattern.observer.core.Event;
import com.wb.pattern.observer.core.IEventLisenter;

import java.lang.reflect.Method;

/**
 * @author wangbo
 * @since 2019/11/7 11:18
 */
public class ObServerTest {
    public static void main(String[] args) {
        try {
            // 观察者
            ObServer obServer = new ObServer();
            Method advice = ObServer.class.getMethod("advice", new Class[]{Event.class});

            // 被观察者
            ISubject subject = (ISubject) new SubjectProxy().newProxyInstance(new Subject());
            System.out.println(subject.getClass());
            System.out.println((IEventLisenter)subject);
            IEventLisenter subject2 = (IEventLisenter)subject;
            subject2.addLisenter(SubjectEventType.ON_ADD,obServer,advice);
            subject2.addLisenter(SubjectEventType.ON_REMOVE,obServer,advice);
            subject2.addLisenter(SubjectEventType.ON_EDIT,obServer,advice);
            subject2.addLisenter(SubjectEventType.ON_QUERY,obServer,advice);

            subject.add();
            subject.remove();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
