#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;
/* 아이디어
문자열 함수들 사용
1.find_first_of
2.각 문자들 자음, 모음으로 구분후 같은거 3개 확인
3.반복문 같은문자 확인
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    string str;
    string m="aiueo";
    while(1){
        cin>>str;
        if(str.compare("end")==0){
            break;
        }
        if(str.find_first_of(m)==string::npos){
            cout<<"<"<<str<<">"<<" is not acceptable.\n";
            continue;
        }
        int temp=0;
        for(int i=0;i<str.length()-1;i++){
            if(((m.find(str[i])==string::npos)? 0 : 1) == ((m.find(str[i+1])==string::npos)? 0 : 1)){
                temp++;
                
            }
            else{
                temp=0;
            }
            if(temp==2){
                break;
            }
        }
        if(temp>=2){
            cout<<"<"<<str<<">"<<" is not acceptable.\n";
            continue;
        }
        temp=0;
        for(int i=0;i<str.length()-1;i++){
            if(str[i]==str[i+1] && str[i] !='e' &&str[i] != 'o'){
                temp=1;
                break;
            }
        }
        if(temp!=0){
            cout<<"<"<<str<<">"<<" is not acceptable.\n";
            continue;
        }
        cout<<"<"<<str<<">"<<" is acceptable.\n";
    }
    
}