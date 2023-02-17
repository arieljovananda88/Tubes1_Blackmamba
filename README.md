# Tubes1_Blackmamba
# "Galaxio" Bot Using Greedy Algorithm

## Table of Contents
- [General Information](#general-information)
- [Greedy Strategy](#greedy-strategy)
- [Requirements](#requirement)
- [How To Build](#how-to-build)
- [How To Run](#how-to-run)
- [Authors](#authors)

## General Information
Galaxio adalah sebuah game battle royale yang mempertandingkan bot kapal anda dengan beberapa bot kapal yang lain. Setiap pemain akan memiliki sebuah bot kapal dan tujuan dari permainan adalah agar bot kapal anda yang tetap hidup hingga akhir permainan

## Greedy Strategy
Berikut adalah strategi greedy yang kami gunakan untuk permainan:
1. Bot akan makan dahulu sampai mencapai suatu konstanta atau jika tidak ada musuh disekitarnya.
2. Jika sudah mencapai suatu konstanta tersebut bot akan mencari musuh terdekat atau jika ada musuh di sekitar bot maka bot akan melakukan beberapa kalkulasi
3. Jika bot musuh lebih kecil, bot akan mencoba untuk menyerang
4. Jika bot musuh lebih besar, bot akan pergi menjauh dari bot musuh.


## Requirement
- [Java 11 (minimum)](https://www.oracle.com/java/technologies/downloads/#java8)
- [IntelliJ  IDEA](https://www.jetbrains.com/idea/)
- [NodeJs](https://nodejs.org/en/download/)
- [Visual Studio Code (optional if you don't want to use IntelliJ)](https://code.visualstudio.com/)
- [Maven](https://maven.apache.org/)
- .NET 3.1 & 5.0


## How To Build The Program
1.Pindah kedalam directory JavaBot yang berada di dalam folder repository ini.
2. Jika sudah di dalam directory JavaBot jalankan 
```
mvn clean package
```

## How To Run
- If you are using Windows, simply double click the ```RunGame.bat```
- If you are using Linux/Mac, run the command
    ```
    make run
    ```

## Authors

<b>Beating Mario Kart</b>
| NIM       | Name                     |
| --------- | ------------------------ |
| 13521086  | Ariel Jovananda          |
| 13521158  | Muhammad Dhiwaul Akbar   |
| 13521184  | Irgiansyah Mondo         |

TUGAS BESAR I - Algorithm Strategies

Bandung Institute of Technology
