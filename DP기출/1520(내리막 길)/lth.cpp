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
캐시구성
cache[i][j]=i,j에서 왼쪽 아래로 갈 수 있는 경우의 수
*/
vector<int> input;
int maap[510][510];
int cache[510][510];
int n,m;

int cnt(int x, int y){
    //기저사례
    if(x==n-1 && y==m-1){
       return 1;
    }
    if((maap[max(0,x-1)][y]>=maap[x][y]) && (maap[min(n-1,x+1)][y]>=maap[x][y]) && (maap[x][max(0,y-1)]>=maap[x][y]) && (maap[x][min(m-1,y+1)]>=maap[x][y])){
        return 0;
    }
    
    //메모이제이션
    if(cache[x][y]!=-1){
        return cache[x][y];
    }

    //로직
    int output=0;
    if(x>0 && maap[x][y]>maap[x-1][y]){
        output+=cnt(x-1,y);
    }
    if(x<n-1 && maap[x][y]>maap[x+1][y]){
        output+=cnt(x+1,y);
    }
    if(y>0 && maap[x][y]>maap[x][y-1]){
        output+=cnt(x,y-1);
    }
    if(y<m-1 && maap[x][y]>maap[x][y+1]){
        output+=cnt(x,y+1);
    }
    

    cache[x][y]=output;

    return output;

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int temp;
    
    cin>>n>>m;

    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>maap[i][j];
        }
    }
    
    memset(cache,-1,sizeof(cache));

   
    cout<<cnt(0,0);
  
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<m;j++){
    //         cout<<cache[i][j]<<" ";
    //     }
    //     cout<<'\n';
    // }

}