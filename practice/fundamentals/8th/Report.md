Practice Report for 2/8
------

実習のレポートを下記に記述してください

### Service

1. サンプルプロジェクト (ServiceSample) に、サービスのライフサイクルをログに出力する実装が格納されています。このプロジェクトをビルドし、ログがどのように表示されるかをレポートしてください。

"Start"を押すと、
StartedService onCreate
StartedService onStartCommand
が表示される

その後、"Stop"を押すと、
StartedService onDestroy
が表示される


“Bind”を押すと、
BoundService onCreate
MainActibity onServiceConnnected
が表示される

その後、"Unbind"を押すと、
BoundService onUnbind
BoundService onDestroy
が表示される


”Call IntentService”を押すと、
MyIntentService	onCreate
MyIntentService	onStartCommand
MyIntentService	onHandleIntent
MyIntentService onDestroy
が表示される

”Start”を押していない状態で"Stop"を押してもログははかれない

”Bind”を押していない状態で"Unbind"を押すと、アプリが落ちる

”Start”を続けて押すと、
StartedService onStartCommand
が続けて表示される。
StartedService onCreate
は最初の一回だけ表示される。
その後、"Stop"を押すと、
StartedService onDestroy
が表示され、その後続けて"Stop"を押してもログは表示されない。
その後また"Start"を押すと、
StartedService onCreate
StartedService onStartCommand
が表示される

”Bind”を続けて押しても、最初の一回しかログは表示されない。

”Start”を押してからホームボタンを押し、再度アプリを起動した後、"Stop"を押すと、
StartedService onDestroy
が表示される。

”Bind”を押してからホームボタンを押し、再度アプリを起動した後、”Unbind”を押すと、
BoundService onUnbind
BoundService onDestroy
が表示される。

”Start”を押してから戻るボタンを押し、再度アプリを起動した後、"Stop"を押すと、
StartedService onDestroy
が表示される。

”Bind”を押してから戻るボタンを押し、再度アプリを起動すると、
BoundService onUnbind
BoundService onDestroy
が表示される。
その後、"Unbind"を押すと、アプリが落ちる


### Loader

1. サンプルプロジェクト (LoaderSample) に、AsyncTaskLoader のライフサイクルをログに出力する実装が格納されています。このプロジェクトをビルドし、ログがどのように出力されているかをレポートしてください。

アプリを起動すると、
MainActivity onCreateLoader
MyAsyncTaskLoader onStartLoading
MyAsyncTaskLoader loadInBackground
が表示される。
その後「hogehoge」がToastで表示された後、
MyAsyncTaskLoader deliverResult
MainActivity onLoadFinished
が表示される。

homeボタンを押すと、
MyAsyncTaskloader onStopLoading
が表示される。
その後、アプリに戻ってくると、
MyAsyncTaskloader onStartLoading
MyAsyncTaskloader deliverResult
が表示される。

戻るボタンを押すと、
MyAsyncTaskloader onStopLoading
MainActivity onLoaderReset
MyAsyncTaskloader onReset
MyAsyncTaskloader onStopLoading
が表示される。
その後、アプリに戻ってくると、
MyAsyncTaskLoader onStartLoading
MyAsyncTaskLoader loadInBackground
が表示される。
その後「hogehoge」がToastで表示された後、
MyAsyncTaskLoader deliverResult
MainActivity onLoadFinished
が表示される。

### AsyncTask

1. `AsyncTask#doInBackground()` で、TextView の文字を変更するような、UI の処理を実行するとどうなるかを、理由を添えてレポートしてください。

`AsyncTask#doInBackground()` で、TextView の文字を変更するような、UI の処理を実行すると、アプリが落ちる。
なぜなら、UIの処理はメインスレッド側が担当しているため。
