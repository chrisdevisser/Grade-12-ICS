package u2a4_chrisdevisser_students;

import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.win32.StdCallLibrary;

public interface Gdi32 extends StdCallLibrary { //for gdi32.dll
    Pointer CreateEllipticRgn(int nLeftRect, int nTopRect, int nRightRect, int nBottomRect);

    static Gdi32 INSTANCE = (Gdi32)Native.loadLibrary("gdi32", Gdi32.class);
}