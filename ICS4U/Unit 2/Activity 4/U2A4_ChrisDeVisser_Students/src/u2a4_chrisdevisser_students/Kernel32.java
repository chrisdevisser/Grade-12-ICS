package u2a4_chrisdevisser_students;

import com.sun.jna.Native;
import com.sun.jna.win32.StdCallLibrary;

public interface Kernel32 extends StdCallLibrary { //for kernel32.dll
    int GetCurrentProcessId();

    static Kernel32 INSTANCE = (Kernel32)Native.loadLibrary("kernel32", Kernel32.class);
}