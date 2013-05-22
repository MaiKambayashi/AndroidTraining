90201703n:TestTargetSample mai.kambayashi$ ant debug install test
Buildfile: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/build.xml

-set-mode-check:

-set-debug-files:

-check-env:
 [checkenv] Android SDK Tools Revision 21.1.0
 [checkenv] Installed at /Users/mai.kambayashi/Documents/sdk

-setup:
     [echo] Project Name: Sample
  [gettype] Project Type: Application

-set-debug-mode:

-debug-obfuscation-check:

-pre-build:

-build-setup:
     [echo] Resolving Build Target for Sample...
[gettarget] Project Target:   Android 4.2.2
[gettarget] API level:        17
     [echo] ----------
     [echo] Creating output directories if needed...
    [mkdir] Created dir: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/dexedLibs
     [echo] ----------
     [echo] Resolving Dependencies for Sample...
[dependency] Library dependencies:
[dependency] No Libraries
     [echo] ----------
     [echo] Building Libraries with 'debug'...
   [subant] No sub-builds to iterate on

-code-gen:
[mergemanifest] Merging AndroidManifest files into one.
[mergemanifest] Manifest merger disabled. Using project manifest only.
     [echo] Handling aidl files...
     [aidl] No AIDL files to compile.
     [echo] ----------
     [echo] Handling RenderScript files...
[renderscript] No RenderScript files to compile.
     [echo] ----------
     [echo] Handling Resources...
     [aapt] Generating resource IDs...
     [echo] ----------
     [echo] Handling BuildConfig class...
[buildconfig] Generating BuildConfig class.

-pre-compile:

-compile:
    [javac] Compiling 2 source files to /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/classes

-post-compile:

-obfuscate:

-dex:
      [dex] input: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/classes
      [dex] input: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/libs/android-support-v4.jar
      [dex] Pre-Dexing /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/libs/android-support-v4.jar -> android-support-v4-57b4e1d81bb17d401e0b58b163bc535d.jar
      [dex] Converting compiled files and external libraries into /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/classes.dex...
       [dx] Merged dex A (22 defs/14.5KiB) with dex B (316 defs/355.2KiB). Result is 338 defs/451.1KiB. Took 0.2s

-crunch:
   [crunch] Crunching PNG Files in source dir: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/res
   [crunch] To destination dir: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/res
   [crunch] Processing image to cache: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/res/drawable-hdpi/ic_launcher.png => /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/res/drawable-hdpi/ic_launcher.png
   [crunch]   (processed image to cache entry /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/res/drawable-hdpi/ic_launcher.png: 53% size of source)
   [crunch] Processing image to cache: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/res/drawable-mdpi/ic_launcher.png => /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/res/drawable-mdpi/ic_launcher.png
   [crunch]   (processed image to cache entry /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/res/drawable-mdpi/ic_launcher.png: 0% size of source)
   [crunch] Processing image to cache: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/res/drawable-xhdpi/ic_launcher.png => /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/res/drawable-xhdpi/ic_launcher.png
   [crunch]   (processed image to cache entry /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/res/drawable-xhdpi/ic_launcher.png: 65% size of source)
   [crunch] Processing image to cache: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/res/drawable-xxhdpi/ic_launcher.png => /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/res/drawable-xxhdpi/ic_launcher.png
   [crunch]   (processed image to cache entry /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/res/drawable-xxhdpi/ic_launcher.png: 66% size of source)
   [crunch] Crunched 4 PNG files to update cache

-package-resources:
     [aapt] Creating full resource package...

-package:
[apkbuilder] Current build type is different than previous build: forced apkbuilder run.
[apkbuilder] Creating Sample-debug-unaligned.apk and signing it with a debug key...

-post-package:

-do-debug:
 [zipalign] Running zip align on final apk...
     [echo] Debug Package: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/Sample-debug.apk
[propertyfile] Creating new property file: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/build.prop
[propertyfile] Updating property file: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/build.prop
[propertyfile] Updating property file: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/build.prop
[propertyfile] Updating property file: /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/build.prop

-post-build:

debug:

install:
     [echo] Installing /Users/mai.kambayashi/AndroidTraining/projects/fundamentals/11th/TestTargetSample/bin/Sample-debug.apk onto default emulator or device...
     [exec] error: device not found
     [exec] - waiting for device -
     [exec] rm failed for /data/local/tmp/Sample-debug.apk, No such file or directory

BUILD FAILED
/Users/mai.kambayashi/Documents/sdk/tools/ant/build.xml:1353: The following error occurred while executing this line:
/Users/mai.kambayashi/Documents/sdk/tools/ant/build.xml:1367: exec returned: 1

Total time: 2 minutes 24 seconds
Practice Report for 3.1
------

実習のレポートを下記に記述してください

デバッグ

1. (実習) 実習プロジェクト`DebugPractice`をビルド・インストールし、起動してから画面が立ち上がるまでのメソッドのプロファイリングを実行し、どのメソッドに時間がかかっているかレポートしてください。


【起動してから画面が立ち上がるまでで時間がかかっているメソッドのレポート】
1 : 27.2% jp/co/canonsoftware/android/emoji/AnimatedEmojiFactory.nativeCheckEmojiUnicode
2 : 22.4% jp/co/canonsoftware/android/emoji/AnimatedEmojiFactory.CheckEmojiUnicode
3 : 10.8% android/text/Layout.measurePara
4 : 10.0% android/text/StaticLayout.generate
5 :  4.5% android/text/StaticLayout.isideographic

上の絵文字はデバイス固有のもの？
３〜５はレイアウトに関わるメソッドなので、やはり長い文章を表示しようとすると、レイアウトを構成するメソッドで時間がかかる。


【スクロールしたときに時間がかかっているメソッドのレポート】
1 : 27.7% android/view/GLES20Canvas.nDrawDisplayList
2 :  4.4% android/view/GLES20Canvas.nEndTileRendering
3 :  4.3% com/google/android/gles_jni/EgLlmpl.eglSwpBuffers

１のリストを描画するメソッドに圧倒的が時間がかかっている。


自動ビルド

2. (実習) 適用したプロジェクトを ant でビルドし、ログを見て、ビルドに必要な手順をレポートしてください。

-set-mode-check:
-set-debug-files:
-check-env:
-setup:
-set-debug-mode:
-debug-obfuscation-check:
-pre-build:
-build-setup:
-code-gen:
-pre-compile:
-compile:
-post-compile:
-obfuscate:
-dex:
-crunch:
-package-resources:
-package:
-post-package:
-do-debug:
-post-build:
debug:
install: