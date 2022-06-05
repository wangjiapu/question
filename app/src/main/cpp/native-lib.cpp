#include "c_main.h"
#include <jni.h>
#include <string>

using pu::CMain;
extern "C" JNIEXPORT jstring JNICALL
Java_com_pupu_question_MainActivity_cMain(JNIEnv *env, jobject) {
  CMain c_main;
  return env->NewStringUTF(c_main.Run().c_str());
}
