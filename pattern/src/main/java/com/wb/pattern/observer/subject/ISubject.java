package com.wb.pattern.observer.subject;

import com.wb.pattern.observer.core.Event;

/**
 * @author wangbo
 * @since 2019/11/7 11:35
 */
public interface ISubject {

    Event add();

    Event remove();
}
