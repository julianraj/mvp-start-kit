#MVP Start kit#

**Android project sample showing how to use MVP pattern.**

This sample project uses Dagger2, RxJava and Retrofit.

It maintains a separate gradle file (`dependencies.gradle`) for easy maintenance of 
dependencies and android versioning.

Also, generates the APK file with the naming convention of 

*${appName}-${appFlavour}-${versionName}.apk*

using `artifacts.gradle` file.

example: *MvpStartKit-release-0.0.1.apk*
