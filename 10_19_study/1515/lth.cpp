#include<stdio.h>
#include<string>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
#include<map>
#include <numeric>
using namespace std;
/* 아이디어
수가 최대 3000자리이다 -> 무슨 숫자가 나오든 10안으로는 나옴
-> 3000자리라면 숫자 30000이하라는 소리
1~30000까지 숫자를 string으로 바꿔서 각요소 매핑시켜 하나씩 지우기?
->완전탐색 각 숫자마다 최대 자릿수로 잡고 시간복잡도 (30000*5)
->탐욕법 있을 것 같은데..
*/



int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    string input;
    int i=0,j=0;
    int num=1;
    cin>>input;
    while(1){
        string temp=to_string(num);
        for(int a=0;a<temp.length();a++){
            if(input[i]==temp[a]){
                i++;
            }
        }
        if(i>=input.length()){
            break;
        }
        num++;
        
    }
    cout<<num;
    
}