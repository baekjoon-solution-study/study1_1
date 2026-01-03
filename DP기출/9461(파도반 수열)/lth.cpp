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
그냥 -4번째꺼랑 더해서 다음꺼 아닌가?
P(12)=P(11)+P(7)
+ longlong 형
이게 왜 dp?
*/



int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
    int temp;
    int t,n;
    vector<long long> arr={0, 1, 1, 1, 2, 2, 3, 4, 5, 7, 9};
    for(int i=10;i<101;i++){
        arr.push_back(arr[i]+arr[i-4]);
    }

    cin>>t;
    
    for(int i=0;i<t;i++){
        cin>>n;
        cout<<arr[n]<<'\n';
    }
 

}