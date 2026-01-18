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
CACHE[n번째 열][3(1번뜯음, 2번뜯음, 아무것도 안뜯음)]=이후로 만들 수 있는 최댓값

*/
int input[2][100010];
int cache[100010][3];
int n;

int max_val(int num, int before){
    if(num==n-1){
        if(before == 0){
            return max(input[0][num],input[1][num]);
        }
        else if(before == 1){
            return input[1][num];
        }
        else{
            return input[0][num];
        }
    }
    if(cache[num][before]!=-1){
        return cache[num][before];
    }
    int mx=0;
    if(before == 0){
        mx= max(max_val(num+1,1)+input[0][num],mx);
        mx= max(max_val(num+1,2)+input[1][num],mx);
        mx= max(max_val(num+1,0),mx);
    }
    else if(before == 1){
        mx= max(max_val(num+1,2)+input[1][num],mx);
        mx= max(max_val(num+1,0),mx);
    }
    else{
        mx= max(max_val(num+1,1)+input[0][num],mx);
        mx= max(max_val(num+1,0),mx);
    }
    cache[num][before]=mx;

    return mx;

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int t;
    cin>>t;
    
    for(int i=0;i<t;i++){
        memset(input,0, sizeof(input));
        memset(cache,-1, sizeof(cache));
        cin>>n;
        for(int a=0;a<2;a++){
            for(int b=0;b<n;b++){
                cin>>input[a][b];
            }
        }
        
        
        cout<<max_val(0,0)<<'\n';

        // for(int a=0;a<3;a++){
        //     for(int b=0;b<n;b++){
        //         cout<<cache[a][b]<<" ";
        //     }
        //     cout<<'\n';
        // }

    }
    

}