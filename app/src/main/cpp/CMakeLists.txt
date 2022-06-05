# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.2)

project("cproject")
set(rootpath ${CMAKE_CURRENT_SOURCE_DIR})

# 当前目录的所有文件添加到DIR_SRCS
aux_source_directory(. DIR_SRCS)
add_subdirectory(list)

#file(GLOB ALLHEADERS ${CMAKE_CURRENT_SOURCE_DIR}/commob/*.h)
include_directories(${CMAKE_CURRENT_SOURCE_DIR}/common)
#message( FATAL_ERROR ${CMAKE_CURRENT_SOURCE_DIR})

add_library(
        ${PROJECT_NAME}
        SHARED
        ${DIR_SRCS}
)

find_library(
        log-lib
        log)

target_link_libraries(
        ${PROJECT_NAME}
        LIST
#        ${ALLHEADERS}
        ${log-lib}
)
