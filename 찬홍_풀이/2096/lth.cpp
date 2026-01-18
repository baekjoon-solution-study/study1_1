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
cache[100000][3]=이 아래로 얻을 수 있는 최대값
*/

int n;
short arr[100005][3];
int cache[3][3];
int cache_mi[3][3];

int dp(int line,int num){
    if(line==n){
        return 0;
    }
    if(cache[line%2][num]!=-1){
        return cache[line%2][num];
    }
    int mx=0;
    if(num==0){
        mx=max(dp(line+1,0),dp(line+1,1));
    }
    else if(num==1){
        mx=max({dp(line+1,0),dp(line+1,1),dp(line+1,2)});
    }
    else{
        mx=max(dp(line+1,2),dp(line+1,1));
    }
    cache[line%2][num]=mx+arr[line][num];
    return mx+arr[line][num];

}
int dp_mi(int line,int num){
    if(line==n){
        return 0;
    }
    if(cache_mi[line%2][num]!=-1){
        return cache_mi[line%2][num];
    }
    int mi=987654321;
    if(num==0){
        mi=min(dp_mi(line+1,0),dp_mi(line+1,1));
    }
    else if(num==1){
        mi=min({dp_mi(line+1,0),dp_mi(line+1,1),dp_mi(line+1,2)});
    }
    else{
        mi=min(dp_mi(line+1,2),dp_mi(line+1,1));
    }
    cache_mi[line%2][num]=mi+arr[line][num];
    return mi+arr[line][num];

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

    
    memset(cache,-1,sizeof(cache));
    memset(cache_mi,-1,sizeof(cache_mi));
    cin>>n;
    
    for(int a=0;a<n;a++){
        cin>>arr[a][0]>>arr[a][1]>>arr[a][2];
    }
    for(int i=n-1;i>=0;i--){
        cache[i%2][0]=-1;cache[i%2][1]=-1;cache[i%2][2]=-1;
        cache_mi[i%2][0]=-1;cache_mi[i%2][1]=-1;cache_mi[i%2][2]=-1;
        dp(i,0);dp(i,1);dp(i,2);
        dp_mi(i,0);dp_mi(i,1);dp_mi(i,2);

    }
    cout<<max({cache[0][0],cache[0][1],cache[0][2]})<<" "<<min({cache_mi[0][0],cache_mi[0][1],cache_mi[0][2]});
    // cout<<'\n';
    // cout<<cache[0][0]<<" "<<cache[0][1]<<" "<<cache[0][2]<<" "<<cache_mi[0][0]<<" "<<cache_mi[0][1]<<" "<<cache_mi[0][2];
}