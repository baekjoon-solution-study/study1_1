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
길이 60만
삽입, 삭제가 빠른시간안에 가능해야함
-> 링크드리스트일듯
*/

struct listt{
    char ch;
    listt* before;
    listt* next;
};


int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    string str;
    char input,insert_char;
    int n;
    
    listt* temp=nullptr;
    cin>>str;
  
    
    for(int i=0;i<str.size();i++){
        listt* temp2=new listt{str[i],temp,nullptr};
        if(temp!=nullptr){
            temp->next=temp2;
        }
        temp=temp2;
    }
    listt* temp2=new listt{0,temp,nullptr};
    temp->next=temp2;
    temp=temp->next;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>input;
        if(input=='L'){
            if(temp->before !=nullptr){
                temp=temp->before;
            }
        }
        else if(input=='D'){
            if(temp->next!=nullptr){
                temp=temp->next;
            }
        }
        else if(input=='B'){
            if(temp->before !=nullptr){
                listt* temp3=temp->before;
                temp->before=temp3->before;
                if(temp3->before !=nullptr){
                    temp3->before->next=temp;
                }
                
            }
        }
        else if(input=='P'){
            cin>>insert_char;
            listt* temp2=new listt{insert_char,temp->before,temp};
            if(temp->before !=nullptr){
                temp->before->next=temp2;
                
            }
            temp->before=temp2;
        }

    }
    for(;temp->before!=nullptr ;temp=temp->before){
    }
    for(listt* prt=temp;prt->next!=nullptr ;prt=prt->next){
        cout<<(prt->ch);
     
    }
 
    
    
}