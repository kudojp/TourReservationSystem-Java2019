# Tour Reservation System


<details>
<summary>日本語の説明はここをクリックして展開</summary>

## 概要

本プロジェクトは、旅行会社の予約管理システムのスタンドアロンアプリケーションであり、これはノースカロライナ州立大学交換留学時の 2019-Spring の [CSC216(Programming Concept)](https://people.engr.ncsu.edu/sesmith5/teaching/syllabi/S19_CSC216_Syllabus.pdf)のファイナルプロジェクトである。オブジェクト指向、エラーハンドリング、テスティング、デザインパターン(シングルトンパターン)、データ構造の理解を前提に、以下に取り組んだ。

1. モデル層の実装(該当箇所は[こちら](https://github.com/kudojp/TourReservationSystem-Java2019/tree/master/Project2/src/edu/ncsu/csc216/travel/model))
   - これは[データ永続化のためのテキストファイルの Reader/Writer クラス](https://github.com/kudojp/TourReservationSystem-Java2019/tree/master/Project2/src/edu/ncsu/csc216/travel/model/file_io)を含む
2. ArrayList, LinkedList の実装(該当箇所は[こちら](https://github.com/kudojp/TourReservationSystem-Java2019/tree/master/Project2/src/edu/ncsu/csc216/travel/list_utils))
   - これはデータ構造への理解を含めるという目的でスクラッチの実装を求められた
3. 1 と 2 のユニットテスト(該当箇所は[こちら](https://github.com/kudojp/TourReservationSystem-Java2019/tree/master/Project2/test/edu/ncsu/csc216/travel))

このプロジェクトは github でコードを提出することを求められており、コード提出時に自動で Jenkins で CI テストが起動した。プロジェクトの完成条件は以下である。

1. これは自らが書いた全てのメソッドをカバーし、尚且つコードカバレッジ 80%を満たすユニットテストが全て pass すること
2. 1 が満たされた場合 TA によるユニットテストが起動する。これらが全て pass すること

## 実行方法

1. 実行可能ファイルを[/TravelManager.jar](https://github.com/kudojp/TourReservationSystem-Java2019/blob/master/TravelManager.jar)からダウンロードする。
2. ローカル環境で jar ファイルを起動する。
3. 画面左上の File から、File>Load でデータをインポートする(初回時には File>New を選択)
4. 使用後は左上の File から、File>Save でデータをアウトポートする。

## Javadoc

このプロジェクトで実装されたクラスの Javadoc は[こちら](https://kudojp.github.io/TourReservationSystem-Java2019/)を参照してください。
![image](https://user-images.githubusercontent.com/44487754/86514577-2d012e00-be4e-11ea-8522-8a73965d5c95.png)

## 仕様

プロジェクトの仕様は[/CSC216P2P1.pdf](https://github.com/kudojp/TourReservationSystem-Java2019/blob/master/CSC216P2P1.pdf)で与えられた。想定されるユーザは旅行会社のスタッフであり、主要な仕様のいくつかは以下である。

1. ユーザはホーム画面からは新しくツアーパッケージを登録できる
   - 登録情報は、ツアー名/ツアータイプ/開始日時/日数/最大収容人数/価格である
   - ツアータイプは LandTour, RiverCruise, EducationalTrip の３種類から選択する
2. ユーザはホーム画面からクライアントを登録できる
   - 登録情報は、氏名/連絡先である。
3. ユーザはホーム画面から(1 で登録した)ツアーパッケージと(2 で登録した)クライアントを選択して、さらにそのクライアントのツアー参加人数を入力して、ツアーの予約ができる
4. ユーザはホーム画面から(1 で登録した)パッケージの削除、(2 で登録した)クライアントの削除、(3 で登録した)予約のキャンセルができる
5. ユーザはホーム画面のデータをローカルのテキストファイルにアウトポートすることで保存できる
6. ユーザは現時点でのデータを保存/呼び出しすることができる。
   - データの保存場所はローカルのテキストファイルである。
   - 保存の際にはテキストファイルの名前を指定してデータを保存し、読み込みの際にはファイルの選択をしてデータを呼び出す。

<img width="1051" alt="travelmanager-menu" src="https://user-images.githubusercontent.com/44487754/86505764-cb1bd680-be03-11ea-816b-0f581304cb90.png">

## 設計

プロジェクトの設計およびその実装手順は[/CSC216P2P2.pdf](CSC216P2P2.pdf)で与えられた。GUI ファイルに関しては既に完成したものが与えられており、Model 部分を以下のクラス図を元に eclipse で実装した(該当箇所は[こちら](https://github.com/kudojp/TourReservationSystem-Java2019/tree/master/Project2/src/edu/ncsu/csc216/travel/model)である)。データの永続化はローカルのテキストファイルで行なっている。

![image](https://user-images.githubusercontent.com/44487754/73433247-c0a66e00-4387-11ea-9050-cf631aedaf6f.png)

以下特筆すべき点である。

### [TourCoordinator クラス](https://github.com/kudojp/TourReservationSystem-Java2019/blob/master/Project2/src/edu/ncsu/csc216/travel/model/office/TourCoordinator.java)

- シングルトンパターンを採用している
  - [コンストラクターは private メソッドとして保持](https://github.com/kudojp/TourReservationSystem-Java2019/blob/master/Project2/src/edu/ncsu/csc216/travel/model/office/TourCoordinator.java#L53-L61)されており、TourCoordinator を外部から呼び出す際には[public static メソッドの getInstance()](https://github.com/kudojp/TourReservationSystem-Java2019/blob/master/Project2/src/edu/ncsu/csc216/travel/model/office/TourCoordinator.java#L68-L73)を使用する。
  - この private メソッドのコンストラクターで初期化された TourCoordinator インスタンスは[private static フィールドの instance](https://github.com/kudojp/TourReservationSystem-Java2019/blob/master/Project2/src/edu/ncsu/csc216/travel/model/office/TourCoordinator.java#L28)として保持される。getInstance()メソッドを初めて呼び出す際には、この内部でコンストラクターが呼び出され、TourCoordinator インスタンスが初期化されて instance に収納される。二度目以降に getInstance()メソッドが呼び出された際には、instance を返す。

### [SimpleArrayList クラス](https://github.com/kudojp/TourReservationSystem-Java2019/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SimpleArrayList.java)

- この ArrayList は[SimpleList インターフェイス](https://github.com/kudojp/TourReservationSystem-Java2019/blob/master/Project2/src/edu/ncsu/csc216/travel/list_utils/SimpleList.java)を実装している。
- ArrayList は、初期化した状態では、内部的に長さ 12 の Array が使わている。要素を追加する中で Array のキャパシティーをオーバーするごとに 24→36→48→...と 12 ずつ長い Array に置き換えている(該当箇所は[こちら](https://github.com/kudojp/TourReservationSystem-Java2019/blob/master/Project2/src/edu/ncsu/csc216/travel/list_utils/SimpleArrayList.java#L95-L110))。

### [SortedLinkedListWithIterator クラス](https://github.com/kudojp/TourReservationSystem-Java2019/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedLinkedListWithIterator.java)

- この LinkedList は[SortedList インターフェイス](https://github.com/kudojp/TourReservationSystem-Java2019/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedList.java)を実装している。この LinkedList は従来の LinkedList と比べると以下の二つの特徴を持つ。
  - 複数の要素の重複を許さない
  - 要素は、そのオブジェクトの compareTo メソッドを使用して、値が小さい順にソートされて収納される
- [Cursor](https://github.com/kudojp/TourReservationSystem-Java2019/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedLinkedListWithIterator.java#L238-L255)というネストされた private クラスを保持しており、これは[SimpleListIterator インターフェイス](https://github.com/kudojp/TourReservationSystem-Java2019/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SimpleListIterator.java)を実装している。
  - この Cursor はこの LinkedListIterator 内部の[iterator()メソッド](https://github.com/kudojp/TourReservationSystem-Java2019/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedLinkedListWithIterator.java#L186-L188)内で初期化されて返される。
  - この Cursor は[toString()メソッド](https://github.com/kudojp/TourReservationSystem-Java2019/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedLinkedListWithIterator.java#L194-L209)において iterator()メソッドから呼び出された上で、この List を文字列で表現する際に使用される。

</details>

## Summary

This is a Java standalone application for a staff of travel agencies to manage tour reservations of one's clients. I developed this system as a final project of [2019-Spring CSC216(Programming Concept)](https://people.engr.ncsu.edu/sesmith5/teaching/syllabi/S19_CSC216_Syllabus.pdf) in North Carolina State University in my one year exchange program. In this project, I worked on implementation on the solid understandings of error handlings, testing, design patterns(e.g singleton pattern), data structure, etc.

1. Implementation of model layers (See [here](https://github.com/kudojp/TourReservationSystem-Java2019/tree/master/Project2/src/edu/ncsu/csc216/travel/model]))
  - This includes [I/O class of text files for saving data](https://github.com/kudojp/TourReservationSystem-Java2019/tree/master/Project2/src/edu/ncsu/csc216/travel/model/file_io)
2. Implementation of ArrayList and LinkedList (See [here](https://github.com/kudojp/TourReservationSystem-Java2019/tree/master/Project2/src/edu/ncsu/csc216/travel/list_utils))
  - Full scratch implementation was required for deep understanding of these data structures.
3. Unit test cases for 1 and 2 (See [here](https://github.com/kudojp/TourReservationSystem-Java2019/tree/master/Project2/test/edu/ncsu/csc216/travel))

Code was supposed to be pushed into GitHub, and CI unit testing were triggered automatically on Jenkins. To complete this project, I was expected to:

1. Write test cases for all implemented methods, as well as the code coverage exceeding 80%.
2. Pass all hidden test cases written by TA which is run in the CI process when 1 is met.


## How to run app

1. Install executable file: [/TravelManager.jar](https://github.com/kudojp/TourReservationSystem-Java2019/blob/master/TravelManager.jar).
2. Click and run the file in your local environment.
3. Import saved data by clicking `File > Load`. (For the first time, click `File > New`.)
4. When exiting, export saved data by clicking `File > Save`.

## Javadoc

Javadoc of the classes implemented in this project is [here](https://kudojp.github.io/TourReservationSystem-Java2019/).


![image](https://user-images.githubusercontent.com/44487754/86514577-2d012e00-be4e-11ea-8522-8a73965d5c95.png)

## Specifications

Specifications of this project was given in [/CSC216P2P1.pdf](https://github.com/kudojp/TravelManager/blob/master/CSC216P2P1.pdf). Target users are staffs who are working for travel agencies. Some of the specifications are:

1. User (= staff) can register new tour package from home page.
   - Tour package has its tour name, tour type, start date, end date, capacity, and price.
   - Tour type is one of LandTour, RiverCruise, EducationalTrip.
2. User can register new client from home page.
   - Client has one's name, phone number.
3. User can create new reservation by selecting a tour package(1) and a client(2), as well as entering number of participants.
4. User can delete tour packages(1), clients(2), reservations(3)
5. User can import saved data from local text file and save data from text file.
   - When importing from / exporting to a text file, user can specify the name of the file.

<img width="1051" alt="travelmanager-menu" src="https://user-images.githubusercontent.com/44487754/116785472-b3b98280-aad4-11eb-82d4-5c043c26904b.png">


## Design

Design of this project and its implementation process was given in [/CSC216P2P2.pdf](CSC216P2P2.pdf). [GUI files](https://github.com/kudojp/TravelManager/tree/master/Project2/src/edu/ncsu/csc216/travel/model) were given, and I was responsible for implementing classes of model layer. I used eclipse for implementation.

![image](https://user-images.githubusercontent.com/44487754/73433247-c0a66e00-4387-11ea-9050-cf631aedaf6f.png)

I will list some of the designs patterns where I learned a lot.

### [TourCoordinator class](https://github.com/kudojp/TravelManager/blob/master/Project2/src/edu/ncsu/csc216/travel/model/office/TourCoordinator.java)

Singleton pattern is used.
- The constructor method is hold as [a private method](https://github.com/kudojp/TravelManager/blob/master/Project2/src/edu/ncsu/csc216/travel/model/office/TourCoordinator.java#L53-L61).
- When constructing TourCoordinator object, [a public static method #getInstance](https://github.com/kudojp/TravelManager/blob/master/Project2/src/edu/ncsu/csc216/travel/model/office/TourCoordinator.java#L68-L73) is to be called. When you call #getInstance for the first time, its constructor method is called and the object is stored as its static field. When #getInstance is called after the second time, object stored as a field is returned.

### [SimpleArrayList class](https://github.com/kudojp/TravelManager/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SimpleArrayList.java)

This ArrayList implements [SimpleList interface](https://github.com/kudojp/TravelManager/blob/master/Project2/src/edu/ncsu/csc216/travel/list_utils/SimpleList.java).

Internally, this ArrayList holds array whose length is 12. When number of elements exceeds the capacity, a whole new array which is 12 longer than original one is instantiated. (i.e. length would be 12→24→36→48,,,,). See [here]((https://github.com/kudojp/TravelManager/blob/master/Project2/src/edu/ncsu/csc216/travel/list_utils/SimpleArrayList.java#L95-L110))


### [SortedLinkedListWithIterator class](https://github.com/kudojp/TravelManager/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedLinkedListWithIterator.java)

This LinkedList implements [SortedList interface](https://github.com/kudojp/TravelManager/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedList.java). This class has these additional specification over conventional LinkedList.

- Duplication of elements are not allowed
- Elements are sorted in an ascending order. (Overridden #comparedTo method is used for deciding elements' ordering.)
- #toString method returns string representing its elements in the form of `[element_1.toString(), element_2.toString(),,, element_n.toString()]`

For implementation of the third one, SortedLinkedListWithIterator class has [an inner private class Cursor](https://github.com/kudojp/TravelManager/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedLinkedListWithIterator.java#L238-L255) and a Cursor object is constructed in the method [SortedLinkedListWithIterator#iterator](https://github.com/kudojp/TravelManager/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedLinkedListWithIterator.java#L186-L188). This cursor is constructed and used every time [SortedLinkedListWithIterator#toString](https://github.com/kudojp/TravelManager/blob/c13ca920c8f267496f95b6afbba5713568351401/Project2/src/edu/ncsu/csc216/travel/list_utils/SortedLinkedListWithIterator.java#L194-L209) is called to traverse all the nodes.

