#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char *input()
{
    // �ַ�����̬��������
    // �����ַ�ָ��
    int n = 0, len=10; 
    char c;
    char *ch = (char *)malloc(len);
    char *sh = NULL;
    while((c = getchar())!='\n')
    {
        if (n<len)
            ch[n++] = c;
        else
        {
            len+=10;
            sh = (char *)malloc(len);
            if (sh==NULL) return NULL;
            strcpy(sh,ch);
            ch = sh;
            ch[n++] = c;
        }
    }
    ch[n++] = '\0';
    return ch;
}


int KHmatch(char *s)
{
    char st[10000];
    int top = -1;
    for(int i=0; s[i]; i++){
    if(top==-1){
        if(s[i]==')' || s[i]==']' || s[i]=='}') return 0;
        else st[++top] = s[i]; // ��ջ
        continue;
    }
    if(s[i]==')')
        if(st[top]=='('){
            top--;
            continue;
        }
        else return 0;
    if(s[i]==']')
        if(st[top]=='['){
            top--;
            continue;
        }
        else return 0;
    if(s[i]=='}')
        if(st[top]=='{'){
            top--;
            continue;
        }
        else return 0;
    st[++top] = s[i];
    }
    return (top==-1)?1:0;
}

int main()
{
    char ch[20];
    //scanf("%s",&ch);
    //printf((KHmatch(ch)?("YES"):("NO")));
    char *sh;
    sh = input();
    printf("%s",sh);
    return 0;
}
