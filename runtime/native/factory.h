// Provides methods to construct common Java objects
// needed by native code. These factory methods directly
// dispatch to symbols compiled from Java code in
// polyllvm.runtime.Factory.
#pragma once

#include "jni.h"

// Arrays.
jbooleanArray CreateJavaBooleanArray(jint len);
jbyteArray    CreateJavaByteArray   (jint len);
jcharArray    CreateJavaCharArray   (jint len);
jshortArray   CreateJavaShortArray  (jint len);
jintArray     CreateJavaIntArray    (jint len);
jlongArray    CreateJavaLongArray   (jint len);
jfloatArray   CreateJavaFloatArray  (jint len);
jdoubleArray  CreateJavaDoubleArray (jint len);

// Strings.
jstring CreateJavaString(jcharArray chars);