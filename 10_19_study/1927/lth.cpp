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
힙 구현
배열에서 i*2, i*2+1로 접근하는걸 구현할 수도 있지만
귀잖아서 라이브러리 찾아봄
priority_queue<자료형, 컨테이너(벡터), 비교함수(functional)>
*/





int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,temp;
    priority_queue<int, vector<int>, greater<int>> min_heap;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>temp;
        if(temp==0){
            if(min_heap.empty()){
                cout<<0<<'\n';
            }
            else{
                cout<<min_heap.top()<<'\n';
                min_heap.pop();
            }
            
        }
        else{
            min_heap.push(temp);
        }
    }
    
}