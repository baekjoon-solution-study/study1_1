#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
using namespace std;
/* 아이디어
짝수 - 짝수번째만 남음
홀수 - 짝수번째만 남고 맨앞에꺼 맨뒤로
*/

int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n;
    cin>>n;
    vector<int> arr;
    for(int i=0;i<n;i++){
        arr.push_back(i+1);
    }
    while(arr.size()>1){
        vector<int> new_arr;
        for(int i=1;i<arr.size();i+=2){
            new_arr.push_back(arr[i]);
        }
        if(arr.size()%2!=0){
            rotate(new_arr.begin(),new_arr.begin()+1,new_arr.end());
        }
        arr=new_arr;
    }
    cout<<arr[0];
}