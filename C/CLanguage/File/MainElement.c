#include <stdio.h>

int main(int argc, char const *argv[])
{
    int ma[] = {1,5,3,5,5,4,2,5,5,5};
    int k = ma[0], n = 0;
 
    int Len = sizeof(ma)/sizeof(int);

    for (int i = 0; i < Len; i++)
    { 
        if (ma[i] == k) n++;    // ==k  ������++
        else n--;               // ������--
        if(n==0)                //  n==0, 
        {
            k = ma[i];  //k ����һ��Ԫ��
            n++;    // n �� 1
        }
    }
    n=0;
    for (int i = 0; i < Len; i++)   // ȷ�� k �Ƿ�����Ԫ��
        if (ma[i]==k) n++;
    
    if (k > n/2) printf("%d",k);
    else printf("NONE");

    return 0;
}
/*
    
    ����һ�� k ������һ�������� n�� k ��ʼΪ���е�һ����
    �������У������һ�������� k��n++�� ���� n--��
    �� n = 0 ʱ���� k ֵ��Ϊ��ǰֵ 
    ������Ԫ�ظ������� n/2; ��ô n++ �Ĵ��� �϶���n--�Ĵ�����
    �����������Ԫ�أ��� k �б����Ŀ϶�������Ԫ�ء�
    ��û����Ԫ�� k Ҳ����ȡֵ�����Ի������ȷ��һ��
 */