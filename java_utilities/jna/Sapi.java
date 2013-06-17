package java_utilities.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.WString;

/**
 * Implements interface for SAPI32.dll and SAPI64.dll
 *
 * @author Chris DeVisser
 */
interface SapiImpl extends Library {
    /**
     * Speaks the given text aloud.
     *
     * @param text The text to speak
     * @return A value indicating success (0) or failure
     */
    public int Speak(WString text);
}

public class Sapi {
    /**
     * Holds the text to speak.
     */
    private static String _text;

    /**
     * Holds the thread implementation.
     */
    private static Runnable _threadImpl = new Runnable() {
        public void run() {
            SapiImpl sapi;

            try {
                sapi = (SapiImpl)Native.loadLibrary("SAPI32", SapiImpl.class);
            } catch (UnsatisfiedLinkError ex) {
                sapi = (SapiImpl)Native.loadLibrary("SAPI64", SapiImpl.class);
            }

            sapi.Speak(new WString(_text));
        }
    };

    /**
     * Holds the thread to use to run the implementation.
     */
    private static Thread _thread = new Thread();

    /**
     * Speaks text aloud.
     *
     * @param text The text to speak
     * @return True if the function was able to speak. False if there was a
     * previous operation or an error.
     */
    public static boolean Speak(String text) {
        try {
			if (!_thread.isAlive()) {
				_text = (text == null) ? "" : text;
				_thread = new Thread(_threadImpl);
				_thread.start();
				return true;
			}
		} catch (UnsatisfiedLinkError ex) {
        } catch (Exception ex) {}

        return false;
    }

    /**
     * Disables creation of utility class.
     */
    private Sapi(){}
}