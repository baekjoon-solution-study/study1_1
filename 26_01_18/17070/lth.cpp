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
dp
cache[x][y][3]=x,y 이후로 n,n까지 가는 경우의 수

*/

int n;
int arr[20][20];
int cache[20][20][3];

int dp(int x,int y,int before){
    if(x==n && y==n){
        return 1;
    }
    if(x>n || y>n){
        return 0;
    }
    if(cache[x][y][before]!=-1){
        return cache[x][y][before];
    }
    int cnt=0;
    if((before==0 || before==2) && arr[x][y+1]==0){
        cnt+=dp(x,y+1,0);
    }
    if(arr[x][y+1]==0 && arr[x+1][y+1]==0 && arr[x+1][y]==0){
        cnt+=dp(x+1,y+1,2);
    }
    if((before==1 || before==2) && arr[x+1][y]==0){
        cnt+=dp(x+1,y,1);
    }
    cache[x][y][before]=cnt;
    return cnt;
}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

    memset(cache,-1,sizeof(cache));
    cin>>n;
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>arr[i][j];
        }
    }
    n--;
    cout<<dp(0,1,0);

}