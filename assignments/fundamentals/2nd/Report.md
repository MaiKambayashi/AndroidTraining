Assignment Report for 2.2
------

以下に、課題の回答を記入してください。

Activity と Fragment
======

### Activity

3. ライフサイクルのコールバックメソッドの呼び出し順

初回起動時
1. onCreate
2. onStart
3. onResume

ホームボタン押下後
1. onPause
2. onStop

ホームボタン押下後、アプリに戻ってきたとき
1. onRestart
2. onStart
3. onResume

戻るボタン押下後
1. onPause
2. onStop
3. onDestroy

戻るボタン押下後、アプリに戻ってきたとき
1. onCreate
2. onStart
3. onResume

画面を横にしたとき
1. onPause
2. onStop
3. onDestroy
4. onCreate
5. onStart
6. onResume