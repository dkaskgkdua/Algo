// https://programmers.co.kr/learn/courses/30/lessons/42861?language=java
// 섬 연결하기

/*
Kruskal 알고리즘
- 그리디를 이용하여 네트워크의 모든 정점을 최소 비용으로 연결하는 최적 해답을 구하는 것
 - 여기서 네트워크는 가중치를 간선에 할당한 그래프이다
 - 그리디(탐욕적인 방법) : 결정을 할 때마다 그 순간 가장 좋다고 생각되는 것을 선택함으로써 최종적인 해당에 도달하는 것
 - 그리디가 항상 최적읜 해답을 주는 것은 아니지만, Kruskal 알고리즘은 최적의 해답을 준다
- MST(최소 비용 신장 트리)가 1)최소 비용의 간선으로 구성됨 2)사이클을 포함하지 않음의 조건에 근거하여 각 단계에서 사이클을 이루지 않는 최소 비용 간선을 선택한다

Kruskal 알고리즘 동작
1. 그래프의 간선들을 가중치의 오름차순으로 정렬한다.
2. 정렬된 간선 리스트에서 순서대로 사이클을 형성하지 않는 간선을 선택한다.
- 즉, 가장 낮은 가중치를 먼저 선택한다.
- 사이클을 형성하는 간선을 제외한다.
 - 사이크 생성 여부를 'union-find 알고리즘'을 이용한다/
3. 해당 간선을 현재의 MST(최소 비용 신장 트리)의 집합에 추가한다.

[출처 및 이 외 자세한 내용](https://gmlwjd9405.github.io/2018/08/29/algorithm-kruskal-mst.html)
[동영상 강의](https://www.youtube.com/watch?v=LQ3JHknGy8c&t=418s)
*/

import java.util.Comparator;
import java.util.Arrays;

class Solution {
    // 부모 노드를 찾는 함수
    public int getParent(int parent[], int x) {
        if(parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    // 두 부모 노드를 합치는 함수
    int unionParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a < b) return parent[b] = a;
        else return parent[a] = b;
    }

    // 같은 부모를 가지는지 확인
    boolean findParent(int parent[], int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);
        if(a == b) return true;
        else return false;
    }

    public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // 비용을 기준으로 내림차순으로 정렬
        Arrays.sort(costs, Comparator.comparingInt(o1 -> o1[2]));

        // 각 정점이 포함된 그래프가 어디인지 저장
        int[] parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < costs.length; i++) {
            // 사이클이 발생하지 않는 경우, 그래프에 포함
            if(!findParent(parent, costs[i][0], costs[i][1])) {
                answer += costs[i][2];
                unionParent(parent, costs[i][0], costs[i][1]);
            }
        }

        return answer;
    }
}