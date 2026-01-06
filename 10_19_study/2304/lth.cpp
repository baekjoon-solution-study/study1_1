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
탐...욕? 재귀?
제일큰 값 찾고
그 값 기준 왼쪽에서 제일 큰값 찾고
왼쪽에서 찾는 제일 큰값 왼쪽에서 제일 큰값 찾고...
오른쪽도 동일
위에서 천 덮는 느낌
*/

int interval_max(int arr[],int *p,int de){
    if(p!=nullptr && *p==0){
        return 0;
    }
    if(de==0){
        int* maxPtr = max_element(arr, arr + 1010);
        int* leftmax = max_element(arr, maxPtr);
        int* rightmax = max_element(maxPtr+1, arr + 1010);
        int sum= (maxPtr-leftmax)*(*leftmax)+(rightmax-maxPtr)*(*rightmax)+(*maxPtr);
        return sum+ interval_max(arr,rightmax,1) + interval_max(arr,leftmax,-1);
    }
    else if(de==-1){
        int* leftmax = max_element(arr, p);
        return (p-leftmax)*(*leftmax)+interval_max(arr,leftmax,-1);
    }
    else{
        int* rightmax = max_element(p+1, arr+1010);
        return (rightmax-p)*(*rightmax)+interval_max(arr,rightmax,1);
    }
    
}


int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int arr[1010]={0};
    int n;
    int p,h;
    cin>>n;
  
    
    for(int i=0;i<n;i++){
        cin>>p>>h;
        arr[p]=h;
    }
    cout<<interval_max(arr,nullptr,0);
 
    
    
}