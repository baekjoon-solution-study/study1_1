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
? 1500*1500 이면 1차원배열 sort로 안나오나?
->메모리초과 캬~
->안넘는데 아무리봐도 크기 지정하고 해봄
*/


int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n;
    int temp;
    vector<int> arr;
    arr.reserve(1500*1510);
    cin>>n;
  
    
    for(int i=0;i<n*n;i++){
        cin>>temp;
        arr.push_back(temp);
    }
    sort(arr.begin(),arr.end());
    
    cout<<arr[n*n-n];
 
    
    
}