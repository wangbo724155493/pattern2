package com.wb.pattern.observer.mouse;

import java.lang.reflect.Method;

/**
 * @author wangbo
 * @since 2019/11/7 14:41
 */
public class MouseTest {
    public static void main(String[] args) throws NoSuchMethodException {

        Mouse mouse = new Mouse();

        mouse.click();
        mouse.doubelClick();

        MouseCallback mouseCallback = new MouseCallback();
        Method method = MouseCallback.class.getMethod("onDoubleClick", null);
        mouse.addLisenter(MouseEventType.ON_DOUBLE_CLICK,mouseCallback,method);

        mouse.click();
        mouse.doubelClick();
    }
}
