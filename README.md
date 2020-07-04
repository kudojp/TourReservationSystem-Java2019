# 概要

本プロジェクトは、旅行会社の予約管理システムのスタンドアロンアプリケーションであり、これはノースカロライナ州立大学交換留学時の 2019-Spring の [CSC216(Programming Concept)](https://people.engr.ncsu.edu/sesmith5/teaching/syllabi/S19_CSC216_Syllabus.pdf)のファイナルプロジェクトである。オブジェクト指向、エラーハンドリング、テスティング、デザインパターン(シングルトンパターン)、データ構造の理解を前提に、以下に取り組んだ。
1. モデル層の実装(該当箇所は[こちら](https://github.com/kudojp/TravelManager/tree/master/Project2/src/edu/ncsu/csc216/travel/model]))
   - これは[データ永続化のためのテキストファイルのReader/Writerクラス](https://github.com/kudojp/TravelManager/tree/master/Project2/src/edu/ncsu/csc216/travel/model/file_io)を含む
2. ArrayList, LinkedListの実装(該当箇所は[こちら](https://github.com/kudojp/TravelManager/tree/master/Project2/src/edu/ncsu/csc216/travel/list_utils))
   - これはデータ構造への理解を含めるという目的でスクラッチでの実装を求められた

このプロジェクトは github でコードを提出することを求められており、コード提出時に自動でJenkinsでCIテストが起動した。プロジェクトの完成条件は以下である。
1. これは自らが書いた全てのメソッドをカバーし、尚且つコードカバレッジ80%を満たすユニットテストが全てpassすること
2. 1が満たされた場合TAによるユニットテストが起動し、これらが全てpassすること。

## 実行方法

1. 実行可能ファイルを[/TravelManager.jar](https://github.com/kudojp/TravelManager/blob/master/TravelManager.jar)からダンロードする。
2. ローカル環境でファイルを起動する。

## 仕様

プロジェクトの仕様は[/CSC216P2P1.pdf](https://github.com/kudojp/TravelManager/blob/master/CSC216P2P1.pdf)で与えられた。主要な仕様のいくつかは以下であった。

- ユーザは新しくツアーパッケージを登録できる
- ユーザは新しくツアーに参加するグループを登録できる
- ユーザはツアーパッケージとグループを洗濯してツアーの予約ができる
- ユーザはパッケージの削除、グループの削除、予約のキャンセルができる
- ユーザはデータをローカルのテキストファイルにアウトポートすることで保存できる
- ユーザはローカルのテキストファイルをインポートすることができる

## 設計

プロジェクトの設計およびその実装手順は[/CSC216P2P2.pdf](CSC216P2P2.pdf)で与えられた。GUIファイルに関しては既に完成したものが与えられており、Model 部分を以下のクラス図を元にeclipseで実装した(該当箇所は[こちら](https://github.com/kudojp/TravelManager/tree/master/Project2/src/edu/ncsu/csc216/travel/model)である)。データの永続化はローカルのテキストファイルで行なっている。

![image](https://user-images.githubusercontent.com/44487754/73433247-c0a66e00-4387-11ea-9050-cf631aedaf6f.png)
