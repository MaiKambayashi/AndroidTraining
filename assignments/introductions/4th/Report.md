Assignment Report for 1.4
------

以下に、課題の回答を記入してください。

Android の基礎知識
======

4. `adb`コマンドを使って、下記の項目を実行してください（課題のファイルに、実行したコマンドを記録しておいてください）。
・端末のSD カード領域に、ローカルにあるファイルを転送する

90201703n:~ mai.kambayashi$ adb push Documents/dummy.rtf /sdcard/Android/data
35 KB/s (338 bytes in 0.009s)

90201703n:~ mai.kambayashi$ adb shell
shell@android:/ $ ls /sdcard/A                                                 
ARROWS Movie/   Alarms/         Android/        
shell@android:/ $ ls /sdcard/Android/data/                                     
com.android.browser
com.android.chrome
com.android.gallery3d
com.android.providers.media
com.fujitsu.mobile_phone.fmail_sbm
com.google.android.apps.maps
com.google.android.music
com.google.android.videos
com.google.android.youtube
dummy.rtf ##ここに転送されていることを確認
jp.mixi
jp.naver.line.android

・端末のSD カード領域から、ローカルにファイルを転送する
90201703n:~ mai.kambayashi$ adb pull /sdcard/Android/data/dummy.rtf
47 KB/s (338 bytes in 0.007s)

90201703n:~ mai.kambayashi$ ls
130417.keystore			Library			dummy.rtf ##ここに転送されていることを確認
AndroidTraining						Movies			practice_130417
Desktop											Music			practice_130417.apk
Documents													Pictures
Downloads														Public

・課題用サンプルプロジェクトの apk ファイルをコマンド経由で端末にインストールする
90201703n:~ mai.kambayashi$ adb install practice_130417.apk
1958 KB/s (196036 bytes in 0.097s)
     pkg: /data/local/tmp/practice_130417.apk
Success

・インストールしたアプリを、コマンド経由でアンインストールする
90201703n:~ mai.kambayashi$ adb uninstall com.example.comment
Success
