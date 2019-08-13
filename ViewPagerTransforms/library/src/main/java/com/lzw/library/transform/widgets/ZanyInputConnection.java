package com.lzw.library.transform.widgets;

import android.view.KeyEvent;
import android.view.inputmethod.InputConnectionWrapper;

/**
 * Solve edit text delete(backspace) key detect, see<a href="http://stackoverflow.com/a/14561345/3790554">
 * Android: Backspace in WebView/BaseInputConnection</a>
 */
public class ZanyInputConnection extends InputConnectionWrapper {

    public ZanyInputConnection(android.view.inputmethod.InputConnection target, boolean mutable) {
        super(target, mutable);
    }

    @Override
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        // magic: in latest Android, deleteSurroundingText(1, 0) will be called for backspace
        if (beforeLength == 1 && afterLength == 0) {
            // backspace
            return sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL))
                    && sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
        }
        return super.deleteSurroundingText(beforeLength, afterLength);
    }
}