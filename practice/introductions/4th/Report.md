Practice Report for 1.4
------

実習のレポートを下記に記述してください

1. (実習)Android SDK 内の、下記の 2 つのディレクトリにあるコマンドを列挙してください。
draw9patch
hierarchyviewer
emulator
hprof-conv
sqlite3
emulator-arm
jobb
android
emulator-mips
emulator-x86
lint
apkbuilder
emulator64-arm
mksdcard
traceview
emulator64-mips
monitor
uiautomatorviewer
ddms
emulator64-x86
monkeyrunner
zipalign
dmtracedump
etc1tool
aapt
adb
aidl
dexdump
dx
fastboot
llvm-rs-cc

2. (実習)上記のディレクトリにパスを通し、下記のコマンドを実行してください。
adb devices
0201703n:‾ mai.kambayashi$ adb devices
List of devices attached 
5403298b	device

adb shell
90201703n:‾ mai.kambayashi$ adb shell
shell@android:/ $ 

3. (実習)adb shellコマンドを使って、Android 内のファイルシステムにアクセスし、下記の項目を確認してください。
•/data/data以下のディレクトリでlsコマンドを打っても、拒否されること
126|shell@android:/ $ ls /data/data
opendir failed, Permission denied

•/sdcard/Android/data以下のディレクトリの中身を自由に読むことができること
読めました

