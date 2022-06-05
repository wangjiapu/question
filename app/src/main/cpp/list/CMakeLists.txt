# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

#message(FATAL_ERROR ${rootpath})

aux_source_directory(. list_file)
include_directories(${rootpath}/common list)

add_library(LIST ${list_file})
