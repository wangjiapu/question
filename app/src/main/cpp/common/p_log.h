
#pragma once

#include "android/log.h"
#include <string>

#ifndef PLOG_PRI
#define PLOG_PRI(priority, tag, ...) __android_log_print(priority, tag, __VA_ARGS__)
#endif // LOG_PRI

#ifndef PLOGD
#define PLOGD(tag,...) PLOG_PRI(ANDROID_LOG_DEBUG, tag, __VA_ARGS__)
#endif // ALOG

//#ifndef PLOGD
//#if NDK_DEBUG
//#define PLOGD(...) ((void)PLOG(LOG_DEBUG, LOG_TAG, __VA_ARGS__))
//#else
//#define PLOGD(...) ((void)0)
//#endif // NDK_DEBUG
//#endif // ALOGD
