package u2a4_chrisdevisser_students;

import com.sun.jna.NativeLong;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.IntByReference;
import javax.swing.JFrame;

class Winapi {
    //retrieve handle to frame
    public static Pointer getHwndFromFrame(final JFrame frame) {
        //WARNING: UGLY HACK
        //I need it to be final to access it, but need to modify it
        final Pointer[] ret = new Pointer[1];

        //procedure for enumerating windows
        User32.WNDENUMPROC enumProc = new User32.WNDENUMPROC() {
            public boolean invoke(Pointer hwnd, NativeLong lParam) {
                //get process id of current window in enumeration
                IntByReference hwndPid = new IntByReference();
                User32.INSTANCE.GetWindowThreadProcessId(hwnd, hwndPid);

                //get title characters
                byte[] title = new byte[256];
                User32.INSTANCE.GetWindowTextA(hwnd, title, 100000);

                //turn them into a string
                String hwndTitle = new String(title);

                //cut off string at null character
                hwndTitle = hwndTitle.substring(0, hwndTitle.indexOf(0));

                //check if window has same PID as this process and if title matches
                if (hwndPid.getValue() == Kernel32.INSTANCE.GetCurrentProcessId() && hwndTitle.equals(frame.getTitle())) {
                     ret[0] = hwnd;
                     return false;
                }

                return true;
            }
        };

        //true means it never got stopped by the procedure => no window found
        if (User32.INSTANCE.EnumWindows(enumProc, null)) {
            return Pointer.NULL;
        }

        return ret[0];
    }

    //set window region to ellipse
    public static boolean makeWindowElliptical(Pointer hwnd, int left, int top, int right, int bottom) {
        Pointer rgn = Gdi32.INSTANCE.CreateEllipticRgn(left, top, right, bottom);

        if (rgn == Pointer.NULL) {
            return false;
        }

        return User32.INSTANCE.SetWindowRgn(hwnd, rgn, true) != 0;
    }
}
