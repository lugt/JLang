// This file implements the native methods in sun.misc.Unsafe.
//
// Normally we are able to reuse Java native method implementations from the
// JDK, but the methods in sun.misc.Unsafe are really just markers for
// JVM intrinsics, and do not exist in a VM-independent way.
// So we re-implement them here.
#include <cstdio>
#include <cstdlib>
#include <jni.h>
#include "rep.h"
#include "stack_trace.h"
#include "unsafe.h"

// GCC built-in compare-and-swap.
#define CAS(ptr, e, x) __sync_val_compare_and_swap(ptr, e, x)

template <typename T>
static jboolean JavaCompareAndSwap(jobject obj, jlong offset, T e, T x) {
    auto raw_ptr = reinterpret_cast<char*>(obj) + offset;
    auto ptr = reinterpret_cast<T*>(raw_ptr);
    T prev = CAS(ptr, e, x);
    return prev == e;
}

[[noreturn]] static void UnsafeUnimplemented(const char* name) {
    fprintf(stderr,
        "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
        "The following sun.misc.Unsafe method is unimplemented:\n"
        "  %s\n"
        "It is defined in " __FILE__ ".\n"
        "Aborting for now.\n"
        "- - - - - - - - - - - - - - - - - - - - - - - - - - - -\n"
        , name);
    DumpStackTrace();
    abort();
}

static void WarnUnsafeUnimplemented(const char* name) {
    fprintf(stderr,
        "WARNING: sun.misc.Unsafe method %s is unimplemented, "
        "but will not abort.\n", name);
}

extern "C" {

void
Java_sun_misc_Unsafe_registerNatives(JNIEnv *env, jclass) {
    // Since we define all the native methods here with the proper names,
    // there's no need to register them explicitly.
}

jint
Java_sun_misc_Unsafe_getInt__Ljava_lang_Object_2J(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getInt__Ljava_lang_Object_2J");
}

void
Java_sun_misc_Unsafe_putInt__Ljava_lang_Object_2JI(JNIEnv *env, jobject, jobject, jlong, jint) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putInt__Ljava_lang_Object_2JI");
}

jobject
Java_sun_misc_Unsafe_getObject(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getObject");
}

void
Java_sun_misc_Unsafe_putObject(JNIEnv *env, jobject, jobject, jlong, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putObject");
}

jboolean
Java_sun_misc_Unsafe_getBoolean(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getBoolean");
}

void
Java_sun_misc_Unsafe_putBoolean(JNIEnv *env, jobject, jobject, jlong, jboolean) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putBoolean");
}

jbyte
Java_sun_misc_Unsafe_getByte__Ljava_lang_Object_2J(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getByte__Ljava_lang_Object_2J");
}

void
Java_sun_misc_Unsafe_putByte__Ljava_lang_Object_2JB(JNIEnv *env, jobject, jobject, jlong, jbyte) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putByte__Ljava_lang_Object_2JB");
}

jshort
Java_sun_misc_Unsafe_getShort__Ljava_lang_Object_2J(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getShort__Ljava_lang_Object_2J");
}

void
Java_sun_misc_Unsafe_putShort__Ljava_lang_Object_2JS(JNIEnv *env, jobject, jobject, jlong, jshort) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putShort__Ljava_lang_Object_2JS");
}

jchar
Java_sun_misc_Unsafe_getChar__Ljava_lang_Object_2J(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getChar__Ljava_lang_Object_2J");
}

void
Java_sun_misc_Unsafe_putChar__Ljava_lang_Object_2JC(JNIEnv *env, jobject, jobject, jlong, jchar) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putChar__Ljava_lang_Object_2JC");
}

jlong
Java_sun_misc_Unsafe_getLong__Ljava_lang_Object_2J(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getLong__Ljava_lang_Object_2J");
}

void
Java_sun_misc_Unsafe_putLong__Ljava_lang_Object_2JJ(JNIEnv *env, jobject, jobject, jlong, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putLong__Ljava_lang_Object_2JJ");
}

jfloat
Java_sun_misc_Unsafe_getFloat__Ljava_lang_Object_2J(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getFloat__Ljava_lang_Object_2J");
}

void
Java_sun_misc_Unsafe_putFloat__Ljava_lang_Object_2JF(JNIEnv *env, jobject, jobject, jlong, jfloat) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putFloat__Ljava_lang_Object_2JF");
}

jdouble
Java_sun_misc_Unsafe_getDouble__Ljava_lang_Object_2J(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getDouble__Ljava_lang_Object_2J");
}

void
Java_sun_misc_Unsafe_putDouble__Ljava_lang_Object_2JD(JNIEnv *env, jobject, jobject, jlong, jdouble) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putDouble__Ljava_lang_Object_2JD");
}

jbyte
Java_sun_misc_Unsafe_getByte__J(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getByte__J");
}

void
Java_sun_misc_Unsafe_putByte__JB(JNIEnv *env, jobject, jlong, jbyte) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putByte__JB");
}

jshort
Java_sun_misc_Unsafe_getShort__J(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getShort__J");
}

void
Java_sun_misc_Unsafe_putShort__JS(JNIEnv *env, jobject, jlong, jshort) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putShort__JS");
}

jchar
Java_sun_misc_Unsafe_getChar__J(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getChar__J");
}

void
Java_sun_misc_Unsafe_putChar__JC(JNIEnv *env, jobject, jlong, jchar) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putChar__JC");
}

jint
Java_sun_misc_Unsafe_getInt__J(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getInt__J");
}

void
Java_sun_misc_Unsafe_putInt__JI(JNIEnv *env, jobject, jlong, jint) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putInt__JI");
}

jlong
Java_sun_misc_Unsafe_getLong__J(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getLong__J");
}

void
Java_sun_misc_Unsafe_putLong__JJ(JNIEnv *env, jobject, jlong, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putLong__JJ");
}

jfloat
Java_sun_misc_Unsafe_getFloat__J(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getFloat__J");
}

void
Java_sun_misc_Unsafe_putFloat__JF(JNIEnv *env, jobject, jlong, jfloat) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putFloat__JF");
}

jdouble
Java_sun_misc_Unsafe_getDouble__J(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getDouble__J");
}

void
Java_sun_misc_Unsafe_putDouble__JD(JNIEnv *env, jobject, jlong, jdouble) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putDouble__JD");
}

jlong
Java_sun_misc_Unsafe_getAddress(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getAddress");
}

void
Java_sun_misc_Unsafe_putAddress(JNIEnv *env, jobject, jlong, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putAddress");
}

jlong
Java_sun_misc_Unsafe_allocateMemory(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_allocateMemory");
}

jlong
Java_sun_misc_Unsafe_reallocateMemory(JNIEnv *env, jobject, jlong, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_reallocateMemory");
}

void
Java_sun_misc_Unsafe_setMemory(JNIEnv *env, jobject, jobject, jlong, jlong, jbyte) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_setMemory");
}

void
Java_sun_misc_Unsafe_copyMemory(JNIEnv *env, jobject, jobject, jlong, jobject, jlong, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_copyMemory");
}

void
Java_sun_misc_Unsafe_freeMemory(JNIEnv *env, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_freeMemory");
}

jlong
Java_sun_misc_Unsafe_staticFieldOffset(JNIEnv *env, jobject, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_staticFieldOffset");
}

jlong
Java_sun_misc_Unsafe_objectFieldOffset(JNIEnv *env, jobject, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_objectFieldOffset");
}

jobject
Java_sun_misc_Unsafe_staticFieldBase(JNIEnv *env, jobject, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_staticFieldBase");
}

jboolean
Java_sun_misc_Unsafe_shouldBeInitialized(JNIEnv *env, jobject, jclass) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_shouldBeInitialized");
}

void
Java_sun_misc_Unsafe_ensureClassInitialized(JNIEnv *env, jobject, jclass) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_ensureClassInitialized");
}

jint
Java_sun_misc_Unsafe_arrayBaseOffset(
        JNIEnv *env, jobject unsafe, jclass cls) {
    jarray arr = nullptr;
    auto ptr = Unwrap(arr)->Data();
    auto offset = reinterpret_cast<intptr_t>(ptr);
    return static_cast<jint>(offset);
}

jint
Java_sun_misc_Unsafe_arrayIndexScale(JNIEnv *env, jobject, jclass) {
    WarnUnsafeUnimplemented("Java_sun_misc_Unsafe_arrayIndexScale");
    return 0;
}

jint
Java_sun_misc_Unsafe_addressSize(JNIEnv *env, jobject) {
    return sizeof(intptr_t);
}

jint
Java_sun_misc_Unsafe_pageSize(JNIEnv *env, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_pageSize");
}

jclass
Java_sun_misc_Unsafe_defineClass__Ljava_lang_String_2_3BIILjava_lang_ClassLoader_2Ljava_security_ProtectionDomain_2(JNIEnv *env, jobject, jstring, jbyteArray, jint, jint, jobject, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_defineClass__Ljava_lang_String_2_3BIILjava_lang_ClassLoader_2Ljava_security_ProtectionDomain_2");
}

jclass
Java_sun_misc_Unsafe_defineClass__Ljava_lang_String_2_3BII(JNIEnv *env, jobject, jstring, jbyteArray, jint, jint) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_defineClass__Ljava_lang_String_2_3BII");
}

jclass
Java_sun_misc_Unsafe_defineAnonymousClass(JNIEnv *env, jobject, jclass, jbyteArray, jobjectArray) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_defineAnonymousClass");
}

jobject
Java_sun_misc_Unsafe_allocateInstance(JNIEnv *env, jobject, jclass) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_allocateInstance");
}

void
Java_sun_misc_Unsafe_monitorEnter(JNIEnv *env, jobject, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_monitorEnter");
}

void
Java_sun_misc_Unsafe_monitorExit(JNIEnv *env, jobject, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_monitorExit");
}

jboolean
Java_sun_misc_Unsafe_tryMonitorEnter(JNIEnv *env, jobject, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_tryMonitorEnter");
}

void
Java_sun_misc_Unsafe_throwException(JNIEnv *env, jobject, jthrowable) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_throwException");
}

jboolean
Java_sun_misc_Unsafe_compareAndSwapObject(
    JNIEnv *env, jobject unsafe,
    jobject obj, jlong offset, jobject e, jobject x
) {
    return JavaCompareAndSwap(obj, offset, e, x);
}

jboolean
Java_sun_misc_Unsafe_compareAndSwapInt(
    JNIEnv *env, jobject unsafe,
    jobject obj, jlong offset, jint e, jint x
) {
    return JavaCompareAndSwap(obj, offset, e, x);
}

jboolean
Java_sun_misc_Unsafe_compareAndSwapLong(
    JNIEnv *env, jobject unsafe,
    jobject obj, jlong offset, jlong e, jlong x
) {
    return JavaCompareAndSwap(obj, offset, e, x);
}

jobject
Java_sun_misc_Unsafe_getObjectVolatile(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getObjectVolatile");
}

void
Java_sun_misc_Unsafe_putObjectVolatile(JNIEnv *env, jobject, jobject, jlong, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putObjectVolatile");
}

jint
Java_sun_misc_Unsafe_getIntVolatile(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getIntVolatile");
}

void
Java_sun_misc_Unsafe_putIntVolatile(JNIEnv *env, jobject, jobject, jlong, jint) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putIntVolatile");
}

jboolean
Java_sun_misc_Unsafe_getBooleanVolatile(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getBooleanVolatile");
}

void
Java_sun_misc_Unsafe_putBooleanVolatile(JNIEnv *env, jobject, jobject, jlong, jboolean) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putBooleanVolatile");
}

jbyte
Java_sun_misc_Unsafe_getByteVolatile(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getByteVolatile");
}

void
Java_sun_misc_Unsafe_putByteVolatile(JNIEnv *env, jobject, jobject, jlong, jbyte) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putByteVolatile");
}

jshort
Java_sun_misc_Unsafe_getShortVolatile(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getShortVolatile");
}

void
Java_sun_misc_Unsafe_putShortVolatile(JNIEnv *env, jobject, jobject, jlong, jshort) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putShortVolatile");
}

jchar
Java_sun_misc_Unsafe_getCharVolatile(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getCharVolatile");
}

void
Java_sun_misc_Unsafe_putCharVolatile(JNIEnv *env, jobject, jobject, jlong, jchar) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putCharVolatile");
}

jlong
Java_sun_misc_Unsafe_getLongVolatile(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getLongVolatile");
}

void
Java_sun_misc_Unsafe_putLongVolatile(JNIEnv *env, jobject, jobject, jlong, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putLongVolatile");
}

jfloat
Java_sun_misc_Unsafe_getFloatVolatile(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getFloatVolatile");
}

void
Java_sun_misc_Unsafe_putFloatVolatile(JNIEnv *env, jobject, jobject, jlong, jfloat) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putFloatVolatile");
}

jdouble
Java_sun_misc_Unsafe_getDoubleVolatile(JNIEnv *env, jobject, jobject, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getDoubleVolatile");
}

void
Java_sun_misc_Unsafe_putDoubleVolatile(JNIEnv *env, jobject, jobject, jlong, jdouble) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putDoubleVolatile");
}

void
Java_sun_misc_Unsafe_putOrderedObject(JNIEnv *env, jobject, jobject, jlong, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putOrderedObject");
}

void
Java_sun_misc_Unsafe_putOrderedInt(JNIEnv *env, jobject, jobject, jlong, jint) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putOrderedInt");
}

void
Java_sun_misc_Unsafe_putOrderedLong(JNIEnv *env, jobject, jobject, jlong, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_putOrderedLong");
}

void
Java_sun_misc_Unsafe_unpark(JNIEnv *env, jobject, jobject) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_unpark");
}

void
Java_sun_misc_Unsafe_park(JNIEnv *env, jobject, jboolean, jlong) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_park");
}

jint
Java_sun_misc_Unsafe_getLoadAverage(JNIEnv *env, jobject, jdoubleArray, jint) {
    UnsafeUnimplemented("Java_sun_misc_Unsafe_getLoadAverage");
}

} // extern "C"