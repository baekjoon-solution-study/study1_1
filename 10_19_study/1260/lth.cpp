#include<stdio.h>
#include<string>
#include <cstring>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
#include<map>
#include <numeric>
#include<bit>
#include <sstream>
#include <queue>
#include <functional>

using namespace std;
/* 아이디어
벡터로 그래프 표현
bfs 
찾은노드 다 큐에넣고 안쪽반복문 끝
바깥 반복문에서 하나 pop

dfs
재귀

*/
int arr[1010][1010]={0};
int n,m;

void dfs(int v, int* visited){
    visited[v]=1;
    cout<< v << " ";
    for(int i=0;i<=n;i++){
        if(arr[v][i]!=0 && visited[i]!=1){
            dfs(i,visited);
        }
    }
}
void bfs(int v,int* visited){
    queue<int> que;
    que.push(v);
    visited[v]=1;
    int t;
    while(que.size()!=0){
        t = que.front();
        que.pop();
        for(int i=0;i<=n;i++){
            if(arr[t][i]!=0 && visited[i]!=1){
                visited[i]=1;
                que.push(i);
            }
        }
        cout<< t << " ";
    }

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int v;
    int q,r;
    
    int visited[1010]={0};

    cin>> n >> m >> v;
    for(int i=0;i<m;i++){
        cin>>q>>r;
        arr[q][r]=1;
        arr[r][q]=1;
    }
    
    dfs(v,visited);
    cout<<'\n';
    memset(visited, 0, sizeof(visited));
    bfs(v,visited);
}