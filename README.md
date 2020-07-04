# 概要

本プロジェクトは、旅行会社の予約管理システムのスタンドアロンアプリケーションであり、これはノースカロライナ州立大学交換留学時の 2019-Spring の [CSC216(Programming Concept)](https://people.engr.ncsu.edu/sesmith5/teaching/syllabi/S19_CSC216_Syllabus.pdf)のファイナルプロジェクトである。オブジェクト指向、エラーハンドリング、テスティング、デザインパターン(シングルトンパターン)、データ構造の理解を前提に、以下に取り組んだ。
1. モデル層の実装(該当箇所は[こちら](https://github.com/kudojp/TravelManager/tree/master/Project2/src/edu/ncsu/csc216/travel/model]))
   - これは[データ永続化のためのテキストファイルのReader/Writerクラス](https://github.com/kudojp/TravelManager/tree/master/Project2/src/edu/ncsu/csc216/travel/model/file_io)を含む
2. ArrayList, LinkedListの実装(該当箇所は[こちら](https://github.com/kudojp/TravelManager/tree/master/Project2/src/edu/ncsu/csc216/travel/list_utils))
   - これはデータ構造への理解を含めるという目的でスクラッチの実装を求められた

このプロジェクトは github でコードを提出することを求められており、コード提出時に自動でJenkinsでCIテストが起動した。プロジェクトの完成条件は以下である。
1. これは自らが書いた全てのメソッドをカバーし、尚且つコードカバレッジ80%を満たすユニットテストが全てpassすること
2. 1が満たされた場合TAによるユニットテストが起動し、これらが全てpassすること。

## 実行方法

1. 実行可能ファイルを[/TravelManager.jar](https://github.com/kudojp/TravelManager/blob/master/TravelManager.jar)からダンロードする。
2. ローカル環境でファイルを起動する。

## 仕様

プロジェクトの仕様は[/CSC216P2P1.pdf](https://github.com/kudojp/TravelManager/blob/master/CSC216P2P1.pdf)で与えられた。想定されるユーザは旅行会社のスタッフであり、主要な仕様のいくつかは以下である。

1. ユーザはホーム画面からは新しくツアーパッケージを登録できる
   - 登録情報は、ツアー名/ツアータイプ/開始日時/日数/最大収容人数/価格である
   - ツアータイプはLandTour, RiverCruise, EducationalTripの３種類から選択する
2. ユーザはホーム画面から参加グループを登録できる
   - 登録情報は、氏名/代表者の連絡先/その参加グループの人数である。
3. ユーザはホーム画面から(1で登録した)ツアーパッケージと(2で登録した)顧客を選択してツアーの予約ができる
4. ユーザはホーム画面から(1で登録した)パッケージの削除、(2で登録した)参加グループの削除、(3で登録した)予約のキャンセルができる
5. ユーザはホーム画面のデータをローカルのテキストファイルにアウトポートすることで保存できる
6. ユーザは現時点でのデータを保存/呼び出しすることができる。
   - データの保存場所はローカルのテキストファイルである。
   - 保存の際にはテキストファイルの名前を指定してデータを保存し、読み込みの際にはファイルの選択をしてデータを呼び出す。

## 設計

プロジェクトの設計およびその実装手順は[/CSC216P2P2.pdf](CSC216P2P2.pdf)で与えられた。GUIファイルに関しては既に完成したものが与えられており、Model 部分を以下のクラス図を元にeclipseで実装した(該当箇所は[こちら](https://github.com/kudojp/TravelManager/tree/master/Project2/src/edu/ncsu/csc216/travel/model)である)。データの永続化はローカルのテキストファイルで行なっている。

![image](https://user-images.githubusercontent.com/44487754/73433247-c0a66e00-4387-11ea-9050-cf631aedaf6f.png)


- 以下特筆すべき点である。

### TourCourdinatorクラス
- シングルトンパターンを採用している。

### SimpleArrayListクラス
- このArrayListは[SimpleListインターフェイス](https://github.com/kudojp/TravelManager/blob/master/Project2/src/edu/ncsu/csc216/travel/list_utils/SimpleList.java)を継承している。
- ArrayListは、初期化した状態では、内部的に長さ12のArrayが使わている。要素を追加する中でArrayのキャパシティーをオーバーするごとに24→36→48→...と12ずつ長いArrayに置き換えている(該当箇所は[こちら](https://github.com/kudojp/TravelManager/blob/master/Project2/src/edu/ncsu/csc216/travel/list_utils/SimpleArrayList.java#L95-L110))。

