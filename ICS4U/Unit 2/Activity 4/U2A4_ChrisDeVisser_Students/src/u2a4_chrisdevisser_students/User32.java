package u2a4_chrisdevisser_students;

import com.sun.jna.Native;
import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.win32.StdCallLibrary;

public interface User32 extends StdCallLibrary { //for user32.dll
    interface WNDENUMPROC extends StdCallCallback {
        public boolean invoke(Pointer hwnd, NativeLong lParam);
    }

    int GetWindowThreadProcessId(Pointer hWnd, IntByReference lpdwProcessId);
    boolean EnumWindows(WNDENUMPROC lpfn, NativeLong lParam);
    int SetWindowRgn(Pointer hWnd, Pointer hRgn, boolean bRedraw);
    int GetWindowTextA(Pointer hWnd, byte[] lpString, int nMaxCount);

    static User32 INSTANCE = (User32)Native.loadLibrary("user32", User32.class);
}