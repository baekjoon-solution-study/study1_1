#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
/* 아이디어
2차원 벡터(배열) 만들어서 각 벡터에서 자신보다 큰 벡터 카운트
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,tempnum;
    cin>>n;
    vector<vector<int>> arr;
    for(int i=0;i<n;i++){
        vector<int> temp;
        for(int j=0;j<2;j++){
            cin>>tempnum;
            temp.push_back(tempnum);
        }
        arr.push_back(temp);
    }
    for(int i=0;i<n;i++){
        int cnt=0;
        for(int j=0;j<n;j++){
            if(arr[j][0]>arr[i][0] && arr[j][1]>arr[i][1]){
                cnt++;
            }
        }
        arr[i].push_back(cnt+1);
    }
    
    for(int i=0;i<n;i++){
        
        printf("%d ",arr[i][2]);
    }
    
}