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
CACHE[계단번호][바로 이전칸 밟았는지] = 이 점에서 끝까지 갔을 때 얻을 수 있는 최대점수

마지막케이스 하드코딩 했는데 좀 지저분한듯 n계단을 모두 밟으면 안된다 조건 커지면 작동안함

*/
int stairs[310];
int cache[310][2];
int n;

int max_val(int num, int is_before){
    if(num==n-1){
        return stairs[n-1];
    }
    if(num==n-2 && is_before){
        return 0;
    }
    if(cache[num][is_before]!=-1){
        return cache[num][is_before];
    }
    int mx=0;
    for(int i=1;i<3;i++){
        if(is_before && i==1){
            continue;
        }
        
        if(num+i < n ){
            mx=max(max_val(num+i,(i==1)?1:0),mx);
        }
    }
    cache[num][is_before]=mx+stairs[num];

    return mx+stairs[num];

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    
    cin>>n;
    memset(cache,-1, sizeof(cache));
    for(int i=0;i<n;i++){
        cin>>stairs[i];
    }
    
    cout<<max(max_val(0,0),max_val(1,0));

    // for(int i=0;i<n;i++){
    //     cout<<cache[i][0]<<" ";
    //     cout<<cache[i][1]<<'\n';
    // }

}