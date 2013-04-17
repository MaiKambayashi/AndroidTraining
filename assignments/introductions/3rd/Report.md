Assignment Report for 1.3
------

以下に、課題の回答を記入してください。

署名済みアプリの作成
======

3. 作成した apk ファイルの中にあるファイル・ディレクトリを列挙してください。
META-INFディレクトリ
resディレクトリ
AndroidManifiest.xml
classes.dex
resources.arsc

4. 上記で列挙したファイル・ディレクトリについて、どのような役割を持っているか説明してください。
META-INFディレクトリ:
 MANIFEST.MF: マニフェストファイル。jarファイルから継承したものでファイルの説明が記述されている。後述するAndroidManifest.xmlとは別物である。
 CERT.RSA: アプリケーションの証明書。
 CERT.SF: 各種リソースの保存場所とそのSHA-1ダイジェストの一覧

res: 
 各種リソースを格納するディレクトリ（アプリが使う画像ファイルや音声ファイルなど）

AndroidManifest.xml:
 Androidのマニフェストファイル。アプリケーションの名称やバージョン、使用するアクセス権限などが書かれているXML形式のファイルである。

classes.dex:
 dexファイル形式のプログラム（Dalvik仮想マシン用の中間コードである）。

resources.arsc:
 リソースのうち、各国語対応のための文字列リソースなど、個別ファイルにする必要のないものがxml形式で格納されている。
