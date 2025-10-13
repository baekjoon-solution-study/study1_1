#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
/* 아이디어
2차원 벡터(배열) 만들어서 정렬 -> 사전순으로 금은동메달 갯수로 자동정렬
앞의 국가와 금은동 같으면 앞에랭크
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n,k,connum,tempnum;
    cin>>n>>k;
    vector<vector<int>> arr;
    for(int i=0;i<n;i++){
        vector<int> temp;
        cin>>connum;
        for(int j=0;j<3;j++){
            cin>>tempnum;
            temp.push_back(tempnum);
        }
        temp.push_back(connum);
        arr.push_back(temp);
    }
    sort(arr.rbegin(),arr.rend());
    
    arr[0].push_back(1);
    for(int i=1;i<n;i++){
        if(arr[i][0]==arr[i-1][0] && arr[i][1]==arr[i-1][1] && arr[i][2]==arr[i-1][2]){
            arr[i].push_back(arr[i-1][4]);
        }
        else{
            arr[i].push_back(i+1);
        }
    }
    // for(int i=0;i<n;i++){
    //     for(int j=0;j<5;j++){
    //         printf("%d ",arr[i][j]);
    //     }
    //     printf("\n");
    // }
    for(int i=0;i<n;i++){
        if(arr[i][3]==k){
            printf("%d",arr[i][4]);
        }
        
    }
}