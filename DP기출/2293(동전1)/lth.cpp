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

CACHE[앞으로 사용할 동전][남은 금액]= m이하의 동전들로 남은금액을 만드는 경우의 수

3 10
1
2
5

5를 한번 사용해서 
[1][5]= [2][3]+[2][1]+[2][5]

-> 메모리초과 4MB네..
-> 슬라이딩 윈도 하게 만들어놨네 씨발럼들이
-> 애초에 dp를 반복문으로 설계하면 이 과정이 훨씬 편리함 근데 난 재귀로 배움

*/
vector<int> input;
int cache[3][10010];
int temp_cache[10010];
int n,k;

int cnt(int num, int rest){
    if(rest==0){
        return 1;
    }
    if(rest<0 || num>=n){
        return 0;
    }
  

    if(cache[num%2][rest]!=-1){
        return cache[num%2][rest];
    }
    int output=0;
    for(int i=0;i*input[num]<=rest;i++){
        output+=cnt(num+1,rest-i*input[num]);   
    }
    cache[num%2][rest]=output;

    return output;

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int temp;
    
    cin>>n>>k;
    
    memset(cache,-1,sizeof(cache));

    for(int i=0;i<n;i++){

        cin>>temp;
        input.push_back(temp);
    }
    sort(input.rbegin(),input.rend());
    
    for(int t=k;t>=0;t--){
        for(int i=0;i<=k;i++){
            cnt(t,i);
        }
        memset(cache[(t+1)%2],-1,sizeof(cache[0]));

    } 
    
    cout<<cache[0][k];
    
    // for(int i=0;i<=n;i++){
    //     for(int j=0;j<=k;j++){
    //         cout<<cache[i][j]<<" ";
    //     }
    //     cout<<'\n';
    // }

}