# 🍗 BOJ 15686: 치킨 배달

## 📝 문제 설명
- 도시에는 집과 치킨집이 있다.
- 폐업시키지 않을 **M개의 치킨집**을 고른 뒤,
- **모든 집의 치킨 거리의 합**이 최소가 되도록 해야 한다.

> ✅ 치킨 거리: 한 집과 가장 가까운 치킨집 사이의 거리  
> ✅ 도시의 치킨 거리: 모든 집의 치킨 거리 합

---

## 📌 입력
- 첫째 줄: `N` (2 ≤ N ≤ 50), `M` (1 ≤ M ≤ 13)
- 다음 N줄: 도시 정보 (0=빈칸, 1=집, 2=치킨집)

---

## 📤 출력
- 도시의 **치킨 거리의 최소값**

---

## 📘 예제
### 예제 입력 1
```
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
```
### 예제 출력 1
```
5
```
### 예제 입력 2
```
5 2
0 2 0 1 0
1 0 1 0 0
0 0 0 0 0
2 0 0 1 1
2 2 0 1 2
```
### 예제 출력 2
```
10
```
### 예제 입력 3
```
5 1
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
1 2 0 0 0
```
### 예제 출력 3
```
11
```
### 예제 입력 4
```
5 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
1 2 0 2 1
```
### 예제 출력 4
```
32
```