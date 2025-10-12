#include<stdio.h>
#include<string.h>
#include<iostream>
#include<algorithm>
#include<vector>
#include<set>
using namespace std;
/* 아이디어
상,하,좌,우 다 1인 점 찾아서 5개의 값 각각 더하기
개 노가다로 품, 코드 드럽게 길어지길래 더러운대신 짧게짬
*/
int main(){
    ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
   
    int n;
    int heart_x=0,heart_y=0,left_arm=0,right_arm=0,left_leg=0,right_leg=0,s=0;
    vector<string> game;
    string temp;
    cin>>n;
    for(int i=0;i<n;i++){
        cin>>temp;
        game.push_back(temp);
    }

    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            if(j>0 && i>0 && j<n-1 && i<n-1 && game[i-1][j]=='*' && game[i+1][j]=='*' && game[i][j-1]=='*' && game[i][j+1]=='*'){
                heart_x=i;
                heart_y=j;
                left_arm=count(game[i].begin(),game[i].begin()+j,'*');
                right_arm=count(game[i].begin()+j+1,game[i].end(),'*');
                for(int k=i+1;k<n;k++){
                    if(game[k][j]=='*'){
                        s++;
                    }
                    if(game[k][j-1]=='*'){
                        left_leg++;
                    }
                    if(game[k][j+1]=='*'){
                        right_leg++;
                    }
                }
                break;
            }
        }
    }
    cout<<heart_x+1<<" "<<heart_y+1<<"\n";
    cout<<left_arm<<" "<<right_arm<<" "<<s<<" "<<left_leg<<" "<<right_leg;
}