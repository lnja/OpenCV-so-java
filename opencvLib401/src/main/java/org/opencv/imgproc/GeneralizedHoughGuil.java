//
// This file is auto-generated. Please don't modify it!
//
package org.opencv.imgproc;

// C++: class GeneralizedHoughGuil
//javadoc: GeneralizedHoughGuil

public class GeneralizedHoughGuil extends GeneralizedHough {

    protected GeneralizedHoughGuil(long addr) {
        super(addr);
    }

    // internal usage only
    public static GeneralizedHoughGuil __fromPtr__(long addr) {
        return new GeneralizedHoughGuil(addr);
    }

    // native support for java finalize()
    private static native void delete(long nativeObj);

    @Override
    protected void finalize() throws Throwable {
        delete(nativeObj);
    }

}
