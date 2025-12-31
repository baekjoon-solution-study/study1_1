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
dp?
->x
2에서 시작해서 다른 모든점 까지의 최단거리
=bfs + bfs레벨 표시

*/
int arr[1010][1010];
int visited[1010][1010];
vector<vector<int>> direct={{0,-1},{0,1},{1,0},{-1,0}};
int n,m;

void bfs(int x,int y){
    queue<vector<int>> que;
    que.push({x,y});
    visited[x][y]=0;
    vector<int> t;
    while(que.size()!=0){
        t = que.front();
        
        que.pop();
        for(int i=0;i<4;i++){
            if(t[0]+direct[i][0] < 0 || t[0]+direct[i][0] >= n || t[1]+direct[i][1] <0 || t[1]+direct[i][1]>=m){
                continue;
            }
            int newx=t[0]+direct[i][0];
            int newy=t[1]+direct[i][1];
            if(arr[newx][newy]==1 && visited[newx][newy]==-1){
                visited[newx][newy]=visited[t[0]][t[1]]+1;
                que.push({newx,newy});
            }
        }
    }

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int q,r;

    cin>> n >> m;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>arr[i][j];
            if(arr[i][j]==2){
                q=i;
                r=j;
            }
        }
    }
    memset(visited, -1, sizeof(visited));
    bfs(q,r);
    
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(arr[i][j]==0){
                cout<<0<<" ";
            }
            else{
                cout<< visited[i][j] <<" ";
            }
        }
        cout<<'\n';
    }
}