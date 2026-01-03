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
동전 크기 정렬
크기가 큰 동전부터 사용하는걸 가정해 캐시 구성
캐시구성

CACHE[앞으로 사용할 동전][남은 금액]= m이하의 동전들로 남은금액을 만드는 최소 동전갯수
-> 기존문제에서 수정하려니까 오래걸림
-> 테크닉적으로 재귀안에서 반복문 돌리는게 아닌 반복문의 상태조차 dp로 연결
ex) for(1~n)[n+1][rest-a] -> [n+1][rest] , [n][rest-a]

*/
vector<int> input;
int cache[110][10010];
int n,k;

int cnt(int num, int rest){
    if(rest==0){
        return 0;
    }
    if(rest<0 || num>=n){
        return 9876543;
    }
  

    if(cache[num][rest]!=-1){
        return cache[num][rest];
    }
    int output=9876543;
    output=min(cnt(num+1,rest),output);
    if(rest>=input[num]){
      output=min(1+cnt(num,rest-input[num]),output);   
    }
    cache[num][rest]=output;

    return output;

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int temp;
    
    cin>>n>>k;
    
    fill(&cache[0][0],&cache[0][0]+110*10010,-1);

    for(int i=0;i<n;i++){

        cin>>temp;
        input.push_back(temp);
    }
    sort(input.rbegin(),input.rend());
    
    if(cnt(0,k)!=9876543){
        cout<<cnt(0,k);
    }
    else{
        cout<<-1;
    }
    
    // for(int i=0;i<=n;i++){
    //     for(int j=0;j<=k;j++){
    //         cout<<cache[i][j]<<" ";
    //     }
    //     cout<<'\n';
    // }

}