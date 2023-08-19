# Barcode2Database
This Android program can get the data from barcode and send it to a web server, eventually DB server.
このAndroid用のプログラムはバーコードからデータを読み取りそれをWebサーバに送信します。最終的にはDBサーバまで。

It uses Android-barcode API for client, PHP for server side processing, and mariaDB for RDBMS.
クライアント側のAndroidバーコードAPI、サーバサイドでPHP(ソース行方不明)、リレーショナルデータベースはmariaDBを使用しています。

## Before using
You need to:
1. run a webserver with the PHP program.
   (サーバサイドのソースコード行方不明になりました😢　[この辺り](https://github.com/Kazuki-Maehara/web-database) を改造してデータベースからフェッチしたデータグラフ描画させてるだけです)
1. install the Android app.
1. set a specific IP address of webserver that is running.
1. shoot a barcode and check the correct code is displayed on your app.
1. press send button.
1. visit the web page to check to see if the data is successfully transmitted to and stored in the database, finally.


## こんな感じで動きます。(参考)
バーコードデータ読み込みと送信

![1_smart_phone](https://github.com/Kazuki-Maehara/Barcode2Database/blob/image/gif/1_smart_phone.gif)

任意のデータ送信

![2_smart_phone](https://github.com/Kazuki-Maehara/Barcode2Database/blob/image/gif/2_smart_phone.gif)

RaspberryPiと連動させてみる　(PLCとかの設備から信号取れたらなーと)

![3_raspberrypi](https://github.com/Kazuki-Maehara/Barcode2Database/blob/image/gif/3_raspberryPi.gif)

(おまけで)ついでにArdinoくっつけてサーボモータ動かしてみる

![4_servo](https://github.com/Kazuki-Maehara/Barcode2Database/blob/image/gif/4_servo.gif)
