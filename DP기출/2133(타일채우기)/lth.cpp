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
/* 아이디어 - 순서강제(왼쪽에서 오른쪽)
3*n 이니까 각 줄에서 어떤 간이 이용가능한지에 대한 배열 [2][2][2]
각줄에대한 배열 [30]
cache[30][2][2][2]= 이번 줄에 어디어디어디 칸이 이용 가능할 때 이후 칸을 채워서 완성 가능한 경우의수

*/
vector<int> input;
int cache[31][2][2][2];
int n,k;

int cnt(int num, int one, int two, int thr){
    if(num==n-1){
        if((one==1 && two==1 && thr==0) || (one==0 && two==1 && thr==1) || (one==0 && two==0 && thr==0)){
            return 1;
        }
        else{
            return 0;
        }
    }
  

    if(cache[num][one][two][thr]!=-1){
        return cache[num][one][two][thr];
    }
    int output=0;
    if(one==1 && two==1){
        if(thr==1){
            output+=cnt(num+1,1,1,0);
        }
        else{
            output+=cnt(num+1,1,1,1);
        }
    }
    if(two==1 && thr==1){
        if(one==1){
            output+=cnt(num+1,0,1,1);
        }
        else{
            output+=cnt(num+1,1,1,1);
        }
    }
    output+=cnt(num+1,one^1,two^1,thr^1);

    cache[num][one][two][thr]=output;

    return output;

}

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int temp;
    
    cin>>n;
    
    memset(cache,-1,sizeof(cache));

   
    cout<<cnt(0,1,1,1);
  
    

}