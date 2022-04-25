#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct Node
{
    int d;
    struct Node *next;
}Node;

char *input();
void Show(Node *head);


Node *Creat(char *s)
{
    
    int n = strlen(s);
    //printf("%d",n);
    Node *head = (Node *)malloc(sizeof(Node));
    Node *p, *q = head;
    head->d = 0;
    for (int i = 0; i < n; i++)
    {
        p = (Node *)malloc(sizeof(Node));
        p->d = s[i]-'0';
        q->next = p;
        q = p;
    }
    p->next = NULL;
    return head;
}

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

void Show(Node *head)
{   //��������ͷ�ڵ㣬��ӡ���нڵ�ֵ��ͷ�ڵ�ֵ��ӳ����
    Node *p = head->next;
    if (head->d == -1) printf("-");    
    while (p!=NULL)
    {
        printf("%d",p->d);
        p = p->next;
    }
    //printf("\n");
}


Node *Reverse(Node *head)
{   //��������ͷ�ڵ㣬���ط�ת���ͷ�ڵ�
    Node *p = head->next;
    Node *q;
    while (p->next!=NULL)
    {
        q = p->next;
        p->next = q->next;
        q->next = head->next;
        head->next = q;
    }
    return head;
}


Node *Minus(Node *LA, Node *LB)
{
    //LA - LB
    LA = Reverse(LA);   //��ת���� ���ӵ�λ����λ�������
    LB = Reverse(LB);
    int carry=0;    //carryΪ��λ����������ʱ����Ҫ����һλ��λ
    int i;
    Node *pla = LA;
    Node *la = LA->next;
    Node *lb = LB->next;
    while (la && lb)
    {
        if (la->d < lb->d)  //���������������λ
        {
            la->d = la->d - lb->d + 10 - carry;
            carry = 1;
        }
        else
        {
            la->d = la->d - lb->d - carry;
            carry = 0;
        }
        la = la->next;
        lb = lb->next;
        pla = pla->next;
    }
    if (la==NULL) //case1��a ��λ���� b �ٵ�ʱ�� ��ʣ�µ� b �ӵ� a ����
    {
        pla->next = lb;
        while (lb!=NULL)
        {
            lb->d = 0 - lb->d + 10 - carry;
            carry = 1;
            lb = lb->next;
        }
    }
    else    //case2��a ��λ���� b ���ʱ��
    {
        while (la!=NULL && carry)
        {
            if(la->d==0)  la->d = la->d + 10 - carry;
            else 
            {
                la->d = la->d - carry;
                carry=0;
            }
            la = la->next;
        }
    }
    la = LA->next;
    if (carry==1)  //��� carry Ϊ 1 �Ļ�˵�����λ�Բ�����λ �����Ϊ����
    {
        /*  
        * ���� 123 - 456 = -333����ת���Ӧλ������Ϊ 321 - 654 = 766��
        * carry=1����ʾ���ս���Ǹ������������Ƕ�����λ 9-x����һλ�� +1��
        * 9-7+1=3�� 9-6=3�� 9-6=3
        * ���Ϊ -333��
        */
        while (la!=NULL)
        {
            la->d = 9 - la->d;     //�� 9 ������λ
            la = la->next;
        }
        LA->next->d++; //��λ������
    }

    la = LA;
    la = Reverse(la);
    while (la->next->d == 0)    // ��ͷ�ڵ㶨λ����һ���� 0 Ԫ��ǰ��,���Ϊ0Ҫ���⿼��
        {
            if(la->next->next!=NULL) la = la->next; 
            else   
            {
                la->next->d = 0;
                break;
            }
        }
    if (carry==1)   // ��ͷ�ڵ�������
        la->d = -1;
    else la->d = 1;

    Show(la); 
    //���ؽ������ͷ�ڵ㣬ͷ�ڵ�Ϊ-1��ʾ���Ϊ������1��ʾ����Ǹ���
    return la;
}

int main()
{
    while (1)
    {
        printf("Input a:");
        char *sa = input();
        if (sa[0] == '\0') break;
        Node *LA = Creat(sa);

        printf("Input b:");
        char *sb = input();
        if (sb[0] == '\0') break;
        Node *LB = Creat(sb);


        printf("%s - %s = ",sa,sb);
        Minus(LA, LB);
        printf("\n\n");
    }

    return 0;
}
