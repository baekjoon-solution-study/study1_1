#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define INF 99999;
typedef struct node{
    int x;
    int y;
}node;
int homecnt=0, chcnt=0, min=INF;
int m;
node *home,ch[13];
int minre(node *choi){
    int* minarr=(int*)malloc(sizeof(int)*homecnt);
    int dt,min=0;
    for(int i=0;i<homecnt;i++){
        minarr[i]=INF;
    }
    for(int i=0;i<m;i++){
        for(int j=0;j<homecnt;j++){
            dt=abs(choi[i].x-home[j].x)+abs(choi[i].y-home[j].y);
            if(dt<minarr[j]){
                minarr[j]=dt;
            }
        }
    }
    for(int i=0;i<homecnt;i++){
        min+=minarr[i];
    }
    return min;
}
void find(node* choi,int n,int start){
    if(n>=m){
        // for(int i=0;i<m;i++){
        //     printf("(%d,%d) ",choi[i].x,choi[i].y);
        // }
        // printf("\n");
        int dt=minre(choi);
        if(min>dt)
            min=dt;
        return;
    }
    for(int i=start;i<chcnt;i++){
        // for(int j=0;j<i;j++){
        //     if(choi[j].x==ch[i].x && choi[j].y==ch[i].y )
        //         return;
        // }
        choi[n].x=ch[i].x;
        choi[n].y=ch[i].y;
        
       // printf("x %d y %d\n",choi[n].x,choi[n].y);
        
        find(choi,n+1,i+1);
    }
    return;
}


int main() {
    int n,temp;
    node *choi;
    scanf("%d %d",&n,&m);
    home=(node*)malloc(sizeof(node)*2*n);
    choi=(node*)malloc(sizeof(node)*m);
    
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            scanf("%d ",&temp);
            if(temp==1){
                home[homecnt].x=i;
                home[homecnt].y=j;
               
                homecnt++;
            }
            else if(temp==2){
                ch[chcnt].x=i;
                ch[chcnt].y=j;
                chcnt++;
            }
        }
    }
    find(choi,0,0);
    printf("%d ",min);
    
}