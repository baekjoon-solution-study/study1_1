#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
using namespace std;
/* 아이디어
씹노가다
*/
void male(vector<int> &arr,int num,int len){
    for(int i=num-1;i<len;i+=num){
        arr[i]=arr[i]^1;
    }
}
void female(vector<int> &arr,int num,int len){
    num--;
    arr[num]=arr[num]^1;
    for(int i=1;i<len;i++){
        if(num+i<len && num-i>-1 && arr[num+i]==arr[num-i]){
            arr[num+i]=arr[num+i]^1;
            arr[num-i]=arr[num-i]^1;
        }
        else{
            break;
        }
    }
}
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int switch_n,student_n;
    int sex,num;
    vector<int> arr;
    int temp;

    cin>>switch_n;
    for(int i=0;i<switch_n;i++){
        cin>>temp;
        arr.push_back(temp);
    }
    cin>>student_n;
    for(int i=0;i<student_n;i++){
        cin>>sex>>num;
        if(sex==1){
            male(arr,num,switch_n);
        }
        else if(sex==2){
            female(arr,num,switch_n);
        }
        // for(int a=0;a<switch_n;a++){
        //     cout<<arr[a]<<" ";
        // }
        // cout<<'\n';
    }
    for(int i=0;i<switch_n;i++){
        cout<<arr[i]<<" ";
        if((i+1)%20==0){
            cout<<"\n";
        }
    }
} 