#include <stdio.h>
#include <stdlib.h>
#include <string.h>


const int MaxSize = 1000;
const int MOD = 986;

typedef struct user{    //  ÿ���û������ݽṹ��
    char name[20];
    char tel_num[13];
}User;

typedef struct Node{    //  hash����ÿ���������ݽṹ��
    User user;
    struct Node *next;
}LNode, *Linklist;


int ELFhash(char *key){      // hash����
    unsigned long h = 0;
    while(*key){
        h = (h<<4) + *key++;
        unsigned long g = h&0Xf0000000L;
        if(g) h ^= g>>24;
        h &= ~g;
    }
    return h % MOD;
}

int ELFhashInt(int *nums, int n){      // hash����
    unsigned long h = 0;
    for (int i = 0; i < n; i++)
    {
        h = (h<<4) + nums[i++]*9999;
        unsigned long g = h&0Xfedc0000L;
        if(g) h ^= g>>24;
        h &= ~g;
    }
    return h % 2147483647;
}

void add_date(LNode **tail, char *name, char *tel_num){   //  β�巨��������ӵ���������tailָ�����µĽڵ�
    LNode *p = NULL;
    p = (LNode *)malloc(sizeof(LNode));
    strcpy(p->user.name, name);
    strcpy(p->user.tel_num, tel_num);
    (*tail)->next = p;
    (*tail) = p;
    p->next = NULL;
}




void add_record(char *name, LNode *tail, LNode *hashtable[]){   // ����name��hashֵ����hashֵΪ�����±괢������Node��ַ
    int key = ELFhash(name);
    hashtable[key] = tail;
}



char *query(char *name, LNode *hashtable[]){        //  ����Ҫ��ѯname��hashֵ��Ȼ��hash���������ж϶�Ӧ�±��Ƿ����
    int key = ELFhash(name);
    if(hashtable[key]!=NULL) return hashtable[key]->user.tel_num;
    return NULL;
}



int main(){
    LNode *hashtable[MaxSize];    // hash��ָ������
    // �����ʼ��
    memset(hashtable,0,sizeof(hashtable));
    Linklist head = NULL; //ͷ���
    Linklist tail = NULL; //β���
    head = (LNode *)malloc(sizeof(LNode));
    tail = head;
    int i;
    char name[8], tel_num[13], *result;
    char names[][8] = {"ming", "huang", "tian", "zheng", "qi", "yun", "wang"};
    char tel_nums[][13] = {"13959869247", "15196227587", "17396914413", "15456897789", "13565488896", "13664851136", "993745"};

    // ����hash��ĳ�ʼ��
    for(i = 0; i < 7; i++){
        strcpy(name, names[i]);
        strcpy(tel_num, tel_nums[i]);
        add_date(&tail, name, tel_num);//�˴���Ҫ����βָ��ĵ�ַ���ܶ� tail ֵ����Ч�޸�
        add_record(name, tail, hashtable);
    }

    while(1){
        printf("������Ҫ��ѯ���û���(��0�˳�): ");
        scanf("%s",name);
        if(!strcmp(name,"0")) break;// 0 ��Ϊ������־
        result = query(name, hashtable);
        if(result==NULL) printf("\n�Բ���û����Ҫ��ѯ���û���" );
        else printf("������ѯ�û��ĵ绰����Ϊ��%s\n",result);
    }
    return 0;
}
