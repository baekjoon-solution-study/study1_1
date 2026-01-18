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
cache[1000][1000]= 첫번째 i이후, 두번째 j이후로 만들 수 있는 최장부분수열 길이
*/

int n;
string a,b;
int cache[1005][1005];


int dp(int x,int y){
    if(x==a.size() || y==b.size()){
        return 0;
    }
    if(cache[x][y]!=-1){
        return cache[x][y];
    }
    int mx=0;
    if(a[x]==b[y]){
        mx=dp(x+1,y+1);
        mx++;
    }
    else{
        mx=max(dp(x,y+1),dp(x+1,y));
    }
    cache[x][y]=mx;
   
    return cache[x][y];

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

    
    memset(cache,-1,sizeof(cache));
    cin>>a;
    cin>>b;

    cout<<dp(0,0);
}